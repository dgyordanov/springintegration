package edu.integration.patterns.service;

import java.util.concurrent.Future;

public interface NikeService {

    Future<Boolean> buy(long itemId);

}
