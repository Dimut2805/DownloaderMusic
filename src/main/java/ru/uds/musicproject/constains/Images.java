package ru.uds.musicproject.constains;

import java.io.File;

public interface Images {
    String SRC_JPG_DEFAULT_TRACK_ICON = new File("/drawable/baseIcons/DedaultTrackIcon.png").getPath();
    String SRC_JPG_BASE_ICON_FOUND_MUSIC = new File("/drawable/baseIcons/BaseIconNotFoundMusic.jpg").getPath();
    String BASE_IMAGE_JPG_NOT_FOUND_MUSIC = "C:\\Users\\" + System.getProperty("user.name") + "\\Pictures\\DownloaderMusicPicture\\basePicture\\BaseIconNotFoundMusic.jpg";
    String BASE_IMAGE_JPG_BASE_ICON = "C:\\Users\\" + System.getProperty("user.name") + "\\Pictures\\DownloaderMusicPicture\\basePicture\\DedaultTrackIcon.png";
}
