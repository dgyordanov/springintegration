package edu.integration.patterns.manufacturer;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.xml.transform.StringResult;

public class Nike implements Manufacturer {

    private static final Logger logger = Logger.getLogger(Nike.class);

    public BigDecimal getPrice(StringResult itemId) {
        logger.info("Price request message received for order: " + itemId);
        return new BigDecimal("50.99");
    }
}
