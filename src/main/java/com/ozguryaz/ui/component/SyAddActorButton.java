package com.ozguryaz.ui.component;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class SyAddActorButton extends Button {
    public SyAddActorButton() {
        setIcon(FontAwesome.PLUS);
        addStyleName(ValoTheme.BUTTON_QUIET);
    }
}
