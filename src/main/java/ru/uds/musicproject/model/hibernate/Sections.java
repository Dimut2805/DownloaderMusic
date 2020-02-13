package ru.uds.musicproject.model.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sections")
public class Sections {
    private String name, url;

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Sections{" +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
