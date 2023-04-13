package com.nilo.necroslayer.character;

import java.util.ArrayList;

public class Party {
	private ArrayList<Charac> comp;
	public Party() {
		this.comp = new ArrayList<Charac>();
		this.comp.add(new Bartz());
		this.comp.add(new Lenna());
		this.comp.add(new Galuf());
		this.comp.add(new Faris());
	}
	
	public void setComp(ArrayList<Charac> comp) {
		this.comp = comp;
	}
	
	public ArrayList<Charac> getComp(){
		return this.comp;
	}
	public Charac getBartz() {
		return this.comp.get(0);
	}
	public Charac getLenna() {
		return this.comp.get(1);
	}
	public Charac getGaluf() {
		return this.comp.get(2);
	}
	public Charac getFaris() {
		return this.comp.get(3);
	}
	public void setBartz(Bartz bartz) {
		this.comp.remove(0);
		this.comp.add(0, bartz);
	}
	public void setLenna(Lenna lenna) {
		this.comp.remove(1);
		this.comp.add(1, lenna);
	}
	public void setGaluf(Galuf galuf) {
		this.comp.remove(2);
		this.comp.add(2, galuf);
	}
	public void setFaris(Faris faris) {
		this.comp.remove(3);
		this.comp.add(3, faris);
	}
}

