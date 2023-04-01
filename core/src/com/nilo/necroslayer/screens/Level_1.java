package com.nilo.necroslayer.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.nilo.necroslayer.Necroslayer;

public class Level_1 extends ScreenAdapter implements InputProcessor{
	Necroslayer game;
	
	public Level_1(Necroslayer game) {
		this.game = game;
	}
	@Override
	public void show() {
		Gdx.input.setInputProcessor(this);
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		this.game.tMR.setView((OrthographicCamera)this.game.viewport.getCamera());
		this.game.tMR.render();
		this.game.batch.begin();
		if(this.game.player.isWalking) {
			this.game.elapsedTime += 0.08;
		}
		this.game.player.walk();
		if(this.game.elapsedTime > 1) {
			this.game.elapsedTime = 0;
		}
		this.game.camera.update();
		this.game.batch.setProjectionMatrix(this.game.camera.combined);
		this.game.spriteanda = (Sprite)this.game.player.currentAnimation.getKeyFrame(this.game.elapsedTime);
		this.game.batch.draw(this.game.spriteanda, this.game.player.posX, this.game.player.posY, 0, 0, 16, 16,
		    		4, 4, 0);
		this.game.time = String.format("%f",this.game.elapsedTime);
		this.game.cXY = String.format("%f , %f",this.game.player.getTileX(), this.game.player.getTileY());
		this.game.tXY = String.format("%d , %d",this.game.player.targetX, this.game.player.targetY);
		this.game.pXY = String.format("%f , %f",this.game.player.posX, this.game.player.posY);
		this.game.font.draw(this.game.batch, this.game.time, 0, 500);
		this.game.font.draw(this.game.batch, this.game.cXY, 0, 485);
		this.game.font.draw(this.game.batch, this.game.tXY, 0, 470);
		this.game.font.draw(this.game.batch, this.game.pXY, 0, 455);
		this.game.batch.end();
	        
			
		}
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.F1) {
			System.out.println(this.game.player.isMovingRight);
		}
		if(keycode == Keys.LEFT) {
			this.game.player.isMovingLeft = true;
		}
		if(keycode == Keys.RIGHT) {
			this.game.player.isMovingRight = true;
		}
		if(keycode == Keys.DOWN) {
			this.game.player.isMovingDown = true;
		}
		if(keycode == Keys.UP) {
			this.game.player.isMovingUp = true;
		}
		return true;
	}
	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Keys.LEFT) {
			this.game.player.isMovingLeft = false;
	}
		if(keycode == Keys.RIGHT) {
			this.game.player.isMovingRight = false;
	}
		if(keycode == Keys.UP) {
			this.game.player.isMovingUp = false;
	}
		if(keycode == Keys.DOWN) {
			this.game.player.isMovingDown = false;
	}
		return true;
	}
	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean scrolled(float amountX, float amountY) {
		// TODO Auto-generated method stub
		return false;
	}
	}
