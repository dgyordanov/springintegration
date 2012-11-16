package edu.integration.patterns;

import org.apache.log4j.Logger;

public class ProducerImpl implements Producer {

    private static final Logger logger = Logger.getLogger(ProducerImpl.class);

    @Override
    public void buy(long itemId) {
        logger.info("Order received: " + itemId);
        //Processing order for about 1 second
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        logger.info("Order processed: " + itemId);
    }

}