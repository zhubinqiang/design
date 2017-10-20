package org.zbq.design;

import java.util.ArrayList;
import java.util.List;

interface Watched {
	public void addWatcher(Watcher watcher);
	public void removeWatcher(Watcher watcher);
	public void notifyWatchers(String s);
}

interface Watcher {
	public void update(String s);
}

class House implements Watched {
	private List<Watcher> list = new ArrayList<Watcher>();

	@Override
	public void addWatcher(Watcher watcher) {
		list.add(watcher);
	}

	@Override
	public void removeWatcher(Watcher watcher) {
		list.remove(watcher);
	}

	@Override
	public void notifyWatchers(String s) {
		for(Watcher w : list) {
			w.update(s);
		}
	}
}

class Person implements Watcher {
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	@Override
	public void update(String s) {
		System.out.println(name + " Say:" + s);
	}
}

public class Observer {
	public static void main(String[] args) {
		Watched hourse = new House();
		Watcher person1 = new Person("张三");
		Watcher person2 = new Person("李四");
		Watcher person3 = new Person("王五");

		hourse.addWatcher(person1);
		hourse.addWatcher(person2);
		hourse.addWatcher(person3);
		
		hourse.notifyWatchers("房价上涨了... ...");
	}
}
