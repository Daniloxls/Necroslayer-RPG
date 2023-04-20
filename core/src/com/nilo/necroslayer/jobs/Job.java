package com.nilo.necroslayer.jobs;

import java.util.ArrayList;

import com.nilo.necroslayer.character.Charac;
import com.nilo.necroslayer.enemy.Enemy;
import com.nilo.necroslayer.model.Backpack;

public abstract class Job {
	private int id;
	private int strBonus;
	private int agilBonus;
	private int vitBonus;
	private int magBonus;
	private String abilityName;
	private Charac charac;
	private ArrayList<String> SpellList;
	public Job(Charac c) {
		this.charac = c;
	}
	
	public void ability(){
		
	};

	public  ArrayList<String> ability(Enemy enemy){
		return null;
	}
	
	public ArrayList<String> ability(Enemy enemy, Backpack backpack) {
		return null;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getStrBonus() {
		return strBonus;
	}


	public void setStrBonus(int strBonus) {
		this.strBonus = strBonus;
	}


	public int getAgilBonus() {
		return agilBonus;
	}


	public void setAgilBonus(int agilBonus) {
		this.agilBonus = agilBonus;
	}


	public int getVitBonus() {
		return vitBonus;
	}


	public void setVitBonus(int vitBonus) {
		this.vitBonus = vitBonus;
	}


	public int getMagBonus() {
		return magBonus;
	}


	public void setMagBonus(int magBonus) {
		this.magBonus = magBonus;
	}


	public String getAbilityName() {
		return abilityName;
	}


	public void setAbilityName(String abilityName) {
		this.abilityName = abilityName;
	}


	public Charac getCharac() {
		return charac;
	}


	public void setCharac(Charac charac) {
		this.charac = charac;
	}

	public ArrayList<String> getSpellList() {
		return SpellList;
	}

	public void setSpellList(ArrayList<String> spellList) {
		SpellList = spellList;
	}



	
	
}
