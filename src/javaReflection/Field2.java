package javaReflection;

import java.lang.reflect.Field;

/**
 * �ʵ尪 �ٲٱ�
 * @author soom
 *
 */
public class Field2 {
	public double d;
	public double d1;
	
	public static void main(String[] args) {
		try {
			Class<?> cls = Class.forName("javaReflection.Field2");
			Field fld = cls.getField("d1");
			Field2 f2obj = new Field2();
			System.out.println("d = " + f2obj.d);
			// f2obj ��ü�� fld�� ���ǵ� �ʵ忡�� ���� ����
			fld.setDouble(f2obj, 12.34);
			System.out.println("d = " + f2obj.d);
			System.out.println("d1 = " + f2obj.d1);
			// f2obj ��ü�� fld�� ���ǵ� �ʵ��� ���� ������
			System.out.println("d = " + fld.getDouble(f2obj));
		} catch (Throwable e) {
			System.err.println(e);
		}
	}
}
