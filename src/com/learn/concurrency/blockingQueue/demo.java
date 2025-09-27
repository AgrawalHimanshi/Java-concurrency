package com.learn.concurrency.blockingQueue;



public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BlockingQueue<Integer>  blockingQueue = new BlockingQueue<Integer>(5);
		Thread producer1 = new Thread(() -> {
			int start = 100;
			for (int i=0;i<5;i++) {
				System.out.println("producer thread " + Thread.currentThread().getName());
				try {
					blockingQueue.syncEnqueue(start);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				start++;
			}
		});
		
		Thread producer2 = new Thread(() -> {
			int start = 200;
			for (int i=0;i<5;i++) {
				System.out.println("producer thread " + Thread.currentThread().getName());
				try {
					blockingQueue.syncEnqueue(start);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				start++;
			}
		});
		Thread consumer1 = new Thread(() -> {
			
			for (int i=0;i<5;i++) {
				System.out.println("consumer thread " + Thread.currentThread().getName());
				try {
					Integer val = blockingQueue.syncDequeu();
					System.out.println("value received " + val);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		Thread consumer2 = new Thread(() -> {
			
			for (int i=0;i<5;i++) {
				System.out.println("consumer thread " + Thread.currentThread().getName());
				try {
					Integer val = blockingQueue.syncDequeu();
					System.out.println("value received " + val);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		producer1.start();
		
		producer2.start();
		
		consumer1.start();
		consumer2.start();
		
		System.out.println("Exiting main");
		
		
		

	}

}
