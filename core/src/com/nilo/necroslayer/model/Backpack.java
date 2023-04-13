package com.nilo.necroslayer.model;

import java.util.ArrayList;

import com.nilo.necroslayer.inventory.Item;

public class Backpack {
	int maxItens;
	private ArrayList<Item> mochila;
	
	public Backpack(int max){
		 this.mochila = new ArrayList<Item>();
		 this.maxItens = max;
	}
	
	private boolean isFull() {
		if(mochila.size() < maxItens) return false;
		else return true;
	}
	
	public ArrayList<Item> getItems() {
		return this.mochila;
	}
	
	public boolean addItem(Item item) {
		if(isFull())return false;
		else {
			mochila.add(item);
			return true;
		}
	}
	
}
