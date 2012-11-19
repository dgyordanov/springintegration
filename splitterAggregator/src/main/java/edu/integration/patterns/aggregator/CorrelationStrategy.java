package edu.integration.patterns.aggregator;

import org.springframework.integration.Message;

import edu.integration.patterns.OrderResult;

public class CorrelationStrategy {

	public Integer getCorrelationKey(Message<?> message) {
		
		OrderResult result = (OrderResult) message.getPayload();
		return result.getResellerOrderNumber();
	}
}
