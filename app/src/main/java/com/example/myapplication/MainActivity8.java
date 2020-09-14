package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity8 extends AppCompatActivity {

    private arraybean[] a = new arraybean[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        a[0] = new arraybean("123");
        a[1] = new arraybean("456");
        a[2] = new arraybean("789");
        Log.d("xone", "onCreate: ------"+a[0].toString());
    }
}