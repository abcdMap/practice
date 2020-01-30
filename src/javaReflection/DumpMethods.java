package javaReflection;

import java.lang.reflect.Method;

/**
 * Reflection : ��ü�� ���� Ŭ������ ������ �м��� ���� ���α׷� ���(����, �ݻ�)
 * @author soom
 *
 */
public class DumpMethods {
	/**
	 * ���� �� run Configuration > arguments 'java.util.Stack'
	 * ���� �޼ҵ� ����Ʈ ���
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
