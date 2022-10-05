package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayerName extends JPanel  {
	private JLabel playerLabel;
	private JTextField user;
	private JButton button1;

	public JButton getButton() {
		return button1;
	}

	public JTextField getUser() {
		return user;
	}

	public void setUser(JTextField user) {
		this.user = user;
	}

	public JLabel getPlayerLabel() {
		return playerLabel;
	}

	public void setPlayerLabel(JLabel playerLabel) {
		this.playerLabel = playerLabel;
	}

	public PlayerName(){
		 playerLabel=new JLabel("Player name");
		playerLabel.setBounds(600,5,100,100);
		add(playerLabel);
		 user =new JTextField(20);
		user.setBounds(700,40,300,30);
		add(user);
		setSize(2000,2000);
		button1 =new JButton("Login");
		button1.setBounds(770,90,150,50);
		add(button1);
		setVisible(true);
		setLayout(null);
		
		 
		
	}
	


	
	
public static void main(String[] args) {
			JFrame frame =new JFrame();
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.add(new PlayerName());
			frame.setVisible(true); 
			new PlayerName();
			
	}
		
}
