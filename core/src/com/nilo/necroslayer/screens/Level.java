package com.nilo.necroslayer.screens;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

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
import com.nilo.necroslayer.enemy.EnemyGroup;
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
	Random random = new Random();
	public Animation<Sprite> walkAnimation, testAnimation;
	public OrthogonalTiledMapRenderer tMR;
	public TiledMap tiledMap;
	public Texture texture;
	public Sprite sprite;
	public TextureAtlas textureAtlas;
	public SpriteBatch batch;
	public BitmapFont font;
	private boolean wild;
	private int playerX, playerY;
	public final int GAME_WORLD_HEIGHT = 576;
	public final int GAME_WORLD_WIDTH = 1024;
	public String time, cXY, tXY, pXY;
	int[] backgroundLayers = {0,1,2};
	int[] foregroundLayers = {3,4};
	public Level(Necroslayer game) {
		this.game = game;
	}
	public Level(int width, int height, String mapname, Player player, Bloco[][] blocos, Necroslayer game, int playerX, int playerY, boolean wild){
		mapa = new MapaBlocos(width,height);
		this.game = game;
		tiledMap = new TmxMapLoader().load(mapname);
		tMR = new OrthogonalTiledMapRenderer(tiledMap, 4);
		this.player = player;
		this.setPlayerX(playerX);
		this.setPlayerY(playerY);
		this.wild = wild;
		playcam = new PlayerCamera(player, mapa);
		playcam.update();
		viewport = new FitViewport(GAME_WORLD_WIDTH, GAME_WORLD_HEIGHT, playcam);
		viewport.apply();

	}
	@Override
	public void show() {
		font = new BitmapFont();
		batch = new SpriteBatch();
		Gdx.input.setInputProcessor(this);
		walkAnimation = player.currentAnimation;
		playcam = new PlayerCamera(player, mapa);
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
		tMR.render(backgroundLayers);
		
		batch.begin();
		if(player.isWalking) {
			this.game.elapsedTime += 0.020f;
		}
		player.walk(mapa);
		if(this.game.elapsedTime > 0.4f) {
			this.game.elapsedTime = 0.0f;
		}
		
		playcam.update();
		playcam.follow(player, mapa);
		spriteanda = (Sprite)player.currentAnimation.getKeyFrame(this.game.elapsedTime);
		batch.draw(spriteanda, player.posX, player.posY, 0, 0, 16, 20,
		    		4, 4, 0);
		mapa.renderItems(batch);
		time = String.format("%f",this.game.elapsedTime);
		cXY = String.format("%f , %f",player.getTileX(),player.getTileY());
		tXY = String.format("%d , %d",player.targetX, player.targetY);
		pXY = String.format("%f , %f",player.posX, player.posY);
		this.logica();
		font.draw(batch, time, playcam.position.x - 512, playcam.position.y + 288);
		font.draw(batch, cXY, playcam.position.x - 512, playcam.position.y + 273);
		font.draw(batch, tXY, playcam.position.x - 512, playcam.position.y + 258);
		font.draw(batch, pXY, playcam.position.x - 512, playcam.position.y + 243);
		tMR.render(foregroundLayers);
		game.dialogo.render(playcam, batch);
		game.getCodeBlock().render(playcam, batch);
		batch.setProjectionMatrix(playcam.combined);
		batch.end();
	        
			
		}
	public void dispose () {
		batch.dispose();
		textureAtlas.dispose();
		Gdx.input.setInputProcessor(null);
		
	}
	public void logica () {
		if(this.mapa.gridBlocos[player.targetX][player.targetY].checkPlayer(player.targetX, player.targetY)) {
			int posX = player.targetX;
			int posY = player.targetY;
			this.player.setPos(this.mapa.gridBlocos[player.targetX][player.targetY].getDestinyX(),this.mapa.gridBlocos[player.targetX][player.targetY].getDestinyY());
			this.game.setScreen(this.game.getLevels().get(this.mapa.gridBlocos[posX][posY].getDestiny()));
		}
		if((this.player.isWalking) && (this.wild)) {
			if(random.nextInt(1000) == 0) {
				player.isMovingLeft = false;
				player.isMovingRight = false;
				player.isMovingDown = false;
				player.isMovingUp = false;
				Gdx.input.setInputProcessor(null);
				switch(random.nextInt(4)) {
				case(0):
					this.game.setScreen(new Batalha(this.game, this.player.party, this, new EnemyGroup(new Enemy())));
					break;
				
				case(1):
					this.game.setScreen(new Batalha(this.game, this.player.party, this, new EnemyGroup(new Enemy(),new Enemy())));
					break;
				
				case(2):
					this.game.setScreen(new Batalha(this.game, this.player.party, this, new EnemyGroup(new Enemy(),new Enemy(),new Enemy())));
					break;
				
				case(3):
					this.game.setScreen(new Batalha(this.game, this.player.party, this, new EnemyGroup(new Enemy(),new Enemy(),new Enemy(),new Enemy())));
					break;
				
				}
			}
		}
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
			this.game.setScreen(new Batalha(this.game, this.player.party, this, new EnemyGroup(new Enemy(),new Enemy(),new Enemy())));
		}
		if(keycode == Keys.SPACE) {
			System.out.printf("this.mapa.gridBlocos[%d][%d].setCenario(\"\");\n", this.player.targetX, this.player.targetY);
		}
		if(keycode == Keys.A) {
			System.out.printf("this.mapa.gridBlocos[%d][%d].isWalkable = false;\n", this.player.targetX, this.player.targetY);
		}
		if(keycode == Keys.Z) {
			if(!game.getCodeBlock().isShowingCode()) {
				if(game.dialogo.getInDialogue()) {
					game.dialogo.nextDialogue();
				}
				else {
					game.dialogo.setDialogue(player.interact(mapa));
				}
			}
			
		}
		if(keycode == Keys.X) {
			if(game.getCodeBlock().isShowingCode()) {
				this.mapa.setBloco(player.getFacingBlock(mapa).getx(),player.getFacingBlock(mapa).gety(), game.getCodeBlock().changeBlock());
				game.getCodeBlock().setShowingCode(false);
			}
		}

		if(!game.dialogo.getInDialogue()) {
			if(keycode == Keys.C) {
				game.getCodeBlock().setCode(player.depurar(mapa), player.getFacingBlock(mapa));
				if(keycode == Keys.DOWN) {
					game.getCodeBlock().downOption();
				}
			}
			if(!game.getCodeBlock().isShowingCode()) {
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
	public int getPlayerX() {
		return playerX;
	}
	public void setPlayerX(int playerX) {
		this.playerX = playerX;
	}
	public int getPlayerY() {
		return playerY;
	}
	public void setPlayerY(int playerY) {
		this.playerY = playerY;
	}
	}