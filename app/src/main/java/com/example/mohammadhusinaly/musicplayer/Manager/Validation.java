package com.example.mohammadhusinaly.musicplayer.Manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;

import static com.example.mohammadhusinaly.musicplayer.BaseActivity.PREFS_IF_ALREADY_LOG;
import static com.example.mohammadhusinaly.musicplayer.BaseActivity.PREFS_LASTNAME;
import static com.example.mohammadhusinaly.musicplayer.BaseActivity.PREFS_USERNAME;
import static com.example.mohammadhusinaly.musicplayer.BaseActivity.PREFS_USER_LOG;

/**
 * Created by mohammadhusinaly on 16/05/2017.
 */

public class Validation {
    private static boolean validateNoSpace(String str){
        return !str.isEmpty() && !str.contains(" ");
    }
    public static boolean validationProfile(Context context, EditText firstNameEditText, EditText lastNameEditText, boolean isAvatarSet) {
        String firstName = firstNameEditText.getText().toString().trim();
        String lastName = lastNameEditText.getText().toString().trim();
        boolean valid = true;
        if (firstName.isEmpty()){
            valid = false;
            firstNameEditText.setError("Empty User Name");
        }
        if (lastName.isEmpty()){
            valid = false;
            lastNameEditText.setError("Empty Password");
        }

        if (valid) {
            SharedPreferences settings = context.getSharedPreferences(PREFS_USER_LOG, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();

            editor.putBoolean(PREFS_IF_ALREADY_LOG,true);
            editor.putString(PREFS_USERNAME,firstName);
            editor.putString(PREFS_LASTNAME,lastName);
            editor.commit();

        }

        return valid;

    }
}
