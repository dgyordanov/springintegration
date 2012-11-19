package edu.integration.patterns.service;

import edu.integration.patterns.OrderBean;

/**
 * Producer service interface which encapsulates the messaging flow(the message
 * gateway)
 * 
 * @author Diyan Yordanov
 * 
 */
public interface NikeService {

    void buy(OrderBean order);

}
