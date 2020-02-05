package ru.uds.musicproject.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import ru.uds.musicproject.constains.Constains;
import ru.uds.musicproject.model.player.ButtonsModelPlayer;
import ru.uds.musicproject.model.player.ButtonsPlayerObject;
import ru.uds.musicproject.model.TrackPlayer;

/**
 * Контроллер работы с  музыкой
 */
public class PlayerController implements Constains {
    ButtonsModelPlayer buttonsModelPlayer;
    @FXML
    Button stopMusicButton;
    @FXML
    Button deleteFromPlayerButton;
    @FXML
    public Button listenMusicButton;
    @FXML
    ImageView imagePlayer;
    @FXML
    Button pauseMusicButton;
    @FXML
    Label nameMusicAtPlayer;

    /**
     * Нажатие на паузу в плеере
     */
    @FXML
    private void pauseMusicButton() {
        buttonsModelPlayer.getPauseMusicButton().click();
    }

    /**
     * Нажатие на стоп в плеере
     */
    @FXML
    void stopMusicButton() {
        buttonsModelPlayer.getStopMusicButton().click();
    }

    /**
     * Нажатие на пуск в плеере
     */
    @FXML
    private void listenMusicButton() {
        buttonsModelPlayer.getStartMusicButton().click();
    }

    /**
     * Нажатие на удаление музыки из плеера
     */
    @FXML
    private void deleteFromPlayerButton() {
        buttonsModelPlayer.getCloseMusicButton().click();
    }

    @FXML
    public void initialize() {
        buttonsModelPlayer = new ButtonsModelPlayer(
                new ButtonsPlayerObject(
                        stopMusicButton,
                        deleteFromPlayerButton,
                        listenMusicButton,
                        pauseMusicButton),
                new TrackPlayer(nameMusicAtPlayer, imagePlayer));
    }
}