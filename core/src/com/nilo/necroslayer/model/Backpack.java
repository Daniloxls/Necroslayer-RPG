package com.nilo.necroslayer.model;

import java.util.ArrayList;

import com.nilo.necroslayer.inventory.Item;

public class Backpack {
	int maxItens;
	private ArrayList<Item> mochila;
	
	public Backpack(){
		 this.mochila = new ArrayList<Item>();
	}
	
	
	public ArrayList<Item> getItems() {
		return this.mochila;
	}
	
	public void addItem(Item item) {
		mochila.add(item);

	}
	
}
