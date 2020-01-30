package javaReflection;

import java.lang.reflect.Constructor;

/**
 * 새로운 객체 만들기
 * @author soom
 *
 */
public class Constructor2 {
	public Constructor2() {
		
	}
	
	public Constructor2(int a, int b) {
		System.out.println("a = " + a + " b = " + b);
	}
	
	public static void main(String[] args) {
		try {
			Class<?> cls = Class.forName("javaReflection.Constructor2");
			Class<?> partypes[] = new Class[2];
			partypes[0] = Integer.TYPE;
			partypes[1] = Integer.TYPE;
			Constructor<?> ct = cls.getConstructor(partypes);
			
			Object arglist[] = new Object[2];
			arglist[0] = new Integer(37);
			arglist[1] = new Integer(47);
			
			// 해당 생성자를 정의하는 클래스의 객체 리턴
			Object retobj = ct.newInstance(arglist);
			
			boolean result = cls.isInstance(retobj);
			
			System.out.println("result = " + result);
			
			System.exit(0);
		} catch (Throwable e) {
			System.err.println(e);
		}
	}
}
