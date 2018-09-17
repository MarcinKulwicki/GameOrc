package com.example.marcinkulwicki.gameorc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marcinkulwicki.gameorc.Game.Monk;
import com.example.marcinkulwicki.gameorc.Game.Orc;
import com.example.marcinkulwicki.gameorc.Game.Troll;

public class MonsterActivity extends AppCompatActivity {

    private Button mButtonTroll;
    private Button mButtonOrc;
    private Button mButtonMonk;
    private TextView mTextInformationMonster;
    private EditText mEditTextLvl;
    private Integer i = 1;
    private ImageView mImageTroll;
    private ImageView mImageOrc;
    private ImageView mImageMonk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster);



        mButtonTroll = findViewById(R.id.buttonTroll);
        mButtonOrc = findViewById(R.id.buttonOrc);
        mButtonMonk = findViewById(R.id.buttonMonk);

        mImageTroll = findViewById(R.id.imageTroll);
        mImageOrc = findViewById(R.id.imageOrc);
        mImageMonk = findViewById(R.id.imageMonk);


        mTextInformationMonster = findViewById(R.id.informationMonsterLvl);
        mEditTextLvl = findViewById(R.id.editTextLvl);
        mEditTextLvl.setText("1");

        FightActivity.Monster = new Troll(1);


        mEditTextLvl.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                int tmp = Integer.parseInt(v.getText().toString());
                if (tmp >25){
                    mEditTextLvl.setText("25");
                    mTextInformationMonster.setText("25");

                }else if (tmp < 1){
                    mEditTextLvl.setText("1");
                    mTextInformationMonster.setText("1");
                }else{
                    mTextInformationMonster.setText(""+tmp);
                }

                return false;
            }
        });



        mButtonTroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mTextInformationMonster.setText(""+i);
                /*
                Intent intent = new Intent(getApplicationContext(), FightActivity.class);
                intent.putExtra("Monster", "Troll");
                intent.putExtra("LVL", mTextInformationMonster.getText());
                intent.putExtra("Hero", getIntent().getStringExtra("Hero"));

                startActivity(intent);
                */
                FightActivity.Monster = new Troll (Integer.parseInt((String)mTextInformationMonster.getText()));
                FightActivity.refresh();
                onBackPressed();
            }
        });

        mButtonOrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                Intent intent = new Intent(MonsterActivity.this, FightActivity.class);
                intent.putExtra("Monster", "Orc");
                intent.putExtra("LVL", mTextInformationMonster.getText());
                intent.putExtra("Hero", getIntent().getStringExtra("Hero"));
                onBackPressed();
                //startActivity(intent);
                //startActivity(new Intent(getApplicationContext(), FightActivity.class));
                */
                FightActivity.Monster = new Orc(Integer.parseInt((String)mTextInformationMonster.getText()));
                FightActivity.refresh();
                onBackPressed();
            }
        });

        mButtonMonk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                Intent intent = new Intent(MonsterActivity.this, FightActivity.class);
                intent.putExtra("Monster", "Monk");
                intent.putExtra("LVL", mTextInformationMonster.getText());
                intent.putExtra("Hero", getIntent().getStringExtra("Hero"));

                startActivity(intent);
                */
                FightActivity.Monster = new Monk(Integer.parseInt((String)mTextInformationMonster.getText()));
                FightActivity.refresh();
                onBackPressed();
            }
        });

        mImageTroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButtonTroll.performClick();
            }
        });
        mImageOrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButtonOrc.performClick();
            }
        });
        mImageMonk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButtonMonk.performClick();
            }
        });
    }

}
