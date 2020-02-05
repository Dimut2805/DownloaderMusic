package ru.uds.musicproject.model.player;

import javafx.scene.control.Button;

public class PauseMusicButton extends JobButtonPlayer {

    PauseMusicButton(Button button, ButtonsModelPlayer buttonsModelPlayer) {
        super(button, buttonsModelPlayer);
    }

    @Override
    public void click() {
        getMyPlayer().pause();
        getButtonsModelPlayer().clickPause();
    }
}