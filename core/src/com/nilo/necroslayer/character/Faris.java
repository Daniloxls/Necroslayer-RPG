package com.nilo.necroslayer.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Faris extends Charac {
	TextureAtlas textureAtlas = new TextureAtlas(Gdx.files.internal("faris.atlas"));
	public Faris(){
		this.setLevel(1);
		this.setMaxHp(35);
		this.setHp(this.getMaxHp());
		this.setMaxMp(5);
		this.setMp(this.getMaxMp());
		this.setStrenght(27);
		this.setAgility(27);
		this.setStamina(26);
		this.setMagic(26);
		this.setAtk(14);
		this.setDef(1);
		this.setEvade(10);
		this.setMdef(1);
		this.setMevade(0);
}

}
