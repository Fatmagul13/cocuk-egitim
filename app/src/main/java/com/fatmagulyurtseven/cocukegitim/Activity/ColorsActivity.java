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
import android.widget.ImageView;
import android.widget.TextView;

import com.fatmagulyurtseven.cocukegitim.Helper.DatabaseHelper;
import com.fatmagulyurtseven.cocukegitim.Model.ColorsModel;
import com.fatmagulyurtseven.cocukegitim.Model.RenklerModel;
import com.fatmagulyurtseven.cocukegitim.R;

import java.io.IOException;
import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;
    ArrayList<ColorsModel> colors;
    ImageView colorImage;
    TextView colorName;
    ImageButton backColor,nextColor,imgbtnsesColor;
    MediaPlayer colorSound;
    int colorIndis = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        Toolbar toolbar = ( Toolbar ) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        backColor=findViewById(R.id.imgbtnGeriColors);
        nextColor=findViewById(R.id.imgbtnIleriColors);
        colorName = findViewById(R.id.txtColorsIsim);
        colorImage = (ImageView ) findViewById(R.id.imgRenkColors);
        imgbtnsesColor=findViewById(R.id.imgbtnSesColors);

        backColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorSound.pause();
                if (colorIndis > 0) {
                    colorIndis--;
                    colorSounds();
                    colorInformation();


                }
                else if(colorIndis==0){
                    colorIndis=colors.size()-1;
                    colorSounds();
                    colorInformation();

                }
                else if(colorIndis<0){
                    colorIndis=colors.size()-1;
                    --colorIndis;
                    colorSounds();
                    colorInformation();

                }
            }
        });
        nextColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorSound.pause();
                if (colorIndis < colors.size()-1) {
                    colorIndis++;

                    colorSounds();
                    colorInformation();
                }
                else if (colorIndis == colors.size()-1) {
                    colorIndis = 0;
                    colorSounds();
                    colorInformation();

                }
            }
        });
        imgbtnsesColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorSounds();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        try {

            dbHelper = new DatabaseHelper(getApplicationContext());

        } catch (IOException e) {
            e.printStackTrace();
        }
        colors = dbHelper.getColors();
        colorSounds();
        colorInformation();

    }

    public void colorInformation(){
        String s=colors.get(colorIndis).getColorName();
        colorName.setText(s);
        int imgId = getResources().getIdentifier(colors.get(colorIndis).getColorImage(), "drawable", this.getPackageName());
        colorImage.setImageResource(imgId);
    }
   public void colorSounds(){
        int renksesId=getResources().getIdentifier(colors.get(colorIndis).getColorSound(),"raw",this.getPackageName());
        colorSound= MediaPlayer.create(ColorsActivity.this,renksesId);
        colorSound.start();
    }

}
