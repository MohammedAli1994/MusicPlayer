package com.example.mohammadhusinaly.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mohammadhusinaly on 16/05/2017.
 */

public class BaseActivity extends AppCompatActivity {

    public static final String PREFS_USERNAME = "username";
    public static final String PREFS_IF_ALREADY_LOG = "if";
    public static final String PREFS_LASTNAME = "password";
    public static final String PREFS_USER_LOG = "myprefs";


    protected void moveToAnotherActivity(Class targetClass, boolean closeRecentActivity){
        Intent intent = new Intent(this, targetClass);
        startActivity(intent);
        if (closeRecentActivity){
            finish();
        }
    }
}
