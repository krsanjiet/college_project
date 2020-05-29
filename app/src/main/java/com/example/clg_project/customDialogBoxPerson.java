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

import java.util.zip.Inflater;

public class customDialogBoxPerson extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.formdialogbox,container,false);

              final EditText name = view.findViewById(R.id.userName);
              EditText age = view.findViewById(R.id.userAge);
              RadioButton mRadio = view.findViewById(R.id.maleRadio);

              RadioButton fever = view.findViewById(R.id.fever);
              RadioButton cough = view.findViewById(R.id.cough);
              RadioButton tiredness = view.findViewById(R.id.tiredness);
              RadioButton loss = view.findViewById(R.id.loss);
              RadioButton pain = view.findViewById(R.id.pain);
              RadioButton breathing = view.findViewById(R.id.breathing);

              Button submitBtn = view.findViewById(R.id.submitButton);
              Button cancelBtn = view.findViewById(R.id.cancelButton);

        Log.d("EVERYTHING IS FINE ", "OK .... ");
            submitBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("MESSAGE FROM DIALOG", String.valueOf(name.getText()));
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
