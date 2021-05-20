package com.ozguryaz.ui.page;

import com.ozguryaz.ui.MyUI;
import com.ozguryaz.ui.component.SearchComponent;
import com.ozguryaz.ui.component.SyMenuBar;
import com.ozguryaz.ui.component.UserLabel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class MainPage extends VerticalLayout {
    public MainPage() {
        setSizeFull();
        MyUI myUI= (MyUI) UI.getCurrent();
        ContentComponent contentComponent = myUI.getContentComponent();
        SearchComponent searchComponent = new SearchComponent();
        UserLabel userLabel= new UserLabel();
        addComponent(userLabel);
        addComponent(searchComponent);

        SyMenuBar menuBar = myUI.getMenuBar();

        addComponent(menuBar);
        addComponent(contentComponent);

        setExpandRatio(searchComponent, 1f);
        setExpandRatio(userLabel, 0.5f);
        setExpandRatio(menuBar, 0.5f);
        setExpandRatio(contentComponent, 8.0f);
    }
}
