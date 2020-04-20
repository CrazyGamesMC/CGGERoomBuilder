package de.cg.rb.ctrl;

import de.cg.rb.windows.MainWindow;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.JMarsDarkTheme;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
            MaterialLookAndFeel.changeTheme(new JMarsDarkTheme());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        new MainWindow();

    }
}
