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
import com.nilo.necroslayer.model.Mapper;
import com.nilo.necroslayer.model.Player;

public class TitleScreen extends ScreenAdapter {

    Necroslayer game;
    Sprite background;
    Texture texture;
    Viewport titleView;
    Level level;
    Mapper map1;
    public TitleScreen(Necroslayer game) {
        this.game = game;
        this.map1 = new Mapper(game);
    }

    @Override
    public void show(){
    	titleView = new FitViewport(this.game.GAME_WORLD_WIDTH, this.game.GAME_WORLD_HEIGHT, this.game.camera);
		titleView.apply();
    	texture = new Texture(Gdx.files.internal("titulo2.png"));
    	background = new Sprite(texture,1024,576);
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.SPACE) {
                	game.player = new Player();
                	game.getLevels().add(new Tutorial(36,11,"tutorial.tmx",game.player, game.blocos, game, 7, 6));
                	game.getLevels().get(0).mapa = map1.tutorial(game.getLevels().get(0).mapa);
                	game.getLevels().add(new Level(20,16,"mercado.tmx",game.player, game.blocos, game, 10, 0, false));
        			game.getLevels().get(1).mapa = map1.mercado(game.getLevels().get(1).mapa);
        			game.getLevels().add(new Level(10,8,"casa.tmx",game.player,game.blocos,game, 2, 0, false));
        			game.getLevels().get(2).mapa = map1.casa(game.getLevels().get(2).mapa);
        			game.getLevels().add(new Level(30,20,"floresta.tmx", game.player,game.blocos,game,0, 10, true));
        			game.getLevels().get(3).mapa = map1.floresta(game.getLevels().get(3).mapa);
        			game.player.setPos(game.getLevels().get(0));
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

