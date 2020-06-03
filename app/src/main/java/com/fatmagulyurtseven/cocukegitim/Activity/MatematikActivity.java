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
import com.fatmagulyurtseven.cocukegitim.Model.HarflerModel;
import com.fatmagulyurtseven.cocukegitim.Model.MatematikModel;
import com.fatmagulyurtseven.cocukegitim.R;

import java.io.IOException;
import java.util.ArrayList;

public class MatematikActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    ArrayList<MatematikModel> matematik;
    ImageView islemResim;
    ImageButton btnIleriMat, btnGeriMat,btnSesMat;
    TextView islemsonuc;
    int matIndis = 0;
    Toolbar toolbar;
    MediaPlayer ses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematik);
        Toolbar toolbar = ( Toolbar ) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnGeriMat=findViewById(R.id.imgbtnGeriMat);
        btnIleriMat=findViewById(R.id.imgbtnIleriMat);
        islemResim=findViewById(R.id.imgmatResim);
        btnSesMat=findViewById(R.id.imgbtnSesMat);

        btnSesMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MatSesleri();
            }
        });

        btnGeriMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ses.pause();
                if (matIndis > 0) {
                    matIndis--;
                    MatSesleri();
                    MatBilgisiGetir();


                }
                else if(matIndis==0){
                    matIndis=matematik.size()-1;
                    MatSesleri();
                    MatBilgisiGetir();

                }
                else if(matIndis<0){
                    matIndis=matematik.size()-1;
                    --matIndis;
                    MatSesleri();
                    MatBilgisiGetir();

                }
            }
        });
        btnIleriMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ses.pause();
                if (matIndis < matematik.size()-1) {
                    matIndis++;
                    MatSesleri();
                    MatBilgisiGetir();
                }
                else if (matIndis == matematik.size()-1) {
                    matIndis = 0;
                    MatSesleri();
                    MatBilgisiGetir();

                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        try {

            dbHelper = new DatabaseHelper(getApplicationContext());

        } catch (IOException e) {
            e.printStackTrace();
        }
        matematik = dbHelper.getMatematik();
        MatBilgisiGetir();
        MatSesleri();

    }
    public void MatBilgisiGetir( ) {

        int imgmatId = getResources().getIdentifier(matematik.get(matIndis).getIslemResmi(), "drawable", this.getPackageName());
        islemResim.setImageResource(imgmatId);
    }
    public void MatSesleri(){
        int matId=getResources().getIdentifier(matematik.get(matIndis).getIslemSes(),"raw",this.getPackageName());
        ses= MediaPlayer.create(MatematikActivity.this,matId);
        ses.start();
    }

}
