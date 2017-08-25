package com.liu.date20170508;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Herry
 * @time 2017年5月8日21:06:26
 * @description 学习java 8中异步编程
 *
 */

public class AsynTest {
	
	public static void main(String[] args) {
		
		//创建ExecutorService，并且通过它向线程池提交任务
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		// 1
		Future<Double> future = executorService.submit(new Callable<Double>() {
		    @Override
		    public Double call() throws Exception {
		        return 1.0;
		    }
		});
		
		System.out.println("我在做其他事情……");
		
		// 获取1处异步处理的结果
		try {
		    double result = (double)future.get(1,TimeUnit.SECONDS);
		    System.out.println(result);
		} catch (InterruptedException e) {
		    //线程被中断
		    e.printStackTrace();
		} catch (ExecutionException e) {
		    //线程抛出异常
		    e.printStackTrace();
		} catch (TimeoutException e) {
		    //线程超时
		    e.printStackTrace();
		}
		
		// ---------------------------- 以上为简单测试 -------------------------//
		System.out.println();
		System.out.println("我是分割线-----------------------------------------");
		System.out.println();
		// ---------------------------- 以下为复杂测试 - -----------------------//
		
		Client client = new Client();
		client.test();
		
	}
	
}


class Shop {
    private String name;
    private Random random = new Random();

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Shop(String name) {
        this.name = name;
    }

    //直接获取价格
    public double getPrice(String product){
        return calculatePrice(product);
    }
    
    public String getPrice2(String product){
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }
    
    //模拟延迟
    public static void delay(){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    //模拟获取价格的服务
    private double calculatePrice(String product){
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    //异步获取价格
    public Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(() -> {
            double price = calculatePrice(product);
            future.complete(price);
        }).start();
        return future;
    }
}

class Client {
	
    public void test(){
        Shop shop = new Shop("BestShop");
        long start = System.currentTimeMillis();
        Future<Double> future = shop.getPriceAsync("My Favorite");
        long invocationTime = System.currentTimeMillis() - start;
        System.out.println("调用接口时间：" + invocationTime + "毫秒");

        doSomethingElse();

        try {
            double price = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long retrievalTime = System.currentTimeMillis() - start;
        System.out.println("返回价格消耗时间：" + retrievalTime + "毫秒");

    }

    public static void doSomethingElse(){
        System.out.println("做其他的事情。。。");
    }
}



