package com.baskom.miadmin.adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baskom.miadmin.R;
import com.baskom.miadmin.model.Resep;
import com.bumptech.glide.Glide;

/**
 * Created by akmalmuhamad on 16/02/18.
 */

public class KelolaResepCardViewHolder extends RecyclerView.ViewHolder {
    private TextView judulResep;
    private TextView subJudulResep;
    private TextView tingkatKesulitan;
    private TextView untukBerapaOrang;
    private TextView waktuMemasak;
    private ImageView resepImage;
    private ImageView overflow;
    private CardView cardView;

    public KelolaResepCardViewHolder(View itemView) {
        super(itemView);
        judulResep = itemView.findViewById(R.id.tv_judul_resep_troli);
        subJudulResep = itemView.findViewById(R.id.cardView_deksripsiResep);
        tingkatKesulitan = itemView.findViewById(R.id.cardView_tingkat_kesulitan);
        untukBerapaOrang = itemView.findViewById(R.id.cardView_untukBerapaOrang);
        waktuMemasak = itemView.findViewById(R.id.cardView_waktuMemasak);
        resepImage = itemView.findViewById(R.id.image_troli);
        overflow = itemView.findViewById(R.id.overflow);
        cardView = itemView.findViewById(R.id.card_troli);
    }

    public void bindData(final Resep resep) {
        Glide.with(cardView.getContext())
                .load(resep.getResepImage())
                .into(resepImage);
        judulResep.setText(resep.getJudulResep());
        subJudulResep.setText(resep.getSubJudulResep());
        tingkatKesulitan.setText(resep.getTingkatKesulitan());
        untukBerapaOrang.setText(resep.getUntukBerapaOrang());
        waktuMemasak.setText(resep.getWaktuMemasak());

        overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(overflow);
            }
        });
    }

    public void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(overflow.getContext(), view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_card, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(overflow.getContext(), "Resep dihapus, tapi belom deh hahahaha", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }
}
