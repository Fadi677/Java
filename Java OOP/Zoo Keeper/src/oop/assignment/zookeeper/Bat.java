package oop.assignment.zookeeper;

public class Bat extends Mammal {
	private int energyLevel=300;
	
	public Bat() {
	}
	
	
	
	public int getEnergyLevel() {
		return energyLevel;
	}



	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}



	public int fly() {
		System.out.println("The Bat is Taking off!");
		int consumeEnergy=50;
		int overallEnergy=getEnergyLevel()-consumeEnergy;
		setEnergyLevel(overallEnergy);
		return overallEnergy;
	}
	
	public int eatHumans() {
		System.out.println("The Bat has eaten a Human");
		int gainEnergy=25;
		int overallEnergy=getEnergyLevel()+gainEnergy;
		setEnergyLevel(overallEnergy);
		return overallEnergy;
	}
	
	public int atackTown() {
		System.out.println("The Town is UnderAtack!");
		int loseEnergy=100;
		int overallEnergy=getEnergyLevel()-loseEnergy;
		setEnergyLevel(overallEnergy);
		return overallEnergy;
	}
	
	@Override
	public int displayEnergy() {
		// TODO Auto-generated method stub
		int energy=getEnergyLevel();
		System.out.println("The Energy Level of The Bat "+energy);
		return energy;
	}
	
}
