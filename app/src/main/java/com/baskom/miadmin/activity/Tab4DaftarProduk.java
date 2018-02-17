package com.baskom.miadmin.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baskom.miadmin.R;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tab4DaftarProduk extends Fragment {
    FloatingTextButton fabSimpan;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_tab4_daftar_produk, container, false);
        fabSimpan = rootview.findViewById(R.id.fab4_simpan);

        fabSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //simpan data disini boi
            }
        });
        return rootview;
    }

}
