package com.example.clg_project;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class FragmentPerson extends Fragment {

    View view; Button formButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_person, container, false);
       formButton = view.findViewById(R.id.inputForm);
      formButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(getContext(),"hello there",Toast.LENGTH_SHORT).show();
              Context context;
                customDialogBoxPerson dialog = new customDialogBoxPerson();
//              dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//              dialog.setCancelable(false);
//              dialog.setContentView(R.layout.formdialogbox);
//              dialog.show();

              dialog.show(getFragmentManager(),"my custom dialog");
          }
      });
        return view;
    }

}
