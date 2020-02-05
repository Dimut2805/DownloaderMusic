package ru.uds.musicproject.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.MalformedURLException;

public class TrackObject {
    private File music;
    private ImageView icon;
    private File iconFile;

    public TrackObject(File icon, File music) {
        try {
            this.icon = new ImageView(new Image(icon.toURI().toURL().toString()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        iconFile = icon;
        this.music = music;
    }

    public File getIconFile() {
        return iconFile;
    }

    public ImageView getIcon() {
        return icon;
    }

    public File getMusic() {
        return music;
    }
}