package com.ozguryaz.ui.component;

import com.ozguryaz.ui.MyUI;
import com.ozguryaz.ui.page.*;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;

public class SyMenuBar extends MenuBar {
    private ContentComponent contentComponent;

    public SyMenuBar() {

        addItem("Film Listele", FontAwesome.LIST, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem) {
                FilmListPage filmListPage= new FilmListPage();
                MyUI syUI = (MyUI) UI.getCurrent();
                ContentComponent contentComponent = syUI.getContentComponent();
                contentComponent.addComponent(filmListPage);
            }
        });
        addItem("Film Ekle", FontAwesome.PLUS, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem) {
                FilmPage filmPage= new FilmPage();
                MyUI syUI = (MyUI) UI.getCurrent();
                ContentComponent contentComponent = syUI.getContentComponent();
                contentComponent.addComponent(filmPage);
            }
        });
        addItem("Oyuncu Ekle", FontAwesome.PLUS, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem) {
                ActorPage actorPage= new ActorPage();
                MyUI syUI = (MyUI) UI.getCurrent();
                ContentComponent contentComponent = syUI.getContentComponent();
                contentComponent.addComponent(actorPage);
            }
        });
        addItem("Oyuncu Listele", FontAwesome.LIST, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem) {
                ActorListPage actorListPage= new ActorListPage();
                MyUI syUI = (MyUI) UI.getCurrent();
                ContentComponent contentComponent = syUI.getContentComponent();
                contentComponent.addComponent(actorListPage);
            }
        });
        addItem("User Listele", FontAwesome.LIST, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem) {
                UserListPage userListPage= new UserListPage();
                MyUI syUI = (MyUI) UI.getCurrent();
                ContentComponent contentComponent = syUI.getContentComponent();
                contentComponent.addComponent(userListPage);
            }
        });
        addItem("User Ekle", FontAwesome.PLUS, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem) {
                UserPage user= new UserPage();
                MyUI syUI = (MyUI) UI.getCurrent();
                ContentComponent contentComponent = syUI.getContentComponent();
                contentComponent.addComponent(user);
            }
        });
        setSizeFull();
        addStyleName("syMenuBar");

        MyUI syUI = (MyUI) UI.getCurrent();
        contentComponent = syUI.getContentComponent();

        findAllMenu();
    }

    private void findAllMenu() {
    }

}
