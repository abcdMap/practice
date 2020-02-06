package com.generic;

public class Util {
	public static <T> GenericBox<T> boxing(T t) {
		GenericBox<T> box = new GenericBox<T>();
		box.set(t);
		return box;
	}

	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        boolean keyCompare = p1.getKey().equals(p2.getKey());
        boolean valueCompare = p1.getValue().equals(p2.getValue());
 
        return keyCompare && valueCompare;
    }

    public static <T extends Number> int compare(T t1, T t2) {
        double v1 = t1.doubleValue();
        double v2 = t2.doubleValue();
 
        return Double.compare(v1, v2);
    }

}
