package com.nilo.necroslayer.spells;

import com.nilo.necroslayer.character.Charac;
import com.nilo.necroslayer.enemy.Enemy;
import com.nilo.necroslayer.enemy.EnemyGroup;

import java.util.ArrayList;
import java.util.Random;

public class Spell {
	private String name;
	private String effect;
	private int target;
	private int custo;
	private int maxDamage;
	private int minDamage;
	private boolean revive;
	private boolean healPoison;
	Random generator = new Random();
	
	public Spell(String name, String effect,int custo, int target, int maxDamage, int minDamage) {
		this.name = name;
		this.effect = effect;
		this.custo = custo;
		this.target = target;
		this.maxDamage = maxDamage;
		this.minDamage = minDamage;
	}
	public Spell(String name, String effect, int custo, int target, int maxDamage, int minDamage, boolean revive) {
		this.name = name;
		this.effect = effect;
		this.custo = custo;
		this.target = target;
		this.maxDamage = maxDamage;
		this.minDamage = minDamage;
		this.revive = revive;
	}
	public Spell(String name, String effect, int custo, int target, int maxDamage, int minDamage, boolean revive, boolean healPoison) {
		this.name = name;
		this.effect = effect;
		this.custo = custo;
		this.target = target;
		this.maxDamage = maxDamage;
		this.minDamage = minDamage;
		this.revive = revive;
		this.healPoison = healPoison;
	}
	
	public ArrayList<String> cast(Charac caster, Enemy target){
		ArrayList<String> texto = new ArrayList<String>();
		int dano = generator.nextInt(this.maxDamage - this.minDamage) + this.minDamage + 1;
		target.setHp(target.getHp() - dano);
		if (target.getHp() < 0) {
			target.setHp(0);
			target.setAlive(false);
		}
		texto.add(caster.getName() + " causou " + Integer.toString(dano) + " de dano.");
		return texto;
	}
	
	public ArrayList<String> cast(Charac caster, EnemyGroup target){
		ArrayList<String> texto = new ArrayList<String>();
		for(Enemy e : target.getComp()) {
			int dano = generator.nextInt(this.maxDamage - this.minDamage) + this.minDamage + 1;
			e.setHp(e.getHp() - dano);
			if (e.getHp() < 0) {
				e.setHp(0);
				e.setAlive(false);
			}
			texto.add(caster.getName() + " causou " + Integer.toString(dano) + " de dano em " + e.getName() + ".");
		}
		return texto;
	}
	public ArrayList<String> cast(Charac caster, Charac target){
		ArrayList<String> texto = new ArrayList<String>();
		int cura = generator.nextInt(this.maxDamage - this.minDamage) + this.minDamage +1;
		if(target.isDead() & this.isRevive()) {
			target.setDead(false);
			target.setHp(target.getHp() - cura);
			texto.add(target.getName() + " foi revivido!");
			return texto;
		}
		target.setHp(target.getHp() - cura);
		if(target.getHp() > target.getMaxHp()) {
			target.setHp(target.getMaxHp());
		}
		texto.add(caster.getName() + " curou " + Integer.toString(-cura) + " de " + target.getName() + ".");
		return texto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}

	public int getMinDamage() {
		return minDamage;
	}

	public void setMinDamage(int minDamage) {
		this.minDamage = minDamage;
	}

	public boolean isRevive() {
		return revive;
	}

	public void setRevive(boolean revive) {
		this.revive = revive;
	}

	public boolean isHealpoison() {
		return healPoison;
	}

	public void setHealpoison(boolean healpoison) {
		this.healPoison = healpoison;
	}
	public int getCusto() {
		return custo;
	}
	public void setCusto(int custo) {
		this.custo = custo;
	}
}
