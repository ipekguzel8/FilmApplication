package com.ozguryaz.ui.page;
import com.ozguryaz.core.domain.Film;
import com.ozguryaz.core.service.FilmService;
import com.ozguryaz.ui.MyUI;
import com.ozguryaz.ui.component.*;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.*;

import java.util.List;

public class FilmListPage extends VerticalLayout {
    private VerticalLayout mainLayout;
    private Table table;
    private Container container;
    public FilmListPage() {

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
        table.setColumnHeaders("ID", "ADI", "YAYIN YILI", "TÜRÜ", "AÇIKLAMA", "MEDYA","DİLİ","GÜNCELLE","SİL","DETAY","OYUNCU EKLE");
    }

    private void buildContainer() {

        container = new IndexedContainer();
        container.addContainerProperty("id", Long.class, null);
        container.addContainerProperty("name", String.class, null);
        container.addContainerProperty("year", Integer.class, null);
        container.addContainerProperty("type", String.class, null);
        container.addContainerProperty("description", String.class, null);
        container.addContainerProperty("media", String.class, null);
        container.addContainerProperty("language", EnumLanguage.class, null);
        container.addContainerProperty("guncelle", Button.class, null);
        container.addContainerProperty("sil", Button.class, null);
        container.addContainerProperty("detay", Button.class, null);
        container.addContainerProperty("oyuncuEkle", Button.class, null);

    }

    private void fillTable() {

        FilmService filmService = new FilmService();
        List<Film> filmList = filmService.findAll();
        container.removeAllItems();
        for (Film film : filmList) {
            Item item = container.addItem(film);
            item.getItemProperty("id").setValue(film.getId());
            item.getItemProperty("name").setValue(film.getName());
            item.getItemProperty("year").setValue(film.getYear());
            item.getItemProperty("type").setValue(film.getType());
            item.getItemProperty("description").setValue(film.getDescription());
            item.getItemProperty("media").setValue(film.getMedia());
            item.getItemProperty("language").setValue(film.getLanguage());

            SyEditButton guncelle = buildEditButton(film);
            item.getItemProperty("guncelle").setValue(guncelle);

            SyDeleteButton sil = buildDeleteButton(film);
            item.getItemProperty("sil").setValue(sil);

            SyDetailButton detay=buildDetailButton(film);
            item.getItemProperty("detay").setValue(detay);

            SyAddActorButton oyuncuEkle=buildAddActorButton(film);
            item.getItemProperty("oyuncuEkle").setValue(oyuncuEkle);
        }
    }

    private SyAddActorButton buildAddActorButton(Film film) {
        SyAddActorButton addActorButton = new SyAddActorButton();
        addActorButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                MyUI syUI = (MyUI) UI.getCurrent();
                ContentComponent contentComponent = syUI.getContentComponent();
                contentComponent.removeAllComponents();
                ActorAddPage actorPage = new ActorAddPage(film);
                contentComponent.addComponent(actorPage);
            }
        });
        return addActorButton;
    }

    private SyEditButton buildEditButton(final Film film) {
        SyEditButton guncelle = new SyEditButton();
        guncelle.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                MyUI syUI = (MyUI) UI.getCurrent();
                ContentComponent contentComponent = syUI.getContentComponent();

                FilmPage urunPage = new FilmPage(film);
                contentComponent.addComponent(urunPage);
            }
        });
        return guncelle;
    }
    private SyDetailButton buildDetailButton(final Film film) {
        SyDetailButton detailButton = new SyDetailButton();
        detailButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                MyUI syUI = (MyUI) UI.getCurrent();
                ContentComponent contentComponent = syUI.getContentComponent();

                FilmActorListPage filmActorPage = new FilmActorListPage(film);
                contentComponent.addComponent(filmActorPage);
            }
        });
        return detailButton;
    }

    private SyDeleteButton buildDeleteButton(final Film film) {
        SyDeleteButton sil = new SyDeleteButton();
        sil.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                FilmService filmService = new FilmService();
                filmService.delete(film);
                fillTable();
            }
        });
        return sil;
    }
}
