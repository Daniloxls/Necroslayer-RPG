package com.nilo.necroslayer;

import java.awt.RenderingHints.Key;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
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
public class Necroslayer extends ApplicationAdapter {
	
	OrthogonalTiledMapRenderer tMR;
	TiledMap tiledMap;
	SpriteBatch batch;
	Texture texture;
	Sprite sprite;
	TextureAtlas textureAtlas;
	Animation<TextureRegion> animation, andarAnimation;
	private float elapsedTime = 0;
	float unitScale = 1 / 16f;
	FitViewport viewport;
	Player player;
	Vector2 posInit = new Vector2(50,50); 
	@Override
	public void create () {
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas(Gdx.files.internal("bartz.atlas"));
        animation = new Animation<TextureRegion>(1f, textureAtlas.getRegions());
		tiledMap = new TmxMapLoader().load("mapa_1.tmx");
		tMR = new OrthogonalTiledMapRenderer(tiledMap);
		andarAnimation = new Animation<TextureRegion>(0.2f,
	            (textureAtlas.findRegion("000")),
	            (textureAtlas.findRegion("001")));

	  
		OrthographicCamera camera= new OrthographicCamera();
		camera.setToOrtho(false, 256, 176);
		camera.update();
		viewport = new FitViewport(256, 176, camera);
		player = new Player(posInit);
		
	}

	@Override
	public void render () {
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		viewport.update(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		tMR.setView((OrthographicCamera)viewport.getCamera());
		tMR.render();
		batch.begin();
		elapsedTime += Gdx.graphics.getDeltaTime();
	    batch.draw(andarAnimation.getKeyFrame(elapsedTime, true), 0, 0);
        batch.end();
        
		
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		textureAtlas.dispose();
		
	}
}
