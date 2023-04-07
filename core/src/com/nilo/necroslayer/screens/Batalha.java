package com.nilo.necroslayer.screens;

import com.badlogic.gdx.Gdx;
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
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.nilo.necroslayer.Necroslayer;
import com.nilo.necroslayer.character.Party;
import com.nilo.necroslayer.enemy.Enemy;
import com.nilo.necroslayer.model.Menu;
import com.nilo.necroslayer.model.Player;

public class Batalha extends ScreenAdapter implements InputProcessor{
	Sprite background, spriteBox_1, spriteBox_2;
    Texture texture, handTexture, box_1, box_2;
    Party party;
    private SpriteBatch batch;
    public BitmapFont font  = new BitmapFont(Gdx.files.internal("finalfont.fnt"), Gdx.files.internal("finalfont.png") , false, true);
    private OrthographicCamera camera;
	private FitViewport battleView;
    Necroslayer game;
    ScreenAdapter lastScreen;
    Sprite maozinha;
    Enemy enemy;
    Animation<Sprite> bartzAnimation,lennaAnimation,galufAnimation,farisAnimation;
    Sprite bartzCurrentSprite,lennaCurrentSprite,galufCurrentSprite,farisCurrentSprite;
    boolean bartzChoosing,lennaChoosing,galufChoosing,farisChoosing;
    int choiceIndex;
    public Batalha(Necroslayer game, Party party, ScreenAdapter lastScreen, Enemy enemy) {
        this.party = party;
        this.enemy = enemy;
        this.game = game;
        this.lastScreen = lastScreen;
    }
    @Override
    public void show() {
		texture = new Texture(Gdx.files.internal("background_batalha.png"));
		background = new Sprite(texture,256,144);
		handTexture = new Texture(Gdx.files.internal("maozinha.png"));
		maozinha = new Sprite(handTexture, 16, 16);
		box_1 = new Texture(Gdx.files.internal("battlebox_1.png"));
		spriteBox_1 = new Sprite(box_1, 256, 64);
		box_2 = new Texture(Gdx.files.internal("battlebox_2.png"));
		spriteBox_2 = new Sprite(box_2, 80, 64);
		camera = new OrthographicCamera();
		bartzAnimation = this.party.bartz.getAnimation();
		lennaAnimation = this.party.lenna.getAnimation();
		galufAnimation = this.party.galuf.getAnimation();
		farisAnimation = this.party.faris.getAnimation();
		camera.position.set(this.game.GAME_WORLD_WIDTH/2, this.game.GAME_WORLD_HEIGHT/2, 0);
		camera.update();
		batch = new SpriteBatch();
		battleView = new FitViewport(this.game.GAME_WORLD_WIDTH, this.game.GAME_WORLD_HEIGHT, camera);
		battleView.apply();
		bartzChoosing = true;
		lennaChoosing = true;
		galufChoosing = true;
		farisChoosing = true;
		this.choiceIndex = 0;
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
        bartzCurrentSprite = (Sprite)bartzAnimation.getKeyFrame(this.game.elapsedTime);
        lennaCurrentSprite = (Sprite)lennaAnimation.getKeyFrame(this.game.elapsedTime);
        galufCurrentSprite = (Sprite)galufAnimation.getKeyFrame(this.game.elapsedTime);
        farisCurrentSprite = (Sprite)farisAnimation.getKeyFrame(this.game.elapsedTime);
        batch.setProjectionMatrix(camera.combined);
        //batch.draw(background, camera.position.x - background.getWidth()/2,camera.position.y - background.getHeight()/2);
        batch.draw(background, 0,  0, 0, 0, 256, 144, 4, 4, 0);
        batch.draw(bartzCurrentSprite, 768, 364, 0, 0, 30, 30,
	    		3, 3, 0);
        batch.draw(lennaCurrentSprite, 768, 284, 0, 0, 30, 30,
	    		3, 3, 0);
        batch.draw(galufCurrentSprite, 768, 204, 0, 0, 30, 30,
	    		3, 3, 0);
        batch.draw(farisCurrentSprite, 768, 124, 0, 0, 30, 30,
	    		3, 3, 0);
        batch.draw(enemy.sprite, 256, 238, 0, 0, 44, 49, 3, 3, 0);
        batch.draw(spriteBox_1, 0, 0, 0, 0, 256,64,
	    		4, 2, 0);
        font.draw(batch,enemy.name, 32, 112);
        font.draw(batch,"Bartz" , 786, 112);
        font.draw(batch,String.valueOf(party.bartz.getHp()) + "/" + String.valueOf(party.bartz.getMaxHp()) , 866, 112);
        font.draw(batch,"Lenna" , 786, 88);
        font.draw(batch,String.valueOf(party.lenna.getHp()) + "/" + String.valueOf(party.lenna.getMaxHp()) , 866, 88);
        font.draw(batch,"Galuf" , 786, 64);
        font.draw(batch,String.valueOf(party.galuf.getHp()) + "/" + String.valueOf(party.galuf.getMaxHp()) , 866, 64);
        font.draw(batch,"Faris" , 786, 40);
        font.draw(batch,String.valueOf(party.faris.getHp()) + "/" + String.valueOf(party.faris.getMaxHp()) , 866, 40);
        this.logica();
        batch.end();
    }
    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
    public void dispose () {
		batch.dispose();
		
	}
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.F2) {
			this.game.setScreen(lastScreen);
		}
		if(keycode == Keys.DOWN) {
			if(this.choiceIndex == 2) {
				this.choiceIndex = 0;
			}else {
				this.choiceIndex ++;
			}
		}
		if(keycode == Keys.UP) {
			if(this.choiceIndex == 0) {
				this.choiceIndex = 1;
			}
			else {
				this.choiceIndex --;
			}
		}
		if(keycode == Keys.Z) {
			if(bartzChoosing) {
				bartzChoosing = false;
			}else if(lennaChoosing) {
				lennaChoosing = false;
			}else if(galufChoosing) {
				galufChoosing = false;
			}else if(farisChoosing) {
				farisChoosing = false;
			} 
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
	public void logica() {
		if(bartzChoosing) {
			batch.draw(spriteBox_2, 320, 0, 0, 0, 80,64,
		    		4, 2, 0);
			this.party.bartz.showOptions(batch, font);
			batch.draw(maozinha, 306, 70-(this.choiceIndex*24), 0, 0, 16, 16,
		    		3, 3, 0);
		}else if(lennaChoosing) {
			batch.draw(spriteBox_2, 320, 0, 0, 0, 80,64,
		    		4, 2, 0);
			this.party.lenna.showOptions(batch, font);
			batch.draw(maozinha, 306, 70-(this.choiceIndex*24), 0, 0, 16, 16,
		    		3, 3, 0);
			
		}else if(galufChoosing) {
			batch.draw(spriteBox_2, 320, 0, 0, 0, 80,64,
		    		4, 2, 0);
			this.party.galuf.showOptions(batch, font);
			batch.draw(maozinha, 306, 70-(this.choiceIndex*24), 0, 0, 16, 16,
		    		3, 3, 0);
			
		}else if(farisChoosing) {
			batch.draw(spriteBox_2, 320, 0, 0, 0, 80,64,
		    		4, 2, 0);
			this.party.faris.showOptions(batch, font);
			batch.draw(maozinha, 306, 70-(this.choiceIndex*24), 0, 0, 16, 16,
		    		3, 3, 0);
		}
	}
}
