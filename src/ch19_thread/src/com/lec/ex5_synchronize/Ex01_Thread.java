package com.lec.ex5_synchronize;

//Thread N�� ��ü 1�� ���� - Runnable�� �̿�
public class Ex01_Thread implements Runnable {
	private int num; // ��������

	@Override

	public void run() { // synchronized run()�����߿��� �ƹ��͵� ������� ���Ѵ�.
		for (int i = 0; i < 10; i++) {
			out();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private synchronized void out() {
		String threadName = Thread.currentThread().getName();
		if (threadName.equals("A")) {
			System.out.println("~ ~ ~ A ������ ~ ~ ~");
			num++;
		}
		System.out.println(threadName + "�� num = " + num);
	}
}
