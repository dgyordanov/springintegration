package edu.integration.patterns.transformer;

import edu.integration.patterns.OrderBean;

public class ReebokMessageTransformer {

	public Long transform(OrderBean order) {
		return order.getItemId();
	}
}
