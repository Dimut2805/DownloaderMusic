package ru.uds.musicproject.model;

import javafx.scene.media.Media;

import java.io.File;

public class MediaFileObject {
    private Media media;

    public Media getMediaFile() {
        return media;
    }

    public void setMediaFile(File mediaFile) {
        this.media = mediaFile == null ? null : new Media(mediaFile.toURI().toString());
    }
}
