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
	
	
	public ArrayList<Item> getItems() {
		return this.mochila;
	}
	
	public void addItem(Item item) {
		mochila.add(item);

	}
	
}
