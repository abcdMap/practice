package javaReflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Class Fields 찾기
 * @author soom
 *
 */
public class Field1 {
	@SuppressWarnings("unused")
	private double d;
	public static final int i = 37;
	String s = "testing";
	
	public static void main(String[] args) {
		try {
			Class<?> cls = Class.forName("javaReflection.Field1");
			Field fieldlist[] = cls.getDeclaredFields();
			
			for (int i=0 ; i < fieldlist.length ; i++) {
				Field fld = fieldlist[i];
				System.out.println("name = " + fld.getName());
				System.out.println("decl class = " + fld.getDeclaringClass());
				System.out.println("type = " + fld.getType());
				// modifier는 "private int"와 같은 필드 멤버를 표현하기 위한 reflection class
				// modifier 제어자 : static, final, abstract
				// access modifier 접근 제어자 : public, protected, default, private
				int mod = fld.getModifiers();
				System.out.println("modifiers num = " + mod);
				System.out.println("modifiers = " + Modifier.toString(mod));
				System.out.println("-----");
			}
		} catch (Throwable e) {
			System.err.println(e);
		}
	}
}
