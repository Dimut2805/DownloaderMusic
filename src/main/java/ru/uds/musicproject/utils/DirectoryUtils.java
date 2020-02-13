package ru.uds.musicproject.utils;

import ru.uds.musicproject.constains.Constains;
import ru.uds.musicproject.constains.Dir;
import ru.uds.musicproject.constains.Images;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

/**
 * Работа с директорией
 */
public class DirectoryUtils implements Dir, Images {
    /**
     * Создание директории
     *
     * @param srcFir путь
     */
    public static void createDirectory(String srcFir) {
        new File(srcFir).mkdir();
    }

    /**
     * Копирование файла в другой репозиторий
     *
     * @param inFile  откуда
     * @param outFile куда
     */
    public static void copyFile(String inFile, String outFile) {
        try {
            Files.copy(Paths.get(inFile),
                    Paths.get(outFile),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Поиск объекта в директории
     *
     * @param srcObject полный путь объекта
     * @return результат поиска
     */
    public static boolean findObjectInDir(String srcObject) {
        return new File(srcObject).exists();

    }

    /**
     * Список музыки
     *
     * @return список музыки
     */
    public static ArrayList<File[]> getTracks() {
        File directory = new File(PATH_MUSICS);
        ArrayList<File[]> tracks = new ArrayList<>();
        for (String musicName : directory.list()) {
            if (musicName.contains(".mp3")) {
                tracks.add(new File[]{new File(musicName), fileIconPlayer(musicName)});
            }
        }
        return tracks;
    }

    private static File fileIconPlayer(String nameMusic) {
        String namePicture = nameMusic.substring(0, nameMusic.length() - 4);
        return DirectoryUtils.findObjectInDir(BASE_DIR_DOWNLOADER_MUSIC_PICTURE + namePicture) ?
                new File(BASE_DIR_DOWNLOADER_MUSIC_PICTURE + namePicture) :
                new File(BASE_IMAGE_JPG_BASE_ICON);
    }

    /**
     * Удаление музыки
     *
     * @param nameDelete путь к директории
     */
    public static void deleteMusic(String nameDelete) {
        File music = new File(PATH_MUSICS + "\\" + nameDelete);
        music.delete();
    }
}