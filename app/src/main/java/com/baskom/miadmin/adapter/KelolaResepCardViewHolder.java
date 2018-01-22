package com.baskom.miadmin.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.baskom.miadmin.R;
import com.baskom.miadmin.model.KelolaResep;
import com.bumptech.glide.Glide;

/**
 * Created by akmalmuhamad on 19/01/18.
 */

public class KelolaResepCardViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageResep;
    private TextView tvJudulResep;
    private Button btnDeleteCard;
    private CardView cardKelolaResep;

    public KelolaResepCardViewHolder(View itemView) {
        super(itemView);
        imageResep = itemView.findViewById(R.id.img_card_video);
        tvJudulResep = itemView.findViewById(R.id.tv_judul_card_video);
        btnDeleteCard = itemView.findViewById(R.id.btn_delete_card_video);
        cardKelolaResep = itemView.findViewById(R.id.card_kelola_video);
    }

    public void bindData(final KelolaResep kelolaResep) {
        Glide.with(cardKelolaResep.getContext())
                .load(kelolaResep.getUrlImage())
                .into(imageResep);
        tvJudulResep.setText(kelolaResep.getJudulResep());
        btnDeleteCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
