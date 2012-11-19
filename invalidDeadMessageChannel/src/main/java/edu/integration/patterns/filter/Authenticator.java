package edu.integration.patterns.filter;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.integration.Message;
import org.springframework.integration.core.MessageSelector;

import edu.integration.patterns.OrderBean;

/**
 * Authentication filter module
 * 
 * @author Diyan Yordanov
 * 
 */
public class Authenticator implements MessageSelector, ApplicationContextAware {

    // Static credentials
    private static final String EXPECTED_USERNAME = "martin";
    private static final String EXPECTED_PASSWORD = "pass";

    private static final Logger logger = Logger.getLogger(Authenticator.class);
	private static final String ERRORS_COLLECTION = "orderAttempts";

    private ApplicationContext context;
    
    @Override
    public boolean accept(Message<?> message) {
        logger.info("Start authenticating..");
        try {
            OrderBean payload = (OrderBean) message.getPayload();
            return authenticate(payload.getUsername(), payload.getPassword());
        } catch (ClassCastException e) {
            return false;
        }

    }

    /**
     * Simple authentication mechanism
     * 
     * @param username
     * @param password
     * @return true if the authentication is successful
     */
    private boolean authenticate(String username, String password) {
        boolean isAuthenticated = EXPECTED_USERNAME.equals(username)
                && EXPECTED_PASSWORD.equals(password);
        if (isAuthenticated) {
            logger.info("Authention successful");
        } else {
            logger.info("Authention failure");
        }
        return isAuthenticated;
    }

	public void onError(OrderBean error) {
		logger.info("Persisting login attempt to Mongo ...");

		MongoOperations mongoOperation = (MongoOperations) context
				.getBean("mongoTemplate");
		mongoOperation.save(error, ERRORS_COLLECTION);
		logger.info("Login attempt persisted to Mongo ...");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		context = applicationContext;
	}
}
