package com.nilo.necroslayer.model;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nilo.necroslayer.inventory.Item;
import com.badlogic.gdx.graphics.Texture;

public class Bau extends BlocoItem{
	Item item;
	Texture textureFechado = new Texture(Gdx.files.internal("bau_fechado.png"));
	Sprite fechado = new Sprite(textureFechado, 16, 15);
	Texture textureAberto = new Texture(Gdx.files.internal("bau_aberto.png"));
	Sprite aberto = new Sprite(textureAberto, 16, 15);
	
	boolean closed;
	
	public Bau(Item item) {
		this.closed = true;
		this.setInteractable(true);
		this.setSprite(fechado);
		this.setHasDialogue(true);
		this.dialogue = new ArrayList<String>();
		this.dialogue.add("Você recebeu item");
	}
	@Override
	public void interact(Player player) {
		if(closed) {
			System.out.println("Abriu");
			//add item no iventario;
			this.setSprite(aberto);
			closed = false;
			//this.dialogue = new ArrayList<String>();
		}
		else {
			this.dialogue = new ArrayList<String>();
		}
	}

}
