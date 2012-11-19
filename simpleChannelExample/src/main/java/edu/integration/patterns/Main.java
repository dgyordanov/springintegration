package edu.integration.patterns;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.integration.patterns.manufacturer.Nike;
import edu.integration.patterns.reseller.Reseller;

public final class Main {

    private static final long ITEM_ID = 23542345;

    public static void main(String[] args) {
    	
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/integration/spring-integration-context.xml");
        
        // reseller buys an item
        Reseller reseller = ac.getBean(Reseller.class);
        reseller.buy(ITEM_ID);
        
        // manufacturer receives the order
        Nike manufacturer = ac.getBean(Nike.class);
        manufacturer.receiverOrder();
    }
}
