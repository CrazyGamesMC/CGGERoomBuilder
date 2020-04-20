package de.cg.rb.ctrl;

import javax.swing.*;

public class SettingsQuestion {

    public String name;
    public Type type = Type.STRING;

    public JTextField textField;
    public JCheckBox checkBox;

    public SettingsQuestion(String name) {
        this.name = name;
    }

    public SettingsQuestion(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public enum Type {
        STRING, OPTIONAL_STRING, CHECKBOX;
    }




    public String getResult() {
        return textField.getText();
    }

    public boolean getBoolResult() {
        return checkBox.isSelected();
    }
}
