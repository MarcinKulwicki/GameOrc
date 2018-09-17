package com.example.marcinkulwicki.gameorc.Game;

import com.example.marcinkulwicki.gameorc.FightActivity;

import java.util.Random;

public class Troll extends Potwory {
	

	public Troll(double dif) {
		if (dif == 0) {
			dif = 1;
		}
		super.hitPower = 3 + dif;
		super.hpSpawn = super.hitPower;
		super.lvl = 1 * dif;
		//super.exp = 15 * dif;
		super.exp = 1;
		super.dif = dif;
	}
	
	@Override
	protected double dropItem() {
		Random r = new Random();
		int x = r.nextInt(10);
		if (x < 3 ) {
			//System.out.println("Wypadla Ci tarcza! + 1 do obrony");

			return 1;
		}
			return 0;
	}
	@Override
	public String toString() {
		return "Troll \n " + (int)super.hitPower + " Hit Power LVL: " + (int)super.lvl;
	}

}
