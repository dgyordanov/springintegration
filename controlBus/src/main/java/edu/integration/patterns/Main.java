package edu.integration.patterns;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.integration.patterns.reseller.Reseller;

public final class Main {

	private static final String USERNAME = "martin3";
    private static final String PASSWORD = "pass";
    private static final long ITEM_ID = 23542345;
    
	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring/integration/spring-integration-context.xml");
		
		try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
		}
		
		Reseller reseller = ac.getBean(Reseller.class);
		reseller.buy(new OrderBean(USERNAME, PASSWORD, ITEM_ID, "nike"));
		reseller.buy(new OrderBean(USERNAME, PASSWORD, ITEM_ID, "adidas"));
		reseller.buy(new OrderBean(USERNAME, PASSWORD, ITEM_ID, "reebok"));
	}
}
