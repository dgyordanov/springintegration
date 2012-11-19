package edu.integration.patterns;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.integration.patterns.reseller.Reseller;

public final class Main {

    private static final long ITEM_ID = 12231234;

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/integration/spring-integration-context.xml");
        Reseller reseller = ac.getBean(Reseller.class);
        reseller.buy(ITEM_ID);
    }
}
