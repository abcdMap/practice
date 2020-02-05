package com.lambda.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.lambda.Func;

import dummy.Person;

class LambdaTest {
	// 익명 클래스
	@Test
	@Disabled
	public void threadTest() {
		// Thread - traditional
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello World.");
			}
		}).start();
	}
	
	@Test
	// junit5 이전에는 ignore로 무시
	@Disabled
	public void threadWithLambdaTest() {
		// Thread - Lambda Expression
		// Runnable 이 FunctionalInterfae 라서 가능(메소드 하나만 가진 인터페이스)
		// 확인 하려면 java decompiler 설치
		new Thread(()->{
			System.out.println("Hello World.");
		}).start();
	}

	@Test
	@Disabled
	public void funcTest() {
		Func add = (a, b) -> a + b;
		Func sub = (int a, int b) -> a - b;
		Func add2 = (int a, int b) -> { return a + b; };
		
		assertEquals(3, add.calc(1, 2));
		assertEquals(5, sub.calc(7, 2));
		
		int result = add.calc(1, 2) + add2.calc(3, 4);
		
		assertEquals(10, result);
	}
	
	// JAVA8 Method Reference
	@Test
	@Disabled
	public void methodReferenceTest() {
		String [] strings = new String [] {
				"6", "5", "4", "3", "2", "1"
		};
		
		List<String> list = Arrays.asList(strings);
		
		/*
		 * for (String s : strings) { System.out.println(s); }
		 */
		
		//list.forEach(x -> System.out.println(x));
		
		// System 클래스가 가진 println 메소드를 forEach에게 전달
		list.forEach(System.out::println);
	}
	
	// 함수형 인터페이스 ex
	// https://imcts.github.io/java-method-reference/
	// JAVA 8 기본 함수형 인터페이스 : https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
	@Test
	@Disabled
	public void functionalInterfaceTest() {
		Person member = new Person();
		Person member1 = new Person("dolen1");
		Person member2 = new Person("dolen2", "man");
		
		// Function<T,R> : T 타입 인자를 받는 함수
		//Function<String, Person> myFunction = name -> new Person(name);
		Function<String, Person> myFunction = Person::new;
		myFunction.apply("dolen1");
		
		// BiFunction<T, U, R> : T와 U타입 인자를 받는 함수
		BiFunction<String, String, Person> myFunction1 = Person::new;
		myFunction1.apply("dolen", "man");
	}
}
