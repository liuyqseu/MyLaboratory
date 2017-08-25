package com.liu.date20170502;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Herry
 * @time 2017年5月2日23:07:33
 * @description 测试java 8新特性：方法引用
 * 
 * 注：方法引用的的好处：
 *     方法引用提供了非常有用的语法，可以直接引用已有Java类或对象（实例）的方法或构造器。与lambda联合使用，方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
 */
public class TestMethodQuote {
	
	public static TestMethodQuote create(final Supplier<TestMethodQuote> supplier) {
        return supplier.get();
    }              
         
    public static void collide( final TestMethodQuote TestMethodQuote) {
        System.out.println("Collided " + TestMethodQuote.toString() );
    }
         
    public void follow(final TestMethodQuote another) {
        System.out.println("Following the " + another.toString());
    }
         
    public void repair() {   
        System.out.println("Repaired " + this.toString());
    }	    
    
    public static void main(String[] args) {
    	// 构造器引用，它的语法是Class::new
		final TestMethodQuote car = TestMethodQuote.create(TestMethodQuote::new);
		final List<TestMethodQuote> cars = Arrays.asList(car);
    	
		// 静态方法引用，它的语法是Class::static_method
		cars.forEach( TestMethodQuote::collide );
		
		// 特定类的任意对象的方法引用，它的语法是Class::method	
		cars.forEach(TestMethodQuote::repair);
		
		// 特定对象的方法引用，它的语法是instance::method
		final TestMethodQuote police = TestMethodQuote.create(TestMethodQuote::new);
		cars.forEach(police::follow);
		
	}
    
	

}
