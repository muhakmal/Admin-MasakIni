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
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baskom.miadmin.R;
import com.baskom.miadmin.adapter.KelolaVideoCardAdapter;
import com.baskom.miadmin.model.Video;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class KelolaVideoActivity extends AppCompatActivity {
    private static final String VIDEO_LIST_REQUEST = "http://masakini.xyz/masakiniapi/Videolist.php";
    RecyclerView recyclerView;
    KelolaVideoCardAdapter adapter;
    List<Video> videoList;
    FloatingTextButton fabTambahVideo;
    Toolbar toolbar;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola_video);
        toolbar = findViewById(R.id.toolbar);
        progressBar = findViewById(R.id.progressBar_kelola_video);
        progressBar.setVisibility(View.VISIBLE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Kelola Video");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fabTambahVideo = findViewById(R.id.fab_tambah_video);
        fabTambahVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KelolaVideoActivity.this, TambahVideoActivity.class);
                startActivity(intent);
            }
        });
        recyclerView = findViewById(R.id.recycler_view_video);
        recyclerView.setFocusable(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        getVideoList();
    }

    public void getVideoList() {
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JsonArray jsonResponse = new JsonParser().parse(response).getAsJsonArray();
                Type listType = new TypeToken<List<Video>>() {
                }.getType();
                videoList = new Gson().fromJson(jsonResponse, listType);
                adapter = new KelolaVideoCardAdapter(videoList);
                recyclerView.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
            }
        };

        Response.ErrorListener responseErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("response", error.toString());
            }
        };
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, VIDEO_LIST_REQUEST, responseListener, responseErrorListener);
        queue.add(request);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}