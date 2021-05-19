package com.ozguryaz.core.domain;

import com.ozguryaz.ui.component.EnumLanguage;
import com.sun.istack.NotNull;

import javax.persistence.*;
@Entity
@Table(name = "Film")
public class Film extends BaseEntity{
    @Override
    public String toString() {
        return name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name",nullable = false,length = 50)
    @NotNull
    private String name;

    @Column(name = "Year")
    private Integer year;

    @Column(name = "Type",nullable = false, length = 50)
    private String type;

    @Column(name = "Description",length = 200)
    private String description;

    @Column(name = "Media", length = 50)
    private String media;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private EnumLanguage language;

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public EnumLanguage getLanguage() {
        return language;
    }

    public void setLanguage(EnumLanguage language) {
        this.language = language;
    }

    @Override
    public Long getId() {
        return id;
    }
}
