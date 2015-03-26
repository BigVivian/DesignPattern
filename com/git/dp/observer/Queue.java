package com.git.dp.observer;

import java.util.Observable;
import java.util.Observer;

public class Queue extends Observable {

	public Queue() {

	}

	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);

		if (o instanceof Person) {
			queueAdd();
		}
	}

	@Override
	public synchronized void deleteObserver(Observer o) {
		super.deleteObserver(o);

		if (o instanceof Person) {
			queueDelete(((Person) o).getCurrentPos());
		}

	}

	// 删除一个观察者时，传入该观察者的当前位置
	public void queueDelete(int current) {
		setChanged();
		notifyObservers(current);
		clearChanged();
	}

	// 增加一个观察者
	public void queueAdd() {
		setChanged();
		notifyObservers();
		clearChanged();
	}
}
