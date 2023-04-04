package com.nilo.necroslayer.model;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BlocoItem {
	public boolean interactable;
	public boolean hasDialogue;
	public ArrayList<String> dialogue;
	Sprite sprite;
	public BlocoItem() {
		
	}
	public void interact() {
		System.out.println("Interagiu!");
	}
	public void render(SpriteBatch batch) {
		//batch.draw(sprite, posX, posY, 0, 0, 16, 16, 4, 4, 0);
		
	}
}