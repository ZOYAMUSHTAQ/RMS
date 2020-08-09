package com.example.login;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class Menu extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Button btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        drawerLayout=findViewById(R.id.drawer_layout);
        btnList = (Button) findViewById(R.id.btnList);
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, FoodList.class);
                startActivity(intent);
            }
        });
    }
    public void Clickmenu(View view) {
        user_list.openDrawer(drawerLayout);
    }
    public void ClickFeedBack(View view)
    {
        user_list.redirectActivity(this,FeedBack.class);
    }
    public void clicklogo(View view)
    {
        user_list.closeDrawer(drawerLayout);
    }
    public void clickHome(View view)
    {
        user_list.redirectActivity(this,user_list.class);
    }
    public void ClickMenu(View view)
    {
        recreate();
    }
    public void ClickAboutUs(View view)
    {
        user_list.redirectActivity(this,AboutUs.class);
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
