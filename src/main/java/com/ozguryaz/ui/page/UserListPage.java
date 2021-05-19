package com.ozguryaz.ui.page;

import com.ozguryaz.core.domain.Actor;
import com.ozguryaz.core.domain.User;
import com.ozguryaz.core.service.ActorService;
import com.ozguryaz.core.service.FilmService;
import com.ozguryaz.core.service.UserService;
import com.ozguryaz.ui.MyUI;
import com.ozguryaz.ui.component.*;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.*;

import java.util.List;

public class UserListPage extends VerticalLayout {
    private VerticalLayout mainLayout;
    private Table table;
    private Container container;
    public UserListPage() {

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
        table.setColumnHeaders("ID", "KULLANICI ADI", "PAROLA", "","");
    }

    private void buildContainer() {

        container = new IndexedContainer();
        container.addContainerProperty("id", Long.class, null);
        container.addContainerProperty("username", String.class, null);
        container.addContainerProperty("password", String.class, null);
        container.addContainerProperty("guncelle", Button.class, null);
        container.addContainerProperty("sil", Button.class, null);

    }

    private void fillTable() {

        UserService userService = new UserService();
        List<User> userList = userService.findAll();
        container.removeAllItems();
        for (User user : userList) {
            Item item = container.addItem(user);
            item.getItemProperty("id").setValue(user.getId());
            item.getItemProperty("username").setValue(user.getUsername());
            item.getItemProperty("password").setValue(user.getPassword());

            SyEditButton guncelle = buildEditButton(user);
            item.getItemProperty("guncelle").setValue(guncelle);

            SyDeleteButton sil = buildDeleteButton(user);
            item.getItemProperty("sil").setValue(sil);
        }
    }

    private SyAuthButton buildAuthButton(User user) {
        SyAuthButton authButton = new SyAuthButton();
        authButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                MyUI syUI = (MyUI) UI.getCurrent();
                ContentComponent contentComponent = syUI.getContentComponent();

                UserPage userPage = new UserPage(user);
                contentComponent.addComponent(userPage);
            }
        });
        return authButton;
    }

    private SyEditButton buildEditButton(final User user) {
        SyEditButton guncelle = new SyEditButton();
        guncelle.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                MyUI syUI = (MyUI) UI.getCurrent();
                ContentComponent contentComponent = syUI.getContentComponent();

                UserPage userPage = new UserPage(user);
                contentComponent.addComponent(userPage);
            }
        });
        return guncelle;
    }
    private SyDeleteButton buildDeleteButton(final User user) {
        SyDeleteButton sil = new SyDeleteButton();
        sil.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UserService userService = new UserService();
                userService.delete(user);
                fillTable();
            }
        });
        return sil;
    }
}
