package edu.integration.patterns;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public final class Main {

    private static final long ITEM_ID = 12231234;

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/integration/spring-integration-context.xml");
        JmsTemplate jmsTemplate = ac.getBean("jmsProducerTemplate", JmsTemplate.class);
        logger.info("Sending message....");
        jmsTemplate.convertAndSend(ITEM_ID);
        logger.info("Message sent");

    }

}
