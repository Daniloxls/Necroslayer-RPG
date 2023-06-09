package com.nilo.necroslayer.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.nilo.necroslayer.inventory.Weapon;
import com.nilo.necroslayer.jobs.BlackMage;
import com.nilo.necroslayer.jobs.Knight;
import com.nilo.necroslayer.jobs.Thief;
import com.nilo.necroslayer.jobs.WhiteMage;

public class Bartz extends Charac{
	public Bartz(){
		this.setNumber(0);
		this.setLevel(1);
		this.setName("Alan");
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
		this.setSprites(new TextureAtlas(Gdx.files.internal("bartz.atlas")));
		this.setJob(new Knight(this));
		this.setrHand(new Weapon("espada", "muito doida", 8,5));
		this.setTexture(new Texture(Gdx.files.internal("char1.png")));
		this.setOnlySprite(new Sprite(this.getTexture(),31,32));
	}

}
