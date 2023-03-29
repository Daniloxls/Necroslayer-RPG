package com.nilo.necroslayer.model;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.Map;
public class Player extends Actor {
	public enum State {
		  IDLE, WALKING
		 }
	public enum Direction{
		LEFT, RIGHT, UP, DOWN
	}
	static final float SIZE = 1f;
	World world;
	public int posX;
	public int posY;
	TextureAtlas textureAtlas= new TextureAtlas(Gdx.files.internal("bartz.atlas"));;
	public Animation<Sprite> southAnimation = new Animation<Sprite>(0.2f,
            (textureAtlas.createSprite("000")),
            (textureAtlas.createSprite("001")));
	public Animation<Sprite> northAnimation = new Animation<Sprite>(0.2f,
            (textureAtlas.createSprite("002")),
            (textureAtlas.createSprite("003")));
	public Animation<Sprite> eastAnimation = new Animation<Sprite>(0.2f,
            (textureAtlas.createSprite("006")),
            (textureAtlas.createSprite("007")));
	public Animation<Sprite> westAnimation= new Animation<Sprite>(0.2f,
            (textureAtlas.createSprite("004")),
            (textureAtlas.createSprite("005")));
	

	State state = State.IDLE;
	Rectangle bounds = new Rectangle();
	
	public Player(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.bounds.height = SIZE;
		this.bounds.width = SIZE;

	}
}

