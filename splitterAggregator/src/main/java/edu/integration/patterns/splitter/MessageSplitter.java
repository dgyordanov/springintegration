package edu.integration.patterns.splitter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.integration.Message;
import org.springframework.integration.splitter.AbstractMessageSplitter;

import edu.integration.patterns.BatchOrderBean;
import edu.integration.patterns.OrderBean;

public class MessageSplitter extends AbstractMessageSplitter {

	private static final Map<Integer, Integer> ordersCountMap = new HashMap<Integer, Integer>();

	public static int getOrdersCount(Integer orderId) {
		return ordersCountMap.get(orderId);
	}
	
	@Override
	protected List<OrderBean> splitMessage(Message<?> message) {
		BatchOrderBean payload = (BatchOrderBean) message.getPayload();
		
		// for use by the aggregator later
		ordersCountMap.put(payload.getResellerOrderNumber(), payload
				.getOrders().size());
		
		List<OrderBean> orders = payload.getOrders();
		for(OrderBean order : orders) {
			order.setOrderId(payload.getResellerOrderNumber());
		}
		
		return orders;
	}
	
}
