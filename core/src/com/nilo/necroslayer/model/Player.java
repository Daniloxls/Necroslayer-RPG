package com.nilo.necroslayer.model;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
	State state = State.IDLE;
	Rectangle bounds = new Rectangle();
	
	public Player(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.bounds.height = SIZE;
		this.bounds.width = SIZE;

	}
}	
