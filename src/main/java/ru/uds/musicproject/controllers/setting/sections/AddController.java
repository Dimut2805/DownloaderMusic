package ru.uds.musicproject.controllers.setting.sections;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class AddController {
    @FXML
    private AnchorPane window;
    @FXML
    TextField nameTextField;
    @FXML
    TextField urlTextField;
    ComboBox sectionsComboBox;

    public void setSectionsComboBox(ComboBox sectionsComboBox) {
        this.sectionsComboBox = sectionsComboBox;
    }

    @FXML
    public void add() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("database/hibernate.cfg.xml").build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        session.createSQLQuery("INSERT INTO Sections" +
                "(name,url)" +
                "VALUES ('" + nameTextField.getText() + "','" + urlTextField.getText() + "');").executeUpdate();
        sectionsComboBox.getItems().add(nameTextField.getText());
        t.commit();
        factory.close();
        session.close();
        ((Stage) window.getScene().getWindow()).close();
    }

    @FXML
    public void cancel() {
        ((Stage) window.getScene().getWindow()).close();
    }
}
