package edu.integration.patterns.reseller;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import edu.integration.patterns.BatchOrderBean;
import edu.integration.patterns.BatchOrderResult;
import edu.integration.patterns.service.ManufacturersService;

public class ResellerImpl implements Reseller, ApplicationContextAware {

    private ApplicationContext applicationContext;

    private static final Logger logger = Logger.getLogger(ResellerImpl.class);

    @Override
    public void buy(BatchOrderBean orders) {
        ManufacturersService producersService = applicationContext.getBean(ManufacturersService.class);
		logger.info("Invoking producersService.....");
		
        // A problem to resolve. We need all the responses, not only one
        BatchOrderResult result = producersService.buy(orders);
        logger.info("producersService invoked. Result: " + result);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
