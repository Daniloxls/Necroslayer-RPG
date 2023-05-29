package com.nilo.necroslayer.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nilo.necroslayer.model.Player.Direction;

public class MapaBlocos {
	public Bloco[][] gridBlocos;
	public int height, width;
	
	
	public MapaBlocos(int w, int h) {
		this.height = h;
		this.width = w;
		this.gridBlocos = new Bloco[w][h];
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				gridBlocos[i][j] = new Bloco(i,j,true);
			}
		}
	}
	public void renderItems(SpriteBatch batch) {
		for(int i = 0; i < this.width; i++) {
			for(int j = 0; j < this.height; j++) {
				if(this.gridBlocos[i][j].getItem().isHasSprite()) {
					this.gridBlocos[i][j].getItem().render(batch, i*64,j*64);
				}
			}
		}
	}
	public void setBloco(int x, int y, Bloco bloco) {
		this.gridBlocos[x][y] = bloco;
	}
}