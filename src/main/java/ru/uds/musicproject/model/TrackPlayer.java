package ru.uds.musicproject.model;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class TrackPlayer {
    private ImageView icon;
    private Label name;
    public TrackPlayer(Label name, ImageView icon) {
        this.icon = icon;
        this.name = name;
    }

    public ImageView getIcon() {
        return icon;
    }

    public Label getName() {
        return name;
    }
}