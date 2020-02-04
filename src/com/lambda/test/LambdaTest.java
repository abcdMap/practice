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
	
	@Test
	@Disabled
	public void streamTest() {
		Stream s = Arrays.asList(1,2,3).stream();
		Arrays.asList(1,2,3).parallelStream(); // 병렬 스트림
		
		// stream 요소 순회
		Arrays.asList(1,2,3).stream()
			.forEach(System.out::println);
		System.out.println("-----------");
		// stream 개별 요소 마다 연산. 하위 : 리스트 요소의 제곱 연산
		Arrays.asList(1,2,3).stream()
			.map(i -> (int)i*(int)i)
			.forEach(System.out::println);
		System.out.println("-----------");
		// stream의 최초 요소부터 선언한 인덱스까지의 요소를 추출해 새로운 stream 생성
		Arrays.asList(1,2,3).stream()
			.limit(2)
			.forEach(System.out::println);
		System.out.println("-----------");
		// stream의 요소마다 비교를 하고 비교문을 만족하는 요소로만 구성된 stream을 반환
		Arrays.asList(1,2,3).stream()
			.filter(i -> 2>=(int)i)
			.forEach(System.out::println);
		System.out.println("-----------");
		// stream의 내부에 있는 객체들을 연결한 stream을 반환
		Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4,5),Arrays.asList(6,7,8,9)).stream()
			.flatMap(i -> i.stream())
			.forEach(System.out::println);
		System.out.println("-----------");
		// stream을 단일 요소로 반환 (1-2 = -1 > -1-3 = -4
		int c = Arrays.asList(1,2,3).stream()
			.reduce((a,b) -> a-b)
			.get();
		System.out.println("result : " + c);
		System.out.println("-----------");
		// 각각의 메서드로 콜렉션 객체를 만들어서 반환
		System.out.println();
		List<Integer> list = Arrays.asList(1,2,3).stream()
			.collect(Collectors.toList());
		for (int i=0 ; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}
		Iterator it = Arrays.asList(1,2,3).stream()
			.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("--end--");
	}
	
	// JAVA8 Method Reference
	@Test
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
