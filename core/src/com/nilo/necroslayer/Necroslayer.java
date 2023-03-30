package com.nilo.necroslayer;

import java.awt.RenderingHints.Key;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.maps.tiled.renderers.BatchTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.graphics.GL20;
import com.nilo.necroslayer.model.Player;
import com.badlogic.gdx.math.Vector2;
public class Necroslayer extends ApplicationAdapter implements ApplicationListener, InputProcessor {
	
	OrthogonalTiledMapRenderer tMR;
	TiledMap tiledMap;
	SpriteBatch batch;
	Texture texture;
	Sprite sprite;
	TextureAtlas textureAtlas;
	Animation<Sprite> animation, southAnimation, northAnimation ,eastAnimation ,westAnimation;
	Animation<Sprite> walkAnimation;
	private float elapsedTime = 0;
	float unitScale = 1 / 16f;
	FitViewport viewport;
	Player player;
	Sprite spriteanda;
	int initX = 0, initY = 0;
	@Override
	public void create () {
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas(Gdx.files.internal("bartz.atlas"));
		tiledMap = new TmxMapLoader().load("mapa_0.tmx");
		tMR = new OrthogonalTiledMapRenderer(tiledMap);
		player = new Player(initX, initY);
		walkAnimation = player.currentAnimation;
		OrthographicCamera camera= new OrthographicCamera();
		camera.setToOrtho(false, 256, 176);
		camera.update();
		viewport = new FitViewport(256, 176, camera);
		
		Gdx.input.setInputProcessor(this);
		
	}

	@Override
	public void render () {
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		viewport.update(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		tMR.setView((OrthographicCamera)viewport.getCamera());
		tMR.render();
		batch.begin();
		if(player.isWalking) {
			elapsedTime += 0.08;
			player.walk();
		}
		System.out.printf("%d, %d\n", player.getTileX(), player.getTileY());
		if(elapsedTime > 1) {
			elapsedTime = 0;
		}
	    //batch.draw(andarAnimation.getKeyFrame(elapsedTime, true), 0, 0);
		
	    spriteanda = (Sprite)player.currentAnimation.getKeyFrame(elapsedTime);
	    batch.draw(spriteanda, player.posX, player.posY, 0, 0, spriteanda.getWidth(), spriteanda.getHeight(),
	    		2.7f, 2.7f, 0);
        batch.end();
        
		
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		textureAtlas.dispose();
		
	}

	@Override
	public boolean keyDown(int keycode) {
		if (player.isWalking == false) {
		if(keycode == Keys.LEFT & player.inTarget()) {
			player.targetX --;
		}
		else if(keycode == Keys.RIGHT & player.inTarget()) {
			player.targetX ++;
		}
		else if(keycode == Keys.DOWN & player.inTarget()) {
			player.targetY --;
		}
		else if(keycode == Keys.UP & player.inTarget()) {
			player.targetY ++;
		}
		player.setAnimation(keycode);
		player.isWalking = true;
		
	}
		return true;
		}

	@Override
	public boolean keyUp(int keycode) {
		return false;
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
