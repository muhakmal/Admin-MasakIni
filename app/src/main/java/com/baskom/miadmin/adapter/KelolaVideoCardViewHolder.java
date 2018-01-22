package com.baskom.miadmin.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baskom.miadmin.R;
import com.baskom.miadmin.model.Video;

/**
 * Created by akmalmuhamad on 19/01/18.
 */

public class KelolaVideoCardViewHolder extends RecyclerView.ViewHolder{
    private TextView tvJudulVideo;
    private ImageView imageVideo;

    public KelolaVideoCardViewHolder(View itemView) {
        super(itemView);
        tvJudulVideo = itemView.findViewById(R.id.tv_judul_card_video);
        imageVideo = itemView.findViewById(R.id.img_card_video);
    }

    public void bindData(Video video){

    }
}
