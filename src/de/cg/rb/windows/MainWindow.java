package de.cg.rb.windows;

import de.cg.rb.ctrl.FileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainWindow extends JFrame {

    public EditPanel editPanel;
    public RoomPanel roomPanel;

    private JMenuBar bar = new JMenuBar();

    private JMenu menuFile = new JMenu("File");
    private JMenu menuProject = new JMenu("Project");

    private JMenuItem itemFileNew = new JMenuItem("New Room");
    private JMenuItem itemFileOpen = new JMenuItem("Open Room");
    private JMenuItem itemFileSave = new JMenuItem("Save Room");

    private JMenuItem itemProjectAddObject = new JMenuItem("Add Object");

    public MainWindow() {

        initSelf();

        initMenuBar();

        initPanels();

        initEvents();

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

        itemFileNew.addActionListener(e -> new NewRoomWindow());
        menuFile.add(itemFileNew);
        menuFile.add(itemFileOpen);
        menuFile.add(itemFileSave);

        bar.add(menuFile);

        itemProjectAddObject.addActionListener(e -> new AddObjectsWindow());
        menuProject.add(itemProjectAddObject);

        bar.add(menuProject);
        add(bar);
    }

    void initPanels() {
        editPanel = new EditPanel();
        editPanel.setBounds(10, 50, 200, getHeight()-120);
        add(editPanel);

        roomPanel = new RoomPanel();
        roomPanel.setBounds(230, 50, getWidth()-250, getHeight()-60);
        roomPanel.setFocusable(true);
        add(roomPanel);

    }

    void initEvents() {
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                FileManager.saveConfig();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

}
