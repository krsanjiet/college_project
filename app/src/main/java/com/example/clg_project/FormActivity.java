package com.example.clg_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Arrays;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        getSupportActionBar().hide();
        final boolean[] flag1 = new boolean[3];
        Arrays.fill(flag1,false);
        final storeUserData storeuserdata = new storeUserData();
        //    final FragmentPerson fragment = (FragmentPerson)getActivity().getSupportFragmentManager().findFragmentByTag("my_custom_dialog");
        final EditText name = findViewById(R.id.userName);
        final  EditText age = findViewById(R.id.userAge);
        RadioButton mRadio = findViewById(R.id.maleRadio);

        final RadioButton fever = findViewById(R.id.fever);
        final RadioButton cough = findViewById(R.id.cough);
        final RadioButton tiredness = findViewById(R.id.tiredness);
        final RadioButton loss = findViewById(R.id.loss);
        final RadioButton pain = findViewById(R.id.pain);
        final RadioButton breathing = findViewById(R.id.breathing);
        final RadioButton fine = findViewById(R.id.ok);
        Button submitBtn = findViewById(R.id.submitButton);
        Button cancelBtn = findViewById(R.id.cancelButton);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().length() == 0){
                    Toast.makeText(getApplicationContext(),"PLEASE ENTER YOUR NAME",Toast.LENGTH_SHORT).show();

                }else if(age.getText().length() == 0){
                    Toast.makeText(getApplicationContext(),"PLEASE ENTER YOUR AGE",Toast.LENGTH_SHORT).show();

                }
                else{
                    // fragment.profileName = name.getText().toString();
                    //   fragment.age = age.getText().toString();
                    storeuserdata.setName(name.getText().toString());
                    storeuserdata.setAge(age.getText().toString());
                    flag1[0] = true; flag1[1] = true;
                }

                if(loss.isChecked() || pain.isChecked() || breathing.isChecked()){
                    storeuserdata.setStatus("red");
                    flag1[2] = true;
                }else if(fever.isChecked() || cough.isChecked() || tiredness.isChecked()){
                    storeuserdata.setStatus("orange");
                    flag1[2] = true;
                }else if(fine.isChecked() ){
                    storeuserdata.setStatus("green");
                    flag1[2] = true;
                }else{
                    Toast.makeText(getApplicationContext(),"PLEASE SELECT ANY SYMPTOMS.",Toast.LENGTH_SHORT).show();
                }

                Log.i("FLAG STATUS", String.valueOf(flag1[0])+" "+String.valueOf(flag1[1])+" "+String.valueOf(flag1[2]));
                if(flag1[0] && flag1[1]  && flag1[2] ){
                   startActivity(new Intent(FormActivity.this,HomeActivity.class));
                }
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FormActivity.this,HomeActivity.class));
            }
        });
    }
}
