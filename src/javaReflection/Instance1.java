package javaReflection;

import java.util.logging.Logger;

import dummy.A;

public class Instance1 {
	private final static Logger log = Logger.getGlobal();
	
	public static void main(String[] args) {
		try {
			// 그냥 "A"라고 하면 java.lang.ClassNotFoundException 발생 ㅠㅠ
			Class<?> cls = Class.forName("dummy.A");
			
			boolean b1 = cls.isInstance(new Integer(37));
			System.out.println(b1);
			
			boolean b2 = cls.isInstance(new A());
			System.out.println(b2);
		} catch (Throwable e) {
			// Throwable > Exception, Error 클래스의 상위 클래스
			System.err.println(e);
			log.info(e.toString());
		}
	}
}
