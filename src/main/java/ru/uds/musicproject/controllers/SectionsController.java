package ru.uds.musicproject.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.uds.musicproject.model.hibernate.Sections;

import java.util.List;

public class SectionsController {
    ComboBox<String> sectionsComboBox;
    @FXML
    public VBox vboxContentSection;
    @FXML
    public TextField nameTextField;
    @FXML
    public TextField urlTextField;

    public void setSections(ComboBox<String> sectionsComboBox) {
        this.sectionsComboBox = sectionsComboBox;
    }

    @FXML
    public void clickAddButton() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("database/hibernate.cfg.xml").build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        session.createSQLQuery("INSERT INTO Sections" +
                "(name,url)" +
                "VALUES ('" + nameTextField.getText() + "','" + urlTextField.getText() + "');").executeUpdate();
        sectionsComboBox.getItems().add(nameTextField.getText());
        update(session);
        t.commit();
        factory.close();
        session.close();
    }

    private void update(Session session) {
        if (vboxContentSection.getChildren().size() != 0) {
            vboxContentSection.getChildren().clear();
        }
        List<Sections> list = session.createQuery("FROM Sections").list();
        for (Sections sections : list) {
            Button button = new Button("Удалить") {{
                setOnAction(event -> clickDelete(sections));
            }};
            vboxContentSection.getChildren().add(new HBox(
                    new Label(sections.getName()), button));
        }
    }

    public void clickDelete(Sections sections) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("database/hibernate.cfg.22xml").build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        session.createSQLQuery("DELETE FROM sections WHERE name = '" + sections.getName() + "'").executeUpdate();
        update(session);
        sectionsComboBox.getItems().remove(nameTextField.getText());
        t.commit();
        factory.close();
        session.close();
    }

    public void initialize() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("database/hibernate.cfg.xml").build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        List<Sections> list = session.createQuery("FROM Sections").list();
        for (Sections sections : list) {
            Button button = new Button("Удалить") {{
                setOnAction(event -> clickDelete(sections));
            }};
            vboxContentSection.getChildren().add(new HBox(
                    new Label(sections.getName()), button));
        }
        t.commit();
        factory.close();
        session.close();
    }
}