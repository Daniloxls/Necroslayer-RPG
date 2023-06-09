package com.nilo.necroslayer.model;

import com.nilo.necroslayer.screens.Level;

public class Door extends Bloco{
	private boolean open;
	private int destiny;
	private int destinyX, destinyY; 
	
	public Door(int x, int y, int destiny, boolean open, int destinyX, int destinyY) {
		super(x, y, true);
		this.setDestiny(destiny);
		this.setOpen(open);
		this.setDestinyX(destinyX);
		this.setDestinyY(destinyY);
	}
	@Override
	public boolean checkPlayer(int x, int y) {
		if((this.getx() == x) && (this.gety() == y)) {
			return true;
		}else {
			return false;
		}

	}
	@Override
	public int getDestiny() {
		return this.destiny;
	}

	public void setDestiny(int destiny) {
		this.destiny = destiny;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}
	public int getDestinyX() {
		return destinyX;
	}
	public void setDestinyX(int destinyX) {
		this.destinyX = destinyX;
	}
	public int getDestinyY() {
		return destinyY;
	}
	public void setDestinyY(int destinyY) {
		this.destinyY = destinyY;
	}
	
	

}
