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
		southAnimation = new Animation<Sprite>(0.2f,
	            (textureAtlas.createSprite("000")),
	            (textureAtlas.createSprite("001")));
		
		northAnimation = new Animation<Sprite>(0.2f,
	            (textureAtlas.createSprite("002")),
	            (textureAtlas.createSprite("003")));
		
		eastAnimation = new Animation<Sprite>(0.2f,
				(textureAtlas.createSprite("006")),
	            (textureAtlas.createSprite("007")));
		westAnimation = new Animation<Sprite>(0.2f,
	            (textureAtlas.createSprite("004")),
	            (textureAtlas.createSprite("005")));

	  
		OrthographicCamera camera= new OrthographicCamera();
		camera.setToOrtho(false, 256, 176);
		camera.update();
		viewport = new FitViewport(256, 176, camera);
		player = new Player(initX, initY);
		Gdx.input.setInputProcessor(this);
		
	}

	@Override
	public void render () {
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		viewport.update(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		tMR.setView((OrthographicCamera)viewport.getCamera());
		tMR.render();
		batch.begin();
		elapsedTime += 0.08;
		if(elapsedTime > 1) {
			elapsedTime = 0;
		}
		System.out.println(elapsedTime);
	    //batch.draw(andarAnimation.getKeyFrame(elapsedTime, true), 0, 0);
	    spriteanda = (Sprite)westAnimation.getKeyFrame(elapsedTime);
	    batch.draw(spriteanda, (player.posX*40)-7, (player.posY*43.6f)-5, 0, 0, spriteanda.getWidth(), spriteanda.getHeight(),
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
		if(keycode == Keys.LEFT) {
			player.posX --;
		}
		else if(keycode == Keys.RIGHT) {
			player.posX ++;
		}
		else if(keycode == Keys.DOWN) {
			player.posY --;
		}
		else if(keycode == Keys.UP) {
			player.posY ++;
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
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
