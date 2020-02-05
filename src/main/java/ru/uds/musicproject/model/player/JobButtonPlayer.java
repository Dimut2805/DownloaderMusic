package ru.uds.musicproject.model.player;

import javafx.scene.control.Button;
import ru.uds.musicproject.abstractclasses.ButtonAbstract;
import ru.uds.musicproject.model.MyPlayer;

class JobButtonPlayer extends ButtonAbstract {
    private MyPlayer myPlayer;
    private ButtonsModelPlayer buttonsModelPlayer;

    JobButtonPlayer(Button button, ButtonsModelPlayer buttonsModelPlayer) {
        super(button);
        this.myPlayer = buttonsModelPlayer.getMyPlayer();
        this.buttonsModelPlayer = buttonsModelPlayer;
        getButton().setDisable(true);
    }

    public MyPlayer getMyPlayer() {
        return myPlayer;
    }

    public ButtonsModelPlayer getButtonsModelPlayer() {
        return buttonsModelPlayer;
    }

    @Override
    public void click() {

    }
}
