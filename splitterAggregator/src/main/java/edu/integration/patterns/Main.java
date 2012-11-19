package edu.integration.patterns;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.integration.patterns.reseller.Reseller;

public final class Main {

	private static final String USERNAME = "martin3";
    private static final String PASSWORD = "pass";
    private static final long ITEM_ID = 23542345;
    private static final int ORDER_ID = 123;
    
	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring/integration/spring-integration-context.xml");
		Reseller reseller = ac.getBean(Reseller.class);
		
		List<OrderBean> orders = new LinkedList<OrderBean>();
		orders.add(new OrderBean(USERNAME, PASSWORD, ITEM_ID, "nike"));
		orders.add(new OrderBean(USERNAME, PASSWORD, ITEM_ID, "adidas"));
		orders.add(new OrderBean(USERNAME, PASSWORD, ITEM_ID, "reebok"));
//		orders.add(new OrderBean(USERNAME, PASSWORD, ITEM_ID, "invalid"));
	
		BatchOrderBean ordersBean= new BatchOrderBean(orders, ORDER_ID);
		
		reseller.buy(ordersBean);
	}
}
