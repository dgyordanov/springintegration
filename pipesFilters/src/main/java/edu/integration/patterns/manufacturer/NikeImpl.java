package edu.integration.patterns.manufacturer;

import org.apache.log4j.Logger;

import edu.integration.patterns.OrderBean;

/**
 * An implementation of a sample producer
 * 
 * @author Diyan Yordanov
 * 
 */
public class NikeImpl implements Nike {

    private static final Logger logger = Logger.getLogger(NikeImpl.class);

    @Override
    public void receiveOrder(OrderBean order) {
        logger.info("Order received: " + order);
        try {
            // Processing order for about 1 second
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.error("Internal error", e);
        }
        logger.info("Order processed: " + order);
    }
}