package com.example.marcinkulwicki.gameorc.Game;

import com.example.marcinkulwicki.gameorc.FightActivity;

import java.util.Random;

public abstract class Postac {
	
	protected double hp;
	protected double maxHp;
	protected double lvl;
	protected double exp;
	protected double hitPower;
	protected double[] equipment;
	
	
	
	Postac (){
		this.lvl = 0;
		this.exp = 0;
		this.equipment = new double[4];
	}
	
	protected void equipment(double x){
		//1-tarcza, 2- armor, 3- topor, 4- miecz
		if (x == 1) {
			if (this.equipment[0] == 0) {
				this.equipment[0] = 1;
				this.hp += 1;
				this.maxHp += 1;
				System.out.println("Wypadla Ci tarcza +1 do obrony");
				FightActivity.mFightResultView.setText(FightActivity.mFightResultView.getText() + " \n Wypadla Ci tarcza! + 1 do obrony");
			}
		}
		if (x == 2) {
			if (this.equipment[1] == 0) {
				this.equipment[1] = 1;
				this.hp += 2;
				this.maxHp += 2;
				System.out.println("Wypadl Ci armor +2 do obrony");
				FightActivity.mFightResultView.setText(FightActivity.mFightResultView.getText() + " \n Wypadla Ci tarcza! + 2 do obrony");
			}
		}
		if (x == 3) {
			if (this.equipment[2] == 0) {
				this.equipment[2] = 1;
				this.hitPower += 1;
				System.out.println("Wypadl Ci topor +1 do ataku");
				FightActivity.mFightResultView.setText(FightActivity.mFightResultView.getText() + " \n Wypadl Ci miesz +1 do ataku");
			}
		}
		if (x == 4) {
			if (this.equipment[3] == 0) {
				this.equipment[3] = 1;
				this.hitPower += 2;
				System.out.println("Wypadl Ci miesz +2 do ataku");
				FightActivity.mFightResultView.setText(FightActivity.mFightResultView.getText() + " \n Wypadl Ci miesz +2 do ataku");
			}
		}
		
	}
	
	protected double hitPower() {
		Random r = new Random();
		int x = r.nextInt(6)+1;
		return this.hitPower+x;
	}
	
	protected void setHitPower(double x) {
		this.hitPower += x;
	}

	protected void getHit() {
		this.hp -= 1;
		if (this.hp < 0)
			this.hp = 0;
	}
	
	protected double expUp(double expUp , double difMonster) {
		if((expUp + (difMonster-this.lvl)) > 0)
			this.exp += expUp + (difMonster-this.lvl);
		else
			this.exp += 0;
		//double expUNeed = 50+((this.lvl+1)*15);
		double expUNeed = 8;
		if(this.exp >= expUNeed){
			this.exp = 0;
			this.lvl += 1;
			lvlUp();
		}
		return expUNeed;
	}
	protected double getHP() {
		return this.hp;
	}
	public void healUp() {
		if (this.hp > 0) {
			this.hp += 1;
			if (this.hp > this.maxHp) {
				this.hp = this.maxHp;
			}
		}
	}
	//Nadpisane metody
	abstract protected void lvlUp();
	
}
