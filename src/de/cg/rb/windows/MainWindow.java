package de.cg.rb.windows;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public EditPanel editPanel;
    public RoomPanel roomPanel;

    private JMenuBar bar = new JMenuBar();

    private JMenu menuFile = new JMenu("File");
    private JMenu menuProject = new JMenu("Project");

    private JMenuItem itemFileNew = new JMenu("New Room");
    private JMenuItem itemFileOpen = new JMenuItem("Open Room");
    private JMenuItem itemFileSave = new JMenuItem("Save Room");

    public MainWindow() {

        initSelf();

        initMenuBar();

        initPanels();

        repaint(); validate();

    }

    void initSelf() {
        setVisible(true);
        setSize(1280, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
    }

    void initMenuBar() {
        bar.setBounds(0,0,120,40);

        menuFile.add(itemFileNew);
        menuFile.add(itemFileOpen);
        menuFile.add(itemFileSave);

        bar.add(menuFile);

        bar.add(menuProject);
        add(bar);
    }

    void initPanels() {
        editPanel = new EditPanel();
        editPanel.setBounds(10, 50, 200, getHeight()-60);
        add(editPanel);

        roomPanel = new RoomPanel();
        roomPanel.setBounds(230, 50, getWidth()-250, getHeight()-60);
        add(roomPanel);

    }

}
