package com.liu.date20170508;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @author Herry
 * @time 2017年5月8日21:43:28
 * @description 测试parallelStream和CompletableFuture各自适合的场景
 * 
 * 【注意】并行操作 Streams和CompletableFutures比较： 
 *     1. 如果有大量计算的操作而没有I/O操作（包括连接互联网），那么使用异步的 Streams可以得到最好的性能；
 *     2. 相反如果有很多I/O操作， 使用CompletableFutures可以得到更好的编弹性。
 * 
 * 
 */

public class CompareParaAndStream {
	
	
	public static void main(String[] args) {
		
		// (1)这是处理计算量较大的操作
		
		// 测试1处的方法findPrice() ----采用parallelStream并行操作方式
		long start = System.currentTimeMillis();
	    System.out.println(findPrice("java8异步编程测试"));
	    long duration = System.currentTimeMillis() - start;
	    System.out.println("总消耗时间：" + duration + "毫秒");
	    
	    
	  	System.out.println();
 		System.out.println("我是分割线----------------------------------------");
 		System.out.println();
 			    
 		
	    // 测试2处的方法findPrice2() ----CompletableFuture并行操作方式
 		long start2 = System.currentTimeMillis();
 		System.out.println(findPrice2("java8异步编程测试"));
 		long duration2 = System.currentTimeMillis() - start2;
 		System.out.println("总消耗时间：" + duration2 + "毫秒");

 		
 		System.out.println();
 		System.out.println("我是分割线2----------------------------------------");
 		System.out.println();
 		
 		
 		
 		// (2)这是多任务流水线的操作
 		long start3 = System.currentTimeMillis();
 		System.out.println(findPrice3("java8异步编程测试"));
 		long duration3 = System.currentTimeMillis() - start3;
 		System.out.println("总消耗时间：" + duration3 + "毫秒");
 		
 		
 		
	}
	
	
	// 1
	public static List<String> findPrice(String product){
	    List<Shop> shops = Arrays.asList(new Shop("淘宝"),
	            new Shop("加瓦匠"),
	            new Shop("京东商城"),
	            new Shop("天猫商城"));
	    return shops.parallelStream()
	            .map(shop -> String.format("%s 的价格是 %.2f", shop.getName(),shop.getPrice(product)))
	            .collect(Collectors.toList());

	}
	
	// 2
	public static List<String> findPrice2(String product){
		 List<Shop> shops = Arrays.asList(new Shop("淘宝"),
		            new Shop("加瓦匠"),
		            new Shop("京东商城"),
		            new Shop("天猫商城"));
	    List<CompletableFuture<String>> priceFuture = shops.stream()
	            .map(shop -> CompletableFuture.supplyAsync( // 使用异步的方式计算每种商品的价格
	                    () -> shop.getName() + " 的价格是 " + shop.getPrice(product)))
	            .collect(Collectors.toList());

	    return priceFuture.stream()
	            .map(CompletableFuture::join) //join 操作等待所有异步操作的结果
	            .collect(Collectors.toList());
	}
	
	// 3
	public static List<String> findPrice3(String product){
		List<Shop> shops = Arrays.asList(new Shop("淘宝"),
	            new Shop("加瓦匠"),
	            new Shop("京东商城"),
	            new Shop("天猫商城"));
	    return shops.stream()
	            .map(shop -> shop.getPrice2(product)) //获取原始报价
	            .map(Quote::parse) //解析报价字符串
	            .map(Discount::applyDiscount) //调用折扣服务应用报价折扣
	            .collect(Collectors.toList());
	}
	
	// 4
	/*public static List<String> findPrice4(String product){
		//创建ExecutorService，并且通过它向线程池提交任务
		ExecutorService executor = Executors.newCachedThreadPool();
		
		List<Shop> shops = Arrays.asList(new Shop("淘宝"),
	            new Shop("加瓦匠"),
	            new Shop("京东商城"),
	            new Shop("天猫商城"));
	    shops.stream()
	            .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice2(product), executor))
	            .map(future -> future.thenApply(Quote::parse)); 
	            .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync( // 另一个异步任务构造异步应用报价
	                                                        () -> Discount.applyDiscount(quote), executor)))
	            .collect(Collectors.toList());

	    return priceFuture.stream()
	            .map(CompletableFuture::join) //join 操作和get操作有相同的含义，等待所有异步操作的结果。
	            .collect(Collectors.toList());
	}
	*/
	

}




class Quote {
    private final String shopName;
    private final double price;
    private final Discount.Code code;

    public Quote(String shopName, double price, Discount.Code code) {
        this.shopName = shopName;
        this.price = price;
        this.code = code;
    }

    public String getShopName() {
        return shopName;
    }

    public double getPrice() {
        return price;
    }

    public Discount.Code getCode() {
        return code;
    }

    public static Quote parse(String s){
        String[] arr = s.split(":");
        return new Quote(arr[0], Double.valueOf(arr[1]), Discount.Code.valueOf(arr[2]));
    }
}


class Discount {
    public enum Code{
        NONE(0),SILVER(5),GOLD(10),PLATINUM(15),DIAMOND(20);

        private final int percentage;
        Code(int percentage){
            this.percentage = percentage;
        }
    }
   
    public static String applyDiscount(Quote quote){
        return quote.getShopName() + " price is " + Discount.apply(quote.getPrice(),quote.getCode());
    }
   
   
    public static double apply(double price, Code code){
        delay();
        return  price * (100 - code.percentage) /100 ;
    }

    public static void delay(){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}










