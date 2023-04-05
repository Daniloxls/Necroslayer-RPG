package com.nilo.necroslayer.character;

import com.nilo.necroslayer.inventory.Armor;
import com.nilo.necroslayer.inventory.Weapon;
import com.nilo.necroslayer.jobs.Job;

public class Charac {
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
	

}
