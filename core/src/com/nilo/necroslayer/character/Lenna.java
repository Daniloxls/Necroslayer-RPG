package com.nilo.necroslayer.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Lenna extends Charac {
	TextureAtlas textureAtlas = new TextureAtlas(Gdx.files.internal("lenna.atlas"));
	
	public Lenna(){
		this.setLevel(1);
		this.setMaxHp(35);
		this.setHp(this.getMaxHp());
		this.setMaxMp(5);
		this.setMp(this.getMaxMp());
		this.setStrenght(25);
		this.setAgility(26);
		this.setStamina(25);
		this.setMagic(28);
		this.setAtk(6);
		this.setDef(1);
		this.setEvade(0);
		this.setMdef(1);
		this.setMevade(0);
	}

}
