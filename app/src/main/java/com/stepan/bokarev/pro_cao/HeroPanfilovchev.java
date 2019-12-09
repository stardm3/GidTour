package com.stepan.bokarev.pro_cao;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.stepan.bokarev.pro_cao.Constants.a24;
import static com.stepan.bokarev.pro_cao.MainActivity.fragmentIs;


public class HeroPanfilovchev extends Fragment {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private DatabaseReference myRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_park_hero_tour, container, false);
        fragmentIs = a24;
        final TextView v1 = view.findViewById(R.id.textView6);

        myRef = FirebaseDatabase.getInstance().getReference();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.child("Плитки").child("Могила Панфиловцев").getValue(String.class);
                v1.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Hospital();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            }
        });
        TextView texttest = view.findViewById(R.id.textVie4);
        texttest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Uri adress = Uri.parse("https://yandex.ru/map-widget/v1/?um=constructor%3A1b8db2fc970323850bd81cbc1d6ee28424b7ac11da10654c43e1c4e10e9f8a78&amp;source=constructor");
                Intent browser = new Intent(Intent.ACTION_VIEW, adress);
                startActivity(browser);
            }

        });
        Button button2 = view.findViewById(R.id.button_return);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ParkTour();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            }
        });
        TextView te = view.findViewById(R.id.textView12);
        te.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Uri adress = Uri.parse("https://28panfilovcev.com/about.php");
                Intent browser = new Intent(Intent.ACTION_VIEW, adress);
                startActivity(browser);
            }

        });
        return view;
    }
}
