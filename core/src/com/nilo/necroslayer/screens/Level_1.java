package com.nilo.necroslayer.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nilo.necroslayer.Necroslayer;
import com.nilo.necroslayer.model.MapaBlocos;
import com.nilo.necroslayer.model.Player;

public class Level_1 extends ScreenAdapter implements InputProcessor{
	Necroslayer game;
	MapaBlocos level_1;
	PlayerCamera playcam;
	Viewport viewport;
	Player player;
	Sprite spriteanda;
	public Animation<Sprite> walkAnimation;
	public OrthogonalTiledMapRenderer tMR;
	public TiledMap tiledMap;
	public Texture texture;
	public Sprite sprite;
	public TextureAtlas textureAtlas;
	public SpriteBatch batch;
	public BitmapFont font;
	public final int GAME_WORLD_HEIGHT = 576;
	public final int GAME_WORLD_WIDTH = 1024;
	public String time, cXY, tXY, pXY;
	public Level_1(Necroslayer game) {
		this.game = game;
	}
	@Override
	public void show() {
		font  = new BitmapFont();
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas(Gdx.files.internal("bartz.atlas"));
		tiledMap = new TmxMapLoader().load("mapa_4.tmx");
		tMR = new OrthogonalTiledMapRenderer(tiledMap, 4);
		Gdx.input.setInputProcessor(this);
		
		level_1 = new MapaBlocos(20,16);
		level_1.gridBlocos[5][10].isWalkable = false;
		level_1.gridBlocos[5][11].isWalkable = false;
		level_1.gridBlocos[5][12].isWalkable = false;
		level_1.gridBlocos[6][10].isWalkable = false;
		level_1.gridBlocos[6][11].isWalkable = false;
		level_1.gridBlocos[6][12].isWalkable = false;
		level_1.gridBlocos[7][10].isWalkable = false;
		level_1.gridBlocos[7][11].isWalkable = false;
		level_1.gridBlocos[7][12].isWalkable = false;
		player = new Player(0, 0);
		playcam = new PlayerCamera(player, level_1);
		walkAnimation = player.currentAnimation;
		playcam.update();
		viewport = new FitViewport(GAME_WORLD_WIDTH, GAME_WORLD_HEIGHT, playcam);
		viewport.apply();
	}
	
	@Override
	public void resize (int width, int height) {
		viewport.update(width, height);
		playcam.position.set(GAME_WORLD_WIDTH/2, GAME_WORLD_HEIGHT/2, 0);
	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		tMR.setView((OrthographicCamera)viewport.getCamera());
		tMR.render();
		
		batch.begin();
		if(player.isWalking) {
			this.game.elapsedTime += 0.08;
		}
		player.walk(level_1);
		if(this.game.elapsedTime > 1) {
			this.game.elapsedTime = 0;
		}
		playcam.update();
		playcam.follow(player, level_1);
		spriteanda = (Sprite)player.currentAnimation.getKeyFrame(this.game.elapsedTime);
		batch.draw(spriteanda, player.posX, player.posY, 0, 0, 16, 16,
		    		4, 4, 0);
		time = String.format("%f",this.game.elapsedTime);
		cXY = String.format("%f , %f",player.getTileX(),player.getTileY());
		tXY = String.format("%d , %d",player.targetX, player.targetY);
		pXY = String.format("%f , %f",player.posX, player.posY);
		font.draw(batch, time, 0, 500);
		font.draw(batch, cXY, 0, 485);
		font.draw(batch, tXY, 0, 470);
		font.draw(batch, pXY, 0, 455);
		batch.setProjectionMatrix(playcam.combined);
		batch.end();
	        
			
		}
	public void dispose () {
		batch.dispose();
		textureAtlas.dispose();
		
	}
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.F1) {
			System.out.println(player.isMovingRight);
		}
		if(keycode == Keys.LEFT) {
			player.isMovingLeft = true;
		}
		if(keycode == Keys.RIGHT) {
			player.isMovingRight = true;
		}
		if(keycode == Keys.DOWN) {
			player.isMovingDown = true;
		}
		if(keycode == Keys.UP) {
			player.isMovingUp = true;
		}
		return true;
	}
	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Keys.LEFT) {
			player.isMovingLeft = false;
	}
		if(keycode == Keys.RIGHT) {
			player.isMovingRight = false;
	}
		if(keycode == Keys.UP) {
			player.isMovingUp = false;
	}
		if(keycode == Keys.DOWN) {
			player.isMovingDown = false;
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
