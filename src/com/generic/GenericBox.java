package com.generic;

public class GenericBox<T> {
	private T t;
	
	public T get() { return t; }
	public void set(T t) { this.t = t; }
}
