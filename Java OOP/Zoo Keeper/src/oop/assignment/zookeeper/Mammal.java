package oop.assignment.zookeeper;

public class Mammal {
	private int energyLevel=100;

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public int displayEnergy() {
		int energy=this.getEnergyLevel();
		System.out.println("The energy level of this mammal is: "+energy);
		return energy;
	}
	
}
