package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class BattleView extends JPanel {


		private JButton playerButton;
		private JButton arButton;
		private JButton manualButton;
		private JButton defenArmy;
		private JTextArea tarea1;
		private JTextArea tarea2;
		private JComboBox army;
		
		
	public JComboBox getArmy() {
			return army;
		}

	public JButton getPlayerButton() {
		return playerButton;
	}

	public JButton getArButton() {
		return arButton;
	}

	public JButton getManualButton() {
		return manualButton;
	}
	
	
	public JButton getDefenArmy() {
		return defenArmy;
	}

	public JTextArea getTarea1() {
		return tarea1;
	}

	public JTextArea getTarea2() {
		return tarea2;
	}

	public BattleView(){
		setSize(1200,1200);
		playerButton =new JButton("PlayerArmy");
		playerButton.setBounds(1,800,150,50);
		add(playerButton);
		arButton =new JButton("AutoResolve");
		arButton.setBounds(300,800,150,50);
		add(arButton);
		manualButton=new JButton("Manual");
		manualButton.setBounds(600,800,150,50);
		add(manualButton);
		defenArmy =new JButton("DefendingArmy");
		defenArmy.setBounds(900,800,150,50);
		add(defenArmy);
		tarea1=new JTextArea();
		tarea1.setBounds(1,1,500,500);
		add(tarea1);
		tarea2=new JTextArea();
		tarea2.setBounds(550,1,500,500);
		add(tarea2);
		army= new JComboBox();
		army.setBounds(650, 600, 200, 50);
		add(army);
		setLayout(null);
		
		setVisible(true);
		
		
		
	}

public static void main(String[] args) {
	JFrame frame =new JFrame();
	frame.setSize(1200,1200);
	frame.add(new BattleView());
	frame.setVisible(true); 
	new BattleView();
}

}
