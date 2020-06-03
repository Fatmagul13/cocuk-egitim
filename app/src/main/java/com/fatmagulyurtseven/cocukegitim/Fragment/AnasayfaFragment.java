package com.fatmagulyurtseven.cocukegitim.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.fatmagulyurtseven.cocukegitim.Activity.HarflerActivity;
import com.fatmagulyurtseven.cocukegitim.Activity.HayvanlarActivity;
import com.fatmagulyurtseven.cocukegitim.Activity.MatematikActivity;
import com.fatmagulyurtseven.cocukegitim.Activity.MesleklerActivity;
import com.fatmagulyurtseven.cocukegitim.Activity.MevsimlerActivity;
import com.fatmagulyurtseven.cocukegitim.Activity.MeyvelerActivity;
import com.fatmagulyurtseven.cocukegitim.Activity.RenklerActivity;
import com.fatmagulyurtseven.cocukegitim.Activity.SayilarActivity;
import com.fatmagulyurtseven.cocukegitim.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnasayfaFragment extends Fragment {


    public AnasayfaFragment( ) {
        // Required empty public constructor
    }

    ImageButton imgSayilar,imgHarfler,imgHayvanlar,imgMeslekler,imgMatematik,imgMevsimler,imgRenkler,imgMeyveler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_anasayfa, container, false);
         imgSayilar=(ImageButton )view.findViewById(R.id.imgButonSayilar);
         imgHarfler=(ImageButton)view.findViewById(R.id.imgButonHarfler);
         imgHayvanlar=(ImageButton)view.findViewById(R.id.imgButonHayvanlar);
         imgMeslekler=(ImageButton)view.findViewById(R.id.imgButonMeslek);
         imgMatematik=(ImageButton)view.findViewById(R.id.imgButonMatematik);
         imgMevsimler=(ImageButton)view.findViewById(R.id.imgButonMevsimler);
         imgRenkler=(ImageButton)view.findViewById(R.id.imgButonRenkler);
         imgMeyveler=(ImageButton)view.findViewById(R.id.imgButonMeyveler);

        imgSayilar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSayi=new Intent(getActivity(), SayilarActivity.class);
                startActivity(intentSayi);
            }
        });
        imgHarfler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHarfler=new Intent(getActivity(), HarflerActivity.class);
                startActivity(intentHarfler);

            }
        });
        imgHayvanlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHayvanlar=new Intent(getActivity(), HayvanlarActivity.class);
                startActivity(intentHayvanlar);
            }
        });
        imgMeyveler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMeyveler=new Intent(getActivity(), MeyvelerActivity.class);
                startActivity(intentMeyveler);
            }
        });
        imgMeslekler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMeslekler=new Intent(getActivity(), MesleklerActivity.class);
                startActivity(intentMeslekler);
            }
        });
        imgRenkler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRenkler=new Intent(getActivity(), RenklerActivity.class);
                startActivity(intentRenkler);
            }
        });
        imgMevsimler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMevsimler=new Intent(getActivity(), MevsimlerActivity.class);
                startActivity(intentMevsimler);
            }
        });
        imgMatematik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMatematik=new Intent(getActivity(), MatematikActivity.class);
                startActivity(intentMatematik);
            }
        });
        return view;
    }

}
