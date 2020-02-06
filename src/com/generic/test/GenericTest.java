package com.generic.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.generic.Apple;
import com.generic.Box;
import com.generic.GenericBox;
import com.generic.Pair;
import com.generic.Product;
import com.generic.Util;

/**
 * https://palpit.tistory.com/664
 * JAVA 5 부터 추가 된 Generic 타입 : 타입을 파라미터로 가지는 클래스와 인터페이스
 * @author soom
 *
 */
public class GenericTest {
	/**
	 * Generic 기본 테스트
	 */
	@Test
	@Disabled
	public void castingTest() {
		List list = new ArrayList();
		list.add("hello");
		// 제네릭 선언 안 할 시 불필요한 타입 변환 필요.
		String str = (String) list.get(0);
		System.out.println("타입 변환 : " + str);
		
		List<String> list2 = new ArrayList<String>();
		list2.add("hello2");
		String str2 = list2.get(0);
		System.out.println("제네릭 : " + str2);
	}
	
	/**
	 * Generic Class 테스트
	 */
	@Test
	@Disabled
	public void objectBoxTest() {
		// box에 다양한 종류의 클래스를 받기 위해서 Object 사용 시 사용 할 때마다 형변환 필요.
		Box box = new Box();
		box.set("Hi");
		String str = (String) box.get();
		
		// 저장 할 때, 불러올 때 타입 변환이 발생
		box.set("Jackie Chan");	// String => Object (자동 타입 변환)
		String name = (String) box.get();	// Object => String (강제 타입 변환)
		
		System.out.println(name);
		
		box.set(new Apple());	// Apple => Object (자동 타입 변환)
		Apple apple = (Apple) box.get();	// Object => Apple (강제 타입 변환)
		
		System.out.println(apple.getClass().getName());
		
		// Object -> 타입 파라미터 T로 대체
		GenericBox<String> gBox = new GenericBox<String>();
		gBox.set("Hi");
		
		String str2 = gBox.get();
		System.out.println(str2);
		
		GenericBox<Integer> gBox2 = new GenericBox<Integer>();
		gBox2.set(11);
		
		int value = gBox2.get();
		System.out.println(value);
	}
	
	/**
	 * Generic 멀티 타입 파라미터 <K, V, ...>
	 */
	@Test
	@Disabled
	public void multitypeTest() {
		Product<Box, String> boxProduct = new Product<Box, String>();
		boxProduct.setKind(new Box());
		boxProduct.setModel("Box Class");
		Box box = boxProduct.getKind();
		String boxModel = boxProduct.getModel();
		
		System.out.println(box.getClass().getName() + ":" + boxModel);
		
		// 생성자 <> 내부 생략 가능
		Product<GenericBox<String>, String> gBoxProduct = new Product<>();
		gBoxProduct.setKind(new GenericBox<String>());
		gBoxProduct.setModel("gBox Class");
		GenericBox<String> gBox = gBoxProduct.getKind();
		String gBoxModel = gBoxProduct.getModel();
		
		System.out.println(gBox.getClass().getName() + ":" + gBoxModel);
	}
	
	/**
	 * Generic Method
	 */
	@Test
	@Disabled
	public void methodTest() {
		GenericBox<Integer> box1 = Util.<Integer> boxing(100);
		int intValue = box1.get();
		
		GenericBox<String> box2 = Util.boxing("ABC");
		String strValue = box2.get();
		
		
        Pair<Integer, String> p1 = new Pair<>(1, "사과");
        Pair<Integer, String> p2 = new Pair<>(1, "사과");
 
        boolean result = Util.<Integer, String> compare(p1, p2);
 
        if (result) {
            System.out.println("논리적으로 동등한 객체입니다.");
        } else {
            System.out.println("논리적으로 동등하지 않은 객체입니다.");
        }
 
        Pair<String, String> p3 = new Pair<>("user1", "Jarc");
        Pair<String, String> p4 = new Pair<>("user2", "Jarc");
 
        boolean result2 = Util.compare(p3, p4);
 
        if (result2) {
            System.out.println("논리적으로 동등한 객체입니다.");
        } else {
            System.out.println("논리적으로 동등하지 않은 객체입니다.");
        }
	}
	
	/**
	 * 제한된 타입 파라미터(<T extends 최상위 타입>)
	 * ? 와일드 카드 => 상세 내용은 상단 주소에.
	 */
	@Test
	public void typeLimitTest() {
		int result1 = Util.compare(10, 20);
		System.out.println(result1);
		
		int result2 = Util.compare(4.5, 3);
		System.out.println(result2);
	}
}
