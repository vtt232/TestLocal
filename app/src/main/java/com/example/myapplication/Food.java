package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Food {
    public String mealName;
    public String mealArea;

    public Food(String _mealName, String _mealArea)
    {
        mealName = _mealName;
        mealArea = _mealArea;
    }

    public String getMealArea() {
        return mealArea;
    }

    public String getMealName() {
        return mealName;
    }
}
