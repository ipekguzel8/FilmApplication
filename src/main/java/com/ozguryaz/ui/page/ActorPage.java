package com.ozguryaz.ui.page;

import com.ozguryaz.core.domain.Actor;
import com.ozguryaz.core.domain.Film;
import com.ozguryaz.core.service.ActorService;
import com.ozguryaz.core.service.FilmService;
import com.ozguryaz.ui.MyUI;
import com.ozguryaz.ui.component.LanguageCombobox;
import com.ozguryaz.ui.component.SySaveButton;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;

public class ActorPage extends VerticalLayout {
    @PropertyId("id")
    private TextField id;

    @PropertyId("name")
    private TextField adi;


    public ActorPage() {
        this(new Actor());
    }
    private FormLayout mainLayout;

    private BeanItem<Actor> filmBeanItem;
    private FieldGroup binder;
    private SySaveButton sySaveButton;
    public ActorPage(Film film){

    }

    private void buildFilmMainLayout() {
    }

    public ActorPage(Actor actor) {

        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);
        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        filmBeanItem = new BeanItem<Actor>(actor);
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

        sySaveButton = new SySaveButton();
        sySaveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try {
                    binder.commit();
                } catch (FieldGroup.CommitException e) {
                    e.printStackTrace();
                }

                Actor actor = filmBeanItem.getBean();
                ActorService actorService = new ActorService();
                actorService.save(actor);
                ActorListPage actorListPage= new ActorListPage();
                MyUI syUI = (MyUI) UI.getCurrent();
                ContentComponent contentComponent = syUI.getContentComponent();
                contentComponent.removeAllComponents();
                contentComponent.addComponent(actorListPage);

            }
        });
        mainLayout.addComponent(sySaveButton);
    }
}

