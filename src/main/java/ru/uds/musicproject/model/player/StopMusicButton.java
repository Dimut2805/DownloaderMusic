package ru.uds.musicproject.model.player;

import javafx.scene.control.Button;

public class StopMusicButton extends JobButtonPlayer {

    StopMusicButton(Button button, ButtonsModelPlayer buttonsModelPlayer) {
        super(button, buttonsModelPlayer);
    }

    @Override
    public void click() {
        getMyPlayer().off();
        getButtonsModelPlayer().clickStop();
    }
}