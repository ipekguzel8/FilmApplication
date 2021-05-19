package com.ozguryaz.ui.page;

import com.ozguryaz.core.domain.Actor;
import com.ozguryaz.core.domain.Film;
import com.ozguryaz.core.service.ActorService;
import com.ozguryaz.core.service.FilmService;
import com.ozguryaz.ui.MyUI;
import com.ozguryaz.ui.component.EnumLanguage;
import com.ozguryaz.ui.component.SyDeleteButton;
import com.ozguryaz.ui.component.SyEditButton;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.*;

import java.util.List;

public class ActorListPage extends VerticalLayout {
    private VerticalLayout mainLayout;
    private Table table;
    private Container container;

    public ActorListPage() {

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
        table.setColumnHeaders("ID", "ADI","","");
    }

    private void buildContainer() {

        container = new IndexedContainer();
        container.addContainerProperty("id", Long.class, null);
        container.addContainerProperty("name", String.class, null);
        container.addContainerProperty("guncelle", Button.class, null);
        container.addContainerProperty("sil", Button.class, null);

    }

    private void fillTable() {

        ActorService actorService = new ActorService();
        List<Actor> actorList = actorService.findAll();
        container.removeAllItems();
        for (Actor actor : actorList) {
            Item item = container.addItem(actor);
            item.getItemProperty("id").setValue(actor.getId());
            item.getItemProperty("name").setValue(actor.getName());

            SyEditButton guncelle = buildEditButton(actor);
            item.getItemProperty("guncelle").setValue(guncelle);

            SyDeleteButton sil = buildDeleteButton(actor);
            item.getItemProperty("sil").setValue(sil);
        }
    }

    private SyEditButton buildEditButton(final Actor actor) {
        SyEditButton guncelle = new SyEditButton();
        guncelle.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                MyUI syUI = (MyUI) UI.getCurrent();
                ContentComponent contentComponent = syUI.getContentComponent();

                ActorPage actorPage = new ActorPage(actor);
                contentComponent.addComponent(actorPage);
            }
        });
        return guncelle;
    }

    private SyDeleteButton buildDeleteButton(final Actor actor) {
        SyDeleteButton sil = new SyDeleteButton();
        sil.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                ActorService actorService = new ActorService();
                actorService.delete(actor);
                fillTable();
            }
        });
        return sil;
    }
}
