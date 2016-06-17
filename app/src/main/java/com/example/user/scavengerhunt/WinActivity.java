package com.example.user.scavengerhunt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WinActivity extends AppCompatActivity {
    SharedPreferences mSharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        mSharedPref = PreferenceManager.getDefaultSharedPreferences(this);
    }
    public void restart_game(View view){
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.clear();
        editor.commit();
        Intent i = new Intent(this,StartingDescriptionActivity.class);
        startActivity(i);
    }
}
