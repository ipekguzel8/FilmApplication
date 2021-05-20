package com.ozguryaz.ui.component;

import com.ozguryaz.ui.MyUI;
import com.ozguryaz.ui.page.*;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class SyMenuBar extends MenuBar {
    public MenuItem getGiris_yap() {
        return giris_yap;
    }

    public MenuItem getCikis_yap() {
        return cikis_yap;
    }

    public void setCikis_yap(MenuItem cikis_yap) {
        this.cikis_yap = cikis_yap;
    }

    public void setGiris_yap(MenuItem giriş_yap) {
        this.giris_yap = giriş_yap;
    }

    private ContentComponent contentComponent;
    private MenuItem giris_yap;
    private MenuItem cikis_yap;
    public SyMenuBar() {
        giris_yap= new MenuItem("",null,null);
        cikis_yap= new MenuItem("",null,null);
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
        giris_yap = this.addItem("Giriş Yap", FontAwesome.SIGN_IN, new Command() {

            @Override
            public void menuSelected(MenuItem menuItem) {
                UserPage user = new UserPage();
                MyUI syUI = (MyUI) UI.getCurrent();
                ContentComponent contentComponent = syUI.getContentComponent();
                ;
                UserLogin userLogin = new UserLogin();
                contentComponent.removeAllComponents();
                contentComponent.addComponent(userLogin);
            }
        });
        cikis_yap = this.addItem("Çıkış Yap", FontAwesome.SIGN_OUT, new Command() {

            @Override
            public void menuSelected(MenuItem menuItem) {
                UserLogin user = new UserLogin();
                MyUI syUI = (MyUI) UI.getCurrent();
                VerticalLayout mainLayout = syUI.getMainLayout();
                mainLayout.removeAllComponents();
                syUI.getMenuBar().cikis_yap.setVisible(false);
                syUI.getMenuBar().giris_yap.setVisible(true);
                mainLayout.addComponent(user);
                ContentComponent contentComponent = syUI.getContentComponent();
                syUI.setUser(null);
                contentComponent.removeAllComponents();
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
