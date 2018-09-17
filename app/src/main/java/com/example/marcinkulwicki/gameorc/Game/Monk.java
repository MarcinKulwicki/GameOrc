package com.example.marcinkulwicki.gameorc.Game;

import java.util.Random;

public class Monk extends Potwory {
	

	public Monk(double dif) {
		if (dif == 0) {
			dif = 1;
		}
		super.hitPower = 5 + (dif );
		super.hpSpawn = super.hitPower;
		super.lvl = 1 * dif;
		//super.exp = 15 * dif;
		super.exp = 1;
		super.dif = dif;
	}

	@Override
	protected double dropItem() {
		Random r = new Random();
		int x = r.nextInt(5)+1;
		if (x < 3 ) {
		//System.out.println("Wypadl Ci miecz! + 2 do ataku");
			return 4;
		}
			return 0;
	}
	@Override
	public String toString() {
		return "Monk \n " + (int)super.hitPower + " Hit Power LVL: " + (int)super.lvl;
	}
	
	protected double effAtt() {
		Random r = new Random();
		int x = r.nextInt(35);
		if (x < 3 ) {
		System.out.println("Monk przed smiercia zwiekszył efektywnosc Twojego ataku o 1");
		return 1;
		}
		return 0;
	}

}