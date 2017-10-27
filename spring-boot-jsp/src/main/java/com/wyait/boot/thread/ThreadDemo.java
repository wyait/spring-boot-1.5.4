package com.wyait.boot.thread;
/**
 * 
 * @项目名称：wupao-job
 * @类名称：ThreadDemo
 * @类描述：多线程demo
 * @创建人：wyait
 * @创建时间：2017年8月11日 下午3:05:31 
 * @version：
 */
public class ThreadDemo {
	public static void main(String[] args) {
		
		/*MyThread m1=new MyThread();
		MyThread m2=new MyThread();
		System.out.println("==================threadName=====!"+m2.getName());
		System.out.println("==================threadName=====!"+m1.getName());*/
		/*MyRunable m1=new MyRunable();
		MyRunable m2=new MyRunable();
		Thread t1=new Thread(m1, "m1");
		Thread t2=new Thread(m2, "m2");
		t1.start();
		t2.start();*/
		SellTiketDemo m1=new SellTiketDemo();
		Thread t1=new Thread(m1, "m1");
		Thread t2=new Thread(m1, "m2");
		Thread t3=new Thread(m1, "m3");
		t1.start();
		t2.start();
		t3.start();
	}
	
}
