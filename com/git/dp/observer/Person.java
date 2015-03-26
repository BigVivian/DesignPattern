package com.git.dp.observer;

import java.util.Observable;
import java.util.Observer;

public class Person implements Observer {
	private Observable observable;
	private String name;
	private int currentPos;

	public Person(Observable observable, String name) {
		this.observable = observable;
		this.name = name;
		this.currentPos = 0;
		observable.addObserver(this); // 增加一个观察者
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg == null && currentPos != 0) {
			;
		}

		// 更新队列状态
		if (arg != null) {
			if ((int) arg < currentPos) {
				currentPos--;
			}
		}

		// 排在队尾
		if (currentPos == 0) {
			currentPos = o.countObservers();
		}

		System.out.println(name + " is in No." + currentPos);

	}

	public String getName() {
		return name;
	}

	public int getCurrentPos() {
		return currentPos;
	}

	public void setCurrentPos(int currentPos) {
		this.currentPos = currentPos;
	}

	public static void main(String[] args) {
		Queue queue = new Queue();
		Person A = new Person(queue, "A");
		System.out.println("***********");

		Person B = new Person(queue, "B");
		System.out.println("***********");

		Person C = new Person(queue, "C");
		System.out.println("***********");

		Person D = new Person(queue, "D");
		System.out.println("***********");

		queue.deleteObserver(A);
		System.out.println("***********");

		queue.deleteObserver(D);
		System.out.println("***********");

	}
}
