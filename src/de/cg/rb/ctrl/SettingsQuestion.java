package de.cg.rb.ctrl;

public class SettingsQuestion {

    private String stringResult = "";
    private boolean boolResult = false;

    public String name;
    public Type type = Type.STRING;

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

    public void pushResult(boolean res) {
        boolResult = res;
        stringResult = "" + res;
    }

    public void pushResult(String res) {
        stringResult = res;
    }

    public String getResult() {
        return stringResult;
    }

    public boolean getBoolResult() {
        return boolResult;
    }
}
