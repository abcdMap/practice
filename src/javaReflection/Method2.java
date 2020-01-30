package javaReflection;

import java.lang.reflect.Method;

/**
 * �̸����� �޼ҵ� ����
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
			
			// �ΰ��� ���� �Ķ����
			Class<?> partypes[] = new Class[2];
			partypes[0] = Integer.TYPE;
			partypes[1] = Integer.TYPE;
			
			// add ��� �޼ҵ� �̸��� ���� �ð��� �˰� �޾ƿ� ��
			// cls���� �ΰ��� ���� �Ķ���͸� ���� add ��� �̸��� �޼ҵ� �˻�
			String methodName = "add";
			Method meth = cls.getMethod(methodName, partypes);
			
			Method2 methobj = new Method2();
			Object arglist[] = new Object[2];
			arglist[0] = new Integer(37);
			arglist[1] = new Integer(47);
			
			// �޼ҵ� �Լ� ȣ��
			Object retobj = meth.invoke(methobj, arglist);
			Integer retval = (Integer) retobj;
			System.out.println(retval.intValue());
		} catch (Throwable e) {
			System.err.println(e);
		}
	}
}
