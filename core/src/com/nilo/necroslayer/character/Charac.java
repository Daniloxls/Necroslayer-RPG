package com.nilo.necroslayer.character;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.nilo.necroslayer.enemy.Enemy;
import com.nilo.necroslayer.inventory.Armor;
import com.nilo.necroslayer.inventory.Weapon;
import com.nilo.necroslayer.jobs.Job;
import java.util.Random;

public class Charac {
	private int[] posOnPartyTab;
	private int level;
	private int hp;
	private int maxHp;
	private int mp;
	private int maxMp;
	private int strenght;
	private int agility;
	private int stamina;
	private int magic;
	private long exp;
	private int atk;
	private int def;
	private int evade;
	private int mdef;
	private int mevade;
	private Weapon rHand;
	private Weapon lHand;
	private Armor head;
	private Armor body;
	private Armor boots;
	private String status;
	private Job job;
	private TextureAtlas sprites;
	private String ablityName;
	private String name;
	private boolean choosing;
	Random generator = new Random();
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public int getAgility() {
		return agility;
	}
	public void setAgility(int agility) {
		this.agility = agility;
	}
	public int getStrenght() {
		return strenght;
	}
	public void setStrenght(int strenght) {
		this.strenght = strenght;
	}
	public int getMagic() {
		return magic;
	}
	public void setMagic(int magic) {
		this.magic = magic;
	}
	public int getStamina() {
		return stamina;
	}
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	public long getExp() {
		return exp;
	}
	public void setExp(long exp) {
		this.exp = exp;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getMdef() {
		return mdef;
	}
	public void setMdef(int mdef) {
		this.mdef = mdef;
	}
	public int getEvade() {
		return evade;
	}
	public void setEvade(int evade) {
		this.evade = evade;
	}
	public int getMevade() {
		return mevade;
	}
	public void setMevade(int mevade) {
		this.mevade = mevade;
	}
	public Weapon getrHand() {
		return rHand;
	}
	public void setrHand(Weapon rHand) {
		this.rHand = rHand;
	}
	public Weapon getlHand() {
		return lHand;
	}
	public void setlHand(Weapon lHand) {
		this.lHand = lHand;
	}
	public Armor getHead() {
		return head;
	}
	public void setHead(Armor head) {
		this.head = head;
	}
	public Armor getBody() {
		return body;
	}
	public void setBody(Armor body) {
		this.body = body;
	}
	public Armor getBoots() {
		return boots;
	}
	public void setBoots(Armor boots) {
		this.boots = boots;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	public int getMaxMp() {
		return maxMp;
	}
	public void setMaxMp(int maxMp) {
		this.maxMp = maxMp;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	
	public Animation<Sprite> getAnimation(){
		if(this.getJob().id < 100) {
		Animation<Sprite> currentAnimation = new Animation<Sprite>(0.2f,
				(sprites.createSprite(("000")+Integer.toString(this.getJob().id))),
				(sprites.createSprite(("000")+Integer.toString(this.getJob().id+1))),
				(sprites.createSprite(("000")+Integer.toString(this.getJob().id+2))),
				(sprites.createSprite(("000")+Integer.toString(this.getJob().id+3))),
				(sprites.createSprite(("000")+Integer.toString(this.getJob().id+4))),
				(sprites.createSprite(("000")+Integer.toString(this.getJob().id+5))),
				(sprites.createSprite(("000")+Integer.toString(this.getJob().id+6))),
				(sprites.createSprite(("000")+Integer.toString(this.getJob().id+7))),
				(sprites.createSprite(("000")+Integer.toString(this.getJob().id+8))),
				(sprites.createSprite(("000")+Integer.toString(this.getJob().id+9))),
				(sprites.createSprite(("000")+Integer.toString(this.getJob().id+10))),
				(sprites.createSprite(("00011")))
				);
			return currentAnimation;
		}
		else  {
			Animation<Sprite> currentAnimation = new Animation<Sprite>(0.2f,
					(sprites.createSprite(("00")+Integer.toString(this.getJob().id))),
					(sprites.createSprite(("00")+Integer.toString(this.getJob().id+1))),
					(sprites.createSprite(("00")+Integer.toString(this.getJob().id+2))),
					(sprites.createSprite(("00")+Integer.toString(this.getJob().id+3))),
					(sprites.createSprite(("00")+Integer.toString(this.getJob().id+4))),
					(sprites.createSprite(("00")+Integer.toString(this.getJob().id+5))),
					(sprites.createSprite(("00")+Integer.toString(this.getJob().id+6))),
					(sprites.createSprite(("00")+Integer.toString(this.getJob().id+7))),
					(sprites.createSprite(("00")+Integer.toString(this.getJob().id+8))),
					(sprites.createSprite(("00")+Integer.toString(this.getJob().id+9))),
					(sprites.createSprite(("00")+Integer.toString(this.getJob().id+10))),
					(sprites.createSprite(("00011")))
					);
				return currentAnimation;
			}
		
	}
	public Sprite getSprite(float n) {
		return this.getAnimation().getKeyFrame(n);
	}
	public TextureAtlas getSprites() {
		return sprites;
	}
	public void setSprites(TextureAtlas sprites) {
		this.sprites = sprites;
	}
	public void showOptions(SpriteBatch batch , BitmapFont font) {
		font.draw(batch,"Attack" , 356, 112);
        font.draw(batch,this.job.abilityName , 356, 88);
        font.draw(batch,"Item" , 356, 64);
	}
	public void atacar(Enemy enemy) {
		int dano;
		dano = (int)this.getStrenght()/4;
		dano += generator.nextInt((this.getrHand().getMaxDamage() - this.getrHand().getMinDamage())+1) + this.getrHand().getMinDamage();
		enemy.setHp(enemy.getHp()-dano); 
	}
	public String getAblityName() {
		return ablityName;
	}
	public void setAblityName(String ablityName) {
		this.ablityName = ablityName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isChoosing() {
		return choosing;
	}
	public void setChoosing(boolean choosing) {
		this.choosing = choosing;
	}
	public int[] getPosOnPartyTab() {
		return posOnPartyTab;
	}
	public void setPosOnPartyTab(int[] posOnPartyTab) {
		this.posOnPartyTab = posOnPartyTab;
	}

}
