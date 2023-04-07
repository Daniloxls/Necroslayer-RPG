package com.nilo.necroslayer.enemy;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Enemy {
	int power;
	int hp;
	int mp;
	int evade;
	public String name;
	public ArrayList<Integer> xp, gil;
	public Sprite sprite;
	Texture texture;
	public Enemy(){
		this.name = "Morcego";
		this.power = 8;
		this.hp = 24;
		this.mp = 0;
		this.evade = 0;
		//this.xp.add(15);
		//this.xp.add(23);
		//this.xp.add(45);
		//this.xp.add(73);
		this.texture  = new Texture(Gdx.files.internal("bat.png"));
		this.sprite = new Sprite(texture, 44, 49);
	}
}
