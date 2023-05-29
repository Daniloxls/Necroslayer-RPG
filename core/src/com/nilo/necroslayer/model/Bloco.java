package com.nilo.necroslayer.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Bloco {
	private int x,y;
	private boolean publicBlock;
	private ArrayList<ArrayList<Integer>> blocopropiedades;
	private BlocoItem item = new BlocoItem();
	private boolean hasItem = false;
	public boolean isWalkable;
	public Bloco (int x, int y, boolean walk){
		this.x = x;
		this.y = y;
		this.isWalkable = true;
		this.setPublicBlock(false);
		this.blocopropiedades = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < 4; i++) {
			blocopropiedades.add(new ArrayList<Integer>(Arrays.asList(i, 0,0,0)));
		}
	}
	public Bloco(int x, int y, boolean walk, BlocoItem item) {
		this.x = x;
		this.y = y;
		this.isWalkable = false;
		this.item = item;
		this.setPublicBlock(false);
		this.blocopropiedades = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < 4; i++) {
			blocopropiedades.add(new ArrayList<Integer>(Arrays.asList(i, 0,0,0)));
		}
	}
	public int getx() {
		return this.x;
	}
	public int gety() {
		return this.y;
	}
	public BlocoItem getItem() {
		return item;
	}
	public void setCenario(String nome) {
		this.item.setName(nome);
		this.isWalkable = false;
		this.hasItem = true;
	}
	public void setItem(BlocoItem item) {
		this.item = item;
		this.isWalkable = false;
		this.hasItem = true;
	}
	public void removeItem() {
		this.item = null;
		this.isWalkable = true;
		this.hasItem = false;
	}
	public boolean isWalkable() {
		return isWalkable;
	}
	public void setWalkable(boolean isWalkable) {
		this.isWalkable = isWalkable;
	}
	public ArrayList<String> depurar() {
		if(this.hasItem) {
			return(this.item.depurar());
		}
		ArrayList<String> detalhes =  new ArrayList<String>();
		detalhes.add("private int x = " + Integer.toString(this.x) + ";");
		detalhes.add("private int y = " + Integer.toString(this.y) + ";" );
		detalhes.add("private Item item = null;");
		
		return detalhes;
	}
	public boolean isPublicBlock() {
		return publicBlock;
	}
	public void setPublicBlock(boolean publicBlock) {
		this.publicBlock = publicBlock;
	}
	public ArrayList<ArrayList<Integer>> getBlocopropiedades() {
		return blocopropiedades;
	}
	public void setBlocopropiedades(ArrayList<ArrayList<Integer>> blocopropiedades) {
		this.blocopropiedades = blocopropiedades;
	}
	

}