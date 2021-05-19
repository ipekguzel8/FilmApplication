package com.ozguryaz.ui.page;

import com.ozguryaz.core.domain.Film;
import com.ozguryaz.core.service.FilmService;
import com.ozguryaz.ui.component.LanguageCombobox;
import com.ozguryaz.ui.component.SySaveButton;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;

public class FilmPage extends VerticalLayout {
    @PropertyId("id")
    private TextField id;

    @PropertyId("name")
    private TextField adi;

    @PropertyId("year")
    private TextField year;

    @PropertyId("type")
    private TextField type;

    @PropertyId("description")
    private TextField description;

    @PropertyId("media")
    private TextField media;

    @PropertyId("language")
    private LanguageCombobox language;

    private FormLayout mainLayout;

    private BeanItem<Film> filmBeanItem;
    private FieldGroup binder;
    private SySaveButton sySaveButton;

    public FilmPage() {
        this(new Film());
    }

    public FilmPage(Film film) {

        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);
        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        filmBeanItem = new BeanItem<Film>(film);
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

        adi = new TextField();
        adi.setCaption("Adı");
        mainLayout.addComponent(adi);

        language = new LanguageCombobox();
        language.setCaption("Language");
        mainLayout.addComponent(language);

        year = new TextField();
        year.setCaption("Yayın Yılı:");
        mainLayout.addComponent(year);

        type = new TextField();
        type.setCaption("Türü:");
        mainLayout.addComponent(type);

        description = new TextField();
        description.setCaption("Açıklama:");
        mainLayout.addComponent(description);

        media = new TextField();
        media.setCaption("Medya:");
        mainLayout.addComponent(media);


        sySaveButton = new SySaveButton();
        sySaveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {


                try {
                    binder.commit();
                } catch (FieldGroup.CommitException e) {
                    e.printStackTrace();
                }

                Film film = filmBeanItem.getBean();
                FilmService filmService = new FilmService();

                filmService.save(film);

            }
        });
        mainLayout.addComponent(sySaveButton);
    }
}
