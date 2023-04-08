package com.nilo.necroslayer.enemy;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Enemy {
	private int power;
	private int hp;
	private int mp;
	private int evade;
	public String name;
	public ArrayList<Integer> xp, gil;
	public Sprite sprite;
	Texture texture;
	public Enemy(){
		this.xp = new ArrayList<Integer>();
		this.gil = new ArrayList<Integer>();
		this.name = "Morcego";
		this.setPower(8);
		this.setHp(24);
		this.setMp(0);
		this.setEvade(0);
		this.xp.add(15);
		this.xp.add(23);
		this.gil.add(45);
		this.gil.add(73);
		this.texture  = new Texture(Gdx.files.internal("bat.png"));
		this.sprite = new Sprite(texture, 44, 49);
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getEvade() {
		return evade;
	}
	public void setEvade(int evade) {
		this.evade = evade;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
}
