package controller;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

import engine.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Currency;

import javax.security.auth.x500.X500Principal;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import buildings.ArcheryRange;
import buildings.Barracks;
import buildings.Building;
import buildings.EconomicBuilding;
import buildings.Farm;
import buildings.Market;
import buildings.MilitaryBuilding;
import buildings.Stable;
import engine.Game;
import exceptions.BuildingInCoolDownException;
import exceptions.FriendlyCityException;
import exceptions.FriendlyFireException;
import exceptions.MaxCapacityException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
import exceptions.TargetNotReachedException;
import view.BattleView;
import view.CityArmy;
import view.Cityview;
import view.Economic;
import view.IdleArmy;
import view.Military;
import view.PlayerName;
import view.Start;
import view.Start;
import view.info;
import units.*;
import view.WorldMap;
import view.MarchingArmy;
import view.BesiegingArmy;

public class ControlGui implements ActionListener {
	private boolean startgame = true;
	private String playername;
	private String PlayerCity;
	private Start start;
	private Game game;
	private PlayerName x;
	private WorldMap w;
	private Cityview c;
	private City current;
	private Army currentArmy;
	private Military military;
	private ArcheryRange archer;
	private Stable cavalry;
	private Barracks infantry;
	private Unit unit;
	private BattleView bt;
	private info info;
	private JLabel list;
	private IdleArmy idle;
	private ArrayList<Army> a1;
	private BattleView battleview;
	private MarchingArmy marching;
	private BesiegingArmy besieging;
	private CityArmy cArmy;
	private Farm f;
	private City defenderCity;
	private Building building;
	private MilitaryBuilding mBuilding;

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public ControlGui() {
		start = new Start();
		start.getButton().addActionListener(this);
	}

	public Start getStart() {
		return start;
	}

	public void setStart(Start start) {
		this.start = start;
	}

	public static void main(String[] args) {
		new ControlGui();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("EndTurn")) {
			// start.setVisible(false);
			game.endTurn();
			if (game.isGameOver()){
				if (game.getPlayer().getControlledCities().size()==3){
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram, "you win the game");
					System.exit(0);
				}
				else {
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram, "you lose the Game");
					System.exit(0);
				}
			}
			update();

		}
		if (e.getActionCommand().equals("Start Game")) {
			// start.setVisible(false);

			start.remove(start.panel);
			// start.getContentPane().remove(start.panel);
			x = new PlayerName();
			start.add(x);
			if (x.getButton() != null)
				x.getButton().addActionListener(this);
			if (x.getUser() != null)
				x.getUser().addActionListener(this);
			start.setVisible(true);
			start.repaint();
			start.revalidate();

		}

		if (e.getActionCommand().equals("Login")) {
			if (x.getUser().getText().equals("")) {
				JFrame fram = new JFrame();
				JOptionPane.showMessageDialog(fram, " Enter a Name!");
			} else {

				playername = x.getUser().getText();
				start.remove(x);
				w = new WorldMap();
				info = new info();
				info.setBackground(Color.red);
				info.setBounds(1, 1, 2000, 150);

				w.setBounds(1, 150, 2000, 2000);

				start.add(w);
				start.add(info);
				w.getButton2().addActionListener(this);
				w.getButton3().addActionListener(this);

				w.getButton4().addActionListener(this);

				w.getButtonA1().addActionListener(this);

				w.getButtonA2().addActionListener(this);

				w.getButtonA3().addActionListener(this);
				info.getB2().addActionListener(this);
				info.getEndturn().addActionListener(this);
				// w.getEndturn().addActionListener(this);
				// w.getWorldMap().addActionListener(this);
				start.setVisible(true);
				start.repaint();
				start.revalidate();

			}
		}

		if (e.getActionCommand().equals("World Map")) {
			// start.setVisible(false);

			start.getContentPane().removeAll();
			info.setBounds(1, 1, 2000, 150);
			w.setBounds(1, 150, 2000, 2000);
			start.setLayout(null);
			start.add(w);
			start.add(info);
			start.revalidate();
			start.repaint();

		}

		if (e.getActionCommand().equals("Cairo")) {
			if (startgame) {
				try {
					game = new Game(playername, "Cairo");
					info.getL1().setText(
							"playerName     " + game.getPlayer().getName()
									+ "  " + "     Treasry   "
									+ game.getPlayer().getTreasury() + "  "
									+ "Food   " + game.getPlayer().getFood()
									+ " " + "        Turncount   "
									+ game.getCurrentTurnCount());
					w.getButton2().setEnabled(false);
					w.getButton3().setEnabled(false);
				} catch (IOException e1) {
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram,"Enter a name!");
					e1.printStackTrace();
				}
				startgame = false;

			} else {
				for (City city : game.getAvailableCities()) {
					if (city.getName().equals("Cairo")) {
						current = city;
					}
				}
				c = new Cityview();
				// if (x.getButton()!=null)
				// x.getButton().addActionListener(this);
				start.remove(w);
				start.add(c);
				c.setBounds(1, 200, 2000, 2000);

				if (c.getButton1() != null)
					c.getButton1().addActionListener(this);
				if (c.getButton2() != null)
					c.getButton2().addActionListener(this);
				if (c.getCityArmy() != null)
					c.getCityArmy().addActionListener(this);
				start.setVisible(true);
				start.repaint();
				start.revalidate();
			}

		}
		if (e.getActionCommand().equals("Sparta")) {
			if (startgame) {
				try {
					game = new Game(playername, "Sparta");
					info.getL1().setText(
							"playerName     " + game.getPlayer().getName()
									+ "  " + "     Treasry   "
									+ game.getPlayer().getTreasury() + "  "
									+ "Food   " + game.getPlayer().getFood()
									+ " " + "        Turncount   "
									+ game.getCurrentTurnCount());
					w.getButton4().setEnabled(false);
					w.getButton2().setEnabled(false);
				} catch (IOException e1) {
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram,"Enter a name!");
					e1.printStackTrace();
				}
				startgame = false;

			} else {
				for (City city : game.getAvailableCities()) {
					if (city.getName().equals("Sparta")) {
						current = city;
					}
				}
				start.remove(w);
				c = new Cityview();
				start.add(c);
				c.setBounds(1, 200, 2000, 2000);
				c.getButton1().addActionListener(this);
				c.getButton2().addActionListener(this);
				c.getCityArmy().addActionListener(this);
				start.setVisible(true);
				start.repaint();
				start.revalidate();

			}
		}
		if (e.getActionCommand().equals("Rome")) {
			if (startgame) {
				try {
					game = new Game(playername, "Rome");
					info.getL1().setText(
							"playerName     " + game.getPlayer().getName()
									+ "  " + "     Treasry   "
									+ game.getPlayer().getTreasury() + "  "
									+ "Food   " + game.getPlayer().getFood()
									+ " " + "        Turncount   "
									+ game.getCurrentTurnCount());
					w.getButton3().setEnabled(false);
					w.getButton4().setEnabled(false);
				} catch (IOException e1) {
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram,"Enter a name!");
					e1.printStackTrace();
				}
				startgame = false;

			} else {
				for (City city : game.getAvailableCities()) {
					if (city.getName().equals("Rome")) {
						current = city;
					}
				}
				start.remove(w);
				c = new Cityview();
				start.add(c);
				c.setBounds(1, 200, 2000, 2000);
				c.getButton1().addActionListener(this);
				c.getButton2().addActionListener(this);
				c.getCityArmy().addActionListener(this);
				start.setVisible(true);
				start.repaint();
				start.revalidate();

			}
		}

		if (e.getActionCommand().equals("Economic")) {
			start.remove(c);
			Economic c1 = new Economic();
			if (c1.getButton1() != null)
				c1.getButton1().addActionListener(this);
			if (c1.getButton2() != null)
				c1.getButton2().addActionListener(this);

			start.add(c1);
			c1.setBounds(1, 200, 2000, 2000);
			// start.setVisible(true);
			start.repaint();
			start.revalidate();

		}
		if (e.getActionCommand().equals("Military")) {
			start.remove(c);
			Military military = new Military();
			start.add(military);
			military.setBounds(1, 200, 2000, 2000);

			// for (MilitaryBuilding build:current.getMilitaryBuildings()){
			// if(build instanceof ArcheryRange){
			// archer=(ArcheryRange) build;
			// }
			// }
			// start.setVisible(true);
			if (military.getButton1() != null)
				military.getButton1().addActionListener(this);
			if (military.getButton2() != null)
				military.getButton2().addActionListener(this);
			if (military.getButton3() != null)
				military.getButton3().addActionListener(this);
			if (military.getButton4() != null)
				military.getButton4().addActionListener(this);
			if (military.getButton5() != null)
				military.getButton5().addActionListener(this);
			start.setVisible(true);
			start.revalidate();
			start.repaint();

		}
		if (e.getActionCommand().equals("CityArmy")) {
			start.remove(c);
			cArmy = new CityArmy();
			cArmy.setBounds(0, 0, 2000, 2000);
			start.add(cArmy);
			// for(Unit u:currentArmy.getUnits()){
			// cArmy.getDefArmyBox().addItem(u);
			// }
			int k = 1;
			for (Unit u : current.getDefendingArmy().getUnits()) {
				cArmy.getDefArmyBox().addItem("UNIT" + k++);

			}
			k = 1;
			for (Army a : game.getPlayer().getControlledArmies()) {
				cArmy.getArmyBox().addItem("Army" + k++);
			}

			cArmy.getRelocateButton().addActionListener(this);
			cArmy.getIntiateButton().addActionListener(this);
			cArmy.getDefArmyBox().addActionListener(this);
			cArmy.getArmyBox().addActionListener(this);
			start.setVisible(true);
			start.repaint();
			start.revalidate();
		}
		if (e.getActionCommand().equals("IntiateArmy")) {
			Unit u = current.getDefendingArmy().getUnits()
					.get(cArmy.getDefArmyBox().getSelectedIndex());

			game.getPlayer().initiateArmy(current, u);
			update2();
		}

		if (e.getActionCommand().equals("Relocate")) {
			try {

				Unit u = current.getDefendingArmy().getUnits()
						.get(cArmy.getDefArmyBox().getSelectedIndex());
				Army a = game.getPlayer().getControlledArmies()
						.get(cArmy.getArmyBox().getSelectedIndex());
				a.relocateUnit(u);

				update2();
			} catch (MaxCapacityException e1) {
				JFrame fram = new JFrame();
				JOptionPane.showMessageDialog(fram, "Capacity is Max");
				e1.printStackTrace();

			}

		}

		if (e.getActionCommand().equals("Idle Armies")) {
			start.remove(w);
			// start.add(new JPanel());
			a1 = new ArrayList<Army>();
			idle = new IdleArmy();
			JComboBox<Army> comboBox = new JComboBox<Army>();
			for (Army a : game.getPlayer().getControlledArmies()) {
				int i = 1;
				if (a.getCurrentStatus() == Status.IDLE) {
					idle.getIdleBox().addItem("Army " + i++);
					a1.add(a);
				}
			}
			for (City a : game.getAvailableCities()) {
				idle.getCityBox().addItem(a.getName());

			}

			info.setBounds(1, 1, 2000, 150);
			current = game.getAvailableCities().get(
					idle.getCityBox().getSelectedIndex());
			// currentArmy=game.getPlayer().getControlledArmies().get(idle.getIdleBox().getSelectedIndex());

			idle.getAttack().addActionListener(this);
			idle.getMarching().addActionListener(this);
			idle.getBesiege().addActionListener(this);
			idle.getIdleIfo().addActionListener(this);
			idle.setBounds(1, 150, 2000, 2000);
			start.add(idle);
			start.add(info);
			start.setVisible(true);
			start.revalidate();
			start.repaint();
		}
		if (e.getActionCommand().equals("idleInfo")) {
			currentArmy = a1.get(idle.getIdleBox().getSelectedIndex());
			idle.getText().setText(currentArmy.ArmyInfo());
		}
		if (e.getActionCommand().equals("marchingInfo")) {
			currentArmy = a1.get(marching.getIdleBox().getSelectedIndex());
			marching.getText().setText(currentArmy.ArmyInfo());
		}
		if (e.getActionCommand().equals("besiegingInfo")) {
			currentArmy = a1.get(besieging.getIdleBox().getSelectedIndex());
			besieging.getText().setText(currentArmy.ArmyInfo());
		}
		
		if (e.getActionCommand().equals("Marching")) {
			currentArmy = a1.get(idle.getIdleBox().getSelectedIndex());
			current = game.getAvailableCities().get(idle.getCityBox().getSelectedIndex());
			game.targetCity(currentArmy, current.getName());
			
			
			
			
		}
		if (e.getActionCommand().equals("Besieging")) {
			for (City c : game.getAvailableCities()) {
				if (c.getDefendingArmy().getCurrentLocation().equals(currentArmy.getCurrentLocation())) {
					defenderCity = c;
				}
			}
			currentArmy = a1.get(idle.getIdleBox().getSelectedIndex());

			try {
				game.getPlayer().laySiege(currentArmy, defenderCity);
				System.out.println(currentArmy.getCurrentStatus());
			} catch (TargetNotReachedException  e1) {
				JFrame fram = new JFrame();
				JOptionPane.showMessageDialog(fram,"You did'nt reach the target!");
				e1.printStackTrace();
			
			}
			catch( FriendlyCityException e1)
			{
				JFrame fram = new JFrame();
				JOptionPane.showMessageDialog(fram,"You attack a friendlycity!");
				e1.printStackTrace();
				
				
			}
		}

		if (e.getActionCommand().equals("Marching Armies")) {
			start.remove(w);
			// start.add(new JPanel());
			a1 = new ArrayList<Army>();
			marching = new MarchingArmy();
			JComboBox<Army> comboBox = new JComboBox<Army>();
			int i=1;
			for (Army a : game.getPlayer().getControlledArmies()) {
				if (a.getCurrentStatus() == Status.MARCHING) {
					marching.getIdleBox().addItem("Army"+i++);
					a1.add(a);
				}
			}
			for (City a : game.getAvailableCities()) {
				marching.getCityBox().addItem(a.getName());
			}

			info.setBounds(1, 1, 2000, 150);
			current = game.getAvailableCities().get(
					marching.getCityBox().getSelectedIndex());
			// currentArmy=game.getPlayer().getControlledArmies().get(idle.getIdleBox().getSelectedIndex());

			marching.getMarching().addActionListener(this);
			marching.getIdleIfo().addActionListener(this);
			marching.setBounds(1, 150, 2000, 2000);
			start.add(marching);
			start.add(info);
			start.setVisible(true);
			start.revalidate();
			start.repaint();
		}

		if (e.getActionCommand().equals("Besieging Armies")) {
			start.remove(w);
			// start.add(new JPanel());
			a1 = new ArrayList<Army>();
			besieging = new BesiegingArmy();
			JComboBox<Army> comboBox = new JComboBox<Army>();
			int i=1;
			for (Army a : game.getPlayer().getControlledArmies()) {
				if (a.getCurrentStatus() == Status.BESIEGING) {
					besieging.getIdleBox().addItem("Army"+i++);
					a1.add(a);
				}
			}
			for (City a : game.getAvailableCities()) {
				besieging.getCityBox().addItem(a.getName());
			}

			info.setBounds(1, 1, 2000, 150);
			current = game.getAvailableCities().get(
					besieging.getCityBox().getSelectedIndex());
			// currentArmy=game.getPlayer().getControlledArmies().get(idle.getIdleBox().getSelectedIndex());

			besieging.getAttack().addActionListener(this);
			besieging.getMarching().addActionListener(this);
			besieging.getIdleIfo().addActionListener(this);
			besieging.setBounds(1, 150, 2000, 2000);
			start.add(besieging);
			start.add(info);
			start.setVisible(true);
			start.revalidate();
			start.repaint();

		}

		if (e.getActionCommand().equals("ArcheryRange")) {

			JFrame archeryframe = new JFrame();
			archeryframe.setBounds(200, 250, 700, 500);
			JButton rbutton = new JButton("RecruitArcher");
			JButton buildArcheryRange = new JButton("BuildArcheryRange");
			buildArcheryRange.setBounds(230, 300, 200, 80);
			if (buildArcheryRange != null)
				buildArcheryRange.addActionListener(this);
			archeryframe.add(buildArcheryRange);
			JButton upgradeArcheryRange = new JButton("UpgradeArcherRange");
			upgradeArcheryRange.setBounds(460, 300, 200, 80);
			upgradeArcheryRange.addActionListener(this);
			archeryframe.add(upgradeArcheryRange);
			rbutton.addActionListener(this);
			rbutton.setBounds(1, 300, 200, 80);
			archeryframe.add(rbutton);
			mBuilding =  new ArcheryRange();
			JLabel label1 = new JLabel("Building cost is  "
					+ mBuilding.getCost());
			label1.setBounds(50, 100, 200, 50);
			archeryframe.add(label1);
			JLabel label2=new JLabel("RecruitmentCost is   "+mBuilding.getRecruitmentCost());
			label2.setBounds(300, 100, 200, 50);
			archeryframe.add(label2);
			JLabel label3=new JLabel("Upgrade cost is   "+mBuilding.getUpgradeCost());
			label3.setBounds(500, 100, 200, 50);
			archeryframe.add(label3);
			archeryframe.setVisible(true);
			archeryframe.setLayout(null);
			archeryframe.repaint();
			archeryframe.revalidate();
			// start.add(archeryframe);
			start.repaint();
			start.revalidate();
			//

		}

		if (e.getActionCommand().equals("RecruitArcher")) {
			MilitaryBuilding m1 = null;
			for (MilitaryBuilding m : current.getMilitaryBuildings()) {
				if (m instanceof ArcheryRange) {
					m1 = m;
				}
			}
			if (m1 == null) {
				JFrame fram = new JFrame();
				JOptionPane.showMessageDialog(fram,
						"you don't have Archeryrange");
			} else {
				try {
					game.getPlayer().recruitUnit("Archer", current.getName());
					update();
				} catch ( NotEnoughGoldException e1) {
					Frame fram = new JFrame();
					JOptionPane.showMessageDialog(fram,"you don't have Enough money");
					
					e1.printStackTrace();
				}
				catch(BuildingInCoolDownException e1){
					Frame fram = new JFrame();
					JOptionPane.showMessageDialog(fram,"Building in cooldown");
					
					e1.printStackTrace();
					
				}
				catch(MaxRecruitedException e1){
					Frame fram = new JFrame();
					JOptionPane.showMessageDialog(fram,"you have reached maxlevel");
					
					e1.printStackTrace();
					
				}

			}
		}
		if (e.getActionCommand().equals("BuildArcheryRange")) {
			try {
				game.getPlayer().build("ArcheryRange", current.getName());
				update();
			} catch (NotEnoughGoldException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (e.getActionCommand().equals("UpgradeArcheryRange")) {
			MilitaryBuilding m1 = null;
			for (MilitaryBuilding m : current.getMilitaryBuildings()) {
				if (m instanceof ArcheryRange) {
					m1 = m;
				}
			}
			if (m1 == null) {
				JFrame fram = new JFrame();
				JOptionPane.showMessageDialog(fram,
						"you don't have Archeryrange");
			} else {

				try {
					game.getPlayer().upgradeBuilding(m1);
					update();
				} catch (NotEnoughGoldException  e1) {
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram,"you don't have Enough money");
					e1.printStackTrace();
				}
				catch(BuildingInCoolDownException e1){
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram,"Building in cooldown");
					e1.printStackTrace();
					
				}
				catch(MaxLevelException e1 ){
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram,"you have reached maxlevel");
					e1.printStackTrace();
					
				}
			}
		}

		if (e.getActionCommand().equals("Stable")) {

			JFrame stableFrame = new JFrame();
			stableFrame.setBounds(600, 200, 900, 500);
			JButton rbutton = new JButton("RecruitStable");
			rbutton.setBounds(1, 300, 200, 80);
			stableFrame.add(rbutton);
			rbutton.addActionListener(this);
			JButton buildStable = new JButton("BuildStable");
			buildStable.setBounds(230, 300, 200, 80);
			buildStable.addActionListener(this);
			stableFrame.add(buildStable);
			JButton upgradeStable = new JButton("UpgradeStable");
			upgradeStable.setBounds(460, 300, 200, 80);
			upgradeStable.addActionListener(this);
			stableFrame.add(upgradeStable);
			stableFrame.add(rbutton);
			mBuilding =  new Stable();
			JLabel label1 = new JLabel("Building cost is  "
					+ mBuilding.getCost());
			label1.setBounds(50, 100, 200, 50);
			stableFrame.add(label1);
			JLabel label2=new JLabel("RecruitmentCost is   "+mBuilding.getRecruitmentCost());
			label2.setBounds(300, 100, 200, 50);
			stableFrame.add(label2);
			JLabel label3=new JLabel("Upgrade cost is   "+mBuilding.getUpgradeCost());
			label3.setBounds(500, 100, 200, 50);
			stableFrame.add(label3);
			stableFrame.setVisible(true);
			stableFrame.setLayout(null);
			start.repaint();
			start.revalidate();

		}

		if (e.getActionCommand().equals("RecruitStable")) {
			MilitaryBuilding m1 = null;
			for (MilitaryBuilding m : current.getMilitaryBuildings()) {
				if (m instanceof Stable) {
					m1 = m;
				}
			}
			if (m1 == null) {
				JFrame fram = new JFrame();
				JOptionPane.showMessageDialog(fram, "you don't have Stable");
			} else {
				try {
					game.getPlayer().recruitUnit("Cavalry", current.getName());
					update();
				} catch ( NotEnoughGoldException e1) {
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram, "you don't have enough money");
					e1.printStackTrace();
				}
				catch(BuildingInCoolDownException e1){
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram, "Building in cooldown");
					e1.printStackTrace();
					
				}
				catch( MaxRecruitedException e1){
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram, "you have reached maxlevel");
					e1.printStackTrace();
					
				}

			}
		}

		if (e.getActionCommand().equals("BuildStable")) {
			try {
				game.getPlayer().build("Stable", current.getName());
				update();
			} catch (NotEnoughGoldException e1) {
				JFrame fram = new JFrame();
				JOptionPane.showMessageDialog(fram, "you don't have enough money");
				e1.printStackTrace();
			}

		}
		if (e.getActionCommand().equals("UpgradeStable")) {
			MilitaryBuilding m1 = null;
			for (MilitaryBuilding m : current.getMilitaryBuildings()) {
				if (m instanceof Stable) {
					m1 = m;
				}
			}
			if (m1 == null) {
				JFrame fram = new JFrame();
				JOptionPane.showMessageDialog(fram, "you don't have Stable");
			} else {

				try {
					game.getPlayer().upgradeBuilding(m1);
					update();
				}  catch ( NotEnoughGoldException e1) {
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram, "you don't have enough money");
					e1.printStackTrace();
				}
				catch(BuildingInCoolDownException e1){
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram, "Building in cooldown");
					e1.printStackTrace();
					
				}
					
				catch (MaxLevelException e1) {
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram, "You reach maxlevel");
					e1.printStackTrace();
					
					e1.printStackTrace();
				}
				
			}
		}
		if (e.getActionCommand().equals("Barracks")) {

			JFrame barracksFrame = new JFrame();
			barracksFrame.setBounds(600, 200, 900, 500);
			JButton rbutton = new JButton("RecruitBarracks");
			JButton buildBarracks = new JButton("BuildBarracks");
			buildBarracks.setBounds(220, 300, 200, 80);
			buildBarracks.addActionListener(this);
			barracksFrame.add(buildBarracks);
			JButton upgradeBarracks = new JButton("UpgradeBarracks");
			upgradeBarracks.setBounds(400, 300, 200, 80);
			upgradeBarracks.addActionListener(this);
			barracksFrame.add(upgradeBarracks);
			rbutton.addActionListener(this);
			rbutton.setBounds(1, 300, 200, 80);
			barracksFrame.add(rbutton);
			mBuilding =  new Barracks();
			JLabel label1 = new JLabel("Building cost is  "
					+ mBuilding.getCost());
			label1.setBounds(50, 100, 200, 50);
			barracksFrame.add(label1);
			JLabel label2=new JLabel("RecruitmentCost is   "+mBuilding.getRecruitmentCost());
			label2.setBounds(300, 100, 200, 50);
			barracksFrame.add(label2);
			JLabel label3=new JLabel("Upgrade cost is   "+mBuilding.getUpgradeCost());
			label3.setBounds(500, 100, 200, 50);
			barracksFrame.add(label3);
			barracksFrame.setVisible(true);
			barracksFrame.setLayout(null);

			start.repaint();
			start.revalidate();

		}
		if (e.getActionCommand().equals("RecruitBarracks")) {
			MilitaryBuilding m1 = null;
			for (MilitaryBuilding m : current.getMilitaryBuildings()) {
				if (m instanceof Barracks) {
					m1 = m;
				}
			}
			if (m1 == null) {
				JFrame fram = new JFrame();
				JOptionPane.showMessageDialog(fram, "you don't have Barracks");
			} else {
				try {
					game.getPlayer().recruitUnit("Infantry", current.getName());
					update();
				}  catch ( NotEnoughGoldException e1) {
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram, "you don't have enough money");
					e1.printStackTrace();
				}
				catch(BuildingInCoolDownException e1){
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram, "Building in cooldown");
					e1.printStackTrace();
					
				}
					
				
				 catch (MaxRecruitedException e1) {
					 JFrame fram = new JFrame();
						JOptionPane.showMessageDialog(fram, "you reached max number");
					
					e1.printStackTrace();
				}

			}
		}

		if (e.getActionCommand().equals("BuildBarracks")) {
			try {
				game.getPlayer().build("Barracks", current.getName());
				update();
			} catch (NotEnoughGoldException e1) {
				JFrame fram = new JFrame();
				JOptionPane.showMessageDialog(fram, "You don't have enough money");
				e1.printStackTrace();
			}

		}
		if (e.getActionCommand().equals("UpgradeBarracks")) {
			MilitaryBuilding m1 = null;
			for (MilitaryBuilding m : current.getMilitaryBuildings()) {
				if (m instanceof Barracks) {
					m1 = m;
				}
			}
			if (m1 == null) {
				JFrame fram = new JFrame();
				JOptionPane.showMessageDialog(fram, "you don't have Barracks");
			} else {

				try {
					game.getPlayer().upgradeBuilding(m1);
					update();
				} catch ( BuildingInCoolDownException e1) {
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram, "Building in cooldown");
					e1.printStackTrace();
				}
				catch(NotEnoughGoldException e1){
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram, "You don't have enough money");
					e1.printStackTrace();
				}
				catch(MaxLevelException e1){
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram, "You have reached maxlevel");
					e1.printStackTrace();
				}
			}
		}

		if (e.getActionCommand().equals("Farm")) {
			JFrame farmFrame = new JFrame();
			farmFrame.setBounds(600, 200, 900, 400);
			;
			JButton upgradeFarm = new JButton("UpgradeFarm");
			if (upgradeFarm != null)
				upgradeFarm.addActionListener(this);
			;

			upgradeFarm.setBounds(1, 200, 300, 50);
			farmFrame.add(upgradeFarm);
			JButton buildFarm = new JButton("BuildFarm");
			if (buildFarm != null)
				buildFarm.addActionListener(this);
			buildFarm.setBounds(320, 200, 300, 50);
			farmFrame.add(buildFarm);
			building = new Farm();
			JLabel label1 = new JLabel("Building cost is  "+ building.getCost());
			JLabel label2=new JLabel("Upgrade cost is   "+building.getUpgradeCost());
			label2.setBounds(600, 100, 200, 50);
			farmFrame.add(label2);
			label1.setBounds(300, 100, 200, 50);
			farmFrame.add(label1);
			farmFrame.setLayout(null);
			start.repaint();
			start.revalidate();
			farmFrame.setVisible(true);

		}
		if (e.getActionCommand().equals("UpgradeFarm")) {
			EconomicBuilding b3 = null;

			for (EconomicBuilding b : current.getEconomicalBuildings()) {
				if (b instanceof Farm)
					b3 = b;
			}
			if (b3 == null) {
				JFrame fram = new JFrame();
				JOptionPane.showMessageDialog(fram,
						"you don't have to Build First!");

			} else {
				try {
					game.getPlayer().upgradeBuilding(b3);
					update();
				} catch ( BuildingInCoolDownException e1) {
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram, "Building in cooldown");
					e1.printStackTrace();
				}
				catch(NotEnoughGoldException e1){
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram, "You don't have enough money");
					e1.printStackTrace();
				}
				catch(MaxLevelException e1){
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram, "You have reached maxlevel");
					e1.printStackTrace();
				}
			}
		}
		if (e.getActionCommand().equals("BuildFarm")) {

			try {
				game.getPlayer().build("Farm", current.getName());
				update();
			} catch(NotEnoughGoldException e1){
				JFrame fram = new JFrame();
				JOptionPane.showMessageDialog(fram, "You don't have enough money");
				e1.printStackTrace();
				
			}
		}
		if (e.getActionCommand().equals("BuildMarket")) {
			try {
				game.getPlayer().build("Market", current.getName());
				update();
			} catch (NotEnoughGoldException e1) {
				JFrame fram = new JFrame();
				JOptionPane.showMessageDialog(fram, "You don't have enough money");
				e1.printStackTrace();
			}

		}

		if (e.getActionCommand().equals("UpgradeMarket")) {
			EconomicBuilding b1 = null;
			for (EconomicBuilding b : current.getEconomicalBuildings()) {
				if (b instanceof Market)
					b1 = b;
			}
			if (b1 == null) {
				JFrame fram = new JFrame();
				JOptionPane.showMessageDialog(fram,
						"you don't have to Build First!");

			} else {
				try {
					game.getPlayer().upgradeBuilding(b1);
					update();
				} catch ( MaxLevelException e1) {
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram,
							"you reach maxlevel!");
					e1.printStackTrace();
				}
				catch(NotEnoughGoldException e1){
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram,
							"you don't have enough money!");
					e1.printStackTrace();
				}
				catch(BuildingInCoolDownException e1){
					JFrame fram = new JFrame();
					JOptionPane.showMessageDialog(fram,
							"Building in cooldown!");
					e1.printStackTrace();
				}
			}
		}
		if (e.getActionCommand().equals("Market")) {
			JFrame marketFrame = new JFrame();
			marketFrame.setBounds(600, 200, 900, 900);
			;
			JButton upgradeMarket = new JButton("UpgradeMarket");
			if (upgradeMarket != null)
				upgradeMarket.addActionListener(this);
			upgradeMarket.setBounds(1, 200, 250, 50);
			marketFrame.add(upgradeMarket);
			JButton buildFarm = new JButton("BuildMarket");
			if (buildFarm != null)
				buildFarm.addActionListener(this);
			buildFarm.setBounds(300, 200, 250, 50);
			marketFrame.add(buildFarm);
			building = new Market();
			JLabel label1 = new JLabel("Building cost is  "
					+ building.getCost());
			label1.setBounds(300, 100, 200, 50);
			marketFrame.add(label1);
			JLabel label2=new JLabel("Upgrade cost is   "+building.getUpgradeCost());
			label2.setBounds(600, 100, 200, 50);
			marketFrame.add(label2);
			marketFrame.setLayout(null);
			marketFrame.setVisible(true);
			start.repaint();
			start.revalidate();

		}

		if (e.getActionCommand().equals("Attack")) {
			start.getContentPane().removeAll();
			battleview = new BattleView();
			start.setLayout(null);
			info.setBounds(1, 1, 2000, 150);
			battleview.setBounds(1, 150, 2000, 2000);
			start.add(info);
			start.add(battleview);
			battleview.getPlayerButton().addActionListener(this);
			battleview.getArButton().addActionListener(this);
			battleview.getManualButton().addActionListener(this);
			battleview.getDefenArmy().addActionListener(this);
			int i = 1;
			currentArmy = a1.get(idle.getIdleBox().getSelectedIndex());
			for (Unit u : currentArmy.getUnits()) {

				battleview.getArmy().addItem("unit" + (i++));
			}
			for (City c : game.getAvailableCities()) {
				if (c.getDefendingArmy().getCurrentLocation().equals(currentArmy.getCurrentLocation())) {
					defenderCity = c;
				}
			}

			start.revalidate();
			start.repaint();
		}
		if (e.getActionCommand().equals("PlayerArmy")) {
			battleview.getTarea2().setText(
					"         player Army \n" + currentArmy.ArmyInfo());

		}
		if (e.getActionCommand().equals("DefendingArmy")) {
			battleview.getTarea2().setText(
					"         Defending Army"
							+ defenderCity.getDefendingArmy().ArmyInfo());
		}
		if (e.getActionCommand().equals("Manual")) {

			int i = (int) (Math.random() * defenderCity.getDefendingArmy().getUnits().size());
			Unit u = defenderCity.getDefendingArmy().getUnits().get(i);

			int b1 = battleview.getArmy().getSelectedIndex();
			
			Unit u2 = currentArmy.getUnits().get(b1);
			try {
				u2.attack(u);
				u.attack(u2);
			} catch (FriendlyFireException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int j = u.getCurrentSoldierCount();
			int i5 = u2.getCurrentSoldierCount();
			String s = "the remaining attack  army  " + j + " \n";
			s += "the remaining defender army   " + i5 + "  \n ";
			
			battleview.getTarea1().setText(s);
			if (cArmy == null) {
				game.getPlayer().getControlledArmies().remove(currentArmy);
			}
		}
		if (e.getActionCommand().equals("AutoResolve")) {
			// defenderCity=null;
			for (City c : game.getAvailableCities()) {
				if (c.getDefendingArmy().getCurrentLocation() == currentArmy
						.getCurrentLocation()) {
					defenderCity = c;
				}

			}
			try {
				game.autoResolve(currentArmy, defenderCity.getDefendingArmy());
				battleview.getTarea1().setText(game.getS());
			} catch (FriendlyFireException e1) {
				JFrame fram = new JFrame();
				JOptionPane.showMessageDialog(fram,"You attack friendlycity!");
				e1.printStackTrace();
			}
		}
	}

	public void update() {
		info.getL1().setText(
				"playerName     " + game.getPlayer().getName() + "  "
						+ "     Treasry   " + game.getPlayer().getTreasury()
						+ "  " + "Food   " + game.getPlayer().getFood() + " "
						+ "        Turncount   " + game.getCurrentTurnCount());

	}

	public void update2() {
		int k = 1;
		cArmy.getDefArmyBox().removeAllItems();
		cArmy.getArmyBox().removeAllItems();

		for (Unit u : current.getDefendingArmy().getUnits()) {
			cArmy.getDefArmyBox().addItem("UNIT" + k++);

		}
		k = 1;
		for (Army a : game.getPlayer().getControlledArmies()) {
			cArmy.getArmyBox().addItem("Army" + k++);
		}
	}

}
