package com.nilo.necroslayer.model;

import java.util.ArrayList;
import java.util.Arrays;

import com.nilo.necroslayer.screens.Level;

public class Porta extends Bloco{
	private Level level;

	public Porta(int x, int y, boolean walk) {
		super(x, y, walk);
	}
	public Porta(int x, int y, boolean walk,  Level level) {
		super(x, y, walk);
		this.setWalkable(false);
		this.setPublicBlock(true);
		this.setBlocopropiedades(new ArrayList<ArrayList<Integer>>());
		this.getBlocopropiedades().add(new ArrayList<Integer>(Arrays.asList(0, 0,0,0)));
		this.getBlocopropiedades().add(new ArrayList<Integer>(Arrays.asList(1, 0,0,0)));
		this.getBlocopropiedades().add(new ArrayList<Integer>(Arrays.asList(2, 1,0,0)));
		this.level = level;
		this.getItem().setHasDialogue(true);
		this.getItem().setInteractable(true);
		this.getItem().dialogue = new ArrayList<String>();
		this.getItem().dialogue.add("Está trancado.");
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}

}
