package edu.integration.patterns.aggregator;

import java.util.List;

import edu.integration.patterns.BatchOrderResult;
import edu.integration.patterns.OrderResult;

/**
 * @author Martin
 */
public class MessageAggregator {

	public BatchOrderResult aggregateOrders(List<OrderResult> results) {
		return new BatchOrderResult(results);
	}

}
