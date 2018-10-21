package com.shape;

import java.awt.Color;

public abstract class Shape {

    protected Color color;
    protected boolean filled;

    // Khởi tạo
//    Shape(Color color, boolean filled) {
//        this.color = color;
//        this.filled = filled;
//    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public boolean isFilled() {
        return this.filled;
    }

    @Override
    public String toString() {
        return "Shape{" + "color = " + color + ", filled = " + filled + '}';
    }
    
    public abstract boolean isDuplicate(Shape s);

}
