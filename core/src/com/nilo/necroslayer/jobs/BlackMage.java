package com.nilo.necroslayer.jobs;

import java.util.ArrayList;

import com.nilo.necroslayer.character.Charac;
import com.nilo.necroslayer.enemy.Enemy;
import com.nilo.necroslayer.spells.Spell;

public class BlackMage extends Job{

	public BlackMage(Charac c){
		super(c);
		this.setId(132);
		this.setAbilityName("Black");
		this.setSpellList(new ArrayList<Spell>());
		this.getSpellList().add(new Spell("Fire", "Causa um alto dano a um inimigo", 10, 1, 32 , 16));
		this.getSpellList().add(new Spell("Thunder", "Causa dano a todos os inimigos", 14, 2, 18 , 12));
		this.getSpellList().add(new Spell("Ice", "Causa dano a um inimigo, pode congelar", 8, 1, 14 , 10));
	}

	@Override
	public ArrayList<String> ability(Enemy e) {
		ArrayList<String> texto = new ArrayList<String>();
		return texto;
	}

}
