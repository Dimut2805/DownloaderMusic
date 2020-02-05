package ru.uds.musicproject.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import ru.uds.musicproject.ActiveButtonsGlobalObject;
import ru.uds.musicproject.model.TrackObject;
import ru.uds.musicproject.constains.Constains;
import ru.uds.musicproject.model.pathmymusic.AttributesPathMyMusicModel;
import ru.uds.musicproject.utils.DirectoryUtils;

import java.io.File;
import java.util.ArrayList;

public class MyMusicController implements Constains {
    private ActiveButtonsGlobalObject activeButtonsGlobalObject;
    @FXML
    PlayerController playerController;
    @FXML
    VBox vboxContentPathMusic;

    /**
     * Запуск обновления директории скачанной музыкой
     */
    @FXML
    public void startUpdatePathMusic() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                updatePathMusic();
            }
        });
    }

    /**
     * Получение ссылки на действующий сторонний контроллер
     *
     * @param playerController сторонний контроллер
     */
    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }

    /**
     * Обновление директории пользователя
     */
    private void updatePathMusic() {
        if (vboxContentPathMusic.getChildren().size() != 0) {
            vboxContentPathMusic.getChildren().clear();
        }
        fillObjects();
    }

    private void fillObjects() {
        ArrayList<File[]> tracks = DirectoryUtils.getTracks();
        for (File[] track : tracks) {
            AttributesPathMyMusicModel modelTrackPathMusic =
                    new AttributesPathMyMusicModel(new TrackObject(track[1], track[0]),
                            playerController.buttonsModelPlayer,
                            activeButtonsGlobalObject);
            vboxContentPathMusic
                    .getChildren()
                    .add(modelTrackPathMusic.getObjectHBox());
        }
    }

    public void initialize() {
        activeButtonsGlobalObject = new ActiveButtonsGlobalObject();
    }
}