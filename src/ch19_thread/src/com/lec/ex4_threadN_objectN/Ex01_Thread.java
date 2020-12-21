//201221 kks threadN_objectN
package com.lec.ex4_threadN_objectN;

//Thread N�� ��ü 1�� ���� - Runnable�� �̿�
public class Ex01_Thread implements Runnable {
	private int num; // ��������

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			String threadName = Thread.currentThread().getName();
			if (threadName.equals("A")) {
				System.out.println("~ ~ ~ A ������ ~ ~ ~");
				num++;
			}
			System.out.println(threadName + "�� num = " + num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
