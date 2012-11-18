package edu.integration.patterns.filter;

import org.apache.log4j.Logger;
import org.springframework.integration.Message;
import org.springframework.integration.core.MessageSelector;

import edu.integration.patterns.OrderBean;

/**
 * Authentication filter module
 * 
 * @author Diyan Yordanov
 * 
 */
public class Authenticator implements MessageSelector {

    // Static credentials
    private static final String EXPECTED_USERNAME = "dido";
    private static final String EXPECTED_PASSWORD = "pass";

    private static final Logger logger = Logger.getLogger(Authenticator.class);

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

}
