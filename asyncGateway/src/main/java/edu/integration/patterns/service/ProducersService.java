package edu.integration.patterns.service;

import java.util.concurrent.Future;

public interface ProducersService {

    Future<Boolean> buy(long itemId);

}
