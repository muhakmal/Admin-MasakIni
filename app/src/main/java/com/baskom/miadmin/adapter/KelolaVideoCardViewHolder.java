package com.baskom.miadmin.adapter;

import android.content.Intent;
import android.net.Uri;
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
import com.baskom.miadmin.model.Video;
import com.bumptech.glide.Glide;

/**
 * Created by akmalmuhamad on 16/02/18.
 */

public class KelolaVideoCardViewHolder extends RecyclerView.ViewHolder {
    private ImageView videoThumbnail, overflow;
    private TextView judulVideo;
    private Uri uri;
    private String urlVideo;
    private CardView cardViewVideo;

    public KelolaVideoCardViewHolder(View itemView) {
        super(itemView);
        judulVideo = itemView.findViewById(R.id.cardView_judul_video);
        videoThumbnail= itemView.findViewById(R.id.cardView_main_image_video);
        overflow = itemView.findViewById(R.id.overflow);
        cardViewVideo = itemView.findViewById(R.id.card_view_video);
    }

    public void bindData(final Video video){
        Glide.with(cardViewVideo.getContext())
                .load(video.getVideoThumbnail())
                .into(videoThumbnail);
        judulVideo.setText(video.getJudulVideo());

        cardViewVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uri = Uri.parse(video.getVideoURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.putExtra("force_fullscreen", true);
                v.getContext().startActivity(intent);
            }
        });

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
        popup.setOnMenuItemClickListener(new KelolaVideoCardViewHolder.MyMenuItemClickListener());
        popup.show();
    }

    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(overflow.getContext(), "Video dihapus, tapi belom deh hahahaha", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }
}
