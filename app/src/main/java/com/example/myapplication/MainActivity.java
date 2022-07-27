package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText namePlainTxt;
    private  LanguageManager lang;
    ArrayList<BurgerItem> mBurgerArray= new ArrayList<>();

    /**
     * Upon creating first screen, initiate layout, view, text
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        namePlainTxt= findViewById(R.id.name_plain_txt);
        lang = new LanguageManager(this);
    }

    /**
     * set name as plain text got from input
     * if name is empty called yourself Burger lover
     * @param view
     */
    public void onClickNameEntered(View view) {
        String name = namePlainTxt.getText().toString();
        if (name.trim().equals("")) {
            name = "Burger Lover";
        }
        Intent intent = new Intent(this, ChooseBurgerType.class);
        intent.putExtra("name_plain_txt", name);
        intent.putExtra("burgerArray", mBurgerArray);
        startActivity(intent);
    }

    /**
     * Change language to Hebrew
     * @param view
     */
    public void onClickChangeToHebrew(View view)
    {
        lang.updateResource("iw");
        recreate();
        Toast.makeText(this, getResources().getString(R.string.language_has_changed),
                Toast.LENGTH_SHORT).show();
    }


    /**
     * Change language to english
     * @param view
     */
    public void onClickChangeToEnglish(View view) {
        lang.updateResource("en");
        recreate();
        Toast.makeText(this, getResources().getString(R.string.language_has_changed),
                Toast.LENGTH_SHORT).show();
    }
}