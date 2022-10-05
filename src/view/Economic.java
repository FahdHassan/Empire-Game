package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Economic extends JPanel{
	private JButton button1;
	private JButton button2;
	
	
	public JButton getButton1() {
		return button1;
	}

	public JButton getButton2() {
		return button2;
	}

	public Economic(){
		
		button1 =new JButton("Farm");
		button1.setBounds(50,80,400,80);
		add(button1);
		button2 =new JButton("Market");
		button2.setBounds(600,80,400,80);
		add(button2);
//		JButton button3 =new JButton("Upgrade Cost");
//		button3.setBounds(80,400,200,200);
//		add(button3);
//		JButton button4 =new JButton("Upgrade");
//		button4.setBounds(460,400,200,200);
//		add(button4);
		setSize(1200,1200);
		
		add(button2);
	//	setVisible(true);
		setLayout(null);

	}
	
	public static void main(String[] args) {
		JFrame frame =new JFrame();
		frame.setSize(1200,1200);
		frame.add(new Economic());
		frame.setVisible(true); 
		new Economic();
		
	}
}
