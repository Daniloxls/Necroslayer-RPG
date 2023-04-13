package com.nilo.necroslayer.model;

public class Bloco {
	private int x,y;
	private BlocoItem item = new BlocoItem();
	public boolean isWalkable;
	public Bloco (int x, int y, boolean walk){
		this.x = x;
		this.y = y;
		this.isWalkable = true;
	}
	public Bloco(int x, int y, boolean walk, BlocoItem item) {
		this.x = x;
		this.y = y;
		this.isWalkable = true;
		this.item = item;
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
	public void setItem(BlocoItem item) {
		this.item = item;
		this.isWalkable = false;
	}
	public void removeItem() {
		this.item = null;
		this.isWalkable = true;
	}
	public boolean isWalkable() {
		return isWalkable;
	}
	public void setWalkable(boolean isWalkable) {
		this.isWalkable = isWalkable;
	}
	

}