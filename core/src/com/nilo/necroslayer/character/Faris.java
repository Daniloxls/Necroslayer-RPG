package com.nilo.necroslayer.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.nilo.necroslayer.inventory.Weapon;
import com.nilo.necroslayer.jobs.BlackMage;
import com.nilo.necroslayer.jobs.Knight;
import com.nilo.necroslayer.jobs.Thief;
import com.nilo.necroslayer.jobs.WhiteMage;

public class Faris extends Charac {
	public Faris(){
		this.setLevel(1);
		this.setName("Faris");
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
		this.setSprites(new TextureAtlas(Gdx.files.internal("faris.atlas")));
		this.setJob(new Thief(this));
		this.setrHand(new Weapon("faquinha", "esfaqueia esfaqueia!", 4,2));
}


}
