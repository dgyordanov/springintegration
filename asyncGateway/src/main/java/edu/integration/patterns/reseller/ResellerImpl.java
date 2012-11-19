package edu.integration.patterns.reseller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import edu.integration.patterns.service.NikeService;

public class ResellerImpl implements Reseller, ApplicationContextAware {

    private ApplicationContext applicationContext;

    private static final Logger logger = Logger.getLogger(ResellerImpl.class);

    @Override
    public void buy(long itemId) {
        NikeService producersService = applicationContext.getBean(NikeService.class);
        logger.info("Invoking producersService.....");
        
        Future<Boolean> status = producersService.buy(itemId);
        logger.info("producersService invoked");
        
        try {
            Boolean result = status.get();
            logger.info("Status is: " + result);
        } catch (InterruptedException e) {
            logger.error("Can not read result", e);
        } catch (ExecutionException e) {
            logger.error("Can not read result", e);
        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
