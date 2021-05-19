package com.ozguryaz.ui.page;

import com.ozguryaz.core.domain.Actor;
import com.ozguryaz.core.domain.Film;
import com.ozguryaz.core.domain.FilmActor;
import com.ozguryaz.core.service.ActorService;
import com.ozguryaz.core.service.FilmActorService;
import com.ozguryaz.core.service.FilmService;
import com.ozguryaz.ui.MyUI;
import com.ozguryaz.ui.component.*;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.*;

import java.util.List;

public class FilmActorPage extends VerticalLayout {

    @PropertyId("id")
    private TextField id;

    @PropertyId("filmname")
    private TextField filmadi;

    @PropertyId("actorname")
    private TextField oyuncuadi;

    @PropertyId("role")
    private TextField rolu;

    @PropertyId("roledescription")
    private TextField rolAciklamasi;

    public FilmActorPage() {
        this(new FilmActor());
    }
    private FormLayout mainLayout;

    private BeanItem<FilmActor> filmBeanItem;
    private FieldGroup binder;
    private SySaveButton sySaveButton;
    public FilmActorPage(FilmActor filmActor) {

        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);
        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        filmBeanItem = new BeanItem<FilmActor>(filmActor);
        binder = new FieldGroup(filmBeanItem);
        binder.bindMemberFields(this);
    }

    private void buildMainLayout() {

        mainLayout = new FormLayout();
        mainLayout.setSizeUndefined();

        id = new TextField();
        id.setCaption("ID");
        id.setEnabled(true);
        mainLayout.addComponent(id);

        filmadi = new TextField();
        filmadi.setCaption("Film Adı");
        mainLayout.addComponent(filmadi);

        oyuncuadi = new TextField();
        oyuncuadi.setCaption("Oyuncu Adı");
        mainLayout.addComponent(oyuncuadi);

        rolu = new TextField();
        rolu.setCaption("Rolü:");
        mainLayout.addComponent(rolu);

        rolAciklamasi = new TextField();
        rolAciklamasi.setCaption("Rol Açıklaması:");
        mainLayout.addComponent(rolAciklamasi);

        sySaveButton = new SySaveButton();
        sySaveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try {
                    binder.commit();
                } catch (FieldGroup.CommitException e) {
                    e.printStackTrace();
                }

                FilmActor filmActor = filmBeanItem.getBean();
                FilmActorService actorService = new FilmActorService();
                actorService.save(filmActor);

            }
        });
        mainLayout.addComponent(sySaveButton);
    }
}
