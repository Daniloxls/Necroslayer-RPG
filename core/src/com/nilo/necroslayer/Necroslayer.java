package com.nilo.necroslayer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.maps.tiled.renderers.BatchTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.graphics.GL20;
public class Necroslayer extends ApplicationAdapter {
	
	OrthogonalTiledMapRenderer tMR;
	TiledMap tiledMap;
	
	float unitScale = 1 / 16f;
	FitViewport viewport;
	@Override
	public void create () {
		tiledMap = new TmxMapLoader().load("mapa_1.tmx");
		tMR = new OrthogonalTiledMapRenderer(tiledMap);
		OrthographicCamera camera= new OrthographicCamera();
		camera.setToOrtho(false, 256, 176);
		camera.update();
		viewport = new FitViewport(256, 176, camera);
		
	}

	@Override
	public void render () {
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		viewport.update(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		tMR.setView((OrthographicCamera)viewport.getCamera());
		tMR.render();
	}
	
	@Override
	public void dispose () {
		
	}
}
