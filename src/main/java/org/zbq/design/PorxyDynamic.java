package org.zbq.design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Sub {
	public String say(String name, int age);
}

class RealSub implements Sub {
	@Override
	public String say(String name, int age) {
		return "My name is " + name + ", I am " + age + " old";
	}
}

class MyInvocationHandler  implements InvocationHandler {
	private Object obj;
	public Object bind(Object obj) {
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("start ... ...");
		Object temp = method.invoke(this.obj, args);
		return temp;
	}
	
}

public class PorxyDynamic {

	public static void main(String[] args) {
		Sub sub = (Sub) new MyInvocationHandler().bind(new RealSub());
		System.out.println(sub.say("Tom", 24));
	}

}
