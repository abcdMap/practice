package com.lambda;

// 람다식을 위한 인터페이스임을 선언하기 위한 annotation
// (즉 하나의 메소드만 가지도록 선언하는 annotation)
@FunctionalInterface
public interface Func {
	public int calc(int a, int b);
}
