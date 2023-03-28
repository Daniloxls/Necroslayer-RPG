package com.nilo.necroslayer.model;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {
	public enum State {
		  IDLE, WALKING
		 }
	static final int SIZE = 16;
	Vector2 position = new Vector2();
	State state = State.IDLE;
	int facing = 0;
	Rectangle bounds = new Rectangle();
	
	public Player(Vector2 position) {
		this.position = position;
		this.bounds.height = SIZE;
		this.bounds.width = SIZE;

	}
}	
