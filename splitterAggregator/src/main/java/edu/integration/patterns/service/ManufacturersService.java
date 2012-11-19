package edu.integration.patterns.service;

import edu.integration.patterns.BatchOrderBean;
import edu.integration.patterns.BatchOrderResult;

public interface ManufacturersService {

    BatchOrderResult buy(BatchOrderBean order);

}
