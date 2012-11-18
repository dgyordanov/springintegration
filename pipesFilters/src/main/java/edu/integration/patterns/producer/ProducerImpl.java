package edu.integration.patterns.producer;

import org.apache.log4j.Logger;

import edu.integration.patterns.OrderBean;

public class ProducerImpl implements Producer {

    private static final Logger logger = Logger.getLogger(ProducerImpl.class);

    @Override
    public void buy(OrderBean order) {
        logger.info("Order received: " + order);
        //Processing order for about 1 second
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        logger.info("Order processed: " + order);
    }

}