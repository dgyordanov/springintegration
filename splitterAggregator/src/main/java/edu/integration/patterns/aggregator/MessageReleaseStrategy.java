package edu.integration.patterns.aggregator;

import org.springframework.integration.aggregator.ReleaseStrategy;
import org.springframework.integration.store.MessageGroup;

import edu.integration.patterns.splitter.MessageSplitter;

public class MessageReleaseStrategy implements ReleaseStrategy {

	public boolean canRelease(MessageGroup group) {
		int orderId = (Integer) group.getGroupId();
		int groupMessages = group.getMessages().size();
		int neededMessages = MessageSplitter.getOrdersCount(orderId);

		return groupMessages == neededMessages;
	}
}
