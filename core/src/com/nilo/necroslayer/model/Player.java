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

import java.util.ArrayList;
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
	public float posX, posY, tileX, tileY;
	public int targetX, targetY;
	TextureAtlas textureAtlas= new TextureAtlas(Gdx.files.internal("player.atlas"));;
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
		this.posX = (tileX*64);
		this.posY = (tileY*64);
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
	public void walk(MapaBlocos mapa) {
		this.setWalking();
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
		}
			if (this.inTarget()) {
				if(this.isMovingLeft) {
					this.direction = Direction.LEFT;
					if(this.targetX >0) {
						if(mapa.gridBlocos[this.targetX - 1][this.targetY].isWalkable) {
							this.targetX --;

						}
					}
				}
				if(this.isMovingRight) {
					this.direction = Direction.RIGHT;
					if(this.targetX < mapa.width-1) {
						if(mapa.gridBlocos[this.targetX + 1][this.targetY].isWalkable) {
							this.targetX ++;
	
							}
						}
					
				}
				if((this.isMovingUp) & !(this.isMovingLeft)& !(this.isMovingRight)) {
					this.direction = Direction.UP;	
					if(this.targetY < mapa.height-1) {
						if(mapa.gridBlocos[this.targetX][this.targetY + 1].isWalkable) {
							this.targetY ++;

							}
						}
				}
				if((this.isMovingDown) & !(this.isMovingLeft)& !(this.isMovingRight)) {
					this.direction = Direction.DOWN;	
					if(this.targetY > 0) {
						if(mapa.gridBlocos[this.targetX][this.targetY -1].isWalkable) {
							this.targetY --;

							}
						}
				}
				this.setWalking();
				this.setAnimation(this.direction);
			}
		}
	public ArrayList<String> interact(MapaBlocos mapa) {
		Bloco blocofacing;
		if(this.direction == Direction.LEFT) {
			blocofacing = mapa.gridBlocos[this.targetX-1][this.targetY];
		}
		else if(this.direction == Direction.RIGHT) {
			blocofacing = mapa.gridBlocos[this.targetX+1][this.targetY];
		}
		else if(this.direction == Direction.DOWN) {
			blocofacing = mapa.gridBlocos[this.targetX][this.targetY-1];
		}
		else{
			blocofacing = mapa.gridBlocos[this.targetX][this.targetY+1];
		}
		if (blocofacing.getItem().interactable) {
			if (blocofacing.getItem().hasDialogue) {
				blocofacing.getItem().interact();
				return blocofacing.getItem().dialogue;
			}
			else {
			blocofacing.getItem().interact();
			return new ArrayList<String>();
			}
		}
		else {
			return new ArrayList<String>();
		}
	}
	public float getTileX(){
		return (this.posX)/64;
	}
	public float getTileY(){
		return (this.posY)/64;
	}
	}
	


