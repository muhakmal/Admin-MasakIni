package com.baskom.miadmin.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baskom.miadmin.R;
import com.baskom.miadmin.adapter.KelolaResepCardAdapter;
import com.baskom.miadmin.model.Resep;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class KelolaResepActivity extends AppCompatActivity {
    private static final String RESEPLIST_REQUEST_URL = "http://masakini.xyz/masakiniapi/Reseplist.php";
    List<Resep> resepList = new ArrayList<>();
    RecyclerView recyclerView;
    KelolaResepCardAdapter adapter;

    FloatingTextButton fabTambahResep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola_resep);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Kelola Resep");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fabTambahResep = findViewById(R.id.fab_tambah_resep);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setFocusable(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        getResepList();

        fabTambahResep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KelolaResepActivity.this, TambahResepActivity.class);
                startActivity(intent);
            }
        });
    }

    public void getResepList(){
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JsonArray jsonResponse = new JsonParser().parse(response).getAsJsonArray();
                Type listType = new TypeToken<List<Resep>>(){}.getType();
                resepList = new Gson().fromJson(jsonResponse,listType);
                adapter = new KelolaResepCardAdapter(resepList);
                recyclerView.setAdapter(adapter);
            }
        };

        Response.ErrorListener responseErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("response", error.toString());
            }
        };
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, RESEPLIST_REQUEST_URL, responseListener, responseErrorListener);
        queue.add(request);
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
