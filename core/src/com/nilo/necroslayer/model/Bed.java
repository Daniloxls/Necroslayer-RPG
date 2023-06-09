package com.nilo.necroslayer.model;

import java.util.ArrayList;
import java.util.Arrays;

import com.nilo.necroslayer.character.Charac;

public class Bed extends BlocoItem{
	
	public Bed() {
		this.dialogue = new ArrayList<String>(Arrays.asList("Você descansou na cama e recuperou as forças", "Equipe curada"));
		this.setInteractable(true);
		this.setHasDialogue(true);
		this.setName("Cama");
	}
	
	public void interact(Player player) {
		for(Charac c : player.party.getComp()) {
			c.rest();
		}
	}

}
