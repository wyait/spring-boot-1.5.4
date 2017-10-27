package com.wyait.boot.thread;

public class SellTiketDemo implements Runnable {
	// 100张票
	private int tickets = 100;

	// 定义一个对象
	private Object obj = new Object();

//	@Override
//	public void run() {
//		/**
//		* 问题：同样的票出现多次，且有负数；
//		*/
//		while (true) { // t1,t2,t3都能走到这里 // 假设t1抢到CPU的执行权，t1就要进来 //
//			// 假设t2抢到CPU的执行权，t2就要进来,发现门是关着的，进不去。所以就等着。 // 门(开,关)
//			synchronized (obj) {// 发现这里的代码将来是会被锁上的，所以t1进来后，就锁了。(关)
//				if (tickets > 0) {
//					try {
//						Thread.sleep(100);// 睡100毫秒
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					} // 出票
//					System.out.println(Thread.currentThread().getName()
//							+ "正在出售第" + (tickets--) + "张票 ");
//				}
//			}// t1出来，开门
//		}
//	}

	private int x = 0;

	@Override
	public void run() {
		while (true) {
			if (x % 2 == 0) {
				// t1,t2,t3都能走到这里
				// 假设t1抢到CPU的执行权，t1就要进来
				// 假设t2抢到CPU的执行权，t2就要进来,发现门是关着的，进不去。所以就等着。
				// 门(开,关)
				synchronized (obj) {// 发现这里的代码将来是会被锁上的，所以t1进来后，就锁了。(关)
					if (tickets > 0) {
						try {
							Thread.sleep(100);// 睡100毫秒
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						// 出票
						System.out.println(Thread.currentThread().getName()
								+ "正在出售第" + (tickets--) + "张票 ");
					}
				}// t1出来，开门
			} else {
				sellTicket();
			}
			x++;
		}
	}

	private synchronized void sellTicket() {
		if (tickets > 0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "正在出售第"
					+ (tickets--) + "张票 ");
		}
	}

}
