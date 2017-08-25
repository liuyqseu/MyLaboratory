package com.liu.date20170503;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by Herry on 2017/7/2.
 */
public class TestFunction {

    public static void main(String[] args) {
        // Function接口
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        Function<String, Integer> toIntegerAddOne = toInteger.andThen(x -> x+1);

        String aString = backToString.apply("123");
        int b = toInteger.apply("123");
        int c = toIntegerAddOne.apply("12");

        System.out.println(aString);
        System.out.println(b);
        System.out.println(c);

        // Predicate接口
        Predicate<String> predicate = (s) -> s.length() > 0;
        predicate.test("foo");              // true
        predicate.negate().test("foo");     // false
        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        // Supplier接口
        Supplier<Person> personSupplier = Person::new;
        Person person = personSupplier.get();   // new Person




        // Consumer接口
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.name);
        greeter.accept(new Person("Luke", 1));

        Stream<Integer> stream = Stream.of(1,2,3,4,5);
        Stream<String> stream2 = Stream.of("d","dd");



    }


}





class Person{

    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }



}