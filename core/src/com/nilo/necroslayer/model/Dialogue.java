package com.nilo.necroslayer.model;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nilo.necroslayer.screens.PlayerCamera;

public class Dialogue {
	int index;
	ArrayList<String> texto;
	boolean inDialogue;
	int size;
	public BitmapFont font  = new BitmapFont(Gdx.files.internal("finalfont.fnt"), Gdx.files.internal("finalfont.png") , false, true);
	Texture textDialogo = new Texture(Gdx.files.internal("dialogue_box.png"));
	Sprite caixaDialogo = new Sprite(textDialogo);
	public Dialogue(){
		this.texto = new ArrayList<String>();
		this.index = 0;
		this.size = 0;
	}
	
	public void render(PlayerCamera playcam, SpriteBatch batch) {
		if (inDialogue){
			float dX = playcam.position.x-430;
			float dY = playcam.position.y - 140;
			batch.draw(caixaDialogo, playcam.position.x - 512, playcam.position.y - 288, 0, 0, 256,48,
		    		4, 4, 0);
			for(char c : this.texto.get(index).toCharArray()) {
				font.draw(batch, String.valueOf(c), dX, dY);
				dX +=12f;
				if(dX > playcam.position.x + 430) {
					dY -= 16f;
					dX = playcam.position.x-430;
				}
			}
			
					
				}
			}
	public void render(SpriteBatch batch) {
		if (inDialogue){
			float dX = 82;
			float dY = 148;
			batch.draw(caixaDialogo, 0, 0, 0, 0, 256,48,
		    		4, 4, 0);
			for(char c : this.texto.get(index).toCharArray()) {
				font.draw(batch, String.valueOf(c), dX, dY);
				dX +=12f;
				if(dX > 942) {
					dY -= 16f;
					dX = 82;
				}
			}
			
					
				}
			}
	public void setDialogue(ArrayList<String> novoTexto) {
		this.texto = novoTexto;
		this.index = 0;
		this.size = novoTexto.size();
		this.inDialogue = true;
		if (this.size == 0) {
			this.inDialogue = false;
		}
	}
	public void nextDialogue() {
		this.index ++;
		if(this.index == this.size) {
			this.inDialogue = false;
		}
	}
	public boolean getInDialogue() {
		return this.inDialogue;
	}
		}
	
