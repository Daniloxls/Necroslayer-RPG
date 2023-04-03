package com.nilo.necroslayer.model;

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
}