package com.nilo.necroslayer.inventory;

public class Weapon extends Item{
	private int maxDamage;
	private int minDamage;
	
	public Weapon(String name, String desc, int max, int min) {
		super(name, desc);
		this.setMaxDamage(max);
		this.setMinDamage(min);
	}


	public int getMaxDamage() {
		return maxDamage;
	}


	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}


	public int getMinDamage() {
		return minDamage;
	}


	public void setMinDamage(int minDamage) {
		this.minDamage = minDamage;
	}

	

}
