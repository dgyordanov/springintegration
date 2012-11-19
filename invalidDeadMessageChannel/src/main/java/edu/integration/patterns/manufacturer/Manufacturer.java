package edu.integration.patterns.manufacturer;

import java.math.BigDecimal;

import edu.integration.patterns.OrderBean;

public interface Manufacturer {

    BigDecimal getPrice(OrderBean itemId);

}
