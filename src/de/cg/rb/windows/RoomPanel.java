package de.cg.rb.windows;

import de.cg.rb.ctrl.GlobalSettings;
import de.cg.rb.ctrl.Main;
import de.cg.rb.ctrl.RoomObject;
import de.cg.rb.ctrl.RoomSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ConcurrentModificationException;

public class RoomPanel extends JPanel {

    public static int offsetX = 0;
    public static int offsetY = 0;

    public RoomPanel() {
        super();

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                mousePressedEvent(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(Color.DARK_GRAY);

        g.fillRect(0, 0, getWidth(), getHeight());


        g.setColor(Color.GREEN);
        try {
            for (RoomObject ro : RoomSettings.roomObjects) {
                if (ro.gameObject.displayAsRect) {
                    g.fillRect(ro.x, ro.y, ro.w, ro.h);
                } else {
                    g.drawImage(ro.gameObject.img.getScaledInstance(ro.w, ro.h, Image.SCALE_REPLICATE), ro.x, ro.y, null);
                }

            }
        } catch (ConcurrentModificationException e) {
            System.out.println("CCMException");
        }
    }

    private void mousePressedEvent(MouseEvent e) {
        var selected = GlobalSettings.selected;
        if (selected >= 0) {
            var obj = GlobalSettings.initializedObjects.get(selected);
            RoomObject ro;

            int x = e.getX();
            int y = e.getY();
            int w = obj.width;
            int h = obj.height;

            ro = new RoomObject(x, y, w, h, obj);
            RoomSettings.roomObjects.add(ro);
        }
    }
}
