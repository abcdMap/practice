package javaReflection;

import java.lang.reflect.Method;

/**
 * 이름으로 메소드 실행
 * @author soom
 *
 */
public class Method2 {
	public int add(int a, int b) {
		return a+b;
	}
	
	public static void main(String[] args) {
		try {
			Class<?> cls = Class.forName("javaReflection.Method2");
			
			// 두개의 숫자 파라미터
			Class<?> partypes[] = new Class[2];
			partypes[0] = Integer.TYPE;
			partypes[1] = Integer.TYPE;
			
			// add 라는 메소드 이름을 실행 시간에 알고 받아올 때
			// cls에서 두개의 숫자 파라미터를 지닌 add 라는 이름의 메소드 검색
			String methodName = "add";
			Method meth = cls.getMethod(methodName, partypes);
			
			Method2 methobj = new Method2();
			Object arglist[] = new Object[2];
			arglist[0] = new Integer(37);
			arglist[1] = new Integer(47);
			
			// 메소드 함수 호출
			Object retobj = meth.invoke(methobj, arglist);
			Integer retval = (Integer) retobj;
			System.out.println(retval.intValue());
		} catch (Throwable e) {
			System.err.println(e);
		}
	}
}
