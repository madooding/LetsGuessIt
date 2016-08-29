package com.example.madooding.letsguessit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView descTv = (TextView) findViewById(R.id.desc);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            int btnId = bundle.getInt("btn");
            int secretNumber = bundle.getInt("secretNumber");
            int numberOnScreen = bundle.getInt("numberOnScreen");
            boolean result = false;
            switch (btnId){
                case R.id.lessBtn : result = numberOnScreen < secretNumber;
                                    break;
                case R.id.equalBtn : result = numberOnScreen == secretNumber;
                                    break;
                case R.id.greaterBtn : result = numberOnScreen > secretNumber;
                                    break;
            }
            if(result){
                descTv.setText("Congrat! you\'ve choosed right answer.\nThe secret number is " + Integer.toString(secretNumber));
            }else{
                descTv.setText("Unfortunately! you\'ve choosed wrong answer.\nThe secret number is " + Integer.toString(secretNumber) + ".");
            }
        } else {
            descTv.setText("Got an Error!");
        }

    }
}
