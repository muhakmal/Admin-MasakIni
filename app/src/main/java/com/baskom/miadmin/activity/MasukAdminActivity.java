package com.baskom.miadmin.activity;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.andreabaccega.formedittextvalidator.AlphaNumericValidator;
import com.andreabaccega.formedittextvalidator.EmailValidator;
import com.andreabaccega.widget.FormEditText;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.baskom.miadmin.R;
import com.baskom.miadmin.request.MasukAdminRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MasukAdminActivity extends AppCompatActivity {
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk_admin);
        progressBar = findViewById(R.id.pb_masuk);
        final FormEditText etEmail = findViewById(R.id.et_email_admin);
        final FormEditText etPassword = findViewById(R.id.et_password_admin);
        final Button btnMasuk = findViewById(R.id.btn_masuk_admin);
        etEmail.addValidator(new EmailValidator(null));
        etPassword.addValidator(new AlphaNumericValidator(null));
        etPassword.setImeActionLabel("MASUK", KeyEvent.KEYCODE_ENTER);
        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = etEmail.getText().toString();
                final String password = etPassword.getText().toString();
                progressBar.setVisibility(View.VISIBLE);
                Response.Listener<String> stringListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            FormEditText[] allFields = {etEmail, etPassword};
                            boolean allValid = true;
                            for (FormEditText field : allFields) {
                                allValid = field.testValidity() && allValid;
                            }
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success && allValid) {
                                Intent intent = new Intent(MasukAdminActivity.this, MainDrawerActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MasukAdminActivity.this);
                                builder.setMessage(response)
                                        .setTitle("Masuk MI Admin Gagal")
                                        .setMessage("Format email admin/password admin yang anda masukkan salah atau data admin anda tidak ada dalam database.")
                                        .setNegativeButton("Ulangi", null)
                                        .create()
                                        .show();
                            }
                            progressBar.setVisibility(View.GONE);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                MasukAdminRequest masukAdminRequest = new MasukAdminRequest(email, password, stringListener);
                RequestQueue requestQueue = Volley.newRequestQueue(MasukAdminActivity.this);
                requestQueue.add(masukAdminRequest);
            }
        });

    }
}