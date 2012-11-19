package edu.integration.patterns.manufacturer;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

public class Reebok implements Manufacturer {

    private static final Logger logger = Logger.getLogger(Reebok.class);
    
    @Override
    public BigDecimal getPrice(long itemId) {
        logger.info("Price request message received: " + itemId);
        return new BigDecimal("55.99");
    }
}
