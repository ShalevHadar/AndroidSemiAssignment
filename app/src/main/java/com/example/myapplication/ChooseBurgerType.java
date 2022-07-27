package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import java.util.ArrayList;

/**
 * Choose the burger type you want - 3 kinds
 */
public class ChooseBurgerType extends AppCompatActivity {
    private String userName;
    private TextView greetings;
    ArrayList<BurgerItem> mBurgerArray= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_screen);
        greetings=findViewById(R.id.greetings_txt);
        userName=getIntent().getStringExtra("name_plain_txt");
        greetings.setText(getString(R.string.hello) + ", " +userName+ "\n" + getString(R.string.what_would_you_like));
        mBurgerArray=(ArrayList<BurgerItem>)getIntent().getSerializableExtra("burgerArray");
    }

    public void onClickCustomMadeChoose(View view) {
        Intent intent = new Intent(this, SelfMadeActivity.class);
        intent.putExtra("name_plain_txt",userName);
        intent.putExtra("burgerArray",mBurgerArray);
        startActivity(intent);
    }
}