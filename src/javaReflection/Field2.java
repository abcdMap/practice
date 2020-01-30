package javaReflection;

import java.lang.reflect.Field;

/**
 * 필드값 바꾸기
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
			// f2obj 객체의 fld에 정의된 필드에만 값을 넣음
			fld.setDouble(f2obj, 12.34);
			System.out.println("d = " + f2obj.d);
			System.out.println("d1 = " + f2obj.d1);
			// f2obj 객체의 fld에 정의된 필드의 값만 가져옴
			System.out.println("d = " + fld.getDouble(f2obj));
		} catch (Throwable e) {
			System.err.println(e);
		}
	}
}
