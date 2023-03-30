package com.nilo.necroslayer.model;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
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
	public boolean isWalking,isMovingLeft, isMovingRight, isMovingUp, isMovingDown;
	public float posX, posY;
	public int targetX, targetY, tileX, tileY;
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
	public Animation<Sprite> southIdle = new Animation<Sprite>(0.2f,
            (textureAtlas.createSprite("000")),
            (textureAtlas.createSprite("001")));
	public Animation<Sprite> currentAnimation;

	State state = State.IDLE;
	Rectangle bounds = new Rectangle();
	
	public Player(int tileX, int tileY) {
		this.tileX = tileX;
		this.tileY = tileY;
		this.bounds.height = SIZE;
		this.bounds.width = SIZE;
		this.targetX = tileX;
		this.targetY = tileY;
		this.currentAnimation = this.southIdle;
		this.isWalking = false;
		this.posX = (tileX*40f)-7;
		this.posY = (tileY*43.6f)-5;
		this.isMovingLeft = false;
		this.isMovingRight = false;
		this.isMovingUp = false;
		this.isMovingDown = false;
		
	}
	public void setAnimation(int keycode) {
		if(keycode == Keys.LEFT) {
			this.currentAnimation = this.westAnimation;
		}
		else if(keycode == Keys.RIGHT) {
			this.currentAnimation = this.eastAnimation;
		}
		else if(keycode == Keys.DOWN) {
			this.currentAnimation = this.southAnimation;
		}
		else if(keycode == Keys.UP) {
			this.currentAnimation = this.northAnimation;
		}
		
	}
	
	public void setWalking() {
		if(this.getTileX() == this.targetX & this.getTileY() == this.targetY) {
			this.isWalking = false;
		}
		else {
			this.isWalking = true;
		}
	}
	public boolean inTarget() {
		if((this.getTileX() == this.targetX & this.getTileY() == this.targetY)) {
			return true;
			
		}
		else {
			return false;
		}
	}
	public void walk() {
		if(this.isWalking) {
			if(this.getTileX() > this.targetX) {
				this.posX -= 1f;
			}
			else if(this.getTileX() < this.targetX){
				this.posX += 1f;
			}
			if(this.getTileY() > this.targetY) {
				this.posY -= 1f;
			}
			else if(this.getTileY() < this.targetY){
				this.posY += 1f;
			}
			this.setWalking();
		}
		if(this.isWalking == false) {
			if(this.isMovingLeft) {
				this.targetX --;
			}
			else if(this.isMovingRight) {
				this.targetX ++;
			}
			else if(this.isMovingUp) {
				this.targetY ++;
			}
			else if(this.isMovingDown) {
				this.targetY --;
			}
			this.setWalking();
		}
		}
	public int getTileX(){
		return (int)((this.posX + 7f)/40f);
	}
	public int getTileY(){
		return (int)((this.posY + 5f)/43.6f);
	}
	}
	


