package com.nilo.necroslayer.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
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
import com.nilo.necroslayer.character.Charac;
import com.nilo.necroslayer.character.Party;
import com.nilo.necroslayer.enemy.Enemy;
import com.nilo.necroslayer.enemy.EnemyGroup;
import com.nilo.necroslayer.model.Menu;
import com.nilo.necroslayer.model.Player;
import com.nilo.necroslayer.spells.Spell;

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
    Sprite cursorR, cursorL;
    EnemyGroup enemyGroup;
    Music theme;
    Audio audio;
    int partyIndex = 0;
    int partyTarget = 0;
    int choiceIndex = 0;
    int enemyIndex = 0;
    int magicIndex = 0;
    int spellTarget = -1;
    private boolean targeting;
    private boolean enemyTurn;
    private boolean showMagic = false;
    private boolean spellTargeting = false;
    public Batalha(Necroslayer game, Party party, ScreenAdapter lastScreen, EnemyGroup enemyGroup) {
        this.party = party;
        this.enemyGroup = enemyGroup;
        this.game = game;
        this.lastScreen = lastScreen;
    }
    @Override
    public void show() {
    	audio = Gdx.audio;
    	theme = audio.newMusic(Gdx.files.internal("battle_theme.wav"));
    	//theme.play();
    	theme.setLooping(true);
		texture = new Texture(Gdx.files.internal("background_batalha.png"));
		background = new Sprite(texture,256,144);
		handTexture = new Texture(Gdx.files.internal("maozinha.png"));
		cursorR = new Sprite(handTexture, 16, 16);
		cursorL = new Sprite(handTexture, 16, 16);
		cursorL.setFlip(true, false);
		box_1 = new Texture(Gdx.files.internal("battlebox_1.png"));
		spriteBox_1 = new Sprite(box_1, 256, 64);
		box_2 = new Texture(Gdx.files.internal("battlebox_2.png"));
		spriteBox_2 = new Sprite(box_2, 80, 64);
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
        batch.draw(background, 0,  0, 0, 0, 256, 144, 4, 4, 0);
        batch.draw(spriteBox_1, 0, 0, 0, 0, 256,64,
	    		4, 2, 0);
        for(Charac c : this.party.getComp()) {
        	batch.draw(c.getSprite(0.0f), 768, 364-(80 * this.party.getComp().indexOf(c)), 0, 0, 30, 30,
    	    		3, 3, 0);
        	font.draw(batch,c.getName() , 786, 112-(this.party.getComp().indexOf(c) * 24));
        	font.draw(batch,String.valueOf(c.getHp()) + "/" + String.valueOf(c.getMaxHp()) , 866, 112-(this.party.getComp().indexOf(c) * 24));
        
        }
        for(Enemy e : this.enemyGroup.getComp()) {
        	batch.draw(e.getSprite(), e.getX(), e.getY(), 0, 0, e.getSizeX(), e.getSizeY(),
    	    		3, 3, 0);
        	font.draw(batch,e.getName() , 32, 112-(this.enemyGroup.getComp().indexOf(e) * 24));
        }
        if(!enemyTurn & spellTarget != 0) {
        	batch.draw(cursorL, 850, 384-(this.partyIndex*80), 0, 0, 16, 16,
        			3, 3, 0);
        }
        batch.draw(spriteBox_2, 320, 0, 0, 0, 80,64,
	    		4, 2, 0);
       
        
        if(partyIndex < 4) {
        	this.party.getComp().get(partyIndex).showOptions(batch, font);
        }
        if(showMagic) {
        	displayMagic(this.party.getComp().get(partyIndex));
        }
        if(spellTarget == 0) {
        	batch.draw(cursorL, 850, 384-(this.partyTarget*80), 0, 0, 16, 16,
        			3, 3, 0);
        }
        if (targeting | spellTarget == 1) {
        	batch.draw(cursorR, this.enemyGroup.getComp().get(enemyIndex).getX(), this.enemyGroup.getComp().get(enemyIndex).getY(), 0, 0, 16, 16,
    	    		3, 3, 0);
        }
        if(spellTarget == 2) {
        	for(Enemy e : this.enemyGroup.getComp()) {
        		batch.draw(cursorR, e.getX(), e.getY(), 0, 0, 16, 16, 3, 3, 0);
        	}
        }
        
		batch.draw(cursorR, 306, 70-(this.choiceIndex*24), 0, 0, 16, 16,
	    		3, 3, 0);
		game.dialogo.render(batch);
		font.draw(batch, Integer.toString(partyIndex), 0, 566);
		font.draw(batch, Boolean.toString(enemyTurn), 0, 551);
		font.draw(batch, Boolean.toString(this.game.dialogo.getInDialogue()), 0,535);
		font.draw(batch, Boolean.toString(this.party.getBartz().isDefend()), 0,520);
		this.logica();
        batch.end();
    }
    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
        theme.stop();

    }
    public void dispose () {
		batch.dispose();
		theme.dispose();
		
	}
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.F2) {
			this.game.setScreen(lastScreen);
		}
		if(game.dialogo.getInDialogue()){
			if(keycode == Keys.Z) {
				game.dialogo.nextDialogue();
			}
		}else{
			if (targeting) {
				if(keycode == Keys.DOWN) {
					if(this.enemyIndex == this.enemyGroup.getComp().size() - 1) {
						this.enemyIndex = 0;
					}else {
						this.enemyIndex ++;
					}
				}
				if(keycode == Keys.UP) {
					if(this.enemyIndex == 0) {
						this.enemyIndex = this.enemyGroup.getComp().size() - 1;
					}
					else {
						this.enemyIndex --;
					}
				}
				if(keycode == Keys.LEFT) {
					if(this.enemyIndex == this.enemyGroup.getComp().size() - 1) {
						this.enemyIndex = 0;
					}else {
						this.enemyIndex ++;
					}
				}
				if(keycode == Keys.RIGHT) {
					if(this.enemyIndex == 0) {
						this.enemyIndex = this.enemyGroup.getComp().size() - 1;
					}
					else {
						this.enemyIndex --;
					}
				}
				if(keycode == Keys.Z) {
					if(this.choiceIndex == 0) {
						this.game.dialogo.setDialogue(this.party.getComp().get(partyIndex).atacar(this.enemyGroup.getComp().get(enemyIndex)));
						this.partyIndex ++;
						this.targeting = false;
					}
					if(this.choiceIndex == 1) {
						this.game.dialogo.setDialogue(this.party.getComp().get(partyIndex).getJob().ability(this.enemyGroup.getComp().get(enemyIndex), this.game.player.mochila));
						this.partyIndex ++;
						this.targeting = false;
					}
				}
				if(keycode == Keys.X) {
					this.targeting = false;
				}
			
			}else if(spellTargeting) {
				if(keycode == Keys.DOWN) {
					if(this.enemyIndex == this.enemyGroup.getComp().size() - 1) {
						this.enemyIndex = 0;
					}else {
						this.enemyIndex ++;
					}
					if(this.partyTarget == 3) {
						this.partyTarget = 0;
					}else {
						this.partyTarget ++;
					}
				}
				if(keycode == Keys.UP) {
					if(this.enemyIndex == 0) {
						this.enemyIndex = this.enemyGroup.getComp().size() - 1;
					}
					else {
						this.enemyIndex --;
					}
					if(this.partyTarget == 0) {
						this.partyTarget = 3;
					}else {
						this.partyTarget --;
					}
				}
				
				if(keycode == Keys.X) {
					this.spellTargeting = false;
					this.spellTarget = -1;
				}
				if(keycode == Keys.Z) {
					if(spellTarget == 0) {
						this.game.dialogo.setDialogue(this.party.getComp().get(partyIndex).getJob().getSpellList()
								.get(choiceIndex).cast(this.party.getComp().get(partyIndex),this.party.getComp().get(partyTarget)));
					}
					if(spellTarget == 1) {
						this.game.dialogo.setDialogue(this.party.getComp().get(partyIndex).getJob().getSpellList()
								.get(choiceIndex).cast(this.party.getComp().get(partyIndex),enemyGroup.getComp().get(enemyIndex)));
					}
					if(spellTarget == 2) {
						this.game.dialogo.setDialogue(this.party.getComp().get(partyIndex).getJob().getSpellList()
								.get(choiceIndex).cast(this.party.getComp().get(partyIndex),enemyGroup));
					}
					this.partyIndex ++;
					this.showMagic = false;
					this.spellTargeting = false;
					this.spellTarget = -1;
				}
				
			}
			else if(showMagic) {
				if(keycode == Keys.DOWN) {
					if(this.choiceIndex == 2) {
						this.choiceIndex = 0;
					}else {
						this.choiceIndex ++;
					}
				}
				if(keycode == Keys.UP) {
					if(this.choiceIndex == 0) {
						this.choiceIndex = 2;
					}
					else {
						this.choiceIndex --;
					}
				}
				if(keycode == Keys.Z) {
					if(party.getComp().get(partyIndex).getMagic() < this.party.getComp().get(partyIndex).getJob().getSpellList().get(choiceIndex).getCusto()) {
						ArrayList<String> semMana = new ArrayList<String>();
						semMana.add("Magia insuficiente");
						this.game.dialogo.setDialogue(semMana);
					}
					else {
						spellTarget = this.party.getComp().get(partyIndex).getJob().getSpellList().get(choiceIndex).getTarget();
						spellTargeting = true;
					}
				}
				if(keycode == Keys.X) {
					this.showMagic = false;
				}
				
			}
			else{
				
				if(keycode == Keys.DOWN) {
					if(this.choiceIndex == 2) {
						this.choiceIndex = 0;
					}else {
						this.choiceIndex ++;
					}
				}
				if(keycode == Keys.UP) {
					if(this.choiceIndex == 0) {
						this.choiceIndex = 2;
					}
					else {
						this.choiceIndex --;
					}
				}
				
				if(keycode == Keys.Z) {
					if(this.choiceIndex == 0) {
						this.targeting = true;
					}
					else if(this.choiceIndex == 1) {
						if (this.party.getComp().get(partyIndex).getJob().getId() == 12) {
							this.party.getComp().get(partyIndex).getJob().ability();
							this.partyIndex++;
						}
						else if (this.party.getComp().get(partyIndex).getJob().getId() == 36) {
							this.targeting = true;
						}
						else if (this.party.getComp().get(partyIndex).getJob().getId() == 132 | this.party.getComp().get(partyIndex).getJob().getId() == 120) {
							this.showMagic = true;
						}
						
						
					}else if (this.choiceIndex == 2) {
						
					}
				}
				
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
		if (partyIndex > 3 & enemyTurn == false & !game.dialogo.getInDialogue()) {
        	enemyTurn = true;
        	enemyIndex = 0;
        }
        if(!game.dialogo.getInDialogue() & enemyTurn) {
			game.dialogo.setDialogue(this.enemyGroup.getComp().get(enemyIndex).attack(party));
			enemyIndex ++;
			if(enemyIndex == this.enemyGroup.getComp().size()) {
				enemyTurn = false;
				partyIndex = 0;
				enemyIndex = 0;
				resetDefense();
			}
        }
		
		
		}
	public void displayMagic(Charac c) {
		batch.draw(spriteBox_2, 320, 0, 0, 0, 80,64,
	    		4, 2, 0);
		for(Spell magia : c.getJob().getSpellList()) {
			font.draw(batch,magia.getName() , 356, 112-(c.getJob().getSpellList().indexOf(magia) * 24));
		}
	}
	public void resetDefense() {
		for(Charac c : this.party.getComp()) {
			if(c.isDefend()) {
				c.setDefend(false);
			}
		}
	}
	}

