package ru.uds.musicproject.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.uds.musicproject.constains.Constains;
import ru.uds.musicproject.model.downloadmusic.AttributesDownloadMusicModel;
import ru.uds.musicproject.model.AttributesMusic;
import ru.uds.musicproject.model.hibernate.Sections;
import ru.uds.musicproject.utils.FindAttributeMusic;

import java.util.ArrayList;
import java.util.List;

public class DownloadMusicController implements Constains {
    MyMusicController myMusicController;
    @FXML
    VBox vboxContentDownloadScrollPane;
    @FXML
    String urlSection;
    @FXML
    public ComboBox<String> sections;
    ArrayList<String> sectionsArrayList;

    /**
     * Добавление стороннего контролера в this
     *
     * @param myMusicController сторонний контроллер
     */
    public void setMyMusicController(MyMusicController myMusicController) {
        this.myMusicController = myMusicController;
    }
    private void fillSections() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("database/hibernate.cfg.xml").build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        List<Sections> list = session.createQuery("FROM Sections").list();
        sectionsArrayList = new ArrayList<>();
        for(Sections sections : list) {
            sectionsArrayList.add(sections.getName());
        }
        sections.setItems(FXCollections.observableArrayList(sectionsArrayList));
        t.commit();
        factory.close();
        session.close();
    }

    /**
     * Получение разделов сайта
     */
    @FXML
    private void getComboBox() {
        urlSection = HASH_MAP_SECTIONS.get(sections.getValue());
    }

    /**
     * Поиск музыки в разделе сайта
     */
    @FXML
    private void clickFindMusicOnSite() {
        if (vboxContentDownloadScrollPane.getChildren().size() != 0) {
            vboxContentDownloadScrollPane.getChildren().clear();
        }
        fillObjects();
    }

    private void fillObjects() {
        List<AttributesMusic> attributeMusic = FindAttributeMusic.findAttributesMusic(urlSection);
        for (AttributesMusic attributes : attributeMusic) {
            AttributesDownloadMusicModel attributesDownloadMusicModel = new AttributesDownloadMusicModel(attributes);
            vboxContentDownloadScrollPane
                    .getChildren()
                    .add(attributesDownloadMusicModel.getObjectHBox());
            myMusicController.startUpdatePathMusic();
        }
    }
    public void initialize() {
        sectionsArrayList = new ArrayList<>();
        fillSections();
    }
}