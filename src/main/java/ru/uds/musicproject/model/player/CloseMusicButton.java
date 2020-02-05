package ru.uds.musicproject.model.player;

import javafx.scene.control.Button;

public class CloseMusicButton extends JobButtonPlayer {

    CloseMusicButton(Button button, ButtonsModelPlayer buttonsModelPlayer) {
        super(button, buttonsModelPlayer);
    }

    @Override
    public void click() {
        getMyPlayer().close();
        getButtonsModelPlayer().clickClose();
    }
}