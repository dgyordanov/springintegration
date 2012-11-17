package edu.integration.patterns.producer;

import java.math.BigDecimal;

public interface Producer {

    void buy(long itemId);

    BigDecimal getPrice(long itemId);

}
