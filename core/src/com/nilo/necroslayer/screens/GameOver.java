package com.nilo.necroslayer.screens;

import com.badlogic.gdx.Screen;

import java.util.ArrayList;

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
import com.nilo.necroslayer.model.Mapper;
import com.nilo.necroslayer.model.Player;

public class GameOver extends ScreenAdapter {

    Necroslayer game;
    Sprite background;
    Texture texture;
    Viewport titleView;
    ScreenAdapter lastScreen;
    Level level;
    Mapper map1 = new Mapper();
    public GameOver(Necroslayer game, ScreenAdapter lastScreen) {
        this.game = game;
        this.lastScreen = lastScreen;
    }

    @Override
    public void show(){
    	titleView = new FitViewport(this.game.GAME_WORLD_WIDTH, this.game.GAME_WORLD_HEIGHT, this.game.camera);
		titleView.apply();
    	texture = new Texture(Gdx.files.internal("gameOver.png"));
    	background = new Sprite(texture,1024,576);
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.SPACE) {
                	game.player = new Player();
                	game.setLevels(new ArrayList<Level>());
                	game.getLevels().add(new Level(23,20,"castelo_1.tmx",game.player, game.blocos, game, 11, 16));
                	game.getLevels().get(0).mapa = map1.mapa_1(game.getLevels().get(0).mapa);
                	game.setScreen(game.getLevels().get(0));
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

