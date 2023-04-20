package com.nilo.necroslayer.enemy;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.nilo.necroslayer.character.Party;
import com.nilo.necroslayer.inventory.Item;
import com.nilo.necroslayer.inventory.Weapon;

import java.util.Random;

public class Enemy {
	private int power;
	private int hp;
	private int mp;
	private int evade;
	private String name;
	public ArrayList<Integer> xp, gil;
	private Sprite sprite;
	Texture texture;
	private int x,y;
	private int sizeX, sizeY;
	private Item item;
	public Enemy(){
		this.xp = new ArrayList<Integer>();
		this.gil = new ArrayList<Integer>();
		this.setName("Morcego");
		this.setPower(8);
		this.setHp(24);
		this.setMp(0);
		this.setEvade(0);
		this.setSizeX(44);
		this.setSizeY(49);
		this.xp.add(15);
		this.xp.add(23);
		this.gil.add(45);
		this.gil.add(73);
		this.texture  = new Texture(Gdx.files.internal("bat.png"));
		this.setSprite(new Sprite(texture, this.sizeX, this.sizeY));
		this.setItem(new Weapon("faquinha", "esfaqueia esfaqueia!", 4,2));
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
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public Sprite getSprite() {
		return sprite;
	}
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSizeY() {
		return sizeY;
	}
	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}
	public int getSizeX() {
		return sizeX;
	}
	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}
	public ArrayList<String> attack(Party party){
		ArrayList<String> texto = new ArrayList<String>();
		int dano, percento, alvo;
		Random generator = new Random();
		alvo = generator.nextInt(4);
		percento = generator.nextInt(26) + 75;
		dano = (int)(this.power * percento) /100;
		if(party.getComp().get(alvo).isDefend()) {
			dano = 0;
		}
		party.getComp().get(alvo).setHp(party.getComp().get(alvo).getHp()-dano);
		texto.add(this.name + " causou " + Integer.toString(dano) + " de dano em " + party.getComp().get(alvo).getName() + ".");
		return texto;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
}