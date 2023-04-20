package com.nilo.necroslayer.jobs;

import java.util.ArrayList;

import com.nilo.necroslayer.character.Charac;
import com.nilo.necroslayer.enemy.Enemy;
import com.nilo.necroslayer.model.Backpack;

public class Thief extends Job{

	public Thief(Charac c){
		super(c);
		this.setId(36);
		this.setAbilityName("Roubar");
	}

	@Override
	public ArrayList<String> ability(Enemy enemy, Backpack backpack) {
		ArrayList<String> texto = new ArrayList<String>();
		if(enemy.getItem() == null) {
			texto.add(this.getCharac().getName() + "roubou nada!");
		}else {
			texto.add(this.getCharac().getName() + "roubou " + enemy.getItem().getName());
			backpack.addItem(enemy.getItem());
			enemy.setItem(null);
		}
		return texto;
		
	}


}
