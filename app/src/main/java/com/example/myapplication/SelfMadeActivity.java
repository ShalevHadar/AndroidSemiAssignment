package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;

public class SelfMadeActivity extends AppCompatActivity {
    private String userName;
    private ArrayList<String> DescriptionList= new ArrayList<>();
    private String CurrentBurgerSize="";
    private TextView finalPrice;
    private int burgerPrice,totalPrice;
    private ArrayList<BurgerItem> mBurgerArray= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_made);
        mBurgerArray=(ArrayList<BurgerItem>)getIntent().getSerializableExtra("burgerArray");
        userName=getIntent().getStringExtra("name_plain_txt");
        burgerPrice=0;
        finalPrice = findViewById(R.id.price_txt);
    }

    public void onClickFamilySizeChosen(View view) {
        CurrentBurgerSize = getString(R.string.first_burger);
        burgerPrice = 50;
        updateFinalPrice();
    }

    public void onClickRegularSizeChosen(View view) {
        CurrentBurgerSize = getString(R.string.second_burger);
        burgerPrice = 55;
        updateFinalPrice();
    }

    public void onClickSmallSizeChosen(View view) {
        CurrentBurgerSize = getString(R.string.third_burger);
        burgerPrice = 45;
        updateFinalPrice();
    }


    //update the total amount
    private void updateFinalPrice() {
        totalPrice = burgerPrice;
        finalPrice.setText("Total amount: " + totalPrice);
    }

    public void onClickFinishOrder(View view) {
        String[] burgers = {"Shalev Burger", "Danny Burger", "Zahi Burger"};
        int burgerInt = Arrays.asList(burgers).indexOf(CurrentBurgerSize);
        System.out.println(burgerInt);
        DescriptionList.add(CurrentBurgerSize);
        StringBuilder sb = new StringBuilder();
        for (String s : DescriptionList)
        {
            sb.append(s);
            sb.append(", ");
        }
        System.out.println(burgers[burgerInt]);
        BurgerItem currentBurgerPicked = new BurgerItem(burgers[burgerInt],R.drawable.burger+burgerInt+1,""+totalPrice,1,sb.toString());
        mBurgerArray.add(currentBurgerPicked);
        Intent intent=new Intent(this, FinalOrderActivity.class);
        intent.putExtra("burgerArray",mBurgerArray);
        intent.putExtra("name_plain_txt",userName);
        startActivity(intent);

    }
}