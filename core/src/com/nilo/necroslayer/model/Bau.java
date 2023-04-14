package com.nilo.necroslayer.model;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nilo.necroslayer.inventory.Item;
import com.nilo.necroslayer.inventory.Weapon;
import com.badlogic.gdx.graphics.Texture;

public class Bau extends BlocoItem{
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
		this.item = item;
		this.dialogue = new ArrayList<String>();
		this.dialogue.add("Você recebeu " + this.item.getName());
	}
	@Override
	public void interact(Player player) {
		if(closed) {
			//add item no iventario;
			this.setSprite(aberto);
			closed = false;
			player.mochila.addItem(this.item);
		}
		else {
			this.dialogue = new ArrayList<String>();
		}
	}

}
