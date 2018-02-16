package com.baskom.miadmin.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baskom.miadmin.R;
import com.baskom.miadmin.model.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 16/02/18.
 */

public class KelolaVideoCardAdapter extends RecyclerView.Adapter {
    private List<Video> videoList = new ArrayList<>();

    public KelolaVideoCardAdapter(List<Video> videoList) {
        this.videoList.addAll(videoList);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_video, parent, false);
        return new KelolaVideoCardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder.getItemViewType() == R.layout.card_video) {
            ((KelolaVideoCardViewHolder) holder).bindData(videoList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.card_video;
    }
}
