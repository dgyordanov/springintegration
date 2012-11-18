package edu.integration.patterns.producer;

import org.apache.log4j.Logger;

public class ProducerImpl implements Producer {

    private static final Logger logger = Logger.getLogger(ProducerImpl.class);

    @Override
    public boolean buy(long itemId) {
        logger.info("Order received: " + itemId);
        logger.info("Order not processed successfully. Exception will be thrown");
        throw new RuntimeException("fake");

    }

}