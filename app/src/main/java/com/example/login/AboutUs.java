package com.example.login;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
public class AboutUs extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        drawerLayout=findViewById(R.id.drawer_layout);
    }
    public void Clickmenu(View view) {
        user_list.openDrawer(drawerLayout);
    }
    public void clicklogo(View view)
    {
        user_list.closeDrawer(drawerLayout);
    }
    public void clickHome(View view)
    {
        user_list.redirectActivity(this,user_list.class);
    }
    public void ClickFeedBack(View view)
    {
        user_list.redirectActivity(this,FeedBack.class);
    }
    public void ClickMenu(View view)
    {
        user_list.redirectActivity(this,FoodList.class);
    }
    public void ClickAboutUs(View view)
    {
        recreate();
    }
    public void ClickLogout(View view)
    {
        user_list.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        user_list.closeDrawer(drawerLayout);
    }
}

