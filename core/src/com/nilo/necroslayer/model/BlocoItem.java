package com.nilo.necroslayer.model;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nilo.necroslayer.inventory.Item;

public class BlocoItem {
	private boolean publico;
	private String Name;
	private boolean interactable;
	private boolean hasDialogue;
	private boolean hasSprite;
	public ArrayList<String> dialogue;
	private Sprite sprite;
	public Item item;
	public BlocoItem() {
		this.setInteractable(false);
		this.setHasDialogue(false);
		this.setHasSprite(false);
	}
	
	public ArrayList<String> depurar(){
		ArrayList<String> texto = new ArrayList<String>();
		texto.add("String nome = " + Name + ";");
		texto.add("boolean interagivel = " + Boolean.toString(this.interactable) + ";" );
		
		return texto;
		
	}

	public void setItem(Item item) {
		this.item = item;
	}
	public void interact(Player player) {

	}
	public void render(SpriteBatch batch,int x, int y) {
		batch.draw(sprite, x, y, 0, 0, 18, 32, 4, 4, 0);
	}
	
	public Sprite getSprite() {
		return this.sprite;
	}
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
		this.setHasSprite(true);
	}
	public boolean isInteractable() {
		return interactable;
	}
	public void setInteractable(boolean interactable) {
		this.interactable = interactable;
	}
	public boolean isHasDialogue() {
		return hasDialogue;
	}
	public void setHasDialogue(boolean hasDialogue) {
		this.hasDialogue = hasDialogue;
	}
	public boolean isHasSprite() {
		return hasSprite;
	}
	public void setHasSprite(boolean hasSprite) {
		this.hasSprite = hasSprite;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
}