package edu.integration.patterns.mbean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import edu.integration.patterns.OrderBean;
import edu.integration.patterns.reseller.Reseller;

public class OrderMBean implements ApplicationContextAware{

	private ApplicationContext context;
	
	private static final String USERNAME = "martin3";
	
	private static final String PASSWORD = "pass";

	public void order(long itemId, String manufacturer) {
		Reseller reseller = context.getBean(Reseller.class);
		reseller.buy(new OrderBean(USERNAME, PASSWORD, itemId, manufacturer));
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = applicationContext;
	}
}
