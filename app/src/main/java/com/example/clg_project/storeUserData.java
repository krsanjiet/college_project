package com.example.clg_project;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class storeUserData{

    String name,age,status,latitude,longitude,phoneNumber;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setLoction(String latitude, String longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setStatus(String status) {
        this.status = status;

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference covidRef = databaseReference.child("covid");
        covidRef.setValue("23");
        Log.i("DATABASE REFERENCE",covidRef.getParent().toString());


    }
}
