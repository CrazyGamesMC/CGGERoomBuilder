package de.cg.rb.windows;

import de.cg.rb.ctrl.SettingsQuestion;

import javax.swing.*;

public class SettingsWindow extends JFrame {

    private SettingsQuestion[] questions;

    public SettingsWindow(String title, SettingsQuestion... questions) {
        this.questions = questions;
    }

    public void onConfirm() {

    }

}
