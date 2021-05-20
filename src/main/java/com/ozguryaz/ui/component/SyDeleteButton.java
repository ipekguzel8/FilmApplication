package com.ozguryaz.ui.component;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class SyDeleteButton extends Button {
    public SyDeleteButton() {
        setIcon(FontAwesome.TRASH);
        addStyleName(ValoTheme.BUTTON_DANGER);
    }
}
