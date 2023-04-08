package com.nilo.necroslayer.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nilo.necroslayer.Necroslayer;

public class TitleScreen extends ScreenAdapter {

    Necroslayer game;
    Sprite background;
    Texture texture;
    Viewport titleView;
    Level level;
    public TitleScreen(Necroslayer game) {
        this.game = game;
    }

    @Override
    public void show(){
    	titleView = new FitViewport(this.game.GAME_WORLD_WIDTH, this.game.GAME_WORLD_HEIGHT, this.game.camera);
		titleView.apply();
    	texture = new Texture(Gdx.files.internal("titulo.png"));
    	background = new Sprite(texture,1024,576);
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.SPACE) {
                    game.setScreen(game.level_1);
                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.game.camera.update();
        game.batch.begin();
        this.game.batch.setProjectionMatrix(this.game.camera.combined);
        background.draw(game.batch);
        //game.font.draw(game.batch, "Rise of the NecroSlayers!", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .75f);
        //game.font.draw(game.batch, "Press space to play.", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .25f);
        game.batch.end();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
    @Override
    public void dispose () {
		game.batch.dispose();
		
	}
}

