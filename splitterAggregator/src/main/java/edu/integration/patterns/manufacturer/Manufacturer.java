package edu.integration.patterns.manufacturer;

import edu.integration.patterns.OrderBean;
import edu.integration.patterns.OrderResult;


public interface Manufacturer {

	public OrderResult getPrice(OrderBean bean);
}
