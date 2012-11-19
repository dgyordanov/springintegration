package edu.integration.patterns.service;

import java.math.BigDecimal;

import edu.integration.patterns.OrderBean;

public interface InvalidMessageService {

    void processMessage(OrderBean order);
}
