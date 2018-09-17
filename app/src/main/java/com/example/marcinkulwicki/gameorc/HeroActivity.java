package com.example.marcinkulwicki.gameorc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class HeroActivity extends AppCompatActivity {



    private Button mButtonWarrior;
    private Button mButtonMag;
    private Button mButtonAssasin;
    private TextView mTextClicker;
    private EditText mEditName;
    private ImageView mImageWarrior;
    private ImageView mImageMag;
    private ImageView mImageAssassin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero);


        mButtonWarrior = findViewById(R.id.buttonWarrior);
        mButtonMag = findViewById(R.id.buttonMag);
        mButtonAssasin = findViewById(R.id.buttonAssasin);
        mEditName = findViewById(R.id.editName);

        mImageAssassin = findViewById(R.id.imageAssassin);
        mImageMag = findViewById(R.id.imageMag);
        mImageWarrior = findViewById(R.id.imageWarrior);


        mTextClicker = findViewById(R.id.textClicker);

        mButtonWarrior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(HeroActivity.this, FightActivity.class);
                intent.putExtra("Hero", "Warrior");
                intent.putExtra("NAME", mEditName.getText().toString());


                startActivity(intent);
            }
        });
        mButtonMag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HeroActivity.this, FightActivity.class);
                intent.putExtra("Hero", "Mag");
                intent.putExtra("NAME", mEditName.getText().toString());
                startActivity(intent);
            }
        });
        mButtonAssasin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HeroActivity.this, FightActivity.class);
                intent.putExtra("Hero", "Assasin");
                intent.putExtra("NAME", mEditName.getText().toString());
                startActivity(intent);
            }
        });

        mImageWarrior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButtonWarrior.performClick();
            }
        });
        mImageMag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButtonMag.performClick();
            }
        });
        mImageAssassin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { mButtonAssasin.performClick();
            }
        });

    }

}
