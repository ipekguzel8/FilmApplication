package com.ozguryaz.ui.component;

import com.vaadin.data.Item;
import com.vaadin.ui.ComboBox;

public class AuthCombobox extends ComboBox {
    public AuthCombobox() {
        fillCombobox();
    }

    private void fillCombobox() {

        for (EnumAuth auth : EnumAuth.values()) {
            Item item = addItem(auth);
        }
    }
}
