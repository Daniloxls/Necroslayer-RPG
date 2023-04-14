package com.nilo.necroslayer.enemy;

import java.util.ArrayList;

public class EnemyGroup {
	private ArrayList<Enemy> group;
	
	public EnemyGroup(Enemy enemyA){
		this.group = new ArrayList<Enemy>();
		enemyA.setX(256);
		enemyA.setY(238);
		this.group.add(enemyA);
	}
	public EnemyGroup(Enemy enemyA, Enemy enemyB){
		this.group = new ArrayList<Enemy>();
		enemyA.setX(86);
		enemyA.setY(238);
		this.group.add(enemyA);
		enemyB.setX(306);
		enemyB.setY(238);
		this.group.add(enemyB);
	}
	public EnemyGroup(Enemy enemyA, Enemy enemyB, Enemy enemyC){
		this.group = new ArrayList<Enemy>();
		enemyA.setX(86);
		enemyA.setY(288);
		this.group.add(enemyA);
		enemyB.setX(306);
		enemyB.setY(288);
		this.group.add(enemyB);
		enemyC.setX(206);
		enemyC.setY(156);
		this.group.add(enemyC);
	}
	public EnemyGroup(Enemy enemyA, Enemy enemyB, Enemy enemyC, Enemy enemyD){
		this.group = new ArrayList<Enemy>();
		enemyA.setX(86);
		enemyA.setY(288);
		this.group.add(enemyA);
		enemyB.setX(306);
		enemyB.setY(288);
		this.group.add(enemyB);
		enemyC.setX(126);
		enemyC.setY(156);
		this.group.add(enemyC);
		enemyD.setX(346);
		enemyD.setY(156);
		this.group.add(enemyD);
	}
	
	public ArrayList<Enemy> getComp(){
		return this.group;
	}

}
