package edu.integration.patterns.manufacturer;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import edu.integration.patterns.OrderBean;
import edu.integration.patterns.OrderResult;

public class Nike implements Manufacturer {

	private static final Logger logger = Logger.getLogger(Nike.class);

	public OrderResult getPrice(OrderBean order) {
		logger.info("Price request message received for order: " + order);
		return new OrderResult(order.getItemId(), new BigDecimal("50.99"),
				order.getOrderId(), "nike");
	}
}
