package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Cityview extends JPanel {
	private JButton button1 ;
	private JButton button2;
	private JButton cityArmy;
	
	
	
	
	public JButton getCityArmy() {
		return cityArmy;
	}

	public JButton getButton1() {
		return button1;
	}

	public void setButton1(JButton button1) {
		this.button1 = button1;
	}

	public JButton getButton2() {
		return button2;
	}

	public void setButton2(JButton button2) {
		this.button2 = button2;
	}

	
	
	public Cityview(){
		
		 button1 =new JButton("Economic");
		button1.setBounds(60,250,400,100);
		add(button1);
		 button2 =new JButton("Military");
		button2.setBounds(530,250,400,100);
		add(button2);
		cityArmy =new JButton("CityArmy");
		cityArmy.setBounds(1030,250,400,100);
		add(cityArmy);
		
		setVisible(true);
		setLayout(null);
		setSize(1000,1000);
	}
	
	public static void main(String[] args) {
		JFrame frame =new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.add(new Cityview());
		frame.setVisible(true); 
		new Cityview();
		
		
	}

		

}
