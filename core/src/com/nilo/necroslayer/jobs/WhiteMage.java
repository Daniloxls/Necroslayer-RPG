package com.nilo.necroslayer.jobs;

import java.util.ArrayList;

import com.nilo.necroslayer.character.Charac;
import com.nilo.necroslayer.enemy.Enemy;

public class WhiteMage extends Job{
	public WhiteMage(Charac c){
		super(c);
		this.setId(120);
		this.setAbilityName("White");
		this.setSpellList(new ArrayList<String>());
		this.getSpellList().add("Cura");
		this.getSpellList().add("Revive");
		this.getSpellList().add("Antidote");
	}

	@Override
	public ArrayList<String> ability(Enemy e) {
		ArrayList<String> texto = new ArrayList<String>();
		return texto;
		
	}

}
