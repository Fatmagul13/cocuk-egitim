package com.fatmagulyurtseven.cocukegitim.Activity;


import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
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

import com.fatmagulyurtseven.cocukegitim.Fragment.TestlerFragment;
import com.fatmagulyurtseven.cocukegitim.Helper.DatabaseHelper;
import com.fatmagulyurtseven.cocukegitim.Model.AnimalsModel;
import com.fatmagulyurtseven.cocukegitim.Model.HayvanlarModel;
import com.fatmagulyurtseven.cocukegitim.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class HayvanlarTestActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    ArrayList<HayvanlarModel> hayvan;
    ImageView hayvanResim;
    ImageButton ileriSoruHayvanlar, geriSoruHayvanlar;
   // Button secenekA=new Button("Button");
    Button secenekA,secenekB,secenekC,secenekD;
    int hayvanIndis = 0;
    String cevap;
    Random rnd = new Random();
    int uretilenSayi1 = rnd.nextInt(15);
    int uretilenSayi2 = rnd.nextInt(15);
    int uretilenSayi3 = rnd.nextInt(15);
    int uretilenSayi4 =rnd.nextInt(15);
    String a,b,c,d;
    public Button r;
    public Boolean dogruCevap;
    TextView txtPuan;
    int puan=0;
    TestlerFragment frTest=new TestlerFragment();
    FragmentManager manager=getFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hayvanlar_test);
        Toolbar toolbar = ( Toolbar ) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        secenekA = findViewById(R.id.btnHayvanlarA);
        secenekB = findViewById(R.id.btnHayvanlarB);
        secenekC = findViewById(R.id.btnHayvanlarC);
        secenekD = findViewById(R.id.btnHayvanlarD);
        hayvanResim = findViewById(R.id.testHayvanRes);
        ileriSoruHayvanlar=findViewById(R.id.ileriSoruHayvan);
        txtPuan = findViewById(R.id.txtPuanHayvan);

        try {

            dbHelper = new DatabaseHelper(getApplicationContext());

        } catch (IOException e) {
            e.printStackTrace();
        }
        hayvan = dbHelper.getHayvanlar();
        HayvanBilgisiGetir();
        secenekAta();


        ileriSoruHayvanlar.setOnClickListener(new View.OnClickListener() {
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

                if (hayvanIndis < hayvan.size()-1) {
                    hayvanIndis++;
                    HayvanBilgisiGetir();
                    secenekAta();

                }
                 if (hayvanIndis == hayvan.size()-1) {
                    //hayvanIndis = 0;
                    HayvanBilgisiGetir();
                    secenekAta();
                     //sonucGoster();

                     Toast.makeText(getApplicationContext(),"TEBRİKLER! TESTİ TAMAMLADINIZ.. PUANINIZ :"+puan, Toast.LENGTH_LONG).show();

                }

            }
        });
        secenekA.setOnClickListener(new View.OnClickListener() {
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
        });

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
                        txtPuan.setText(Integer.toString(puan));
                    }
                }
            }
        } );
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public void HayvanBilgisiGetir( ) {
         String s=hayvan.get(hayvanIndis).getHayvanAdi();
          cevap= s.toString();

        int imgId = getResources().getIdentifier(hayvan.get(hayvanIndis).getHayvanResim(), "drawable", this.getPackageName());
        hayvanResim.setImageResource(imgId);


    }
    public void secenekAta(){


        sayiKontrol();

         a=hayvan.get(uretilenSayi1).getHayvanAdi();
         b=hayvan.get(uretilenSayi2).getHayvanAdi();
         c=hayvan.get(uretilenSayi3).getHayvanAdi();
         d=hayvan.get(uretilenSayi4).getHayvanAdi();

        while (a!=cevap && b!=cevap && c!=cevap && d!=cevap ) {
             uretilenSayi1 = rnd.nextInt(15);
             uretilenSayi2 = rnd.nextInt(15);
             uretilenSayi3 = rnd.nextInt(15);
             uretilenSayi4 =rnd.nextInt(15);
             sayiKontrol();
             a=hayvan.get(uretilenSayi1).getHayvanAdi();
             b=hayvan.get(uretilenSayi2).getHayvanAdi();
             c=hayvan.get(uretilenSayi3).getHayvanAdi();
             d=hayvan.get(uretilenSayi4).getHayvanAdi();
        }


        secenekA.setText(a);
        secenekB.setText(b);
        secenekC.setText(c);
        secenekD.setText(d);



    }
    public void sayiKontrol(){
        if(uretilenSayi1==uretilenSayi2){
            uretilenSayi2 = rnd.nextInt(15);
        }
        if(uretilenSayi1==uretilenSayi3||uretilenSayi2==uretilenSayi3){
            uretilenSayi3 = rnd.nextInt(15);
        }
        if(uretilenSayi1==uretilenSayi4||uretilenSayi2==uretilenSayi4||uretilenSayi3==uretilenSayi4){
            uretilenSayi4=rnd.nextInt(15);
        }
    }
    public void sonucGoster(){
        AlertDialog.Builder builder = new AlertDialog.Builder(HayvanlarTestActivity.this);
        builder.setTitle("ÇOCUK EĞİTİMİ");

            builder.setMessage("TEBRİKLER! TESTİ TAMAMLADINIZ.. PUANINIZ : "+puan);


        builder.setNeutralButton("TAMAM", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {


                manager.beginTransaction().replace( R.id.matTest,frTest,frTest.getTag()).commit();

            }
        });
        builder.show();
    }


}
