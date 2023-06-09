package com.nilo.necroslayer.model;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.nilo.necroslayer.character.Bartz;
import com.nilo.necroslayer.character.Faris;
import com.nilo.necroslayer.character.Galuf;
import com.nilo.necroslayer.character.Lenna;
import com.nilo.necroslayer.character.Party;
import com.nilo.necroslayer.screens.Level;
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
	public boolean isWalking,isMovingLeft, isMovingRight, isMovingUp, isMovingDown;
	public float posX, posY, tileX, tileY;
	public int targetX, targetY;
	TextureAtlas textureAtlas= new TextureAtlas(Gdx.files.internal("player.atlas"));;
	public Animation<Sprite> southAnimation = new Animation<Sprite>(0.2f,
            (textureAtlas.createSprite("001")),
            (textureAtlas.createSprite("002")));
	public Animation<Sprite> northAnimation = new Animation<Sprite>(0.2f,
            (textureAtlas.createSprite("010")),
            (textureAtlas.createSprite("011")));
	public Animation<Sprite> eastAnimation = new Animation<Sprite>(0.2f,
            (textureAtlas.createSprite("007")),
            (textureAtlas.createSprite("008")));
	public Animation<Sprite> westAnimation= new Animation<Sprite>(0.2f,
            (textureAtlas.createSprite("004")),
            (textureAtlas.createSprite("005")));
	public Animation<Sprite> southIdle = new Animation<Sprite>(0.2f,
            (textureAtlas.createSprite("000")));
	public Animation<Sprite> northIdle = new Animation<Sprite>(0.2f,
            (textureAtlas.createSprite("009")));
	public Animation<Sprite> eastIdle = new Animation<Sprite>(0.2f,
            (textureAtlas.createSprite("006")));
	public Animation<Sprite> westIdle = new Animation<Sprite>(0.2f,
            (textureAtlas.createSprite("003")));
	public Animation<Sprite> currentAnimation;
	public Backpack mochila;
	private int gold;
	State state = State.IDLE;
	Direction direction = Direction.DOWN;
	Rectangle bounds = new Rectangle();
	public Party party;
	public Player() {
		this.mochila = new Backpack();
		this.bounds.height = SIZE;
		this.bounds.width = SIZE;
		this.currentAnimation = this.southIdle;
		this.isWalking = false;
		this.isMovingLeft = false;
		this.isMovingRight = false;
		this.isMovingUp = false;
		this.isMovingDown = false;
		this.party = new Party();
		this.gold = 50;
	}
	public void setPos(int x, int y) {
		this.tileX = x;
		this.tileY = y;
		this.targetX = x;
		this.targetY = y;
		this.posX = x*64;
		this.posY = y*64;
	}
	public void setPos(Level level) {
		this.setPos(level.getPlayerX(), level.getPlayerY());
	}
	public void setAnimation() {
		if(this.isWalking) {
			if(this.direction == Direction.LEFT) {
				this.currentAnimation = this.westAnimation;
			}
			if(this.direction == Direction.RIGHT) {
				this.currentAnimation = this.eastAnimation;
			}
			if(this.direction == Direction.DOWN) {
				this.currentAnimation = this.southAnimation;
			}
			if(this.direction == Direction.UP) {
				this.currentAnimation = this.northAnimation;
			}
		}
		else {
			if(this.direction == Direction.LEFT) {
				this.currentAnimation = this.westIdle;
			}
			if(this.direction == Direction.RIGHT) {
				this.currentAnimation = this.eastIdle;
			}
			if(this.direction == Direction.DOWN) {
				this.currentAnimation = this.southIdle;
			}
			if(this.direction == Direction.UP) {
				this.currentAnimation = this.northIdle;
			}
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
	public ArrayList<String> depurar(MapaBlocos mapa) {
		Bloco blocoFacing;
		
		if(this.direction == Direction.LEFT) {
			if(this.targetX == 0) {
				return new ArrayList<String>();
			}
			else {
				blocoFacing = mapa.gridBlocos[this.targetX-1][this.targetY];
			}
		}
		else if(this.direction == Direction.RIGHT) {
			if(this.targetX == mapa.width-1) {
				return new ArrayList<String>();
			}
			else {
				blocoFacing = mapa.gridBlocos[this.targetX+1][this.targetY];
			}
		}
		else if(this.direction == Direction.DOWN) {
			if(this.targetY == 0) {
				return new ArrayList<String>();
			}
			else {
				blocoFacing = mapa.gridBlocos[this.targetX][this.targetY-1];
			}
		}
		else{
			if(this.targetY == mapa.height-1) {
				return new ArrayList<String>();
			}
			else {
				blocoFacing = mapa.gridBlocos[this.targetX][this.targetY+1];
			}
		}
		return blocoFacing.depurar();
		
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
				this.setAnimation();
			}
		}
	
	public ArrayList<String> interact(MapaBlocos mapa) {
		Bloco blocofacing;
		if(this.direction == Direction.LEFT) {
			if(this.targetX == 0) {
				return new ArrayList<String>();
			}
			else {
				blocofacing = mapa.gridBlocos[this.targetX-1][this.targetY];
			}
		}
		else if(this.direction == Direction.RIGHT) {
			if(this.targetX == mapa.width-1) {
				return new ArrayList<String>();
			}
			else {
				blocofacing = mapa.gridBlocos[this.targetX+1][this.targetY];
			}
		}
		else if(this.direction == Direction.DOWN) {
			if(this.targetY == 0) {
				return new ArrayList<String>();
			}
			else {
				blocofacing = mapa.gridBlocos[this.targetX][this.targetY-1];
			}
		}
		else{
			if(this.targetY == mapa.height-1) {
				return new ArrayList<String>();
			}
			else {
				blocofacing = mapa.gridBlocos[this.targetX][this.targetY+1];
			}
		}
		if (blocofacing.getItem().isInteractable()) {
			if (blocofacing.getItem().isHasDialogue()) {
				blocofacing.getItem().interact(this);
				return blocofacing.getItem().dialogue;
			}
			else {
			blocofacing.getItem().interact(this);
			return new ArrayList<String>();
			}
		}
		else {
			return new ArrayList<String>();
		}
	}
	
	public Bloco getFacingBlock(MapaBlocos mapa) {
		Bloco blocofacing;
		if(this.direction == Direction.LEFT) {
			if(this.targetX == 0) {
				return null;
			}
			else {
				blocofacing = mapa.gridBlocos[this.targetX-1][this.targetY];
			}
		}
		else if(this.direction == Direction.RIGHT) {
			if(this.targetX == mapa.width-1) {
				return null;
			}
			else {
				blocofacing = mapa.gridBlocos[this.targetX+1][this.targetY];
			}
		}
		else if(this.direction == Direction.DOWN) {
			if(this.targetY == 0) {
				return null;
			}
			else {
				blocofacing = mapa.gridBlocos[this.targetX][this.targetY-1];
			}
		}
		else{
			if(this.targetY == mapa.height-1) {
				return null;
			}
			else {
				blocofacing = mapa.gridBlocos[this.targetX][this.targetY+1];
			}
		}
		return blocofacing;
	}
	public float getTileX(){
		return (this.posX)/64;
	}
	public float getTileY(){
		return (this.posY)/64;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public void gainGold(int gold) {
		this.gold += gold;
	}
}