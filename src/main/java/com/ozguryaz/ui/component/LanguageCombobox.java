package com.ozguryaz.ui.component;

import com.vaadin.data.Item;
import com.vaadin.ui.ComboBox;

public class LanguageCombobox extends ComboBox {
    public LanguageCombobox() {
        fillCombobox();
    }

    private void fillCombobox() {

        for (EnumLanguage cinsiyet : EnumLanguage.values()) {
            Item item = addItem(cinsiyet);
        }
    }
}
