package edu.integration.patterns.manufacturer;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

public class Adidas implements Manufacturer{

    private static final Logger logger = Logger.getLogger(Adidas.class);
    
    public BigDecimal getPrice(String order) {
        
        	logger.info("Price request message received for order: " + order);
            return new BigDecimal("50");
    }

}
