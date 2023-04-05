package com.nilo.necroslayer.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Bartz extends Charac{
	TextureAtlas textureAtlas = new TextureAtlas(Gdx.files.internal("bartz.atlas"));
	public Bartz(){
		this.setLevel(1);
		this.setMaxHp(36);
		this.setHp(this.getMaxHp());
		this.setMaxMp(5);
		this.setMp(this.getMaxMp());
		this.setStrenght(28);
		this.setAgility(25);
		this.setStamina(27);
		this.setMagic(25);
		this.setAtk(15);
		this.setDef(1);
		this.setEvade(0);
		this.setMdef(1);
		this.setMevade(0);
	}

}
