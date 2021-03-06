package edu.integration.patterns.manufacturer;

import org.apache.log4j.Logger;

public class NikeImpl implements Nike {

    private static final Logger logger = Logger.getLogger(NikeImpl.class);

    @Override
    public boolean receiveOrder(long itemId) {
        logger.info("Order received: " + itemId);
        //Processing order for about 1 second
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return false;
        }
        logger.info("Order processed: " + itemId);
        
        // Return successful status
        return true;
    }

}