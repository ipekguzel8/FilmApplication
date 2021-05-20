package com.ozguryaz.ui.component;

import com.ozguryaz.ui.MyUI;
import com.vaadin.ui.*;

public class UserLabel extends HorizontalLayout {
    private HorizontalLayout mainLayout;
    private Label userLbl;
    public UserLabel() {
        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);
        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);
    }

    private void buildMainLayout() {
        mainLayout = new HorizontalLayout();
        userLbl=new Label();
        addComponent(userLbl);
        MyUI myUI= (MyUI) UI.getCurrent();
        String username = myUI.getUser().getUsername();
        userLbl.setValue(username);
    }
}
