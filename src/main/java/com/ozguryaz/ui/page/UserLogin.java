package com.ozguryaz.ui.page;
import com.ozguryaz.core.domain.User;
import com.ozguryaz.core.service.UserService;
import com.ozguryaz.ui.MyUI;
import com.ozguryaz.ui.component.SyMenuBar;
import com.vaadin.ui.*;

import java.util.List;

public class UserLogin extends VerticalLayout {
    private TextField username;
    private TextField password;
    private Button loginbtn;
    private VerticalLayout mainLayout;
    public UserLogin() {
        this("");
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
                    MyUI myUI=(MyUI) UI.getCurrent();
                    ContentComponent contentComponent = myUI.getContentComponent();
                    VerticalLayout mainLayout = myUI.getMainLayout();
                    MainPage mainPage= new MainPage();
                    VerticalLayout mainLayout1 = myUI.getMainLayout();
                    mainLayout.removeAllComponents();
                    mainLayout.addComponent(mainPage);
                }
                else{
                    User user= new User();
                    user.setUsername(username.getValue());
                    user.setPassword(password.getValue());
                    UserService userService= new UserService();
                    List<User> allUser = userService.findAllUser(user);
                    if(allUser!=null){
                        System.out.println(allUser);
                        MyUI myUI=(MyUI) UI.getCurrent();
                        myUI.setUser(allUser.get(0));
                        System.out.println(allUser.get(0));
                        SyMenuBar menuBar = myUI.getMenuBar();
                        menuBar.getGiris_yap().setVisible(false);
                        menuBar.getCikis_yap().setVisible(true);
                        ContentComponent contentComponent = myUI.getContentComponent();
                        VerticalLayout mainLayout = myUI.getMainLayout();
                        MainPage mainPage= new MainPage();
                        VerticalLayout mainLayout1 = myUI.getMainLayout();
                        mainLayout.removeAllComponents();
                        mainLayout.addComponent(mainPage);
                    }

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
