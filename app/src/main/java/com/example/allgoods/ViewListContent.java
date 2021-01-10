package com.example.allgoods;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import java.util.ArrayList;

public class ViewListContent extends AppCompatActivity {
    DatabaseHelper myDB;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_list_content);

        ListView listView = (ListView) findViewById(R.id.listview);

        drawerLayout = findViewById(R.id.drawer_layout);

        myDB = new DatabaseHelper(this);

        ArrayList<String> thelist = new ArrayList<>();
        Cursor data = myDB.getListContents();

        if(data.getCount() == 0){
            Toast.makeText(ViewListContent.this, "You Must put something in the text field",Toast.LENGTH_SHORT).show();
        }else {
            while (data.moveToNext()){
                thelist.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,thelist);
                listView.setAdapter(listAdapter);
            }
        }
    }
    public void ClickMenu1(View view){
        Sidebar.openDrawer(drawerLayout);
    }
    public void Clicklogo(View view){
        //close drawer
        Sidebar.closeDrawer(drawerLayout);
    }
    public void ClickCategories(View view){
        //redirect to categories
        Sidebar.redirectActivity(this, Sidebar.class);
    }
    public void ClickSharethoughts(View view){
        //recreate activity
        recreate();
    }
    public void ClickAboutus(View view){
        //redirect to about us
        Sidebar.redirectActivity(this, Aboutus.class);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        Sidebar.closeDrawer(drawerLayout);
    }
}
