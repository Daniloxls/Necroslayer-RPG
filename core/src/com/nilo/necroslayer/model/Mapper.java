package com.nilo.necroslayer.model;

import com.nilo.necroslayer.inventory.Item;
import com.nilo.necroslayer.inventory.Weapon;

import java.util.ArrayList;
import java.util.Arrays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;

public class Mapper {
	MapaBlocos mapa;
	
	public MapaBlocos tutorial(MapaBlocos mapa) {
		this.mapa = mapa;
		for(int i = 0; i < mapa.width; i++) {
			this.mapa.gridBlocos[i][8].isWalkable = false;
		}
		for(int i = 6; i < 9; i++) {
			this.mapa.gridBlocos[i][4].isWalkable = false;
		}
		for(int i = 5; i < 8; i++) {
			this.mapa.gridBlocos[5][i].isWalkable = false;
			this.mapa.gridBlocos[9][i].isWalkable = false;
		}
		for(int i = 0; i< 8; i++) {
			this.mapa.gridBlocos[15][i].isWalkable = false;
			this.mapa.gridBlocos[16][i].isWalkable = false;
			this.mapa.gridBlocos[25][i].isWalkable = false;
			this.mapa.gridBlocos[26][i].isWalkable = false;
		}
		this.mapa.gridBlocos[20][7].setCenario("Tocha");
		this.mapa.gridBlocos[22][7].setCenario("Tocha");
		this.mapa.gridBlocos[21][7].setItem(new Bau(new Item("Espada", "Espada de ferro")));
		this.mapa.setBloco(32, 8, new Porta(32, 8, false, null));
		return this.mapa;
	}
	public MapaBlocos mercado(MapaBlocos mapa) {
		this.mapa = mapa;
		this.mapa.gridBlocos[0][4].isWalkable = false;
		this.mapa.gridBlocos[17][4].isWalkable = false;
		this.mapa.gridBlocos[0][9].isWalkable = false;
		this.mapa.gridBlocos[17][9].isWalkable = false;
		this.mapa.gridBlocos[7][13].isWalkable = false;
		this.mapa.gridBlocos[11][13].isWalkable = false;
		for(int i = 14 ; i < 18; i++) {
			this.mapa.gridBlocos[i][12].isWalkable = false;
			this.mapa.gridBlocos[i][13].isWalkable = false;
			this.mapa.gridBlocos[i][14].isWalkable = false;
			this.mapa.gridBlocos[i][15].isWalkable = false;
		}
		for(int i = 2; i < 6; i++) {
			this.mapa.gridBlocos[i][4].isWalkable = false;
			this.mapa.gridBlocos[i][5].isWalkable = false;
			this.mapa.gridBlocos[i][6].isWalkable = false;
			this.mapa.gridBlocos[i-1][11].isWalkable = false;
			this.mapa.gridBlocos[i-1][12].isWalkable = false;
			this.mapa.gridBlocos[i-1][13].isWalkable = false;
		}
		this.mapa.gridBlocos[3][5].isWalkable = true;
		this.mapa.gridBlocos[3][6].isWalkable = true;
		this.mapa.gridBlocos[2][12].isWalkable = true;
		this.mapa.gridBlocos[2][13].isWalkable = true;
		return this.mapa;
	}
	public MapaBlocos mapa_1(MapaBlocos mapa) {
		this.mapa = mapa;
		Json json = new Json();
		//String text = json.to;
		//mapa = json.fromJson(MapaBlocos.class, Gdx.files.internal("level1.json"));
		
		this.mapa.gridBlocos[0][1].isWalkable = false;
		this.mapa.gridBlocos[0][2].isWalkable = false;
		this.mapa.gridBlocos[0][3].isWalkable = false;
		this.mapa.gridBlocos[0][4].isWalkable = false;
		this.mapa.gridBlocos[0][5].isWalkable = false;
		this.mapa.gridBlocos[0][6].isWalkable = false;
		this.mapa.gridBlocos[0][7].isWalkable = false;
		this.mapa.gridBlocos[0][8].isWalkable = false;
		this.mapa.gridBlocos[0][9].isWalkable = false;
		this.mapa.gridBlocos[0][10].isWalkable = false;
		this.mapa.gridBlocos[1][1].isWalkable = false;
		this.mapa.gridBlocos[1][3].isWalkable = false;
		this.mapa.gridBlocos[1][5].isWalkable = false;
		this.mapa.gridBlocos[1][7].isWalkable = false;
		this.mapa.gridBlocos[1][11].isWalkable = false;
		this.mapa.gridBlocos[2][1].isWalkable = false;
		this.mapa.gridBlocos[2][3].isWalkable = false;
		this.mapa.gridBlocos[2][5].isWalkable = false;
		this.mapa.gridBlocos[2][11].isWalkable = false;
		this.mapa.gridBlocos[3][1].isWalkable = false;
		this.mapa.gridBlocos[3][3].isWalkable = false;
		this.mapa.gridBlocos[3][5].isWalkable = false;
		this.mapa.gridBlocos[3][10].isWalkable = false;
		this.mapa.gridBlocos[4][7].isWalkable = false;
		this.mapa.gridBlocos[4][10].isWalkable = false;
		this.mapa.gridBlocos[5][1].isWalkable = false;
		this.mapa.gridBlocos[5][2].isWalkable = false;
		this.mapa.gridBlocos[5][3].isWalkable = false;
		this.mapa.gridBlocos[5][6].isWalkable = false;
		this.mapa.gridBlocos[5][7].isWalkable = false;
		this.mapa.gridBlocos[5][8].isWalkable = false;
		this.mapa.gridBlocos[5][9].isWalkable = false;
		this.mapa.gridBlocos[5][10].isWalkable = false;
		this.mapa.gridBlocos[5][11].isWalkable = false;
		this.mapa.gridBlocos[6][1].isWalkable = false;
		this.mapa.gridBlocos[6][11].isWalkable = false;
		this.mapa.gridBlocos[7][0].isWalkable = false;
		this.mapa.gridBlocos[7][5].isWalkable = false;
		this.mapa.gridBlocos[7][6].isWalkable = false;
		this.mapa.gridBlocos[7][7].isWalkable = false;
		this.mapa.gridBlocos[7][11].isWalkable = false;
		this.mapa.gridBlocos[8][0].isWalkable = false;
		this.mapa.gridBlocos[8][2].isWalkable = false;
		this.mapa.gridBlocos[8][5].isWalkable = false;
		this.mapa.gridBlocos[8][6].isWalkable = false;
		this.mapa.gridBlocos[8][7].isWalkable = false;
		this.mapa.gridBlocos[8][11].isWalkable = false;
		this.mapa.gridBlocos[8][13].isWalkable = false;
		this.mapa.gridBlocos[8][14].isWalkable = false;
		this.mapa.gridBlocos[8][15].isWalkable = false;
		this.mapa.gridBlocos[8][16].isWalkable = false;
		this.mapa.gridBlocos[8][17].isWalkable = false;
		this.mapa.gridBlocos[9][1].isWalkable = false;
		this.mapa.gridBlocos[9][4].isWalkable = false;
		this.mapa.gridBlocos[9][5].isWalkable = false;
		this.mapa.gridBlocos[9][6].isWalkable = false;
		this.mapa.gridBlocos[9][7].isWalkable = false;
		this.mapa.gridBlocos[9][11].isWalkable = false;
		this.mapa.gridBlocos[9][12].isWalkable = false;
		this.mapa.gridBlocos[9][17].isWalkable = false;
		this.mapa.gridBlocos[10][1].isWalkable = false;
		this.mapa.gridBlocos[10][2].isWalkable = false;
		this.mapa.gridBlocos[10][3].isWalkable = false;
		this.mapa.gridBlocos[10][4].isWalkable = false;
		this.mapa.gridBlocos[10][5].isWalkable = false;
		this.mapa.gridBlocos[10][6].isWalkable = false;
		this.mapa.gridBlocos[10][11].isWalkable = false;
		this.mapa.gridBlocos[10][12].isWalkable = false;
		this.mapa.gridBlocos[10][17].isWalkable = false;
		this.mapa.gridBlocos[11][1].isWalkable = false;
		this.mapa.gridBlocos[11][17].isWalkable = false;
		this.mapa.gridBlocos[12][1].isWalkable = false;
		this.mapa.gridBlocos[12][2].isWalkable = false;
		this.mapa.gridBlocos[12][3].isWalkable = false;
		this.mapa.gridBlocos[12][4].isWalkable = false;
		this.mapa.gridBlocos[12][5].isWalkable = false;
		this.mapa.gridBlocos[12][6].isWalkable = false;
		this.mapa.gridBlocos[12][11].isWalkable = false;
		this.mapa.gridBlocos[12][12].isWalkable = false;
		this.mapa.gridBlocos[12][17].isWalkable = false;
		this.mapa.gridBlocos[13][1].isWalkable = false;
		this.mapa.gridBlocos[13][4].isWalkable = false;
		this.mapa.gridBlocos[13][5].isWalkable = false;
		this.mapa.gridBlocos[13][6].isWalkable = false;
		this.mapa.gridBlocos[13][7].isWalkable = false;
		this.mapa.gridBlocos[13][11].isWalkable = false;
		this.mapa.gridBlocos[13][12].isWalkable = false;
		this.mapa.gridBlocos[13][17].isWalkable = false;
		this.mapa.gridBlocos[14][0].isWalkable = false;
		this.mapa.gridBlocos[14][2].isWalkable = false;
		this.mapa.gridBlocos[14][5].isWalkable = false;
		this.mapa.gridBlocos[14][6].isWalkable = false;
		this.mapa.gridBlocos[14][7].isWalkable = false;
		this.mapa.gridBlocos[14][11].isWalkable = false;
		this.mapa.gridBlocos[14][13].isWalkable = false;
		this.mapa.gridBlocos[14][14].isWalkable = false;
		this.mapa.gridBlocos[14][15].isWalkable = false;
		this.mapa.gridBlocos[14][16].isWalkable = false;
		this.mapa.gridBlocos[14][17].isWalkable = false;
		this.mapa.gridBlocos[15][0].isWalkable = false;
		this.mapa.gridBlocos[15][5].isWalkable = false;
		this.mapa.gridBlocos[15][6].isWalkable = false;
		this.mapa.gridBlocos[15][7].isWalkable = false;
		this.mapa.gridBlocos[15][11].isWalkable = false;
		this.mapa.gridBlocos[16][1].isWalkable = false;
		this.mapa.gridBlocos[16][11].isWalkable = false;
		this.mapa.gridBlocos[17][1].isWalkable = false;
		this.mapa.gridBlocos[17][2].isWalkable = false;
		this.mapa.gridBlocos[17][3].isWalkable = false;
		this.mapa.gridBlocos[17][6].isWalkable = false;
		this.mapa.gridBlocos[17][7].isWalkable = false;
		this.mapa.gridBlocos[17][8].isWalkable = false;
		this.mapa.gridBlocos[17][9].isWalkable = false;
		this.mapa.gridBlocos[17][10].isWalkable = false;
		this.mapa.gridBlocos[17][11].isWalkable = false;
		this.mapa.gridBlocos[18][7].isWalkable = false;
		this.mapa.gridBlocos[18][10].isWalkable = false;
		this.mapa.gridBlocos[19][1].isWalkable = false;
		this.mapa.gridBlocos[19][3].isWalkable = false;
		this.mapa.gridBlocos[19][5].isWalkable = false;
		this.mapa.gridBlocos[19][10].isWalkable = false;
		this.mapa.gridBlocos[20][1].isWalkable = false;
		this.mapa.gridBlocos[20][3].isWalkable = false;
		this.mapa.gridBlocos[20][5].isWalkable = false;
		this.mapa.gridBlocos[20][11].isWalkable = false;
		this.mapa.gridBlocos[21][1].isWalkable = false;
		this.mapa.gridBlocos[21][3].isWalkable = false;
		this.mapa.gridBlocos[21][5].isWalkable = false;
		this.mapa.gridBlocos[21][7].isWalkable = false;
		this.mapa.gridBlocos[21][11].isWalkable = false;
		this.mapa.gridBlocos[22][1].isWalkable = false;
		this.mapa.gridBlocos[22][2].isWalkable = false;
		this.mapa.gridBlocos[22][3].isWalkable = false;
		this.mapa.gridBlocos[22][4].isWalkable = false;
		this.mapa.gridBlocos[22][5].isWalkable = false;
		this.mapa.gridBlocos[22][6].isWalkable = false;
		this.mapa.gridBlocos[22][7].isWalkable = false;
		this.mapa.gridBlocos[22][8].isWalkable = false;
		this.mapa.gridBlocos[22][9].isWalkable = false;
		this.mapa.gridBlocos[1][10].setItem(new Bau(new Weapon("Espada", "Espadoca Bacana", 15, 21)));
		this.mapa.gridBlocos[2][10].setItem(new Bau(new Item("Potion", "Health Potion")));
		this.mapa.gridBlocos[21][10].setItem(new Bau(new Weapon("Cajado Branco", "Feito de madeira branca", 10, 12)));
		this.mapa.gridBlocos[20][10].setItem(new Bau(new Item("Elixir", "Magic Potion")));
		
		//System.out.println(json.prettyPrint(mapa));
		
		return this.mapa;
	}

}
