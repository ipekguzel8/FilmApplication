package com.ozguryaz.ui.component;

import com.ozguryaz.core.service.FilmService;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

public class SearchComponent extends HorizontalLayout {
    private HorizontalLayout mainLayout;
    private TextField searchField;
    private Button searchButton;
    public SearchComponent() {
        setSizeFull();

        buildMainLayout();
        addComponent(mainLayout);

        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);
    }

    private void buildMainLayout() {

        mainLayout = new HorizontalLayout();

        searchField = new TextField();
        searchField.setId("searchField");
        searchField.setInputPrompt("Film veya aktör adı giriniz");
        mainLayout.addComponent(searchField);

        searchButton = new Button();
        searchButton.setIcon(FontAwesome.SEARCH);
        searchButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                //search
            }
        });
        mainLayout.addComponent(searchButton);
    }
}
