package org.zbq.design;

interface Component {
	public void doSomething();
}

class ConcreteComponent implements Component {
	@Override
	public void doSomething() {
		System.out.println("Function");
	}
}

class Decorator implements Component {
	private Component component;
	
	public Decorator(Component component) {
		this.component = component;
	}
	
	@Override
	public void doSomething() {
		this.component.doSomething();
	}
}

class ConcreteDecorator1 extends Decorator {

	public ConcreteDecorator1(Component component) {
		super(component);
	}
	
	@Override
	public void doSomething() {
		super.doSomething();
		doAnotherthing();
	}

	private void doAnotherthing() {
		System.out.println("Function 111");
	}
}

class ConcreteDecorator2 extends Decorator {

	public ConcreteDecorator2(Component component) {
		super(component);
	}
	
	@Override
	public void doSomething() {
		super.doSomething();
		doAnotherthing();
	}

	private void doAnotherthing() {
		System.out.println("Function 222");
	}
}

public class DecoratorDemo {
	public static void main(String[] args) {
		Component component1 = new ConcreteComponent();
		Component component2 = new ConcreteDecorator1(component1);
		Component component3 = new ConcreteDecorator2(component2);
		component3.doSomething();
	}
}
