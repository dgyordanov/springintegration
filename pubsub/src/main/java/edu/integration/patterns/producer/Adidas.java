package edu.integration.patterns.producer;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

public class Adidas implements Producer {

    private static final Logger logger = Logger.getLogger(Adidas.class);

    @Override
    public void buy(long itemId) {
        logger.info("Order received: " + itemId);
        // Processing order for about 1 second
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        logger.info("Order processed: " + itemId);
    }

    @Override
    public BigDecimal getPrice(long itemId) {
        logger.info("Price request message received: " + itemId);
        return new BigDecimal("50");
    }

}