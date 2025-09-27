package com.learn.concurrency.blockingQueue;

import java.util.Deque;
import java.util.LinkedList;

public class BlockingQueue<T> {
	
	/**
	 * Classical synchronization problem involving a limited size buffer which can have items added to it or removed from it by different producer and consumer threads.
	 * This problem is known by different names: consumer producer problem, bounded buffer problem or blocking queue problem.
	 * @param args
	 */
	
	private int capacity;
	private Deque<T> dqDeque;

	
	public BlockingQueue(final int cap) {
		this.capacity = cap;
		this.dqDeque = new LinkedList<T>();
	
	}
	
	
	public void syncEnqueue(T val) throws InterruptedException {
		synchronized (this) {
			while(dqDeque.size() == this.capacity) {
				System.out.println("que is full");
				wait();
			}
			System.out.println("adding val");
			dqDeque.add(val);
			notifyAll();
			
		}
	}
	
	public T syncDequeu() throws InterruptedException {
		synchronized (this) {
			while(dqDeque.size() == 0) {
				System.out.println("que is empty");
				wait();
			}
			System.out.println("consuming val");
			T val = dqDeque.removeFirst();
			notifyAll();
			return val;
		}
	}
	

}
