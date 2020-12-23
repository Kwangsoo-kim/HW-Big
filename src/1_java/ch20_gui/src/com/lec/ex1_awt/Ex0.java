//201221 kks gui_awt
package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class Ex0 {
	public static void main(String[] args) {
		Frame f = new Frame("title");
		Button btn = new Button("버튼");
		Button btn1 = new Button("그냥 버튼");
		f.add(btn,BorderLayout.NORTH);
		f.add(btn1,BorderLayout.CENTER);
		f.setSize(new Dimension(300,200));
		f.setLocation(100, 50);
		f.setVisible(true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		f.setVisible(false); 	//화면에서 안보이게
		f.dispose(); 			//프레임의 모든 자원을 해제 
		System.exit(0);			//강제종료
	}
}
