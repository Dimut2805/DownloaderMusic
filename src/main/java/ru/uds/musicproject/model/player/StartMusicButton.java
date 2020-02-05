package ru.uds.musicproject.model.player;

import javafx.scene.control.Button;

public class StartMusicButton extends JobButtonPlayer {

    StartMusicButton(Button button, ButtonsModelPlayer buttonsModelPlayer) {
        super(button, buttonsModelPlayer);
    }

    @Override
    public void click() {
        getMyPlayer().on();
        getButtonsModelPlayer().clickStart();
    }
}
