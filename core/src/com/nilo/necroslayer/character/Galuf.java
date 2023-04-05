package com.nilo.necroslayer.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Galuf extends Charac {
	TextureAtlas textureAtlas = new TextureAtlas(Gdx.files.internal("galuf.atlas"));
	public Galuf(){
		
			this.setLevel(1);
			this.setMaxHp(37);
			this.setHp(this.getMaxHp());
			this.setMaxMp(5);
			this.setMp(this.getMaxMp());
			this.setStrenght(27);
			this.setAgility(24);
			this.setStamina(28);
			this.setMagic(28);
			this.setAtk(3);
			this.setDef(1);
			this.setEvade(0);
			this.setMdef(1);
			this.setMevade(0);
	}

}
