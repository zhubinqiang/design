package org.zbq.design;

interface Subject {
	public String say(String name, int age);
}

class RealSubject implements Subject {
	@Override
	public String say(String name, int age) {
		return "My name is " + name + ", I am " + age + " old";
	}
}

class ProxySubject implements Subject {
	private Subject subject;

	public ProxySubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String say(String name, int age) {
		return this.subject.say(name, age);
	}
}

public class PorxyStatic {

	public static void main(String[] args) {
		Subject sub = new ProxySubject(new RealSubject());
		System.out.println(sub.say("Zhangsan", 21));
	}

}
