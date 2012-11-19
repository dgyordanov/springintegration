package edu.integration.patterns.router;

import edu.integration.patterns.OrderBean;

/**
 * @author Martin
 */
public class MessageRouter {

	// NOTE: this channel might be dynamically configurable in case of a dynamic router
	private static final String NIKE_CHANNEL = "nikeChannel";
	private static final String ADIDAS_CHANNEL = "adidasChannel";
	private static final String REEBOK_CHANNEL = "reebokChannel";
	
	public String route(OrderBean order) {

		String channel = "invalidManufacturerChannel";
		String manufacturer = order.getManufacturer();
		
		if("nike".equals(manufacturer)) {
			channel = NIKE_CHANNEL;
		} else if ("adidas".equals(manufacturer)) {
			channel = ADIDAS_CHANNEL;
		} else if("reebok".equals(manufacturer)) {
			channel = REEBOK_CHANNEL;
		}
		
		return channel;
	}
}
