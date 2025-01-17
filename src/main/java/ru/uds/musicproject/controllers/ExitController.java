package ru.uds.musicproject.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ExitController {
    @FXML
    private AnchorPane window;

    /**
     * Закрытие прилодения
     */
    @FXML
    private void clickYes() {
        System.exit(0);
    }

    /**
     * Отмена закрытия
     */
    @FXML
    private void clickNo() {
        ((Stage) window.getScene().getWindow()).close();
    }
}
