package com.ozguryaz.ui.page;

import com.ozguryaz.ui.MyUI;
import com.ozguryaz.ui.component.SyMenuBar;
import com.vaadin.ui.*;

public class UserLogin extends HorizontalLayout {
    private TextField username;
    private TextField password;
    private Button loginbtn;
    private VerticalLayout mainLayout;
    public UserLogin() {
        setSizeFull();
        username= new TextField("Kullanıcı Adı:");
        password= new TextField("Parola:");
        loginbtn= new Button("Giriş");
        addComponent(username);
        addComponent(password);
        addComponent(loginbtn);
    }
    public UserLogin(String ilkGiris){

        mainLayout= new VerticalLayout();
        setSizeFull();
        username= new TextField("Kullanıcı Adı:");
        password= new TextField("Parola:");

        loginbtn= new Button("Giriş");
        loginbtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                if(username.getValue().equals("admin") && password.getValue().equals("admin")){
                    System.out.println("GİRDİM");
                    MyUI myUI=(MyUI) UI.getCurrent();
                    ContentComponent contentComponent = myUI.getContentComponent();
                    VerticalLayout mainLayout = myUI.getMainLayout();
                    MainPage mainPage= new MainPage();
                    VerticalLayout mainLayout1 = myUI.getMainLayout();
                    mainLayout.removeAllComponents();
                    mainLayout.addComponent(mainPage);
                }
                else{
                    System.out.println("GİREMEDİM");
                }
            }
        });

        mainLayout.addComponent(username);
        mainLayout.addComponent(password);
        mainLayout.addComponent(loginbtn);
        addComponent(mainLayout);
        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);
    }
}
