package com.draw;

import java.awt.Component;

public abstract class Draw extends Component {
    public Draw() {
        com = null;
    }
    public Component com;

    public abstract void add();

    public abstract void move();

    public abstract int calculateLocationX();

    public abstract int calculateLocationY();

    public abstract int calculateWidthDraw();

    public abstract int calculateHeightDraw();
    
    public abstract boolean isDuplicate(Draw d);
}
