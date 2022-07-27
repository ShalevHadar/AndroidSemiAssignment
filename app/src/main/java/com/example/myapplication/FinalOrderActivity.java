package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FinalOrderActivity extends AppCompatActivity {
    private String userName;
    private ListView lvSpinner;
    private TextView finalPrice;
    private int totalPrice;
    private ArrayList<BurgerItem> mBurgerArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_order);
        mBurgerArray = (ArrayList<BurgerItem>) getIntent().getSerializableExtra("burgerArray");
        userName = getIntent().getStringExtra("name_plain_txt");
        lvSpinner = (ListView) findViewById(R.id.burger_list_view);
        finalPrice = (TextView) findViewById(R.id.total_price_for_all_burgers);
        updatePrice();
        FinalAdapter adapter = new FinalAdapter(this, mBurgerArray);
        lvSpinner.setAdapter(adapter);
    }

    private void updatePrice() {
        totalPrice = 0;
        int curPrice, curAmount;
        for (int i = 0; i < mBurgerArray.size(); i++) {
            curAmount = mBurgerArray.get(i).getmBurgerAmount();
            if (curAmount <= 0) {
                mBurgerArray.remove(i);
            } else {
                curPrice = Integer.parseInt(mBurgerArray.get(i).getPrices());
                totalPrice += curPrice * curAmount;
            }
        }
        finalPrice.setText("Total price: " + totalPrice + " ₪");
        FinalAdapter adapter = new FinalAdapter(this, mBurgerArray);
        lvSpinner.setAdapter(adapter);
    }

    public void onClickUpdatePrice(View view) {
        updatePrice();
    }

    public void onClickAddMoreItem(View view) {
        Intent intent = new Intent(this, SelfMadeActivity.class);
        intent.putExtra("burgerArray", mBurgerArray);
        intent.putExtra("name_plain_txt", userName);
        startActivity(intent);
    }

}