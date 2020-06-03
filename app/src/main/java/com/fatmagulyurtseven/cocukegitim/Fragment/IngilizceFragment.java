package com.fatmagulyurtseven.cocukegitim.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.fatmagulyurtseven.cocukegitim.Activity.AnimalsActivity;
import com.fatmagulyurtseven.cocukegitim.Activity.ColorsActivity;
import com.fatmagulyurtseven.cocukegitim.Activity.DrinksActivity;
import com.fatmagulyurtseven.cocukegitim.Activity.FruitsActivity;
import com.fatmagulyurtseven.cocukegitim.Activity.NumbersActivity;
import com.fatmagulyurtseven.cocukegitim.Activity.ObjectsActivity;
import com.fatmagulyurtseven.cocukegitim.Activity.SayilarActivity;
import com.fatmagulyurtseven.cocukegitim.Model.AnimalsModel;
import com.fatmagulyurtseven.cocukegitim.Model.ColorsModel;
import com.fatmagulyurtseven.cocukegitim.Model.NumbersModel;
import com.fatmagulyurtseven.cocukegitim.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IngilizceFragment extends Fragment {


    public IngilizceFragment( ) {
        // Required empty public constructor
    }

    ImageButton imgNumbers,imgDrinks,imgColors,imgFruits,imgObjects,imgAnimals;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_ingilizce, container, false);
        imgNumbers=(ImageButton )view.findViewById(R.id.imgButonNumbers);
        imgAnimals=(ImageButton)view.findViewById(R.id.imgButonAnimals);
        imgColors=(ImageButton)view.findViewById(R.id.imgButonColors);
        imgDrinks=(ImageButton)view.findViewById(R.id.imgButonDrinks);
        imgFruits=(ImageButton)view.findViewById(R.id.imgButonFruits);
        imgObjects=(ImageButton)view.findViewById(R.id.imgButonObjects);

        imgNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNumbers=new Intent(getActivity(), NumbersActivity.class);
                startActivity(intentNumbers);
            }
        });
        imgAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAnimals=new Intent(getActivity(), AnimalsActivity.class);
                startActivity(intentAnimals);
            }
        });
        imgObjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentObjects=new Intent(getActivity(), ObjectsActivity.class);
                startActivity(intentObjects);
            }
        });
        imgColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentColors=new Intent(getActivity(), ColorsActivity.class);
                startActivity(intentColors);
            }
        });
      imgDrinks.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intentDrinks=new Intent(getActivity(), DrinksActivity.class);
              startActivity(intentDrinks);
          }
      });
        imgFruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentFruits=new Intent(getActivity(), FruitsActivity.class);
                startActivity(intentFruits);
            }
        });
        return view;
    }

}
