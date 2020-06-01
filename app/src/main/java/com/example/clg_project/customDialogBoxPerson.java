package com.example.clg_project;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Arrays;
import java.util.zip.Inflater;

public class customDialogBoxPerson extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.formdialogbox,container,false);

        final boolean[] flag1 = new boolean[3];
        Arrays.fill(flag1,false);
        final storeUserData storeuserdata = new storeUserData();
    //    final FragmentPerson fragment = (FragmentPerson)getActivity().getSupportFragmentManager().findFragmentByTag("my_custom_dialog");
              final EditText name = view.findViewById(R.id.userName);
             final  EditText age = view.findViewById(R.id.userAge);
              RadioButton mRadio = view.findViewById(R.id.maleRadio);

             final RadioButton fever = view.findViewById(R.id.fever);
             final RadioButton cough = view.findViewById(R.id.cough);
             final RadioButton tiredness = view.findViewById(R.id.tiredness);
             final RadioButton loss = view.findViewById(R.id.loss);
             final RadioButton pain = view.findViewById(R.id.pain);
             final RadioButton breathing = view.findViewById(R.id.breathing);
             final RadioButton fine = view.findViewById(R.id.ok);
              Button submitBtn = view.findViewById(R.id.submitButton);
              Button cancelBtn = view.findViewById(R.id.cancelButton);


            submitBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(name.getText().length() == 0){
                        Toast.makeText(getActivity(),"PLEASE ENTER YOUR NAME",Toast.LENGTH_SHORT).show();

                    }else if(age.getText().length() == 0){
                        Toast.makeText(getActivity(),"PLEASE ENTER YOUR AGE",Toast.LENGTH_SHORT).show();

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
                        Toast.makeText(getActivity(),"PLEASE SELECT ANY SYMPTOMS.",Toast.LENGTH_SHORT).show();
                    }

                    Log.i("FLAG STATUS", String.valueOf(flag1[0])+" "+String.valueOf(flag1[1])+" "+String.valueOf(flag1[2]));
                    if(flag1[0] && flag1[1]  && flag1[2] ){
                        getDialog().dismiss();
                    }
                }
            });

            cancelBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getDialog().dismiss();
                }
            });

        return view;
    }
}
