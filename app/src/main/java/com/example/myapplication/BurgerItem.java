package com.example.myapplication;

import java.io.Serializable;

/**
 * Burger item class, setters and getters
 */
class BurgerItem implements Serializable {

    private String mdata;
    private Integer mImage;
    private String mPrice;
    private int mBurgerAmount;
    private String mDescription;

    public BurgerItem(String data, Integer image, String Price, int BurgerAmount, String Description) {
        mdata=data;
        mImage=image;
        mBurgerAmount=BurgerAmount;
        mDescription=Description;
        mPrice=Price;
    }
    public void setmBurgerAmount(int mBurgerAmount) {
        this.mBurgerAmount = mBurgerAmount;
    }

    //SETS:
    public Integer getmImage() { return mImage; }
    public String getPrices() {
        return mPrice;
    }
    public String getMdata() {
        return mdata;
    }
    public int getmBurgerAmount() { return mBurgerAmount; }

}