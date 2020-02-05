package ru.uds.musicproject.model.pathmymusic;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import ru.uds.musicproject.ActiveButtonsGlobalObject;
import ru.uds.musicproject.model.TrackObject;
import ru.uds.musicproject.abstractclasses.AttributesObjectMusicAbstract;
import ru.uds.musicproject.model.player.ButtonsModelPlayer;

public class AttributesPathMyMusicModel extends AttributesObjectMusicAbstract {

    public AttributesPathMyMusicModel(TrackObject trackObject, ButtonsModelPlayer buttonsModelPlayer, ActiveButtonsGlobalObject activeButtonsGlobalObject) {
        AddMusicAtPlayerButton addMusicAtPlayerButton = new AddMusicAtPlayerButton("Слушать", trackObject, buttonsModelPlayer);
        addMusicAtPlayerButton.setActiveButtonsGlobalObject(activeButtonsGlobalObject);
        setObjectHBox(new HBox(
                trackObject.getIcon(),
                new Label(trackObject.getMusic().getName()),
                addMusicAtPlayerButton.getButton(),
                new DeleteMusicAtPlayerButton("Удалить", trackObject).getButton()));
    }
}