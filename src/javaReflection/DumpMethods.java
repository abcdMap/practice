package javaReflection;

import java.lang.reflect.Method;

/**
 * Reflection : 객체를 통해 클래스의 정보를 분석해 내는 프로그램 기법(투영, 반사)
 * @author soom
 *
 */
public class DumpMethods {
	/**
	 * 실행 전 run Configuration > arguments 'java.util.Stack'
	 * 하위 메소드 리스트 출력
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Class<?> c = Class.forName(args[0]);
			Method m[] = c.getDeclaredMethods();
			for (int i=0 ; i < m.length ; i++) {
				System.out.println(m[i].toString());
			}
		} catch (Throwable e) {
			System.err.println(e);
		}
	}
}
