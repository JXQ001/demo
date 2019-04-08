package demo.reflect;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws Exception{
		String className = "demo.reflect.Hello";
		String sayHello = "sayHello";
		Class clazz = Class.forName(className);
		Object obj = clazz.newInstance();
		Method m = obj.getClass().getDeclaredMethod(sayHello,String.class,String.class);
		Object invoke = m.invoke(obj,"saa","dssd");
		System.out.println(invoke);
	}

}
