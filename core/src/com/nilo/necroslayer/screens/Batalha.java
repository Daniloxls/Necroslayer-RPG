package com.nilo.necroslayer.screens;

import com.badlogic.gdx.Gdx;
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
import com.nilo.necroslayer.Necroslayer;
import com.nilo.necroslayer.character.Party;
import com.nilo.necroslayer.model.Menu;
import com.nilo.necroslayer.model.Player;

public class Batalha extends ScreenAdapter implements InputProcessor{
	Sprite background;
    Texture texture;
    Party party;
    private SpriteBatch batch;
    private OrthographicCamera camera;
	private FitViewport battleView;
    Necroslayer game;
    ScreenAdapter lastScreen;
    Texture handTexture;
    Sprite maozinha;
    public BitmapFont font;
    
    public Batalha(Necroslayer game, Party party, ScreenAdapter lastScreen) {
        this.party = party;
        this.game = game;
        this.lastScreen = lastScreen;
    }
    @Override
    public void show() {
    	font = new BitmapFont();
        font.getData().setScale(1.5f);
		texture = new Texture(Gdx.files.internal("background_batalha.png"));
		background = new Sprite(texture,256,144);
		handTexture = new Texture(Gdx.files.internal("maozinha.png"));
		maozinha = new Sprite(handTexture, 16, 16);
		camera = new OrthographicCamera();
		camera.position.set(this.game.GAME_WORLD_WIDTH/2, this.game.GAME_WORLD_HEIGHT/2, 0);
		camera.update();
		batch = new SpriteBatch();
		battleView = new FitViewport(this.game.GAME_WORLD_WIDTH, this.game.GAME_WORLD_HEIGHT, camera);
		battleView.apply();
		Gdx.input.setInputProcessor(this);
		
    }
    @Override
	public void resize (int width, int height) {
		battleView.update(width, height);
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
        batch.end();
    }
    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.F2) {
			this.game.setScreen(lastScreen);
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
