package de.cg.rb.ctrl;

import java.awt.*;

public class GameObject {

    public int width = 0;
    public int height = 0;

    public boolean displayAsRect;
    public boolean includeWAndHInConstructor;

    public String pckg;
    public String name;
    public Image img;

    public GameObject(int width, int height, boolean displayAsRect, boolean includeWAndHInConstructor, String pckg, String name, Image img) {
        this.width = width;
        this.height = height;
        this.displayAsRect = displayAsRect;
        this.includeWAndHInConstructor = includeWAndHInConstructor;
        this.pckg = pckg;
        this.name = name;
        this.img = img;
    }
}
