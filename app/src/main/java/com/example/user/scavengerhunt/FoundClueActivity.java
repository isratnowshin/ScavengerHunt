package com.example.user.scavengerhunt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.user.scavengerhunt.DataObjects.Clue;

import java.util.ArrayList;

public class FoundClueActivity extends AppCompatActivity {
    SharedPreferences mSharedPref;
    String lastPath;
    int clueNum;
    int value;
    TextView text;
    Clue[] clues1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_clue);
        mSharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        Intent intent = getIntent();
        Uri uri = intent.getData();                 // retrieve a Uri object instance or
        lastPath = uri.getLastPathSegment();  // retrieve the string representation of the URI
        text = (TextView) findViewById(R.id.clueNum);
        clueNum=Integer.parseInt(lastPath);
        value = mSharedPref.getInt("userCurrentClue",0);
        if(clueNum==value){

                text.setText("Found the correct Clue");
        }
        else if(clueNum>value){
            text.setText("Whoops! Found a clue too early");
        }
        else{
            text.setText("This clue has already been found");
        }

    }

    public void finish(View v){
        String[] clues = getResources().getStringArray(R.array.clues);
        int n=clues.length;
        if (clueNum==2 && value==2){
            Intent i = new Intent(this,WinActivity.class);
            startActivity(i);
        }
        else if(clueNum==value){
            Intent i = new Intent(this,CurrentClueActivity.class);
            SharedPreferences.Editor editor = mSharedPref.edit();
            editor.putInt("userCurrentClue", value+1);
            editor.commit();
            startActivity(i);
        }
        else{
            Intent i = new Intent(this,CurrentClueActivity.class);
            startActivity(i);
        }
    }
}
