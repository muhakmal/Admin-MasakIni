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
public class Tab3CaraMemasak extends Fragment {

    FloatingTextButton fabNext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_tab3_cara_memasak, container, false);
        fabNext = rootview.findViewById(R.id.fab3_next);
        fabNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TambahResepActivity)getActivity()).setCurrentItem(3,true);
            }
        });

        return rootview;
    }

}
