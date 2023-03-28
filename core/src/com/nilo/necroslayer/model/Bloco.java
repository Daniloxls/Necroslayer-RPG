package com.nilo.necroslayer.model;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bloco {
	static final int SIZE = 16;
	 Vector2  position = new Vector2();
	 Rectangle  bounds = new Rectangle();
	 
	 public Bloco(Vector2 pos) {
		  this.position = pos;
		  this.bounds.width = SIZE;
		  this.bounds.height = SIZE;
		 }

}
