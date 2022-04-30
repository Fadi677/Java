package oop.assignment.zookeeper;

public class Gorilla extends Mammal{
	
	public Gorilla() {
		
	}
	
	@Override
	public void setEnergyLevel(int energyLevel) {
		// TODO Auto-generated method stub
		super.setEnergyLevel(energyLevel);
	}
	
	public int throwSomething() {
		System.out.println("The Gorilla has thrown something");
		int consumeEnergy=5;
		int overallEnergy=super.getEnergyLevel()-consumeEnergy;
		setEnergyLevel(overallEnergy);
		return overallEnergy;
	}

	@Override
	public int displayEnergy() {
		// TODO Auto-generated method stub
		int energy=getEnergyLevel();
		System.out.println("The Energy Level of Gorilla "+energy);
		return energy;
	}
	
	public int eatBananas() {
		System.out.println("The Gorilla has eaten Bananas");
		int gainEnergy=10;
		int overallEnergy=super.getEnergyLevel()+gainEnergy;
		setEnergyLevel(overallEnergy);
		return overallEnergy;
	}
	
	public int climbSomething() {
		System.out.println("The Gorilla has Climbed Something");
		int loseEnergy=10;
		int overallEnergy=super.getEnergyLevel()-loseEnergy;
		setEnergyLevel(overallEnergy);
		return overallEnergy;
	}
	
}
