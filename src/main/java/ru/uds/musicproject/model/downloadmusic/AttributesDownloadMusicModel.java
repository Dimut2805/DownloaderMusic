package ru.uds.musicproject.model.downloadmusic;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import ru.uds.musicproject.model.AttributesMusic;
import ru.uds.musicproject.abstractclasses.AttributesObjectMusicAbstract;

public class AttributesDownloadMusicModel extends AttributesObjectMusicAbstract {

    public AttributesDownloadMusicModel(AttributesMusic attributesMusic) {
        setObjectHBox(new HBox(
                new Label(attributesMusic.getNumberMusic() +
                        ". " + attributesMusic.getAuthor() +
                        " - " + attributesMusic.getNameMusic()),
                new DownloadButton("Скачать", attributesMusic).getButton()
        ));
    }
}
