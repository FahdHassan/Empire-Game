package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import units.Army;

public class MarchingArmy extends JPanel {
	private JButton attack;
	private JButton marching;
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

	public MarchingArmy() {
	
		setSize(1200,1200);
		 marching=new JButton("Marching");
		marching.setBounds(300,800,150,50);
		add(marching);
		 text =new JTextArea();
		text.setBounds(1,1,800,700);
		idleBox=new JComboBox();
		idleBox.setBounds(900, 50, 200, 50);
		cityBox=new JComboBox();
		cityBox.setBounds(900,300 , 200, 50);
		idleIfo=new JButton("marchingInfo");
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
		frame.add(new MarchingArmy());
		frame.setVisible(true); 
		new MarchingArmy();
	}

}
