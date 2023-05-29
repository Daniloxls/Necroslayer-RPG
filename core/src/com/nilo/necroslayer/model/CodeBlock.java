package com.nilo.necroslayer.model;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nilo.necroslayer.screens.PlayerCamera;

public class CodeBlock {
	private ArrayList<String> texto;
	private int choiceIndex = 0;
	private Bloco bloco;
	private int size;
	private boolean showingCode;
	private ArrayList<Integer> options = new ArrayList<Integer>();
	private BitmapFont font  = new BitmapFont(Gdx.files.internal("finalfont.fnt"), Gdx.files.internal("finalfont.png") , false, true);
	Texture textDialogo = new Texture(Gdx.files.internal("codebox.png"));
	Sprite caixaDialogo = new Sprite(textDialogo);
	Texture handTexture = new Texture(Gdx.files.internal("maozinha.png"));
	Sprite cursorR = new Sprite(handTexture, 16, 16);
	
	public void render(PlayerCamera playcam, SpriteBatch batch) {
		if (showingCode){
			float dX = playcam.position.x - 290;
			float dY = playcam.position.y + 240;
			batch.draw(caixaDialogo, playcam.position.x - 300, playcam.position.y, 0, 0, 116,64,
		    		4, 4, 0);
			for(String s : this.texto) {
				if(this.bloco.getBlocopropiedades().get(this.texto.indexOf(s)).get(1) == 1) {
					String line = "public ";
					switch(this.bloco.getBlocopropiedades().get(this.texto.indexOf(s)).get(2)) {
					case 0:
						line += "boolean trancado ";
						if (this.bloco.getBlocopropiedades().get(this.texto.indexOf(s)).get(3) == 0) {
							line += "= false;";
						}else {
							line += "= true;";
						}
						break;
					case 1:
						line += "int =";
						line += Integer.toString(this.bloco.getBlocopropiedades().get(this.texto.indexOf(s)).get(3));
						
					}
					font.draw(batch, line, dX, dY);
					
				}else {
				font.draw(batch, s, dX, dY);
				}
				dY -= 16f;
			}
			if(bloco.isPublicBlock()) {
				batch.draw(cursorR, playcam.position.x - 325, playcam.position.y + 210-(this.choiceIndex*16), 0, 0, 16, 16,
			    		2, 2, 0);
			}
		
		}
		
	}
	public void setCode(ArrayList<String> novoTexto, Bloco bloco) {
		this.bloco = bloco;
		if(bloco.isPublicBlock()) {
			for(ArrayList<Integer> p : this.bloco.getBlocopropiedades()) {
				if(p.get(1) == 1) {
					this.options.add(p.get(0));
				}
			}
			this.choiceIndex = this.options.get(0);
		}
		this.texto = novoTexto;
		this.size = novoTexto.size();
		this.showingCode = true;
		if (this.size == 0) {
			this.showingCode = false;
		}
	}
	public boolean isShowingCode() {
		return this.showingCode;
	}
	public void setShowingCode(boolean showing) {
		this.showingCode = showing;
	}
	public ArrayList<Integer> getOptions() {
		return options;
	}
	public void setOptions(ArrayList<Integer> options) {
		this.options = options;
	}
	public Bloco getBloco() {
		return bloco;
	}
	public void setBloco(Bloco bloco) {
		this.bloco = bloco;
	}
	public void downOption() {
		if(!this.bloco.isPublicBlock()) {
			return;
		}
		if(this.options.size() <= this.options.indexOf(choiceIndex) + 1) {
			this.choiceIndex = this.options.get(0);
			return;
		}
		this.choiceIndex = this.options.get(this.options.indexOf(choiceIndex)+ 1 );
	}
	public void upOption() {
		if(!this.bloco.isPublicBlock()) {
			return;
		}
		if(0 > this.options.indexOf(choiceIndex) - 1) {
			this.choiceIndex = this.options.get(this.options.size() - 1);
			return;
		}
		this.choiceIndex = this.options.get(this.options.indexOf(choiceIndex) - 1 );
	}
	public void leftOption() {
		if(!this.bloco.isPublicBlock()) {
			return;
		}
		switch(this.bloco.getBlocopropiedades().get(this.choiceIndex).get(2)) {
		case 0:
			if (this.bloco.getBlocopropiedades().get(this.choiceIndex).get(3) == 0) {
				this.bloco.getBlocopropiedades().get(this.choiceIndex).set(3, 1);
				this.bloco.setWalkable(true);
			}else {
				this.bloco.getBlocopropiedades().get(this.choiceIndex).set(3, 0);
				this.bloco.setWalkable(false);
			}
			break;
		case 1:
			int val = this.bloco.getBlocopropiedades().get(this.choiceIndex).get(3) - 1;
			this.bloco.getBlocopropiedades().get(this.choiceIndex).set(3, val);
			
		}
		
	}
	public void rightOption() {
		if(!this.bloco.isPublicBlock()) {
			return;
		}
		switch(this.bloco.getBlocopropiedades().get(this.choiceIndex).get(2)) {
		case 0:
			if (this.bloco.getBlocopropiedades().get(this.choiceIndex).get(3) == 0) {
				this.bloco.getBlocopropiedades().get(this.choiceIndex).set(3, 1);
				this.bloco.setWalkable(true);
			}else {
				this.bloco.getBlocopropiedades().get(this.choiceIndex).set(3, 0);
				this.bloco.setWalkable(false);
			}
			break;
		case 1:
			int val = this.bloco.getBlocopropiedades().get(this.choiceIndex).get(3) + 1;
			this.bloco.getBlocopropiedades().get(this.choiceIndex).set(3, val);
			
		}
		
	}
	public int getChoiceIndex() {
		return choiceIndex;
	}
	public void setChoiceIndex(int choiceIndex) {
		this.choiceIndex = choiceIndex;
	}
	public Bloco changeBlock() {
		return this.bloco;
	}
}

