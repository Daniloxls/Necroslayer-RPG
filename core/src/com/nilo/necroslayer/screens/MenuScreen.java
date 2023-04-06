package com.nilo.necroslayer.screens;

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
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nilo.necroslayer.Necroslayer;
import com.nilo.necroslayer.inventory.Item;
import com.nilo.necroslayer.model.Menu;
import com.nilo.necroslayer.model.MenuTab;
import com.nilo.necroslayer.model.Player;

public class MenuScreen extends ScreenAdapter implements InputProcessor{
    Sprite background;
    Texture texture;
    Player player;
    private SpriteBatch batch;
    private OrthographicCamera camera;
	private FitViewport menuView;
    Necroslayer game;
    ScreenAdapter lastScreen;
    Texture handTexture;
    Sprite maozinha;
    Menu menu;
    public BitmapFont font;
    boolean showInfos;
    public enum Infos {
		  PARTY, BACKPACK, OPTIONS, SKILLS, MAP
		 }
    public MenuScreen(Necroslayer game, Player player, ScreenAdapter lastScreen){
        this.player = player;
        this.game = game;
        this.lastScreen = lastScreen;
        this.menu = new Menu();
        this.showInfos = false;
    }
    
    @Override
    public void show() {
    	font = new BitmapFont();
        font.getData().setScale(1.5f);
		texture = new Texture(Gdx.files.internal("menu.png"));
		background = new Sprite(texture,256,144);
		handTexture = new Texture(Gdx.files.internal("maozinha.png"));
		maozinha = new Sprite(handTexture, 16, 16);
		//background.setScale(4);
		camera = new OrthographicCamera();
		camera.position.set(this.game.GAME_WORLD_WIDTH/2, this.game.GAME_WORLD_HEIGHT/2, 0);
		camera.update();
		batch = new SpriteBatch();
		menuView = new FitViewport(this.game.GAME_WORLD_WIDTH, this.game.GAME_WORLD_HEIGHT, camera);
		menuView.apply();
		Gdx.input.setInputProcessor(this);
		
    }
    @Override
	public void resize (int width, int height) {
		menuView.update(width, height);
		camera.position.set(this.game.GAME_WORLD_WIDTH/2, this.game.GAME_WORLD_HEIGHT/2, 0);
	}
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        batch.begin();
        batch.setProjectionMatrix(camera.combined);
        //batch.draw(background, camera.position.x - background.getWidth()/2,camera.position.y - background.getHeight()/2);
        batch.draw(background, 0,  0, 0, 0, 256, 144, 4, 4, 0);
        for(int i = 0; i < menu.getMenus().size(); i++) {
        	font.draw(batch, menu.getMenus().get(i).getName(), this.game.GAME_WORLD_WIDTH * 0.7f + 125, (this.game.GAME_WORLD_HEIGHT - 50) - (i * 70));
        	if(menu.getMenus().get(i).isSelected()) {
        		batch.draw(maozinha, this.game.GAME_WORLD_WIDTH * 0.7f + 75f, (this.game.GAME_WORLD_HEIGHT - 80f) - (i * 70f), 0, 0, 16, 16, 3, 3, 0);
        	}
        }
        switch(menu.getSelectedMenu().getTipo()) {
        case PARTY:
        	break;
        case BACKPACK:
        	font.draw(batch, menu.getSelectedMenu().getName().toUpperCase(), 50, this.game.GAME_WORLD_HEIGHT - 50);
        	for(int i = 0; i < this.player.mochila.getItems().size(); i++) {
        		font.draw(batch, this.player.mochila.getItems().get(i).getName(), 50, this.game.GAME_WORLD_HEIGHT - (100 + 20 * i));
        		font.draw(batch, this.player.mochila.getItems().get(i).getDesc(), 50, this.game.GAME_WORLD_HEIGHT - (130 + 20 * i));
        	}
        }        
        batch.end();
    }
	public void dispose () {
		batch.dispose();
		
	}
    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.BACKSPACE) {
			this.game.setScreen(lastScreen);
		}
		if(keycode == Keys.UP) {
			menu.menuUp();
		}
		if(keycode == Keys.DOWN) {
			menu.menuDown();
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