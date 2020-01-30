package javaReflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Class Fields ã��
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
				// modifier�� "private int"�� ���� �ʵ� ����� ǥ���ϱ� ���� reflection class
				// modifier ������ : static, final, abstract
				// access modifier ���� ������ : public, protected, default, private
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
