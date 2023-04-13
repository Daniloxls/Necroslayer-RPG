package com.nilo.necroslayer.screens;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nilo.necroslayer.Necroslayer;
import com.nilo.necroslayer.inventory.Armor;
import com.nilo.necroslayer.enemy.Enemy;
import com.nilo.necroslayer.inventory.Weapon;
import com.nilo.necroslayer.model.Bau;
import com.nilo.necroslayer.model.Bloco;
import com.nilo.necroslayer.model.MapaBlocos;
import com.nilo.necroslayer.model.Player;

public class Level extends ScreenAdapter implements InputProcessor{
	Necroslayer game;
	MapaBlocos mapa;
	PlayerCamera playcam;
	Viewport viewport;
	Player player;
	Sprite spriteanda;
	public Animation<Sprite> walkAnimation, testAnimation;
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
	public Level(Necroslayer game) {
		this.game = game;
	}
	public Level(int width, int height, String mapname, Player player, Bloco[][] blocos, Necroslayer game){
		mapa = new MapaBlocos(width,height);
		this.game = game;
		tiledMap = new TmxMapLoader().load(mapname);
		tMR = new OrthogonalTiledMapRenderer(tiledMap, 4);
		this.player = player;
		playcam = new PlayerCamera(player, mapa);
		playcam.update();
		viewport = new FitViewport(GAME_WORLD_WIDTH, GAME_WORLD_HEIGHT, playcam);
		viewport.apply();
<<<<<<< HEAD
		mapa.gridBlocos[1][1].setItem(new Bau(new Weapon(6, 8)));
=======
		mapa.gridBlocos[5][3].getItem().hasDialogue = true;
		mapa.gridBlocos[5][3].getItem().interactable = true;
		mapa.gridBlocos[5][3].getItem().setItem(new Armor("Armadura PICA", "Uma armadura mt pica mt pica msm"));
		ArrayList<String> texto = new ArrayList<String>();
		texto.add("A");
		texto.add("B");
		texto.add("ASDUAHSUD");
		mapa.gridBlocos[5][3].getItem().dialogue = texto;
		mapa.gridBlocos[5][3].isWalkable = false;
>>>>>>> 503b91cd6b8eb64227702f921b9864f2a4f04991
	}
	@Override
	public void show() {
		font = new BitmapFont();
		batch = new SpriteBatch();
		Gdx.input.setInputProcessor(this);
		walkAnimation = player.currentAnimation;
		playcam.update();
		viewport = new FitViewport(GAME_WORLD_WIDTH, GAME_WORLD_HEIGHT, playcam);
		viewport.apply();
	}
	
	@Override
	public void resize (int width, int height) {
		viewport.update(width, height);
	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		tMR.setView((OrthographicCamera)viewport.getCamera());
		tMR.render();
		
		batch.begin();
		if(player.isWalking) {
			this.game.elapsedTime += 0.025f;
		}
		player.walk(mapa);
		if(this.game.elapsedTime > 0.4f) {
			this.game.elapsedTime = 0.0f;
		}
		
		playcam.update();
		playcam.follow(player, mapa);
		spriteanda = (Sprite)player.currentAnimation.getKeyFrame(this.game.elapsedTime);
		batch.draw(spriteanda, player.posX, player.posY, 0, 0, 16, 16,
		    		4, 4, 0);
		mapa.renderItems(batch);
		game.dialogo.render(playcam, batch);
		
		time = String.format("%f",this.game.elapsedTime);
		cXY = String.format("%f , %f",player.getTileX(),player.getTileY());
		tXY = String.format("%d , %d",player.targetX, player.targetY);
		pXY = String.format("%f , %f",player.posX, player.posY);
		font.draw(batch, time, playcam.position.x - 512, playcam.position.y + 288);
		font.draw(batch, cXY, playcam.position.x - 512, playcam.position.y + 273);
		font.draw(batch, tXY, playcam.position.x - 512, playcam.position.y + 258);
		font.draw(batch, pXY, playcam.position.x - 512, playcam.position.y + 243);
		batch.setProjectionMatrix(playcam.combined);
		batch.end();
	        
			
		}
	public void dispose () {
		batch.dispose();
		textureAtlas.dispose();
		Gdx.input.setInputProcessor(null);
		
	}
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.F1) {
			player.isMovingLeft = false;
			player.isMovingRight = false;
			player.isMovingDown = false;
			player.isMovingUp = false;
			this.game.setScreen(new MenuScreen(this.game, this.player, this));
		}
		if(keycode == Keys.F2) {
			player.isMovingLeft = false;
			player.isMovingRight = false;
			player.isMovingDown = false;
			player.isMovingUp = false;
			Gdx.input.setInputProcessor(null);
			this.game.setScreen(new Batalha(this.game, this.player.party, this, new Enemy()));
		}
		if(keycode == Keys.Z) {
			if(game.dialogo.getInDialogue()) {
				game.dialogo.nextDialogue();
			}
			else {
				game.dialogo.setDialogue(player.interact(mapa));
			}
			
		}
		if(!game.dialogo.getInDialogue()) {
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