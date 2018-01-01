package com.baskom.miadmin.model;

/**
 * Created by akmalmuhamad on 29/11/17.
 */

public class StatusPesanan {
    private String judulVideo;
    private String videoThumbnail;
    private String videoURL;

    public String getJudulVideo() {
        return judulVideo;
    }

    public void setJudulVideo(String judulVideo) {
        this.judulVideo = judulVideo;
    }

    public String getVideoThumbnail() {
        return videoThumbnail;
    }

    public void setVideoThumbnail(String videoThumbnail) {
        this.videoThumbnail = videoThumbnail;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public StatusPesanan(String judulVideo, String videoThumbnail, String videoURL) {

        this.judulVideo = judulVideo;
        this.videoThumbnail = videoThumbnail;
        this.videoURL = videoURL;
    }
}
