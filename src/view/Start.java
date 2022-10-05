package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.javafx.collections.SetListenerHelper;

public class Start extends JFrame  {
	private JButton button;
	public  JPanel panel;
	public JPanel getPanel() {
		return panel;
	}



	public void setPanel(JPanel panel) {
		this.panel = panel;
	}



	public Start(){
		
		
		 panel =new JPanel();
		 
		button =new JButton("Start Game");
		button.setBounds(700,500,300,100);
		panel.setLayout(null);
		panel.add(button);
		//this.setLayout(new BorderLayout());
		add(panel);
		//panel.add(button);
		setVisible(true);
		panel.setBounds(0,0,1500,1500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	   
	}
	
	

	public JButton getButton() {
		return button;
	}



	public void setButton(JButton button) {
		this.button = button;
	}



	public static void main(String[] args) {
		new Start();
		
		
		
		
		
		
		
		

	}

	
		
		
		
	}


