package com.nilo.necroslayer.model;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BlocoItem {
	private boolean interactable;
	private boolean hasDialogue;
	private boolean hasSprite;
	public ArrayList<String> dialogue;
	private Sprite sprite;
	public BlocoItem() {
		this.setInteractable(false);
		this.setHasDialogue(false);
		this.setHasSprite(false);
	}
	public void interact(Player player) {
		System.out.println("Interagiu!");
	}
	public void render(SpriteBatch batch,int x, int y) {
		batch.draw(sprite, x, y, 0, 0, 16, 16, 4, 4, 0);
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
}