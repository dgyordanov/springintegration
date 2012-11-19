package edu.integration.patterns;

import java.util.List;

/**
 * @author Martin
 */
public class BatchOrderBean {

	private List<OrderBean> orders;

	private Integer resellerOrderNumber;
	
	public BatchOrderBean(List<OrderBean> orders, Integer resellerOrderNumber) {
		this.orders = orders;
		this.resellerOrderNumber = resellerOrderNumber;
	}

	public List<OrderBean> getOrders() {
		return orders;
	}
	
	public Integer getResellerOrderNumber() {
		return resellerOrderNumber;
	}
}
