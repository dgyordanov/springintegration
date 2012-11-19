package edu.integration.patterns;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.integration.patterns.reseller.Reseller;

public final class Main {

    private static final long ITEM_ID = 23542345;

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/integration/spring-integration-context.xml");
        Reseller testService = ac.getBean(Reseller.class);
        testService.buy(ITEM_ID);
    }
}
