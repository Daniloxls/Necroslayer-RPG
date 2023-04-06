package com.nilo.necroslayer.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.nilo.necroslayer.jobs.BlackMage;
import com.nilo.necroslayer.jobs.Knight;
import com.nilo.necroslayer.jobs.Thief;

public class Bartz extends Charac{
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
		this.setSprites(new TextureAtlas(Gdx.files.internal("bartz.atlas")));
		this.setJob(new Thief());
	}
	//@Override
	/*public Animation<Sprite> getAnimation(){
		TextureAtlas sprites = this.getSprites();
		Animation<Sprite> currentAnimation = new Animation<Sprite>(0.2f,
				(sprites.createSprite(("000")+Integer.toString(this.getJob().id))),
				(sprites.createSprite(("000")+Integer.toString(this.getJob().id+1))),
				(sprites.createSprite(("000")+Integer.toString(this.getJob().id+2))),
				(sprites.createSprite(("000")+Integer.toString(this.getJob().id+3))),
				(sprites.createSprite(("000")+Integer.toString(this.getJob().id+4))),
				(sprites.createSprite(("000")+Integer.toString(this.getJob().id+5))),
				(sprites.createSprite(("000")+Integer.toString(this.getJob().id+6))),
				(sprites.createSprite(("000")+Integer.toString(this.getJob().id+7))),
				(sprites.createSprite(("000")+Integer.toString(this.getJob().id+8))),
				(sprites.createSprite(("000")+Integer.toString(this.getJob().id+9))),
				(sprites.createSprite(("000")+Integer.toString(this.getJob().id+10))),
				(sprites.createSprite(("00011")))
				);
			System.out.println(this.getJob().id);
			System.out.println(("000")+Integer.toString(this.getJob().id));
			System.out.println("SpriteCarregado");
		return currentAnimation;
	}*/

}
