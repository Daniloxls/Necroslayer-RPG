package com.nilo.necroslayer.spells;

import com.nilo.necroslayer.character.Charac;
import com.nilo.necroslayer.enemy.Enemy;
import com.nilo.necroslayer.enemy.EnemyGroup;

import java.util.ArrayList;

public class Spell {
	private String name;
	private String effect;
	private int target;
	private int custo;
	private int maxDamage;
	private int minDamage;
	private boolean revive;
	private boolean healPoison;
	
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
		texto.add("Uhul deu um bocado de dano nesse inimigo");
		return texto;
	}
	
	public ArrayList<String> cast(Charac caster, EnemyGroup target){
		ArrayList<String> texto = new ArrayList<String>();
		texto.add("Uhul deu dano em todo mundo");
		
		return texto;
	}
	public ArrayList<String> cast(Charac caster, Charac target){
		ArrayList<String> texto = new ArrayList<String>();
		texto.add("Uhul curou um caba");
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
