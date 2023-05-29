package com.nilo.necroslayer.screens;

import java.util.ArrayList;
import java.util.Random;

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
    Random random;
    Music theme;
    Audio audio;
    Music victoryTheme;
    int partyIndex = 0;
    int partyTarget = 0;
    int choiceIndex = 0;
    int enemyIndex = 0;
    int deadIndex = 0;
    int deadTarget = 0;
    int i;
    int magicIndex = 0;
    int spellTarget = -1;
    int loot = 0;
    int xp = 0;
    private ArrayList<Charac> deadMembers = new ArrayList<Charac>();
    private ArrayList<String> lootText = new ArrayList<String>();
    private boolean targeting;
    private boolean enemyTurn;
    private boolean showMagic = false;
    private boolean spellTargeting = false;
    boolean victory = false;
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
    	victoryTheme = audio.newMusic(Gdx.files.internal("victory_theme.wav"));
    	//theme.play();
    	theme.setLooping(true);
    	random = new Random();
		texture = new Texture(Gdx.files.internal("battleback8.png"));
		background = new Sprite(texture,1104,621);
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
        batch.draw(background, 0,  0, 0, 0, 1104, 621, 1, 1, 0);
        batch.draw(spriteBox_1, 0, 0, 0, 0, 256,64,
	    		4, 2, 0);
        /*if (victory) {
        	for(Charac c : this.party.getComp()) {
            	batch.draw(c.getWin().getKeyFrame(this.game.elapsedTime, true), 768, 364-(80 * c.getNumber()), 0, 0, 30, 30,
        	    		3, 3, 0);
            	this.game.elapsedTime += 0.025f;
            	font.draw(batch,c.getName() , 786, 112-(c.getNumber() * 24));
            	font.draw(batch,String.valueOf(c.getHp()) + "/" + String.valueOf(c.getMaxHp()) , 866, 112-(c.getNumber() * 24));
            
            }
        }else {*/
	        for(Charac c : this.party.getComp()) {
	        	batch.draw(c.getSprite(), 768, 364-(80 * c.getNumber()), 0, 0, 30, 30,
	    	    		3, 3, 0);
	        	font.draw(batch,c.getName() , 786, 112-(c.getNumber() * 24));
	        	font.draw(batch,String.valueOf(c.getHp()) + "/" + String.valueOf(c.getMaxHp()) , 866, 112-(c.getNumber() * 24));
	        
	        }
        //}
        for(Charac c : this.deadMembers) {
        	batch.draw(c.getSprite(2.4f), 768, 364-(80 * c.getNumber()), 0, 0, 30, 30,
    	    		3, 3, 0);
        	font.draw(batch,c.getName() , 786, 112-(c.getNumber() * 24));
        	font.draw(batch,String.valueOf(c.getHp()) + "/" + String.valueOf(c.getMaxHp()) , 866, 112-(c.getNumber() * 24));
        
        }
        for(Enemy e : this.enemyGroup.getComp()) {
        	if(e.isAlive()) {
	        	batch.draw(e.getSprite(), e.getX(), e.getY(), 0, 0, e.getSizeX(), e.getSizeY(),
	    	    		4, 4, 0);
	        	font.draw(batch,e.getName() , 32, 112-(this.enemyGroup.getComp().indexOf(e) * 24));
        	}
        }
        if(!enemyTurn & spellTarget != 0 & partyIndex < this.party.getComp().size() & spellTarget != 6) {
        	batch.draw(cursorL, 850, 384-(this.party.getComp().get(partyIndex).getNumber()*80), 0, 0, 16, 16,
        			3, 3, 0);
        }
        batch.draw(spriteBox_2, 320, 0, 0, 0, 80,64,
	    		4, 2, 0);
       
        
        if(partyIndex < this.party.getComp().size()) {
        	this.party.getComp().get(partyIndex).showOptions(batch, font);
        }
        if(showMagic) {
        	displayMagic(this.party.getComp().get(partyIndex));
        }
        if(spellTarget == 0) {
        	batch.draw(cursorL, 850, 384-(this.party.getComp().get(partyTarget).getNumber()*80), 0, 0, 16, 16,
        			3, 3, 0);
        }
        if (targeting | spellTarget == 1) {
        	batch.draw(cursorR, this.enemyGroup.getComp().get(enemyIndex).getX(), this.enemyGroup.getComp().get(enemyIndex).getY(), 0, 0, 16, 16,
    	    		3, 3, 0);
        }
        if(spellTarget == 6) {
        	batch.draw(cursorL, 850, 384-(this.deadMembers.get(deadTarget).getNumber()*80), 0, 0, 16, 16,
        			3, 3, 0);
        }
        if(spellTarget == 2) {
        	for(Enemy e : this.enemyGroup.getComp()) {
        		if(e.isAlive()) {
        			batch.draw(cursorR, e.getX(), e.getY(), 0, 0, 16, 16, 3, 3, 0);
        		}
        	}
        }
        
		batch.draw(cursorR, 306, 70-(this.choiceIndex*24), 0, 0, 16, 16,
	    		3, 3, 0);
		game.dialogo.render(batch);
		font.draw(batch, Integer.toString(partyIndex), 0, 566);
		font.draw(batch, Boolean.toString(enemyTurn), 0, 551);
		font.draw(batch, Boolean.toString(this.game.dialogo.getInDialogue()), 0,535);
		font.draw(batch, Integer.toString(partyTarget), 0, 505);
		font.draw(batch, Integer.toString(deadTarget), 0, 490);
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
		if(keycode == Keys.F1) {
			this.enemyGroup.getComp().get(0).setAlive(false);
			this.enemyGroup.getComp().get(0).setHp(0);
		}
		if(keycode == Keys.F2) {
			this.game.setScreen(lastScreen);
		}
		if(keycode == Keys.F3) {
			this.party.getComp().get(0).setDead(true);
			this.party.getComp().get(0).setHp(0);
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
					if(this.partyTarget == this.party.getComp().size()-1) {
						this.partyTarget = 0;
					}else {
						this.partyTarget ++;
					}
					if(this.deadTarget == this.deadMembers.size()-1) {
						this.deadTarget = 0;
					}else {
						this.deadTarget ++;
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
						this.partyTarget = this.party.getComp().size()-1;
					}else {
						this.partyTarget --;
					}
					if(this.deadTarget == 0) {
						this.deadTarget = this.deadMembers.size()-1;
					}else {
						this.deadTarget --;
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
					if(spellTarget == 6) {
						this.game.dialogo.setDialogue(this.party.getComp().get(partyIndex).getJob().getSpellList()
								.get(choiceIndex).cast(this.party.getComp().get(partyIndex),this.deadMembers.get(deadTarget)));
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
						if(spellTarget == 6 & this.deadMembers.isEmpty()) {
							ArrayList<String> semMorto = new ArrayList<String>();
							semMorto.add("Nenhum membro caido");
							this.game.dialogo.setDialogue(semMorto);
							spellTarget = -1;
						}
						else {
							partyTarget = 0;
							enemyIndex = 0;
							deadTarget = 0;
							spellTargeting = true;
						}
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
		if (partyIndex > this.party.getComp().size()-1 & enemyTurn == false & !game.dialogo.getInDialogue()) {
        	enemyTurn = true;
        	enemyIndex = 0;
        }
        if(!game.dialogo.getInDialogue() & enemyTurn & !this.enemyGroup.getComp().isEmpty()) {
			game.dialogo.setDialogue(this.enemyGroup.getComp().get(enemyIndex).attack(party));
			enemyIndex ++;
			if(enemyIndex == this.enemyGroup.getComp().size()) {
				enemyTurn = false;
				partyIndex = 0;
				enemyIndex = 0;
				resetDefense();
			}
        }
        
        for (i = 0 ; i < this.enemyGroup.getComp().size() ; i++) {
        	if(!this.enemyGroup.getComp().get(i).isAlive()) {
        		this.xp += random.nextInt(this.enemyGroup.getComp().get(i).getMaxXp() - this.enemyGroup.getComp().get(i).getMinXp()) + this.enemyGroup.getComp().get(i).getMinXp()+1;
        		this.loot += random.nextInt(this.enemyGroup.getComp().get(i).getMaxGil() - this.enemyGroup.getComp().get(i).getMinGil()) + this.enemyGroup.getComp().get(i).getMinGil()+1;
        		this.enemyGroup.getComp().remove(i);
        		
        	}
        }
        for (i = 0 ; i < this.party.getComp().size() ; i++) {
        	if(this.party.getComp().get(i).isDead()) {
        		this.deadMembers.add(this.party.getComp().get(i));
        		this.party.getComp().remove(i);
        	}
        }
        for (i = 0 ; i < this.deadMembers.size() ; i++) {
        	if(!this.deadMembers.get(i).isDead()) {
        		this.party.getComp().add(this.deadMembers.get(i).getNumber(), this.deadMembers.get(i));
        		this.deadMembers.remove(i);
        	}
        }
        if(this.victory & !this.game.dialogo.getInDialogue()) {
        	for(Charac c : this.deadMembers) {
        		this.party.getComp().add(c.getNumber(), c);
        	}
        	this.game.setScreen(lastScreen);
        	this.victoryTheme.stop();
        }
        
        if(this.enemyGroup.getComp().isEmpty() & !this.game.dialogo.getInDialogue() & !this.victory) {
        	this.victory = true;
        	this.lootText.add("Voce recebeu " + Integer.toString(this.xp) + " pontos de experiência");
        	this.lootText.add("Voce recebeu " + Integer.toString(this.loot) + " moedas de ouro");
        	this.game.dialogo.setDialogue(lootText);
        	this.victoryTheme.play();
        }
        
        
        if(this.game.player.party.getComp().isEmpty() & !this.game.dialogo.getInDialogue()) {
        	this.game.setScreen(new GameOver(this.game, this.lastScreen));
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

