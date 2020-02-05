package ru.uds.musicproject.model.pathmymusic;

import javafx.concurrent.Task;
import ru.uds.musicproject.model.TrackObject;
import ru.uds.musicproject.abstractclasses.ButtonAbstract;
import ru.uds.musicproject.utils.DirectoryUtils;

class DeleteMusicAtPlayerButton extends ButtonAbstract {
    private TrackObject trackObject;

    DeleteMusicAtPlayerButton(String nameButton, TrackObject trackObject) {
        super(nameButton);
        this.trackObject = trackObject;
    }

    private String deleteFormatString(String music) {
        return music.substring(0, music.length() - 4);
    }

    @Override
    public void click() {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                DirectoryUtils.deleteMusic(trackObject.getMusic().getName());
                trackObject.getIconFile().delete();
                return null;
            }
        };
        new Thread(task).start();
    }
}