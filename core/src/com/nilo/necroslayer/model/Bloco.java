package com.nilo.necroslayer.model;

public class Bloco {
	private int x,y;
	private float pixelX,pixelY;
	private BlocoItem item = new BlocoItem();
	public boolean isWalkable = true;
	private boolean haveAPlayer = false;
	public Bloco (int x, int y){
		this.x = x;
		this.y = y;

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
	}
	public boolean isWalkable() {
		return isWalkable;
	}
	public void setWalkable(boolean isWalkable) {
		this.isWalkable = isWalkable;
	}
	public boolean isHaveAPlayer() {
		return haveAPlayer;
	}
	public void setHaveAPlayer(boolean haveAPlayer) {
		this.haveAPlayer = haveAPlayer;
	}

}