package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class info extends JPanel{
	JLabel l1=new JLabel("label 1");
	JButton b2=new JButton("World Map");
	JButton endturn;
	public info() {
			endturn=new JButton("EndTurn");
		endturn.setBounds(1800,10,100,30);	
		l1.setBounds(30, 5, 450, 80);
		b2.setBounds(1800,100,100, 30);
		setLayout(null);
		add(l1);
		add(b2);
		add(endturn);
		
	}
	public JButton getEndturn() {
		return endturn;
	}
	public JLabel getL1() {
		return l1;
	}
	public JButton getB2() {
		return b2;
	}
	public static void main(String[] args) {
		JFrame xFrame=new JFrame();
		xFrame.add(new info());
		xFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		xFrame.setVisible(true);
	}

}
