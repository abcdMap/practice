package javaReflection;

import java.lang.reflect.Array;

/**
 * 3차원 배열의 사용
 * @author soom
 *
 */
public class Array2 {
	public static void main(String[] args) {
		int dims[] = new int[] {5, 10, 15};
		Object arr = Array.newInstance(Integer.TYPE, dims);
		
		Object arrobj = Array.get(arr, 3);
		Class<?> cls = arrobj.getClass().getComponentType();
		System.out.println(cls);
		arrobj = Array.get(arrobj, 5);
		Array.setInt(arrobj, 10, 37);
		
		int arrcast[][][] = (int[][][]) arr;
		System.out.println(arrcast[3][5][10]);
	}
}
