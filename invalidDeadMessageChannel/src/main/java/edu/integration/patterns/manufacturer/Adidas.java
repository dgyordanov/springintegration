package edu.integration.patterns.manufacturer;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import edu.integration.patterns.OrderBean;
import edu.integration.patterns.service.InvalidMessageService;

public class Adidas implements Manufacturer, ApplicationContextAware {

    private static final Logger logger = Logger.getLogger(Adidas.class);
    
    private static final String VALID_USER = "martin";
    
    private static final String VALID_PASS = "pass";
    
    private ApplicationContext context;
    
    @Override
    public BigDecimal getPrice(OrderBean order) {
        
    	if(authenticate(order)) {
        	logger.info("Price request message received for order: " + order);
            return new BigDecimal("50");
    	} else {
			InvalidMessageService service = (InvalidMessageService) context
					.getBean("invalidMessage");
			service.processMessage(order);
			
			return new BigDecimal("-1");
    	}
    }
    
    private boolean authenticate(OrderBean order) {

    	boolean isValid = VALID_USER.equals(order.getUsername()) && 
    			VALID_PASS.equals(order.getPassword());
    	
    	return isValid;
    }

	@Override
    public void setApplicationContext(ApplicationContext applicationContext)
    		throws BeansException {
    	context = applicationContext;
    }
}
