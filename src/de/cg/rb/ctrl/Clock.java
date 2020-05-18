package de.cg.rb.ctrl;

public class Clock {

    public static void start() {
        while (true) {
            Main.mainWindow.roomPanel.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
