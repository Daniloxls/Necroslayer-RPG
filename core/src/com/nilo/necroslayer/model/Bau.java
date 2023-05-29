package com.nilo.necroslayer.model;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nilo.necroslayer.inventory.Item;
import com.nilo.necroslayer.inventory.Weapon;
import com.badlogic.gdx.graphics.Texture;

public class Bau extends BlocoItem{
	
	boolean closed;
	
	public Bau(Item item) {
		this.closed = true;
		this.setName("Bau");
		this.setHasSprite(true);
		this.setInteractable(true);
		this.setHasDialogue(true);
		this.item = item;
		this.dialogue = new ArrayList<String>();
		this.dialogue.add("Você recebeu " + this.item.getName());
	}
	@Override
	public void interact(Player player) {
		if(closed) {
			//add item no iventario;
			closed = false;
			player.mochila.addItem(this.item);
		}
		else {
			this.dialogue = new ArrayList<String>();
		}
	}
	@Override
	public ArrayList<String> depurar(){
		ArrayList<String> texto = new ArrayList<String>();
		if(this.closed) {
			texto.add("private String nome = \"Bau\" ;");
			texto.add("private boolean interagivel = true ;" );
			texto.add("private boolean aberto = " + Boolean.toString(!closed) + ";");
			texto.add("private Item item =" + this.item.getName() + ";");
		}
		else {
			texto.add("private String nome = \"Bau\" ;");
			texto.add("private boolean interagivel = false ;" );
			texto.add("private boolean aberto = " + Boolean.toString(!closed) + ";");
			texto.add("private Item item = null;");
		}
		return texto;
		
	}
	@Override
	public void render(SpriteBatch batch,int x, int y) {
		Texture textureFechado = new Texture(Gdx.files.internal("bau_fechado.png"));
		Sprite fechado = new Sprite(textureFechado, 18, 32);
		Texture textureAberto = new Texture(Gdx.files.internal("bau_aberto.png"));
		Sprite aberto = new Sprite(textureAberto, 18, 32);
		if (closed) {
			batch.draw(fechado, x, y, 0, 0, 18, 32, 4, 4, 0);
		}
		else {
			batch.draw(aberto, x, y, 0, 0, 18, 32, 4, 4, 0);
		}
		
	}

}
