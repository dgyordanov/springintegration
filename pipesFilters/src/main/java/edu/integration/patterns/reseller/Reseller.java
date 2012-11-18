package edu.integration.patterns.reseller;

import edu.integration.patterns.OrderBean;

/**
 * Reseller interface
 * 
 * @author Diyan Yordanov
 * 
 */
public interface Reseller {

    /**
     * Reseller receives an order
     * 
     * @param order
     */
    void buy(OrderBean order);

}
