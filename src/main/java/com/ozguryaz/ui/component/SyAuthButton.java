package com.ozguryaz.ui.component;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class SyAuthButton extends Button {
    public SyAuthButton() {
        setIcon(FontAwesome.TOGGLE_ON);
        addStyleName(ValoTheme.BUTTON_PRIMARY);
    }
}
