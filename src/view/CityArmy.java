package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import units.Army;

public class CityArmy extends JPanel {
	private JButton relocateButton;
	private JButton intiateButton;
	private JComboBox defArmyBox;
	private JComboBox armyBox;
	
	
	
	public JButton getRelocateButton() {
		return relocateButton;
	}
	public JButton getIntiateButton() {
		return intiateButton;
	}
	public JComboBox getDefArmyBox() {
		return defArmyBox;
	}
	public JComboBox getArmyBox() {
		return armyBox;
	}
	public CityArmy(){
		relocateButton=new JButton("Relocate");
		relocateButton.setBounds(100,500,400,100);
		add(relocateButton);
		intiateButton=new JButton("IntiateArmy");
		intiateButton.setBounds(600,500,400,100);
		add(intiateButton);
		defArmyBox=new JComboBox();
		defArmyBox.setBounds(50,170,300,100);
		add(defArmyBox);
		armyBox=new JComboBox();
		armyBox.setBounds(530,170,300,100);
		add(armyBox);
		setVisible(true);
		setBounds(0, 0, 2000, 2000);
		setLayout(null);
		
		
		
		
	}
	public static void main(String[] args) {
		JFrame frame =new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.add(new CityArmy());
		frame.setVisible(true); 
		new CityArmy();
	}

}
