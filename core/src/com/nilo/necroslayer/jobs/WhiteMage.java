package com.nilo.necroslayer.jobs;

import java.util.ArrayList;

import com.nilo.necroslayer.character.Charac;
import com.nilo.necroslayer.enemy.Enemy;
import com.nilo.necroslayer.spells.Spell;

public class WhiteMage extends Job{
	public WhiteMage(Charac c){
		super(c);
		this.setId(120);
		this.setAbilityName("White");
		this.setSpellList(new ArrayList<Spell>());
		this.getSpellList().add(new Spell("Cura", "Cura um aliado", 8, 0, -16 , -32));
		this.getSpellList().add(new Spell("Revive", "Revive um aliado caido", 24, 6, -8, -12, true));
		this.getSpellList().add(new Spell("Antidote", "Cura o veneno de um aliado", 0, 0, 0, 0, false, true));
	}

	@Override
	public ArrayList<String> ability(Enemy e) {
		ArrayList<String> texto = new ArrayList<String>();
		return texto;
		
	}

}
