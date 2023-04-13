package com.nilo.necroslayer.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.nilo.necroslayer.jobs.BlackMage;
import com.nilo.necroslayer.jobs.Knight;
import com.nilo.necroslayer.jobs.WhiteMage;

public class Galuf extends Charac {
	public Galuf(){
		
			this.setLevel(1);
			this.setName("Galuf");
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
			this.setSprites(new TextureAtlas(Gdx.files.internal("galuf.atlas")));
			this.setJob(new Knight());
	}

}
