//201221 kks threadN_objectN
package com.lec.ex4_threadN_objectN;

public class Ex02_TestMain {
	public static void main(String[] args) {
		Runnable target1 = new Ex01_Thread();
		Runnable target2 = new Ex01_Thread();
		Thread t1 = new Thread(target1,"A");
		Thread t2 = new Thread(target2,"B");
		t1.start();
		t2.start();
		//�ٸ� ��ü�� �νĵǱ⶧���� ó�� ����ߴ� �� �״�� ����
		
	}
}
