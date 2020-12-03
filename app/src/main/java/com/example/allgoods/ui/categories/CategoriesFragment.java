package com.example.allgoods.ui.categories;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.allgoods.R;
import com.example.allgoods.Sidebar;
import com.example.allgoods.StartingActivity;

public class CategoriesFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.categories, container, false);


        ImageView imageView = (ImageView) root.findViewById(R.id.emotional);
        imageView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                 fragmentTransaction.replace(R.id.categories);
             }
         });

        return root;

    }


}