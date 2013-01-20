package com.eyallupu.blog.springmvc.services;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class CreditService {
	ExecutorService executorService = Executors.newFixedThreadPool(3);
	
	public final static CreditService instance = new CreditService();
	
	private CreditService() {}
	
	public long getBalance(String customerID) throws InterruptedException, ExecutionException {
		Future<Long> balance = executorService.submit(new Callable<Long>() {

			@Override
			public Long call() throws Exception {
				TimeUnit.SECONDS.sleep(5);
				return ThreadLocalRandom.current().nextLong(3000);
			}
		});
		
		return balance.get();
	}
	
}
