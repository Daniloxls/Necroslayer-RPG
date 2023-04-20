package com.nilo.necroslayer.jobs;

import java.util.ArrayList;

import com.nilo.necroslayer.character.Charac;
import com.nilo.necroslayer.enemy.Enemy;

public class BlackMage extends Job{

	public BlackMage(Charac c){
		super(c);
		this.setId(132);
		this.setAbilityName("Black");
		this.setSpellList(new ArrayList<String>());
		this.getSpellList().add("Fogo");
		this.getSpellList().add("Raio");
		this.getSpellList().add("Gelo");
	}

	@Override
	public ArrayList<String> ability(Enemy e) {
		ArrayList<String> texto = new ArrayList<String>();
		return texto;
	}

}
