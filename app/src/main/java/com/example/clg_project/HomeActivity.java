package com.example.clg_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();

        ImageButton profileButton = (ImageButton) findViewById(R.id.profile);
        ImageButton mapButton = (ImageButton) findViewById(R.id.map);
        ImageButton passButton = (ImageButton) findViewById(R.id.pass);
        ImageButton settingButton = (ImageButton) findViewById(R.id.setting);

    }

    public void changeFragment(View view){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(view == findViewById(R.id.profile)){

           FragmentPerson fragment1 = new FragmentPerson();
          ft.replace(R.id.fragment,fragment1);
          ft.commit();

        }else if(view == findViewById(R.id.map)){

            FragmentMap fragment1 = new FragmentMap();
            ft.replace(R.id.fragment,fragment1);
            ft.commit();

        }else if(view == findViewById(R.id.pass)){

            FragmentPass fragment1 = new FragmentPass();
            ft.replace(R.id.fragment,fragment1);
            ft.commit();

        }else if(view == findViewById(R.id.setting)){

            FragmentSetting fragment1 = new FragmentSetting();
            ft.replace(R.id.fragment,fragment1);
            ft.commit();

        }
    }
}
