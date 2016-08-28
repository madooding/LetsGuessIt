package com.example.madooding.letsguessit;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import game.Game;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Game game = new Game();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.numberOnScreen);
        tv.setText(Integer.toString(game.showNum));

        Button equalBtn = (Button) findViewById(R.id.equalBtn);
        Button lessBtn = (Button) findViewById(R.id.lessBtn);
        Button greaterBtn = (Button) findViewById(R.id.greaterBtn);

        equalBtn.setOnClickListener(this);
        lessBtn.setOnClickListener(this);
        greaterBtn.setOnClickListener(this);

    }

    public void onClick (View v){
        Intent i = new Intent(this, ResultActivity.class);
        i.putExtra("btn", v.getId());
        i.putExtra("secretNumber", game.getSecretNum());
        i.putExtra("numberOnScreen", game.showNum);
        startActivity(i);
    }

    @Override
    public  void onResume(){
        super.onResume();

        game.reset();
        TextView tv = (TextView) findViewById(R.id.numberOnScreen);
        tv.setText(Integer.toString(game.showNum));

    }

}
