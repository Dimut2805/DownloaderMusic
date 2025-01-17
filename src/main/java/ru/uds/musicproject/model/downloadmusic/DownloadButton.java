package ru.uds.musicproject.model.downloadmusic;

import javafx.concurrent.Task;
import ru.uds.musicproject.DownloadsSource;
import ru.uds.musicproject.abstractclasses.ButtonAbstract;
import ru.uds.musicproject.model.AttributesMusic;

import java.io.IOException;

class DownloadButton extends ButtonAbstract {
    private AttributesMusic attributes;

    DownloadButton(String nameButton, AttributesMusic attributes) {
        super(nameButton);
        this.attributes = attributes;
    }

    @Override
    public void click() {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                downloadImage();
                downloadMusic();
                return null;
            }
        };
        new Thread(task).start();
    }

    private void downloadMusic() {
        DownloadsSource.downloadSong(attributes.getUrlMusic(), attributes.getAuthor() + " - " + attributes.getNameMusic());
    }

    private void downloadImage() {
        try {
            DownloadsSource.downloadImage(attributes.getUrlImage(), attributes.getAuthor() + " - " + attributes.getNameMusic());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}