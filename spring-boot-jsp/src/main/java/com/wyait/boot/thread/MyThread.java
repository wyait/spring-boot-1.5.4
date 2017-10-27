package com.wyait.boot.thread;

public class MyThread extends Thread {
	@Override
	public void run() {
		// 自定义
		for (int i = 0; i < 100; i++) {
			System.out.println("##="+i);
		}
	}
}
