package com.example.mohammadhusinaly.musicplayer;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.mohammadhusinaly.musicplayer.Manager.Validation;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private SharedPreferences settings;
    private SharedPreferences.Editor editor;

    private static final int LAUNCH_CAMERA_APP_REQUEST_CODE = 1;
    private static final int GALLERY_REQUEST_CODE = 2;


    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private View LoginButtonView;

    private boolean isAvatarSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        firstNameEditText = (EditText) findViewById(R.id.activity_profile_first_name_edit_text);
        lastNameEditText = (EditText) findViewById(R.id.activity_profile_last_name_edit_text);
        LoginButtonView = findViewById(R.id.activity_Login_profile_button);


        LoginButtonView.setOnClickListener(this);


        settings = getSharedPreferences(PREFS_USER_LOG, MODE_PRIVATE);
        editor = settings.edit();
    }

    @Override
    public void onClick(View v) {
        if(v == LoginButtonView){
            if (Validation.validationProfile(this, firstNameEditText, lastNameEditText,  isAvatarSet)){
                moveToAnotherActivity(MainActivity.class, true);
            }
        }
    }

}
