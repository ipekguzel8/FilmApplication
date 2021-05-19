package com.ozguryaz.ui.page;
import com.ozguryaz.core.domain.Actor;
import com.ozguryaz.core.domain.Film;
import com.ozguryaz.core.domain.User;
import com.ozguryaz.core.service.ActorService;
import com.ozguryaz.core.service.UserService;
import com.ozguryaz.ui.MyUI;
import com.ozguryaz.ui.component.AuthCombobox;
import com.ozguryaz.ui.component.SySaveButton;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;

public class UserPage extends VerticalLayout {
    @PropertyId("id")
    private TextField id;

    @PropertyId("username")
    private TextField username;

    @PropertyId("password")
    private TextField password;

    @PropertyId("auth")
    private AuthCombobox auth;

    public UserPage() {
        this(new User());
    }
    private FormLayout mainLayout;

    private BeanItem<User> userBeanItem;
    private FieldGroup binder;
    private SySaveButton sySaveButton;

    private void buildFilmMainLayout() {
    }

    public UserPage(User user) {

        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);
        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        userBeanItem = new BeanItem<User>(user);
        binder = new FieldGroup(userBeanItem);
        binder.bindMemberFields(this);
    }

    private void buildMainLayout() {

        mainLayout = new FormLayout();
        mainLayout.setSizeUndefined();

        id = new TextField();
        id.setCaption("ID");
        id.setEnabled(true);
        mainLayout.addComponent(id);

        username = new TextField();
        username.setCaption("Kullanıcı Adı:");
        mainLayout.addComponent(username);

        password = new TextField();
        password.setCaption("Parola:");
        mainLayout.addComponent(password);

        auth=new AuthCombobox();
        auth.setCaption("Yetkilendirme:");
        mainLayout.addComponent(auth);

        sySaveButton = new SySaveButton();
        sySaveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try {
                    binder.commit();
                } catch (FieldGroup.CommitException e) {
                    e.printStackTrace();
                }

                User user = userBeanItem.getBean();
                UserService userService = new UserService();
                userService.save(user);
                UserListPage userListPage= new UserListPage();
                MyUI syUI = (MyUI) UI.getCurrent();
                ContentComponent contentComponent = syUI.getContentComponent();
                contentComponent.removeAllComponents();
                contentComponent.addComponent(userListPage);

            }
        });
        mainLayout.addComponent(sySaveButton);
    }
}

