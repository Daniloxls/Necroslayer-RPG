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
	Direction direction = Direction.DOWN;
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
	public void setAnimation(Direction direct) {
		if(direct == Direction.LEFT) {
			this.currentAnimation = this.westAnimation;
		}
		if(direct == Direction.RIGHT) {
			this.currentAnimation = this.eastAnimation;
		}
		if(direct == Direction.DOWN) {
			this.currentAnimation = this.southAnimation;
		}
		if(direct == Direction.UP) {
			this.currentAnimation = this.northAnimation;
		}
		
	}
	
	public void setWalking() {
		if(this.inTarget()) {
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
				this.posX -= 2f;
			}
			else if(this.getTileX() < this.targetX){
				this.posX += 2f;
			}
			if(this.getTileY() > this.targetY) {
				this.posY -= 2f;
			}
			else if(this.getTileY() < this.targetY){
				this.posY += 2f;
			}
			this.setWalking();
		}
			if (this.inTarget()) {
				if(this.isMovingLeft) {
					this.targetX --;
					this.direction = Direction.LEFT;
				}
				if(this.isMovingRight) {
					this.targetX ++;
					this.direction = Direction.RIGHT;
				}
				if((this.isMovingUp) & !(this.isMovingLeft)& !(this.isMovingRight)) {
					this.targetY ++;
					this.direction = Direction.UP;
				}
				if((this.isMovingDown) & !(this.isMovingLeft)& !(this.isMovingRight)) {
					this.targetY --;
					this.direction = Direction.DOWN;
				}
				this.setWalking();
				this.setAnimation(this.direction);
			}
		}
	public int getTileX(){
		return (int)((this.posX + 7f)/40f);
	}
	public int getTileY(){
		return (int)((this.posY + 5f)/43.6f);
	}
	}
	


