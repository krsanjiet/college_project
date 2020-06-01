package com.example.clg_project;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class FragmentPerson extends Fragment {

    View view;
    Button formButton;
    EditText phoneNumber;
    public TextView personName;
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    String longtitude,lagtitude;
    Thread thread1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final Location gps_loc;

        view = inflater.inflate(R.layout.fragment_person, container, false);
        formButton = view.findViewById(R.id.inputForm);
        personName = view.findViewById(R.id.userName);
        phoneNumber = view.findViewById(R.id.phoneEditText);
        final TextView personAge = view.findViewById(R.id.userAge);



        if(ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        }else{
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        }

        locationManager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);
        final boolean gps_enable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (gps_enable) {
            gps_loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Log.i("CURRENT GPS LOCATION ",String.valueOf(gps_loc.getLatitude())+" "+String.valueOf(gps_loc.getLongitude()));
            lagtitude = String.valueOf(gps_loc.getLatitude());
            longtitude = String.valueOf(gps_loc.getLongitude());
        }else{
            Toast.makeText(getContext(),"ENABLING GPS", Toast.LENGTH_SHORT).show();
        }

      formButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(getContext(),phoneNumber.getText().toString(),Toast.LENGTH_SHORT).show();
                if(!phoneNumber.getText().toString().isEmpty()){
                     thread1 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                             storeUserData storeUserData1 = new storeUserData();
                            storeUserData1.setPhoneNumber(phoneNumber.getText().toString());
                            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
                            DatabaseReference covidRef = databaseReference.child("covid/"+phoneNumber.getText().toString());
                            covidRef.child("longLoc").setValue(longtitude);
                            covidRef.child("latLoc").setValue(lagtitude);
                        }
                    });
                    thread1.start();
                    startActivity(new Intent(getActivity(),FormActivity.class));
                }


          }
      });
        return view;
    }



}
