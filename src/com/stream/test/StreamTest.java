package com.stream.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import dummy.Person;

public class StreamTest {

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
		
		// stream을 단일 요소로 반환 (1-2 = -1 > -1-3 = -4)
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
	
	// https://effectivesquid.tistory.com/entry/Java-Stream%EC%9D%B4%EB%9E%80
	@Test
	@Disabled
	public void beforeUseStream() {
		//Stream 사용 전
		String[] strArr = {"mash-up", "backend", "codingsquid"};
		List<String> strList = Arrays.asList(strArr);
		
		Arrays.sort(strArr);
		Collections.sort(strList);
		
		for (String str : strArr) {
			System.out.println(str);
		}
		
		for (String str : strList) {
			System.out.println(str);
		}
		
		//Stream 사용 후
		Stream<String> listStream = strList.stream();
		Stream<String> arrayStream = Arrays.stream(strArr);
		
		listStream.sorted().forEach(System.out::println);
		arrayStream.sorted().forEach(System.out::println);
		
		System.out.println("----------------");
		
		// String 인 경우 1, 10, 2, 5 | Integer 인 경우 1, 2, 5, 10
		Stream<Integer> testStream = Arrays.asList(new Integer[]{1, 2, 2, 10, 5}).stream();
		
		testStream.distinct().limit(5).sorted().map(i -> i + " ").forEach(System.out::print);
	}
	
	/**
	 * 스트림의 소스가 될 수 있는 대상은 배열, 컬렉션, 임의의 수, 파일 등 다양하다.
	 */
	
	@Test
	@Disabled
	public void collectionStreamTest() {
		// Collection에 stream이 정의되어 있음
		//Stream<T> Collection.stream();
		
		// List로부터 스트림을 생성하는 코드
		List<String> list = Arrays.asList("a", "b", "c");
		Stream<String> listStream = list.stream();
		
		listStream.map(i -> i + " ").forEach(System.out::print);
	}
	
	@Test
	@Disabled
	public void arrayStreamTest() {
		// Stream의 static 메서드
		//Stream<T> Stream.of(T... values); // 가변인자
		//Stream<T> Stream.of(T[]);
		// Arrays의 static 메서드
		//Stream<T> Arrays.stream(T[]);
		//Stream<T> Arrays.stream(T[] array, int startInclusive, int endExclusive);
		//문자열 스트림 생성 코드
		Stream<String> strStream = Stream.of("a", "b", "c"); // 가변인자
		Stream<String> strStream2 = Stream.of(new String[] {"a", "b", "c"});
		Stream<String> strStream3 = Arrays.stream(new String[] {"a", "b", "c"});
		Stream<String> strStream4 = Arrays.stream(new String[] {"a", "b", "c"}, 0, 3); // end범위 포함 x
	}
	
	/**
	 * 중간연산
	 */
	
	@Test
	@Disabled
	public void mapStreamTest() {
		// 스트림 요소에 저장된 값 중에서 원하는 필드로만 뽑아내거나, 특정 형태로 변환할 때 사용
		// Stream<R> map(Function<? super T, ? extends R> mapper);
		Stream<File> fileStream = Stream.of(new File("Ex1.java"), new File("Ex1.txt"), new File("Ex2.java"));
		// map()으로 Stream<File>을 Stream<String>으로 변환
		Stream<String> fileNameStream = fileStream.map(File::getName);
		fileNameStream.forEach(System.out::println);
	}
	
	@Test
	@Disabled
	public void flatMapStreamTest() {
		// 스트림의 요소가 배열이거나 map()의 연산결과가 배열인 경우, 즉 스트림의 타입이 Stream<T[]>인 경우.
		// Stream<T[]> -> Stream 으로 변환
		Stream<String[]> strArrStream = Stream.of(new String[] {"a", "b", "c"}, new String[] {"d", "e", "f"});
		
		Stream<Stream<String>> strStrStream = strArrStream.map(Arrays::stream);
		
		Stream<String> strStream = strArrStream.flatMap(Arrays::stream);
	}
	
	/**
	 * 최종연산
	 */
	
	@Test
	@Disabled
	public void reduceStreamTest() {
		// Optional<T> reduce(BinaryOperator<T> accumulator);
		List<Integer> intList = new ArrayList<>();
		intList.add(1);
		intList.add(12);
		intList.add(15);
		intList.add(7);
		intList.add(8);
		intList.add(9);
		intList.add(10);
		Stream<Integer> intStream = intList.stream();
		System.out.println(intStream.reduce(Integer::max).get().toString());
	}
	
	@Test
	public void collectStreamTest() {
		// collect() : 스트림의 최종연산, 매개변수로 컬렉터를 필요로 한다.
		// Collector : 인터페이스, 컬렉터는 이 인터페이스를 구현해야한다.
		// Collectors : 클래스, static메서드로 미리 작성된 컬렉터를 제공한다.
		// Object collect(Collector collector);
		Stream<Person> personList = Stream.of(new Person("A"), new Person("B"), new Person("C"));
				
		List<String> names = personList.map(Person::getName).collect(Collectors.toList()); 
		
		ArrayList<String> list = names.stream().collect(Collectors.toCollection(ArrayList::new));
	}
}
