package com.example.marcinkulwicki.gameorc.Game;

import java.util.Random;

public class Orc extends Potwory {

	public Orc(double dif) {
		if (dif == 0) {
			dif = 1;
		}
		super.hitPower = 4 + dif ;
		super.hpSpawn = super.hitPower;
		super.lvl = 1 * dif;
		//super.exp = 15 * dif;
		super.exp = 1;
		super.dif = dif;
	}
	
	@Override
	public String toString() {
		return "Orc \n " + (int)super.hitPower + " Hit Power LVL: " + (int)super.lvl;
	}
	
	
	@Override
	protected double dropItem() {
		Random r = new Random();
		int x = r.nextInt(25);
		if (x < 4 ) {
			//System.out.println("Wypadl Ci topor! + 1 do ataku");
			return 3;
		}
		if (x>22) {
			//System.out.println("Wypadl Ci armor +2 do obrony");
			return 2;
		}
		return 0;
	}
}
