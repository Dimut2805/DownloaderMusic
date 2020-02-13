package ru.uds.musicproject.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.uds.musicproject.model.GUI;

import java.util.ArrayList;
import java.util.List;


public class MainController {
    @FXML
    DownloadMusicController downloadMusicController;
    @FXML
    PlayerController playerController;
    @FXML
    MyMusicController myMusicController;
    @FXML
    VBox window;

    /**
     * Полготовка приложения к работе
     */
    public void initialize() {
        sendControllersForControllers();
        myMusicController.startUpdatePathMusic();
    }

    private void sendControllersForControllers() {
        downloadMusicController.setMyMusicController(myMusicController);
        myMusicController.setPlayerController(playerController);
    }

    @FXML
    public void openSettingSection() {
        GUI.settingSectionGUI(downloadMusicController.sections);
    }
}