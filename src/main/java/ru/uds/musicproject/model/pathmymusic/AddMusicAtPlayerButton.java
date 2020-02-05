package ru.uds.musicproject.model.pathmymusic;

import ru.uds.musicproject.ActiveButtonsGlobalObject;
import ru.uds.musicproject.model.TrackObject;
import ru.uds.musicproject.abstractclasses.ButtonAbstract;
import ru.uds.musicproject.model.player.ButtonsModelPlayer;

import java.io.File;

import static ru.uds.musicproject.constains.Constains.PATH_MUSICS;

class AddMusicAtPlayerButton extends ButtonAbstract {
    private TrackObject trackObject;
    private ButtonsModelPlayer buttonsModelPlayer;
    private ActiveButtonsGlobalObject activeButtonsGlobalObject;

    AddMusicAtPlayerButton(String nameButton, TrackObject trackObject, ButtonsModelPlayer buttonsModelPlayer) {
        super(nameButton);
        this.trackObject = trackObject;
        this.buttonsModelPlayer = buttonsModelPlayer;
    }

    public void setActiveButtonsGlobalObject(ActiveButtonsGlobalObject activeButtonsGlobalObject) {
        this.activeButtonsGlobalObject = activeButtonsGlobalObject;
    }

    @Override
    public void click() {
        if (activeButtonsGlobalObject.getAddMusicInPlayerButton() != null) {
            activeButtonsGlobalObject.getAddMusicInPlayerButton().setDisable(false);
        }
        activeButtonsGlobalObject.setAddMusicInPlayerButton(this.getButton());
        getButton().setDisable(true);
        buttonsModelPlayer.getMyPlayer().getIcon().setImage(trackObject.getIcon().getImage());
        buttonsModelPlayer.getMyPlayer().getName().setText(trackObject.getMusic().getName());
        if (buttonsModelPlayer.getMyPlayer().getMediaPlayerObject().getMediaFileObject().getMediaFile() != null) {
            buttonsModelPlayer.getMyPlayer().getMediaPlayerObject().deleteMediaFile();
            buttonsModelPlayer.getMyPlayer().getMediaPlayerObject().getMediaPlayer().stop();
        }
        buttonsModelPlayer.getMyPlayer().getMediaPlayerObject().createMediaFile(new File(PATH_MUSICS + trackObject.getMusic().getName()));
        buttonsModelPlayer.getMyPlayer().getMediaPlayerObject().addMediaInPlayer();
        buttonsModelPlayer.clickAdd();
    }
}