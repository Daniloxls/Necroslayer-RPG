package com.nilo.necroslayer.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.nilo.necroslayer.Necroslayer;
import com.nilo.necroslayer.enemy.Enemy;
import com.nilo.necroslayer.enemy.EnemyGroup;
import com.nilo.necroslayer.model.Bloco;
import com.nilo.necroslayer.model.Mapper;
import com.nilo.necroslayer.model.Player;

public class Tutorial extends Level implements InputProcessor{
	private boolean moveTutorial = true ;
	private boolean examineTutorial = true;
	private boolean interactTutorial = true;
	private boolean editTutorial = true;
	private boolean examineChest = false;
	private boolean leverPull = false;
	private boolean movedRight = false;
	private boolean movedLeft = false;
	private boolean movedUp = false;
	private boolean movedDown = false;
	private int[] foreground = {3};
	Mapper map1 = new Mapper();
	private ArrayList<String> texto = new ArrayList<String>();
	
	private int spikelayer[] = {4,5};
	private int spikelayer_2[] = {6,7};
	private int spikelayer_3[] = {8,9};
	private int portalayer[] = {10};
	public Tutorial(int width, int height, String mapname, Player player, Bloco[][] blocos, Necroslayer game,
			int playerX, int playerY) {
		super(width, height, mapname, player, blocos, game, playerX, playerY);
		texto.add("Seja bem vindo ao projeto de POO");
		texto.add("Nesse jogo você vai testar suas habilidades em Programação orientadada a objeto, junto com desafios e lutas contra monstros");
		texto.add("Para começar use as setas para se mover");
		this.game.dialogo.setDialogue(texto);
		
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
		mapa.renderItems(batch);
		batch.draw(spriteanda, player.posX, player.posY, 0, 0, 16, 20,
		    		4, 4, 0);
		
		
		tMR.render(foreground);
		
		
		
		time = String.format("%f",this.game.elapsedTime);
		cXY = String.format("%f , %f",player.getTileX(),player.getTileY());
		tXY = String.format("%d , %d",player.targetX, player.targetY);
		pXY = String.format("%f , %f",player.posX, player.posY);
		font.draw(batch, time, playcam.position.x - 512, playcam.position.y + 288);
		font.draw(batch, cXY, playcam.position.x - 512, playcam.position.y + 273);
		font.draw(batch, tXY, playcam.position.x - 512, playcam.position.y + 258);
		font.draw(batch, pXY, playcam.position.x - 512, playcam.position.y + 243);
		if(moveTutorial) {
			tMR.render(spikelayer);
		}
		if(!leverPull) {
			tMR.render(spikelayer_2);
		}
		if(!this.examineChest) {
			tMR.render(spikelayer_3);
		}
		if(!this.mapa.gridBlocos[32][8].isWalkable) {
			tMR.render(portalayer);
		}
		game.dialogo.render(playcam, batch);
		game.getCodeBlock().render(playcam, batch);
		this.checkProgess();
		batch.setProjectionMatrix(playcam.combined);
		batch.end();
	        
			
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
		if(keycode == Keys.F3) {

		}
		if(keycode == Keys.Z) {
			if(!game.getCodeBlock().isShowingCode()) {
				if(game.dialogo.getInDialogue()) {
					game.dialogo.nextDialogue();
				}
				else {
					game.dialogo.setDialogue(player.interact(mapa));
					if((player.targetX == 13) & (player.targetY == 7)) {
						leverPull = true;
					}
				}
			}
			
		}
		if(keycode == Keys.X) {
			if(game.getCodeBlock().isShowingCode()) {
				this.mapa.setBloco(player.getFacingBlock(mapa).getx(),player.getFacingBlock(mapa).gety(), game.getCodeBlock().changeBlock());
				game.getCodeBlock().setShowingCode(false);
			}
		}

		if(game.getCodeBlock().isShowingCode()) {
			if(keycode == Keys.DOWN) {
				game.getCodeBlock().downOption();
			}
			if(keycode == Keys.UP) {
				game.getCodeBlock().upOption();
			}
			if(keycode == Keys.LEFT) {
				game.getCodeBlock().leftOption();
			}
			if(keycode == Keys.RIGHT) {
				game.getCodeBlock().rightOption();
			}
		}
		if(!game.dialogo.getInDialogue()) {
			if(keycode == Keys.C) {
				game.getCodeBlock().setCode(player.depurar(mapa), player.getFacingBlock(mapa));
				if((player.getFacingBlock(mapa).getx() == 21) & (player.getFacingBlock(mapa).gety() == 7)) {
					this.examineChest = true;
				}
				
				
			}
			if(!game.getCodeBlock().isShowingCode()) {
				if(keycode == Keys.LEFT) {
					player.isMovingLeft = true;
					this.movedLeft = true;
				}
				if(keycode == Keys.RIGHT) {
					player.isMovingRight = true;
					this.movedRight = true;
				}
				if(keycode == Keys.DOWN) {
					player.isMovingDown = true;
					this.movedDown = true;
				}
				if(keycode == Keys.UP) {
					player.isMovingUp = true;
					this.movedUp = true;
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
	
	public void checkProgess() {
		if((this.movedDown)& (this.movedLeft)& (this.movedRight) & (this.movedUp) & (this.moveTutorial)) {
			this.moveTutorial = false;
			for(int i = 6; i < 9; i++) {
				this.mapa.gridBlocos[i][4].isWalkable = true;
			}
			for(int i = 5; i < 8; i++) {
				this.mapa.gridBlocos[5][i].isWalkable = true;
				this.mapa.gridBlocos[9][i].isWalkable = true;
			}
			texto = new ArrayList<String>();
			texto.add("Muito bem, agora siga em frente para o proximo passo");
			texto.add("Cuidado com os espinhos ;)");
			this.game.dialogo.setDialogue(texto);
		}
		if((this.player.targetX == 11) & (this.interactTutorial)) {
			texto = new ArrayList<String>();
			texto.add("Você pode utilizar objetos no mundo apertando a tecla Z, tente com esta alavanca.");
			this.game.dialogo.setDialogue(texto);
			this.interactTutorial = false;
		}
		if((this.player.getTileX() == 18) & (this.examineTutorial)) {
			texto = new ArrayList<String>();
			texto.add("Você pode observar o codigo contido em um objeto quando olha para ele e aperta C");
			texto.add("Tente isso com o bau a seguir, não se esqueça que para sair do menu de  detalhes basta apertar X");
			this.game.dialogo.setDialogue(texto);
			this.examineTutorial = false;
		}
		if((this.player.getTileX() == 29) & (this.editTutorial)) {
			texto = new ArrayList<String>();
			texto.add("Alguns blocos possuem variaveis publicas, isso significa que você pode  edita-las");
			texto.add("Tente editar a propiedade trancada dessa porta para que ela seja falsa");
			this.game.dialogo.setDialogue(texto);
			this.editTutorial = false;
		}
		if(this.leverPull) {
			for(int i = 0; i< 8; i++) {
				this.mapa.gridBlocos[15][i].isWalkable = true;
				this.mapa.gridBlocos[16][i].isWalkable = true;
			}
		}
		if(this.examineChest) {
			for(int i = 0; i< 8; i++) {
				this.mapa.gridBlocos[25][i].isWalkable = true;
				this.mapa.gridBlocos[26][i].isWalkable = true;
			}
		}
		if((player.targetX == 32) & (player.targetY == 9)) {
			game.getLevels().add(new Level(20,16,"mercado.tmx",game.player, game.blocos, game, 10, 0));
			game.getLevels().get(1).mapa = map1.mercado(game.getLevels().get(1).mapa);
			game.setScreen(game.getLevels().get(1));
		}
	}


}
