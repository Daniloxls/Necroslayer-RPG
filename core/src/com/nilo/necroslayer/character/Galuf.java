package com.nilo.necroslayer.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.nilo.necroslayer.inventory.Weapon;
import com.nilo.necroslayer.jobs.BlackMage;
import com.nilo.necroslayer.jobs.Knight;
import com.nilo.necroslayer.jobs.WhiteMage;

public class Galuf extends Charac {
	public Galuf(){
		this.setNumber(2);
		this.setLevel(1);
		this.setName("Ada");
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
		this.setrHand(new Weapon("Vara do poder", "apenas um cajado normal", 10,2));
		this.setJob(new BlackMage(this));
		this.setTexture(new Texture(Gdx.files.internal("char3.png")));
		this.setOnlySprite(new Sprite(this.getTexture(),31,32));
	}

}
