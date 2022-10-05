package view;

import java.awt.Color;

import javafx.scene.shape.Box;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.omg.PortableInterceptor.USER_EXCEPTION;

import engine.Game;
import engine.Player;

public class WorldMap extends JPanel  {
	private JButton button4;
	private JButton button2;
	private JButton button3;
	private JButton buttonA1;
	private JButton buttonA2;
	private JButton buttonA3;
	private JPanel label;
	private JButton endturn;
	private JButton worldMap;
	private JLabel info;
	private PlayerName pname;
	private Player player;
	private Game g;
	
	
	
	
	
	public JLabel getinfo() {
		return info;
	}
	public JButton getEndturn() {
		return endturn;
	}
	public JButton getWorldMap() {
		return worldMap;
	}
	public JPanel getLabel() {
		return label;
	}
	public WorldMap(){
		setLayout(null);
		 button4 =new JButton("Cairo");
		button4.setBounds(1,200,400,100);
		add(button4);
		 button2 =new JButton("Rome");
		button2.setBounds(600,200,400,100);
		add(button2);
	     button3 =new JButton("Sparta");
		button3.setBounds(1100,200,400,100);
		add(button3);
		
		 buttonA1 =new JButton("Idle Armies");
		buttonA1.setBounds(100,500,200,50);
		add(buttonA1);
		 buttonA2 =new JButton("Marching Armies");
		buttonA2.setBounds(700,500,200,50);
		add(buttonA2);
		 buttonA3 =new JButton("Besieging Armies");
		buttonA3.setBounds(1200,500,200,50);
		add(buttonA3);
		

		
		
		setSize(1200,1200);
		
	    setVisible(true);
	}
	public JButton getButton4() {
		return button4;
	}
	public JButton getButton2() {
		return button2;
	}
	public JButton getButton3() {
		return button3;
	}
	public JButton getButtonA1() {
		return buttonA1;
	}
	public JButton getButtonA2() {
		return buttonA2;
	}
	public JButton getButtonA3() {
		return buttonA3;
	}
	public static void main(String[] args) {
	 new WorldMap();
	 JFrame frame =new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.add(new WorldMap());
		frame.setVisible(true);
	   

}}
