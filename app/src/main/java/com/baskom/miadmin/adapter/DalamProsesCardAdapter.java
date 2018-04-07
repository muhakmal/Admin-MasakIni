package com.baskom.miadmin.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.baskom.miadmin.R;
import com.baskom.miadmin.model.DalamProses;
import com.baskom.miadmin.request.AcceptOrRejectRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 23/11/17.
 */

public class DalamProsesCardAdapter extends RecyclerView.Adapter {

    private List<DalamProses> dalamProsesList = new ArrayList<>();
    Context context;

    public DalamProsesCardAdapter(List<DalamProses> dalamProsesList, final Context context) {
        this.dalamProsesList = dalamProsesList;
        this.context = context;
    }

    public List<DalamProses> getDalamProsesList() {
        return dalamProsesList;
    }

    public void setDalamProsesList(List<DalamProses> dalamProsesList) {
        this.dalamProsesList = dalamProsesList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate new view when creating new items in recyclerview
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_dalam_proses, parent, false);
        return new DalamProsesCardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder.getItemViewType() == R.layout.card_dalam_proses) {
            ((DalamProsesCardViewHolder) holder).bindData(dalamProsesList.get(position));

            //konfirmasi tolak pesanan
            ((DalamProsesCardViewHolder)holder).btnTolakPesanan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Konfirmasi Tolak Pesanan")
                            .setMessage("Apakah anda yakin ingin menolak pesananan ini?")
                            .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //do nothing
                                }
                            })
                            .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //update data to status pesanan menjadi ditolak
                                    Response.Listener<String> listener = new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            Toast.makeText(v.getContext().getApplicationContext(), "Pesananan ditolak.", Toast.LENGTH_SHORT).show();
                                        }
                                    };
                                    AcceptOrRejectRequest request = new AcceptOrRejectRequest(dalamProsesList.get(position).getNomorPesanan(),"Ditolak",listener);
                                    Volley.newRequestQueue(v.getContext().getApplicationContext()).add(request);
                                    ((Activity) v.getContext()).recreate();
                                }
                            })
                            .show();
                }
            });

            ((DalamProsesCardViewHolder)holder).btnTerimaPesanan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    //do something when terima pesanan
                    final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Konfirmasi Terima Pesanan")
                            .setMessage("Apakah anda yakin ingin menerima pesananan ini?")
                            .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //do nothing when tidak is clicked
                                }
                            })
                            .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //update database to status pesanan menjadi dikirim
                                    Response.Listener<String> listener = new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            Toast.makeText(v.getContext().getApplicationContext(), "Pesanan diterima.", Toast.LENGTH_SHORT).show();
                                        }
                                    };
                                    AcceptOrRejectRequest request = new AcceptOrRejectRequest(dalamProsesList.get(position).getNomorPesanan(),"Dikirim",listener);
                                    Volley.newRequestQueue(v.getContext().getApplicationContext()).add(request);
                                    ((Activity) v.getContext()).recreate();
                                }
                            })
                            .show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dalamProsesList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.card_dalam_proses;
    }
}
