package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.MinLevelException;
import units.Archer;
import units.Unit;

public class ArcheryRange extends MilitaryBuilding {
	
	

	public ArcheryRange() {
		super(1500, 800,400);
		
	}
	public void downgrade() throws BuildingInCoolDownException, MinLevelException{
		if(isCoolDown()==true)
			throw new BuildingInCoolDownException();
		if(getLevel()==1){
			throw new MinLevelException();
		}
		if(getLevel()==3){
			setLevel(2);
			setDowngradeGoldBack(300);
			setUpgradeCost(700);
			setRecruitmentCost(450);
			setCoolDown(true);
		}
		else{
			setLevel(1);
			setDowngradeGoldBack(500);
			setUpgradeCost(800);
			setRecruitmentCost(400);
			setCoolDown(true);
			
		}
	}

	@Override
	public Unit recruit() throws BuildingInCoolDownException, MaxRecruitedException {
		if(isCoolDown())
			throw new BuildingInCoolDownException("Building is cooling down, please wait for the next turn");
		if(getCurrentRecruit()==getMaxRecruit())
			throw new MaxRecruitedException("Max recruited units reached, please wait till next turn. ");
		setCurrentRecruit(getCurrentRecruit()+1);
		if(getLevel()==1)
			return new Archer(1, 60, 0.4, 0.5, 0.6);
		
	else if(getLevel()==2)
		return new Archer(2,60,0.4,0.5,0.6);
	else
		return new Archer(3,70,0.5,0.6,0.7);
		
	}

	@Override
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException {
		super.upgrade();
		if(getLevel()==1)
		{
			setLevel(2);
			setUpgradeCost(700);
			setRecruitmentCost(450);
		}
		else if(getLevel()==2)
		{
		setLevel(3);
		setRecruitmentCost(500);
		}
		
	}


}
