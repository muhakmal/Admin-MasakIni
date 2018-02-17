package com.baskom.miadmin.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.baskom.miadmin.fragment.Tab1KartuResep;
import com.baskom.miadmin.fragment.Tab2BahanResep;
import com.baskom.miadmin.fragment.Tab3CaraMemasak;
import com.baskom.miadmin.fragment.Tab4DaftarProduk;

/**
 * Created by akmalmuhamad on 16/02/18.
 */

public class TambahResepViewPagerAdapter extends FragmentPagerAdapter {
    public TambahResepViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Tab1KartuResep();
        } else if (position == 1) {
            return new Tab2BahanResep();
        } else if (position == 2) {
            return new Tab3CaraMemasak();
        } else return new Tab4DaftarProduk();
    }


    @Override
    public int getCount() {
        return 4;
    }
}
