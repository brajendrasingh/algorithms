package com.thread;

public class Threads extends Thread {

	@Override
	public void run() {
		int x = 0;
		for (int i = 0; i < 5; i++)
			System.out.println("x: " + (++x));
	}

}
