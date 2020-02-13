package ru.uds.musicproject.model;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import ru.uds.musicproject.constains.CSS;
import ru.uds.musicproject.constains.FXML;
import ru.uds.musicproject.controllers.setting.sections.AddController;
import ru.uds.musicproject.controllers.setting.sections.SectionsController;
import ru.uds.musicproject.utils.BaseOperation;

import java.io.IOException;

public class GUI extends BaseOperation implements FXML, CSS {
    Stage window;

    public GUI(Stage stage) {
        this.window = stage;
    }

    /**
     * Создание главного окна
     */
    public void createGUI() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(SRC_FXML_MAIN_LAYOUT));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(String.valueOf(this.getClass().getResource(SRC_CSS_BLACK_STYLE)));
            window.setTitle("Приложение для скачивания музыки.");
            window.setScene(scene);
            window.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    event.consume();
                    exitGUI();
                }
            });
            installationBaseObjects();
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addSectionInSectionSetting(ComboBox sectionsComboBox) {
        Parent root = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource(SRC_FXML_ADD_SECTION));
            root = fxmlLoader.load();
            AddController addController = fxmlLoader.getController();
            addController.setSectionsComboBox(sectionsComboBox);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        scene.getStylesheets().add(String.valueOf(GUI.class.getResource(SRC_CSS_BLACK_STYLE)));
        Stage window = new Stage();
        window.setTitle("Настройка разделов");
        window.setOnCloseRequest(event -> window.close());
        window.setScene(scene);
        window.show();
    }

    /**
     * Окно потверждения закрытия приложения
     */
    public static void exitGUI() {
        Parent root = null;
        try {
            root = FXMLLoader.load(GUI.class.getResource(SRC_FXML_EXIT));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        scene.getStylesheets().add(String.valueOf(GUI.class.getResource(SRC_CSS_BLACK_STYLE)));
        Stage window = new Stage();
        window.setTitle("Выход");
        window.setOnCloseRequest(event -> window.close());
        window.setScene(scene);
        window.show();
    }

    public static void settingSectionGUI(ComboBox<String> sectionsComboBox) {
        Parent root = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource(SRC_FXML_SECTIONS_SETTING));
            root = fxmlLoader.load();
            SectionsController sectionsController = fxmlLoader.getController();
            sectionsController.setSections(sectionsComboBox);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        scene.getStylesheets().add(String.valueOf(GUI.class.getResource(SRC_CSS_BLACK_STYLE)));
        Stage window = new Stage();
        window.setTitle("Настройка разделов");
        window.setOnCloseRequest(event -> window.close());
        window.setScene(scene);
        window.show();
    }
}