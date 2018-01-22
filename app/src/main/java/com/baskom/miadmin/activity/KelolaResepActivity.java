package com.baskom.miadmin.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.baskom.miadmin.R;
import com.baskom.miadmin.adapter.KelolaResepCardAdapter;
import com.baskom.miadmin.model.KelolaResep;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class KelolaResepActivity extends AppCompatActivity {
    Locale localeId = new Locale ("in", "ID");
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeId);
    List<KelolaResep> kelolaResepList = new ArrayList<>();
    RecyclerView recyclerView;
    KelolaResepCardAdapter adapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola_resep);
        toolbar = findViewById(R.id.toolbar_kelola_resep);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Kelola Resep");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView.findViewById(R.id.recycler_view_card_kelola_resep);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setFocusable(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void getKelolaResepList(){
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        finish();
    }
}