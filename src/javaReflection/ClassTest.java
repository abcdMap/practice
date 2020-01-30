package javaReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import javax.xml.crypto.Data;
/**
 * reflection class 테스트
 * @author soom
 *
 */
public class ClassTest {
	public static void main(String[] args) {
		try {
			Class<?> c = Date.class;
			// Class<?> c = Data.class;
			// Class<?> c = Class.gorName("클래스이름");
			// Class<?> c = int.class;
			// 기본형의 경우 (Integer 와 같은) Wrapper 에 기정의된 TYPE을 사용한다.
			// Class<?> c = Integer.TYPE;
			
			Method[] m = c.getMethods();
			// public 으로 선언된 변수 목록을 리턴
			Field[] f = c.getFields();
			Constructor<?>[] cs = c.getConstructors();
			Class<?>[] inter = c.getInterfaces();
			Class<?> superClass = c.getSuperclass();
			
			for (int i=0 ; i < m.length ; i++) {
				System.out.println("class Method[" + i + "] : " + m[i].toString());
			}
			
			System.out.println("\n");
			
			for (int i=0 ; i < f.length ; i++) {
				System.out.println("class Field[" + i + "] : " + f[i].toString());
			}
			
			System.out.println("\n");
			
			// constructor : 생성자
			for (int i=0 ; i < cs.length ; i++) {
				System.out.println("class Constructor[" + i + "] : " + cs[i].toString());
			}
			
			System.out.println("\n");
			
			for (int i=0 ; i < inter.length ; i++) {
				System.out.println("class Interface[" + i + "] : " + inter[i].toString());
			}
			
			System.out.println("\n");
			
			System.out.println("superclass name : " + superClass.getName());
			Method[] sm = superClass.getMethods();
			
			for (int i=0 ; i < sm.length ; i++) {
				System.out.println("class Superclass Method[" + i + "] : " + sm[i].toString());
			}
			
			System.out.println("\n");
			
			//System.exit(0);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
