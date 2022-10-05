package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Military extends JPanel {
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	
	public JButton getButton1() {
		return button1;
	}
	public JButton getButton2() {
		return button2;
	}
	public JButton getButton3() {
		return button3;
	}
	public JButton getButton4() {
		return button4;
	}
	public JButton getButton5() {
		return button5;
	}
	public Military(){
		
		 button1 =new JButton("ArcheryRange");
		button1.setBounds(50,80,400,100);
		add(button1);
		 button2 =new JButton("Barracks");
		button2.setBounds(600,80,400,100);
		add(button2);
		 button3 =new JButton("Stable");
		button3.setBounds(1150,80,400,100);
		add(button3);
//		 button4 =new JButton("RecruitmentCost");
//		button4.setBounds(70,500,400,200);
//		add(button4);
//		 button5 =new JButton("Recruit");
//		button5.setBounds(600,500,400,200);
		//add(button5);
		setSize(1200,1200);
		add(button2);
		setLayout(null);
	}
	public static void main(String[] args) {
		JFrame frame =new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.add(new Military());
		frame.setVisible(true);
		new Military();
		
	}

}
