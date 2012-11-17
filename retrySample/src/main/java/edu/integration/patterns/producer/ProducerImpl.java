package edu.integration.patterns.producer;

import org.apache.log4j.Logger;

public class ProducerImpl implements Producer {

    private static final Logger logger = Logger.getLogger(ProducerImpl.class);

    @Override
    public boolean buy(long itemId) {
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