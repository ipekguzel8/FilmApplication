package com.ozguryaz.ui.page;

import com.ozguryaz.core.domain.Actor;
import com.ozguryaz.core.domain.Film;
import com.ozguryaz.core.domain.FilmActor;
import com.ozguryaz.core.service.ActorService;
import com.ozguryaz.core.service.FilmActorService;
import com.ozguryaz.ui.component.SySaveButton;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

public class ActorAddPage extends VerticalLayout {
    private ComboBox adi;
    private TextField role;
    private TextField roleDescription;
    private SySaveButton sySaveButton;
    FilmActor filmActor;
    public ActorAddPage(Film film) {
        role= new TextField("Rolü");
        roleDescription=new TextField("Rolünün Açıklaması:");
        adi= new ComboBox();
        filmActor = new FilmActor();
        filmActor.setFilm(film);
        ActorService actorService= new ActorService();
        List<Actor> all = actorService.findAll();
        for (Actor actor:all){
            adi.addItem(actor);
        }
        adi.setCaption("Adı Seçiniz:");
        sySaveButton = new SySaveButton();
        sySaveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                filmActor.setActor((Actor) adi.getValue());
                filmActor.setRole(role.getValue());
                filmActor.setRoleDescription(roleDescription.getValue());
                FilmActorService filmActorService= new FilmActorService();
                filmActorService.save(filmActor);

            }
        });
        addComponent(adi);
        addComponent(role);
        addComponent(roleDescription);
        addComponent(sySaveButton);
    }

}
