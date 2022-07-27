package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.ArrayList;

/**
 * Final Adapter class
 */

public class FinalAdapter extends ArrayAdapter<String> {

    ArrayList<BurgerItem> mBurgerItem;
    private Context mContext;
    public FinalAdapter(FinalOrderActivity context, ArrayList<BurgerItem> BurgerItem) {
        super(context,R.layout.final_list_design,R.id.burger_final_name);
        mContext=context;
        mBurgerItem=BurgerItem;
    }

    @Override
    public int getCount() {
        return mBurgerItem.size();
    }

    @Override
    public String getItem(int position){ return mBurgerItem.get(position).getMdata();}

    @NonNull
    @Override
    public View getView(int listViewPosition, @NonNull View convertView, @NonNull ViewGroup parent)
    {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.final_list_design, null);
        }

        ImageView imageView=(ImageView)view.findViewById(R.id.final_image_burger);
        TextView textNameView=(TextView)view.findViewById(R.id.burger_final_name);
        TextView priceView=(TextView)view.findViewById(R.id.price_per_burger);
        TextView amountBurgerView=(TextView)view.findViewById(R.id.final_price_per_burger);
        Button increaseBurgerView=(Button)view.findViewById(R.id.increase_amount);
        Button decreaseBurgerView=(Button)view.findViewById(R.id.decrease_amount);
        imageView.setImageResource(mBurgerItem.get(listViewPosition).getmImage());
        textNameView.setText(mBurgerItem.get(listViewPosition).getMdata());
        priceView.setText(mBurgerItem.get(listViewPosition).getPrices()+" ₪");
        amountBurgerView.setText("Amount: "+mBurgerItem.get(listViewPosition).getmBurgerAmount());
        increaseBurgerView.setOnClickListener(v -> {
            mBurgerItem.get(listViewPosition).setmBurgerAmount(mBurgerItem.get(listViewPosition).getmBurgerAmount()+1);
            amountBurgerView.setText("Amount: "+mBurgerItem.get(listViewPosition).getmBurgerAmount());
        });
        decreaseBurgerView.setOnClickListener(v -> {
            mBurgerItem.get(listViewPosition).setmBurgerAmount(mBurgerItem.get(listViewPosition).getmBurgerAmount()-1);
            int currAmount =mBurgerItem.get(listViewPosition).getmBurgerAmount();
            amountBurgerView.setText("Amount: "+currAmount);
        });
        return view;
    }
}
