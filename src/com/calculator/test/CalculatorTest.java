package com.calculator.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import com.calculator.Calculator;

/**
 * junit test
 * 일반 프로젝트 라이브러리에 junit 추가하면 됨.
 * http://junit.sourceforge.net/javadoc/org/junit/Assert.html
 * @author soom
 *
 */
class CalculatorTest {

	@Test
	void testSum() {
		Calculator calculator = new Calculator();
		assertEquals(30, calculator.sum(10, 20));
		fail("실패 ㅎㅎ");
	}

	@Test
	public void testSum2() {
		Calculator c = new Calculator();
		double result = c.sum(10, 50);
		// assertEquals(expected, actual, delta) 예상값, 실제값, 허용오차
		assertEquals(60, result, 0);
	}
}
