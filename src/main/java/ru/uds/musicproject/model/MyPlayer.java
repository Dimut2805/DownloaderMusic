package ru.uds.musicproject.model;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ru.uds.musicproject.constains.Constains;
import ru.uds.musicproject.constains.Images;

import java.io.File;
import java.net.MalformedURLException;

public class MyPlayer extends TrackPlayer implements Images {
    private MediaPlayerObject mediaPlayerObject;

    public MyPlayer(Label name, ImageView icon) {
        super(name, icon);
        mediaPlayerObject = new MediaPlayerObject(new MediaFileObject());
    }

    /**
     * Базовые настройки плеера
     */
    public void setBaseSettingPlayer() {
        getName().setText("Не выбрано");
        try {
            getIcon().setImage(new Image(new File(BASE_IMAGE_JPG_NOT_FOUND_MUSIC).toURI().toURL().toString()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        mediaPlayerObject.getMediaPlayer().pause();
    }

    public void on() {
        mediaPlayerObject.getMediaPlayer().play();
    }

    public void off() {
        mediaPlayerObject.getMediaPlayer().stop();
    }

    public MediaPlayerObject getMediaPlayerObject() {
        return mediaPlayerObject;
    }

    public void close() {
        setBaseSettingPlayer();
        mediaPlayerObject.deleteMediaFile();
        mediaPlayerObject.getMediaPlayer().stop();
    }
}