package com.nilo.necroslayer.inventory;

public class Weapon extends Item{
	private int maxDamage;
	private int minDamage;
	private String name;
	
	public Weapon(int max, int min) {
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	

}
