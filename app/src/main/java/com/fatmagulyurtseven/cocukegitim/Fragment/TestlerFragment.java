package com.fatmagulyurtseven.cocukegitim.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.fatmagulyurtseven.cocukegitim.Activity.HayvanlarTestActivity;
import com.fatmagulyurtseven.cocukegitim.Activity.IngilizceTestActivity;
import com.fatmagulyurtseven.cocukegitim.Activity.MatematikTestActivity;
import com.fatmagulyurtseven.cocukegitim.Activity.MeyvelerTestActivity;
import com.fatmagulyurtseven.cocukegitim.Activity.NumbersActivity;
import com.fatmagulyurtseven.cocukegitim.Activity.RenklerTestActivity;
import com.fatmagulyurtseven.cocukegitim.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestlerFragment extends Fragment {

    Button btnIngilizce, btnHayvanlar,btnRenkler,btnMeyveler,btnMatematik;
    public TestlerFragment( ) {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_testler, container, false);
        btnIngilizce=(Button ) view.findViewById(R.id.btningilizcetest);
        btnHayvanlar=(Button ) view.findViewById(R.id.btnhayvanlartest);
        btnRenkler=(Button ) view.findViewById(R.id.btnrenklertest);
        btnMeyveler=(Button ) view.findViewById(R.id.btnmeyvelertest);
        btnMatematik=(Button ) view.findViewById(R.id.btnmat);

        btnHayvanlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHayvan=new Intent(getActivity(), HayvanlarTestActivity.class);
                startActivity(intentHayvan);
            }
        });

        btnIngilizce.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentIng=new Intent(getActivity(), IngilizceTestActivity.class);
                startActivity(intentIng);
            }
        } );

        btnMeyveler.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMeyveler=new Intent(getActivity(), MeyvelerTestActivity.class);
                startActivity(intentMeyveler);
            }
        } );

        btnRenkler.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRenkler=new Intent(getActivity(), RenklerTestActivity.class);
                startActivity(intentRenkler);
            }
        } );
        btnMatematik.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMat=new Intent(getActivity(), MatematikTestActivity.class);
                startActivity(intentMat);
            }
        } );
        return view;
    }

}
