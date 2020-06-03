package com.fatmagulyurtseven.cocukegitim.Activity;

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
import android.widget.Toast;

import com.fatmagulyurtseven.cocukegitim.Helper.DatabaseHelper;
import com.fatmagulyurtseven.cocukegitim.Model.ObjectsModel;
import com.fatmagulyurtseven.cocukegitim.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class IngilizceTestActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    ArrayList<ObjectsModel> object;
    ImageView objectResim;
    ImageButton ileriSoruObject, geriSoruObject;
    Button secenekA,secenekB,secenekC,secenekD;
    int objectIndis = 0;
    String cevap;
    Random rnd = new Random();
    int uretilenSayi1 = rnd.nextInt(16);
    int uretilenSayi2 = rnd.nextInt(16);
    int uretilenSayi3 = rnd.nextInt(16);
    int uretilenSayi4 =rnd.nextInt(16);
    String a,b,c,d;
    TextView txtPuan;
    int puan=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_ingilizce_test );
        Toolbar toolbar = ( Toolbar ) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
        secenekA = findViewById(R.id.btnIngA);
        secenekB = findViewById(R.id.btnIngB);
        secenekC = findViewById(R.id.btnIngC);
        secenekD = findViewById(R.id.btnIngD);
        objectResim = findViewById(R.id.testIngRes);
        ileriSoruObject=findViewById(R.id.ileriSoruIng);
        txtPuan = findViewById(R.id.txtPuanIng);
        try {

            dbHelper = new DatabaseHelper(getApplicationContext());

        } catch (IOException e) {
            e.printStackTrace();
        }
        object = dbHelper.getObjects();
        ObjectBilgisiGetir();
        secenekAta();

        ileriSoruObject.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secenekA.setBackgroundResource(R.color.colorTest);
                secenekB.setBackgroundResource(R.color.colorTest);
                secenekC.setBackgroundResource(R.color.colorTest);
                secenekD.setBackgroundResource(R.color.colorTest);

                secenekA.setEnabled( true );
                secenekB.setEnabled( true );
                secenekC.setEnabled( true );
                secenekD.setEnabled( true );

                if (objectIndis < object.size()-1) {
                    objectIndis++;
                    ObjectBilgisiGetir();
                    secenekAta();

                }
                if (objectIndis == object.size()-1) {
                  //  objectIndis = 0;
                    ObjectBilgisiGetir();
                    secenekAta();
                    Toast.makeText(getApplicationContext(),"TEBRİKLER! TESTİ TAMAMLADINIZ.. PUANINIZ :"+puan, Toast.LENGTH_LONG).show();

                }
            }
        } );
        secenekA.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secenekB.setEnabled( false );
                secenekC.setEnabled( false );
                secenekD.setEnabled( false );


                if (a== cevap ) {
                    secenekA.setBackgroundResource(R.color.green);
                    puan+=10;
                    txtPuan.setText(Integer.toString(puan));
                }
                else {
                    secenekA.setBackgroundResource(R.color.red);
                    if(puan>0){
                        puan-=10;
                    }
                    txtPuan.setText(Integer.toString(puan));
                }
            }
        } );
        secenekB.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secenekA.setEnabled( false );
                secenekC.setEnabled( false );
                secenekD.setEnabled( false );
                if (b== cevap ) {
                    secenekB.setBackgroundResource(R.color.green);
                    puan+=10;
                    txtPuan.setText(Integer.toString(puan));
                }
                else{
                    secenekB.setBackgroundResource(R.color.red);
                    if(puan>0){
                        puan-=10;
                    }
                    txtPuan.setText(Integer.toString(puan));
                }

            }
        } );
        secenekC.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secenekB.setEnabled( false );
                secenekA.setEnabled( false );
                secenekD.setEnabled( false );
                if (c== cevap ) {
                    secenekC.setBackgroundResource(R.color.green);
                    puan+=10;
                    txtPuan.setText(Integer.toString(puan));
                }
                else  {
                    secenekC.setBackgroundResource(R.color.red);
                    if(puan>0){
                        puan-=10;
                    }
                    txtPuan.setText(Integer.toString(puan));
                }

            }
        } );
        secenekD.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secenekB.setEnabled( false );
                secenekC.setEnabled( false );
                secenekA.setEnabled( false );
                if(d==cevap ) {
                    secenekD.setBackgroundResource(R.color.green);
                    puan+=10;
                    txtPuan.setText(Integer.toString(puan));
                }
                else {
                    secenekD.setBackgroundResource(R.color.red);
                    if(puan>0){
                        puan-=10;
                    }
                    txtPuan.setText(Integer.toString(puan));
                }

            }
        } );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
    }
    public void ObjectBilgisiGetir( ) {

        String s=object.get(objectIndis).getObjectName();
        cevap= s.toString();
        int imgId = getResources().getIdentifier(object.get(objectIndis).getObjectImage(), "drawable", this.getPackageName());
        objectResim.setImageResource(imgId);

    }
    public void secenekAta(){


        sayiKontrol();

        a=object.get(uretilenSayi1).getObjectName();
        b=object.get(uretilenSayi2).getObjectName();
        c=object.get(uretilenSayi3).getObjectName();
        d=object.get(uretilenSayi4).getObjectName();

        while (a!=cevap && b!=cevap && c!=cevap && d!=cevap ) {
            uretilenSayi1 = rnd.nextInt(16);
            uretilenSayi2 = rnd.nextInt(16);
            uretilenSayi3 = rnd.nextInt(16);
            uretilenSayi4 =rnd.nextInt(16);
            sayiKontrol();
            a=object.get(uretilenSayi1).getObjectName();
            b=object.get(uretilenSayi2).getObjectName();
            c=object.get(uretilenSayi3).getObjectName();
            d=object.get(uretilenSayi4).getObjectName();
        }


        secenekA.setText(a);
        secenekB.setText(b);
        secenekC.setText(c);
        secenekD.setText(d);



    }
    public void sayiKontrol(){
        if(uretilenSayi1==uretilenSayi2){
            uretilenSayi2 = rnd.nextInt(16);
        }
        if(uretilenSayi1==uretilenSayi3||uretilenSayi2==uretilenSayi3){
            uretilenSayi3 = rnd.nextInt(16);
        }
        if(uretilenSayi1==uretilenSayi4||uretilenSayi2==uretilenSayi4||uretilenSayi3==uretilenSayi4){
            uretilenSayi4=rnd.nextInt(16);
        }
    }

}
