package ru.uds.musicproject.utils;

import ru.uds.musicproject.constains.Constains;
import ru.uds.musicproject.constains.Dir;
import ru.uds.musicproject.constains.Images;

import static ru.uds.musicproject.utils.DirectoryUtils.createDirectory;
import static ru.uds.musicproject.utils.DirectoryUtils.findObjectInDir;
import static ru.uds.musicproject.utils.DirectoryUtils.copyFile;


public class BaseOperation implements Images, Dir {
    /**
     * Базовые загрузки при запуске приложения
     */
    public void installationBaseObjects() {
        if (!findObjectInDir(BASE_DIR_DOWNLOADER_MUSIC_PICTURE)) {
            createDirectory(BASE_DIR_DOWNLOADER_MUSIC_PICTURE);
        }
        if (!findObjectInDir(BASE_DIR_BASE_PICTURE)) {
            createDirectory(BASE_DIR_BASE_PICTURE);
        }
        if (!findObjectInDir(BASE_IMAGE_JPG_BASE_ICON)) {
            copyFile(SRC_JPG_DEFAULT_TRACK_ICON, BASE_IMAGE_JPG_BASE_ICON);
        }
        if (!findObjectInDir(BASE_IMAGE_JPG_NOT_FOUND_MUSIC)) {
            copyFile(SRC_JPG_BASE_ICON_FOUND_MUSIC, BASE_IMAGE_JPG_NOT_FOUND_MUSIC);
        }
    }
}