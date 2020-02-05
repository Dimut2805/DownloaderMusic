package ru.uds.musicproject.model;

import javafx.scene.media.MediaPlayer;

import java.io.File;

public class MediaPlayerObject {
    private MediaPlayer mediaPlayer;
    private MediaFileObject mediaFileObject;
    private String nameMusic;

    public MediaPlayerObject(MediaFileObject mediaFileObject) {
        this.mediaFileObject = mediaFileObject;
    }

    public void createMediaFile(File file) {
        this.mediaFileObject.setMediaFile(file);
        this.nameMusic = file.getName();
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void deleteMediaFile() {
        this.mediaFileObject.setMediaFile(null);
        this.nameMusic = null;
    }

    public void addMediaInPlayer() {
        if (mediaFileObject.getMediaFile() == null) {
            throw new NullPointerException();
        }
        mediaPlayer = new MediaPlayer(mediaFileObject.getMediaFile());
    }

    public MediaFileObject getMediaFileObject() {
        return mediaFileObject;
    }
}