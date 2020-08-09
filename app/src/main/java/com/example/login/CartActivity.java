package com.example.login;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



public class CartActivity extends AppCompatActivity {
    RecyclerView recycler_itemlist;
    public static TextView tv_total;
    //CartListAdapter cartListAdapter;
    public static int total=0;
    String jsonCartList;
    DatabaseHelper dh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        recycler_itemlist=findViewById(R.id.recycler_cart);
        recycler_itemlist.setLayoutManager(new LinearLayoutManager(this));
        String[] languages={"java","ulu","anda","paratha"};
        Intent intent=getIntent();
        dh=new DatabaseHelper(this);
        String c1=intent.getStringExtra("added_dishname");
        String c2=intent.getStringExtra("added_dishprice");
        Cart cart=new Cart(c1,c2);
        dh.addtocart(cart);
        dh.showcart();
        recycler_itemlist.setAdapter(new OrderAdapter(dh.carts));
    }}