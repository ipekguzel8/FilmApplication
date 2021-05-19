package com.ozguryaz.ui.page;

import com.ozguryaz.core.domain.Actor;
import com.ozguryaz.core.domain.Film;
import com.ozguryaz.core.domain.FilmActor;
import com.ozguryaz.core.service.FilmActorService;
import com.ozguryaz.ui.MyUI;
import com.ozguryaz.ui.component.SyDeleteButton;
import com.ozguryaz.ui.component.SyEditButton;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.*;

import java.util.List;

public class FilmActorListPage extends VerticalLayout {
    private VerticalLayout mainLayout;
    private Table table;
    private Container container;
    Film film= new Film();
    public FilmActorListPage(Film film) {
        this.film=film;
        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);

        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        fillTable();
    }

    private void buildMainLayout() {

        mainLayout = new VerticalLayout();
        mainLayout.setSizeUndefined();

        buildTable();
        mainLayout.addComponent(table);
    }

    private void buildTable() {

        table = new Table();

        buildContainer();
        table.setContainerDataSource(container);
        table.setColumnHeaders("ID","FİLM ADI","OYUNCU ADI", "ROLÜ", "ROL AÇIKLAMASI");
    }

    private void buildContainer() {

        container = new IndexedContainer();
        container.addContainerProperty("id", Long.class, null);
        container.addContainerProperty("adi", String.class, null);
        container.addContainerProperty("actor", String.class, null);
        container.addContainerProperty("role", String.class, null);
        container.addContainerProperty("roleDescription", String.class, null);

    }

    private void fillTable() {

        FilmActorService filmActorService= new FilmActorService();
        List<FilmActor> allActor = filmActorService.findAllActor(film);
        container.removeAllItems();
        for (FilmActor filmActor : allActor) {
            List<Actor> byActorId = filmActorService.findByActorId(filmActor.getActor().getId());
            Item item = container.addItem(filmActor);
            item.getItemProperty("id").setValue(filmActor.getId());
            item.getItemProperty("adi").setValue(film.getName());
            item.getItemProperty("actor").setValue(byActorId.get(0));
            item.getItemProperty("role").setValue(filmActor.getRole());
            item.getItemProperty("roleDescription").setValue(filmActor.getRoleDescription());

        }
    }
}
