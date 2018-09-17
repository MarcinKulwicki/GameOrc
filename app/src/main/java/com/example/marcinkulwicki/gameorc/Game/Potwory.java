package com.example.marcinkulwicki.gameorc.Game;

import java.util.Random;

public abstract class Potwory {
	
	protected double lvl;
	protected double exp;
	protected double hitPower;
	protected double hpSpawn;
	protected double dif;
	
	double hitPower() {
		
		Random r = new Random();
		int x = r.nextInt(6)+1;
		return this.hitPower+x;
	}

	double expGive() {
		return this.exp;
	}

	double difGive() { return this.dif; }

	double gethitPower() {
		return this.hitPower;
	}
	void spawn() {
		this.hitPower = this.hpSpawn;
	}
	
	//Nadpisane
	abstract double dropItem();
}
