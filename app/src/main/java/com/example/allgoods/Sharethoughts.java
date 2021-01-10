package com.example.allgoods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Sharethoughts extends AppCompatActivity {
    DrawerLayout drawerLayout;
    EditText etText;
    Button btnsave,btnview;
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharethoughts);

        drawerLayout = findViewById(R.id.drawer_layout);

        etText = (EditText) findViewById(R.id.et_text);
        btnsave = (Button) findViewById(R.id.btn_add);
        btnview = (Button) findViewById(R.id.btn_viewdata);

        myDB = new DatabaseHelper(this);

        btnsave.setOnClickListener(v -> {
            //get text from editText
            String newEntry = etText.getText().toString();
            if(etText.length() != 0){
                AddData(newEntry);
                etText.setText("");
            }else{
                Toast.makeText(Sharethoughts.this, "You Must put something in the text field",Toast.LENGTH_SHORT).show();
            }
        });

        btnview.setOnClickListener(v -> {
            Intent intent = new Intent(Sharethoughts.this,ViewListContent.class);
            startActivity(intent);
        });
    }

    public void AddData(String newEntry){
        boolean insertData = myDB.addData(newEntry);

        if(insertData==true){
            Toast.makeText(Sharethoughts.this,"Successfully Entered Data",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(Sharethoughts.this,"Something went wrong",Toast.LENGTH_SHORT).show();
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