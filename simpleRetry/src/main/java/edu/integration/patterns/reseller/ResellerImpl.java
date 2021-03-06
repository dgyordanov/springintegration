package edu.integration.patterns.reseller;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import edu.integration.patterns.service.ProducersService;

public class ResellerImpl implements Reseller, ApplicationContextAware {

    private ApplicationContext applicationContext;

    private static final Logger logger = Logger.getLogger(ResellerImpl.class);

    @Override
    public void buy(long itemId) {
        ProducersService producersService = applicationContext.getBean(ProducersService.class);
        logger.info("Invoking producersService.....");
        producersService.buy(itemId);
        logger.info("producersService invoked");

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
