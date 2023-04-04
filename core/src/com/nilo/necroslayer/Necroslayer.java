package com.nilo.necroslayer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.nilo.necroslayer.model.Player;
import com.nilo.necroslayer.screens.TitleScreen;
public class Necroslayer extends Game implements ApplicationListener{
	public OrthogonalTiledMapRenderer tMR;
	public TiledMap tiledMap;
	public SpriteBatch batch;
	public Texture texture;
	public Sprite sprite;
	public TextureAtlas textureAtlas;
	public Animation<Sprite> animation, southAnimation, northAnimation ,eastAnimation ,westAnimation;
	public Animation<Sprite> walkAnimation;
	public float elapsedTime = 0;
	float unitScale = 1 / 16f;
	public final int GAME_WORLD_HEIGHT = 576;
	public final int GAME_WORLD_WIDTH = 1024;
	public FitViewport viewport;
	public Player player;
	
	
    public OrthographicCamera camera;
	// Debug Info
    
	int initX = 8, initY = 4;
	@Override
	public void create () {
		
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas(Gdx.files.internal("bartz.atlas"));
		tiledMap = new TmxMapLoader().load("mapa_4.tmx");
		tMR = new OrthogonalTiledMapRenderer(tiledMap, 4);
		camera = new OrthographicCamera();
		camera.update();
		viewport = new FitViewport(GAME_WORLD_WIDTH, GAME_WORLD_HEIGHT, camera);
		viewport.apply();
		setScreen(new TitleScreen(this));
	}
	@Override
	public void resize (int width, int height) {
		viewport.update(width, height);
		camera.position.set(GAME_WORLD_WIDTH/2, GAME_WORLD_HEIGHT/2, 0);
	}
	@Override
	public void dispose () {
		batch.dispose();
		textureAtlas.dispose();
		
	}
}
