package javaReflection;

import java.util.logging.Logger;

import dummy.A;

public class Instance1 {
	private final static Logger log = Logger.getGlobal();
	
	public static void main(String[] args) {
		try {
			// �׳� "A"��� �ϸ� java.lang.ClassNotFoundException �߻� �Ф�
			Class<?> cls = Class.forName("dummy.A");
			
			boolean b1 = cls.isInstance(new Integer(37));
			System.out.println(b1);
			
			boolean b2 = cls.isInstance(new A());
			System.out.println(b2);
		} catch (Throwable e) {
			// Throwable > Exception, Error Ŭ������ ���� Ŭ����
			System.err.println(e);
			log.info(e.toString());
		}
	}
}
