package com.example.login;

public class Cart {
    String dish_name=new String();
    String dish_price;
    int quantity;
    Cart()
    {quantity++;}
    Cart(String dn,String dp)
    {dish_name=dn;
        dish_price=dp;
        quantity++;
    }

    public String getDish_name() {
        return dish_name;
    }

    public String getDish_price() {
        return dish_price;
    }

    public int getQuantity() {
        return quantity;
    }
}
