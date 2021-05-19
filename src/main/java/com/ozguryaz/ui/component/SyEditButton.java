package com.ozguryaz.ui.component;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class SyEditButton extends Button {

    public SyEditButton() {
        setIcon(FontAwesome.EDIT);
        addStyleName(ValoTheme.BUTTON_FRIENDLY);
    }
}
