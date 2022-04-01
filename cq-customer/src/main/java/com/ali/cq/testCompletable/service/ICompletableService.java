package com.ali.cq.testCompletable.service;

import java.util.concurrent.ExecutionException;

public interface ICompletableService {

    void testCompletableMethod() throws InterruptedException, ExecutionException, Exception;
}
