package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import units.Army;

public class BesiegingArmy extends JPanel {
	private JButton attack;
	private JButton marching;
	private JButton besiege;
	private JTextArea text;
	
	private JComboBox<Army>idleBox;
	private JComboBox cityBox;
	private JButton idleIfo;
	
	
	public JButton getAttack() {
		return attack;
	}

	public JButton getMarching() {
		return marching;
	}

	public JButton getBesiege() {
		return besiege;
	}

	public JTextArea getText() {
		return text;
	}

	public JComboBox getIdleBox() {
		return idleBox;
	}

	public JComboBox getCityBox() {
		return cityBox;
	}

	public JButton getIdleIfo() {
		return idleIfo;
	}

	public BesiegingArmy(){
		setSize(1200,1200);
		 attack =new JButton("Attack");
		attack.setBounds(1,800,150,50);
		add(attack);
		 marching=new JButton("Marching");
		marching.setBounds(300,800,150,50);
		add(marching);
		 text =new JTextArea();
		text.setBounds(1,1,800,700);
		idleBox=new JComboBox();
		idleBox.setBounds(900, 50, 200, 50);
		cityBox=new JComboBox();
		cityBox.setBounds(900,300 , 200, 50);
		idleIfo=new JButton("besiegingInfo");
		idleIfo.setBounds(900, 800, 150, 50);
		add(idleIfo);
		add(idleBox);
		add(text);
		add(cityBox);
		setVisible(true);
		setLayout(null);
		
	}
	
	public static void main(String[] args) {
		JFrame frame =new JFrame();
		frame.setSize(1200,1200);
		frame.add(new BesiegingArmy());
		frame.setVisible(true); 
		new BesiegingArmy();
	}

}
