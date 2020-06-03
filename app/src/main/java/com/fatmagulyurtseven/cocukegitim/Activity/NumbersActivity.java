package com.fatmagulyurtseven.cocukegitim.Activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.fatmagulyurtseven.cocukegitim.Helper.DatabaseHelper;
import com.fatmagulyurtseven.cocukegitim.Model.NumbersModel;
import com.fatmagulyurtseven.cocukegitim.Model.SayilarModel;
import com.fatmagulyurtseven.cocukegitim.R;

import java.io.IOException;
import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    int number=0;
    DatabaseHelper dbHelper;
    ArrayList<NumbersModel> numbers;
    TextView txtNumber ;
    TextView txtWrite;
    MediaPlayer ses;
    ImageButton backNumbers,nextNumbers,imgbtnSound;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        Toolbar toolbar = ( Toolbar ) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        backNumbers=findViewById(R.id.imgbtnGeriNumbers);
        nextNumbers=findViewById(R.id.imgbtnIleriNumbers);
        txtNumber = findViewById(R.id.txtNumbers);
        txtWrite = findViewById(R.id.txtNumbersWrite);
        imgbtnSound = findViewById(R.id.imgbtnSesNumbers);

        imgbtnSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberSounds();
            }
        });

        backNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ses.pause();
                if (number > 0) {
                    --number;
                    txtNumber.setText(String.valueOf(number));
                    NumberSounds();
                    Number();

                } else if (number == 0) {
                    number = 20;
                    txtNumber.setText(String.valueOf(number));
                    NumberSounds();
                    Number();

                } else if (number < 0) {
                    number = 20;
                    --number;
                    txtNumber.setText(String.valueOf(number));
                    NumberSounds();
                    Number();

                }
            }
        });
        nextNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ses.pause();
                if (number < 20) {
                    ++number;
                    txtNumber.setText(String.valueOf(number));
                    NumberSounds();
                    Number();

                } else if (number == 20) {
                    number = 0;
                    txtNumber.setText(String.valueOf(number));
                    NumberSounds();
                    Number();

                }
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        try
        {
            dbHelper = new DatabaseHelper(getApplicationContext());

        } catch (IOException e) {
            e.printStackTrace();
        }

        numbers = dbHelper.getNumbers();

        Number();
        NumberSounds();

    }
    public void Number(){
        String s=numbers.get(number).getNumberName();
        txtWrite.setText(s);
    }

    public void NumberSounds(){
        int sesId=getResources().getIdentifier(numbers.get(number).getNumberSound(),"raw",this.getPackageName());
        ses= MediaPlayer.create(NumbersActivity.this,sesId);
        ses.start();
    }

}
