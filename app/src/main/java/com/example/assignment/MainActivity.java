package com.example.assignment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editTextTextPersonName;
    private EditText editTextTextEmailAddress;
    private EditText editTextTextPassword;
    private EditText width;
    private EditText hight;
    private Spinner  spinner;
    private Button button;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private static final String FLAG = "FLAG";
    private static final String BASEINFO = "BASEINFO";
    private boolean flag = false;

    public MainActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        setupSharedPrefs();
        checkPrefs();
    }
    protected void onPause() {
        super.onPause();
        Gson gson = new Gson();
        information bi = new information(editTextTextPersonName.getText().toString(),editTextTextEmailAddress.getText().toString(),editTextTextPassword.getText().toString(), width.getText().toString(),hight.getText().toString(),(char) spinner.getSelectedItem());
        String gsonString = gson.toJson(bi);
        editor.putString(BASEINFO, gsonString);
        flag = true;
        editor.putBoolean(FLAG,flag);
        editor.commit();
    }
    private void checkPrefs() {
        flag = prefs.getBoolean(FLAG, false);

        if (flag) {
            String basicInformation = prefs.getString(BASEINFO,null);
            Gson gson = new Gson();
            if (basicInformation != null) {
                information base = gson.fromJson(basicInformation, information.class);
                editTextTextPersonName.setText(base.getName());
                editTextTextEmailAddress.setText(base.getEmail());
                if(base.getGender() == 'F'){
                    spinner.setSelection(0);
                }else {
                    spinner.setSelection(1);
                }
                editTextTextPassword.setText(base.getPass());
                width.setText(base.getWidth());
                hight.setText(base.getHight());
            } else {
                Toast.makeText(this,"Data Not Found", Toast.LENGTH_SHORT).show();
            }


        }

    }
    private void setupSharedPrefs() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }
    private void setupViews() {

        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword= findViewById(R.id.editTextTextPassword);
        width = findViewById(R.id.width);
        hight = findViewById(R.id.hight);
        ArrayList<Character> gen = new ArrayList<Character>();
        gen.add('F');
        gen.add('M');
        ArrayAdapter<Character> adapter = new ArrayAdapter<Character>(this,android.R.layout.simple_spinner_item,gen);
        spinner.setAdapter(adapter);
        button =findViewById(R.id.button);

    }

}