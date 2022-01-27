package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class clickActivity extends AppCompatActivity {
    private static String TAG="Success";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "Change Activity success", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"clicked");
    }


}
