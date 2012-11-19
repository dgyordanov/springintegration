package edu.integration.patterns.manufacturer;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

public class Reebok implements Manufacturer {

    private static final Logger logger = Logger.getLogger(Reebok.class);

    public BigDecimal getPrice(Long itemId) {
        logger.info("Price request message received for order: " + itemId);
        return new BigDecimal("55.99");
    }
}
