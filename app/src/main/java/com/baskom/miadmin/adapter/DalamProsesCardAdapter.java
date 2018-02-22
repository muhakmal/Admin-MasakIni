package com.baskom.miadmin.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.baskom.miadmin.R;
import com.baskom.miadmin.model.DalamProses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 23/11/17.
 */

public class DalamProsesCardAdapter extends RecyclerView.Adapter {

    private List<DalamProses> dalamProsesList = new ArrayList<>();
    Context context;

    public DalamProsesCardAdapter(List<DalamProses> dalamProsesList, final Context context) {
        this.dalamProsesList.addAll(dalamProsesList);
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
                public void onClick(View v) {
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
                                }
                            })
                            .show();

                }
            });

            ((DalamProsesCardViewHolder)holder).btnTerimaPesanan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //do something when terima pesanan
                    final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Konfirmasi Terima Pesanan")
                            .setMessage("Apakah anda yakin ingin menerima pesananan ini?")
                            .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //do nothing when tidak is click
                                }
                            })
                            .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //update database to status pesanan menjadi dikirim
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
