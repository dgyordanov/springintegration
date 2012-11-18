package edu.integration.patterns.producer;

import edu.integration.patterns.OrderBean;

/**
 * Producer interface
 * 
 * @author Diyan Yordanov
 * 
 */
public interface Producer {

    void buy(OrderBean order);

}
