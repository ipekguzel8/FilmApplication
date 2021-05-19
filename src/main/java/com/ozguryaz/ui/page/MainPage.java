package com.ozguryaz.ui.page;

import com.ozguryaz.ui.MyUI;
import com.ozguryaz.ui.component.SearchComponent;
import com.ozguryaz.ui.component.SyMenuBar;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class MainPage extends VerticalLayout {
    public MainPage() {
        setSizeFull();
        MyUI myUI= (MyUI) UI.getCurrent();
        ContentComponent contentComponent = myUI.getContentComponent();
        SearchComponent searchComponent = new SearchComponent();
        addComponent(searchComponent);

        SyMenuBar syMenuBar = new SyMenuBar();

        addComponent(syMenuBar);
        addComponent(contentComponent);

        setExpandRatio(searchComponent, 1f);
        setExpandRatio(syMenuBar, 0.4f);
        setExpandRatio(contentComponent, 8.6f);
    }
}
