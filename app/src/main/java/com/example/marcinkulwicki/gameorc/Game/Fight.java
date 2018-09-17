package com.example.marcinkulwicki.gameorc.Game;

import com.example.marcinkulwicki.gameorc.FightActivity;

public class Fight {

	public Fight() {

	}

	public void doFight(Postac Hero, Potwory Monster) {

		Monster.spawn();
		double hitPowerHero = Hero.hitPower();
		double hitPowerMonster = Monster.hitPower();
		//Monster.lvl = 15;
		
		
		if (Hero.getHP() <= 0) {
			System.out.println("Twoj Bohater już Umarl");
			FightActivity.mFightResultView.setText("Nothing changed, your hero is dead!");
		} else
			{
				System.out.println("**********");
				System.out.println("Walka zostala rozpoczeta");
				System.out.println("ATT Hero: "+ hitPowerHero + " ATT Monster: "+ hitPowerMonster);
				if (hitPowerHero > hitPowerMonster) {
					System.out.println("WYGRANA  " + "ATT Hero: "+ hitPowerHero + " ATT Monster: "+ hitPowerMonster);
					FightActivity.mFightResultView.setText("WYGRANA  \n" + "ATT Hero: "+ hitPowerHero + "\n ATT Monster: "+ hitPowerMonster);
					Hero.expUp(Monster.expGive(), Monster.difGive());

					
					if (Monster instanceof Monk) {
						Hero.setHitPower(((Monk)Monster).effAtt());
					}
					Hero.equipment(Monster.dropItem());



				}else if (hitPowerHero == hitPowerMonster) {
					System.out.println("REMIS " + "ATT Hero: "+ hitPowerHero + " ATT Monster: "+ hitPowerMonster);
					FightActivity.mFightResultView.setText("REMIS \n" + "ATT Hero: "+ hitPowerHero + " \n ATT Monster: "+ hitPowerMonster);
				}
				else if (hitPowerHero < hitPowerMonster){
					System.out.println("PRZEGRANA " + "ATT Hero: "+ hitPowerHero + " ATT Monster: "+ hitPowerMonster);
					FightActivity.mFightResultView.setText("PRZEGRANA\n" + "ATT Hero: "+ hitPowerHero + "\n ATT Monster: "+ hitPowerMonster);
					Hero.getHit();

				}
				
				//System.out.println("EXP jaki potrzebujesz: ");
				//Hero.getInfo();
				
			
				
			}
			
	}

}
