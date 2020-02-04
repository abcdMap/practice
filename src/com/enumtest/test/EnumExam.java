package com.enumtest.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

/**
 * https://inor.tistory.com/12
 * runnable 테스트
 * @author soom
 *
 */
public class EnumExam {
	enum Currency {
		DOLLAR, EURO, YEN, YUAN
	}

	@Test
	@Disabled
	@Ignore
	public void CurrencyTest() {
		Currency curCurrency = Currency.EURO;
		switch(curCurrency){
		case DOLLAR :
			System.out.println("달러 입니다.");
			break;
		case EURO :
			System.out.println("유로화 입니다.");
			break;
		}
	}
	
	enum Currency2{
		DOLLAR(1100), EURO(1500), YEN(1000), YUAN(150);
		int value; 
		private Currency2(int value){
			this.value = value;
		}
		public int getValue(){
			return value;
		}
	}

	@Test
	@Disabled
	@Ignore
	public void CurrencyTest2() {
		Currency2 curCurrency = Currency2.EURO;
		switch(curCurrency){
		case DOLLAR :
			System.out.println("달러의 환율은 " + curCurrency.getValue() + "원 입니다.");
			break;
		case EURO :
			System.out.println("유로화의 환율은 " + curCurrency.getValue() + "원 입니다.");
			break;
		}
	}
	
	enum Currency3 implements Runnable {
		DOLLAR(1100){
			public void showCurrency(){
				System.out.println("달러의 환율은 " + getValue() + "원 입니다.");
			}
			@Override
			public void run(){
				System.out.println("hello i'm run method in DOLLAR");
			}
		}, 
		EURO(1500){
			public void showCurrency(){
				System.out.println("유로의 환율은 " + getValue() + "원 입니다.");
			}
			@Override
			public void run(){
				System.out.println("hello i'm run method in EURO");
			}
		}, 
		YEN(1000){
			public void showCurrency(){
				System.out.println("엔화의 환율은 " + getValue() + "원 입니다.");
			}
			@Override
			public void run(){
				System.out.println("hello i'm run method in YEN");
			}
		}, 
		YUAN(150){
			public void showCurrency(){
				System.out.println("위완화의 환율은 " + getValue() + "원 입니다.");
			}
			@Override
			public void run(){
				System.out.println("hello i'm run method in YUAN");
			}
		};
		
		private int value; 
		
		private Currency3(int value){
			this.value = value;
		}
		
		public int getValue(){
			return value;
		}
		
		@Override
		public String toString(){
			String tempString = value+"원";
			return tempString;
		}
		
		@Override
		public void run(){
			System.out.println("hello i'm run method");
		}
		
		public void showMe(){
			System.out.println("hello i'm");
		}
		
		/*
		 * 추상 메서드를 사용하면 상수에서 재정의가 가능합니다.
		 * enum의 확장성이 증가합니다.
		 * 개발자의 실수를 컴파일 시점에 확인 할 수 있습니다.
		 */
		public abstract void showCurrency();
	}
	
	// springboot 2.0 OAUTH 설정 enum 되나 확인해본거....
	enum test {
		GOOGLE {
			@Override
			public void getBuilder() {
				
			}
		};
		
		public abstract void getBuilder();
	}
	
	@Test
	public void CurrencyTest3() {
		Currency3 myCurrency = Currency3.EURO;
		System.out.println(Currency3.EURO); // 1500원 (toString 기본 출력인듯)
		myCurrency.showCurrency();
		Currency3.YUAN.run();
	}

}
