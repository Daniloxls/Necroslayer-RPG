package com.nilo.necroslayer.model;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nilo.necroslayer.inventory.Item;

public class BlocoItem {
	public boolean interactable;
	public boolean hasDialogue;
	public ArrayList<String> dialogue;
	public Item item;
	Sprite sprite;
	public BlocoItem() {
		
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public void interact(Player player) {
		System.out.println("Interagiu!");
		player.mochila.addItem(this.item);
	}
	public void render(SpriteBatch batch) {
		//batch.draw(sprite, posX, posY, 0, 0, 16, 16, 4, 4, 0);
		
	}
}