package com.example.marcinkulwicki.gameorc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.marcinkulwicki.gameorc.Game.*;

import static java.lang.Integer.parseInt;


public class FightActivity extends AppCompatActivity {

    private static TextView mFightStatisticHero;
    private static TextView mFightStatisticMonster;
    public static TextView mFightResultView;
    private Button mFightButton;
    private Button mChangeButton;
    private Button mHealButton;
    public static Postac Hero;
    public static Potwory Monster;

    public FightActivity() {
        Monster = new Troll (1);
        Hero = new Warrior("Marcin");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);



        mFightStatisticHero = findViewById(R.id.fightStatisticHero);
        mFightStatisticMonster = findViewById(R.id.fightStatisticMonster);
        mFightResultView = findViewById(R.id.fightResultView);
        mFightButton = findViewById(R.id.fightButton);
        mChangeButton = findViewById(R.id.changeButton);
        mHealButton = findViewById(R.id.healButton);



        // Wybor Herosa
        try {
            if (getIntent().getStringExtra("Hero").equals("null") == true) {

            } else if (getIntent().getStringExtra("Hero").equals("Warrior") == true) {
                Hero = new Warrior(getIntent().getStringExtra("NAME"));
            } else if (getIntent().getStringExtra("Hero").equals("Mag") == true) {
                Hero = new Mag(getIntent().getStringExtra("NAME"));
            } else if (getIntent().getStringExtra("Hero").equals("Assasin") == true) {
                Hero = new Assasin(getIntent().getStringExtra("NAME"));
            }
        }catch(Exception e){
            mFightStatisticHero.setText("nie udalo sie");
        }



        /*
        // Wybor Monstera
        try {
            if (getIntent().getStringExtra("Monster").equals("Troll") == true) {
                String tmp = getIntent().getStringExtra("LVL");
                mFightStatisticMonster.setText(""+Double.parseDouble(tmp));
                Monster = new Troll(Double.parseDouble(tmp));
            }else if(getIntent().getStringExtra("Monster").equals("Orc") == true){
                String tmp = getIntent().getStringExtra("LVL");
                mFightStatisticMonster.setText(""+Double.parseDouble(tmp));
                Monster = new Orc(Double.parseDouble(tmp));
            }else if(getIntent().getStringExtra("Monster").equals("Monk") == true){
                String tmp = getIntent().getStringExtra("LVL");
                mFightStatisticMonster.setText(""+Double.parseDouble(tmp));
                Monster = new Monk(Double.parseDouble(tmp));
            }

        }catch(Exception e){
            mFightStatisticMonster.setText("nie udalo sie");
        }

        */
        //mFightStatisticMonster.setText(Monster.toString());
        //mFightStatisticHero.setText(Hero.toString());





        mFightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fight walka = new Fight();
                walka.doFight(Hero, Monster);

                mFightStatisticMonster.setText(Monster.toString());
                mFightStatisticHero.setText(Hero.toString());


            }
        });
        mChangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FightActivity.this, MonsterActivity.class);
                startActivity(intent);
                //intent.putExtra("Hero", "Assasin");
                //onBackPressed();

            }
        });
        mHealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hero.healUp();
                mFightStatisticMonster.setText(Monster.toString());
                mFightStatisticHero.setText(Hero.toString());
            }
        });


        mFightStatisticMonster.setText(Monster.toString());
        mFightStatisticHero.setText(Hero.toString());


    }

    public static void refresh(){
        try{
            mFightStatisticMonster.setText(Monster.toString());
            mFightStatisticHero.setText(Hero.toString());
        }catch(Exception e){
            System.out.println("Nothing special");
        }
    }

}
