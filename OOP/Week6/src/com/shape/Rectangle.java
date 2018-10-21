package com.shape;

import com.location.Location2D;
import java.awt.Color;

public class Rectangle extends Shape {
    
    protected int width;
    protected int length;
    protected Location2D firstPoint;
    
    public Location2D getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Location2D firstPoint) {
        this.firstPoint = firstPoint;
    }

    
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getLength() {
        return length;
    }
    
    public void setLength(int length) {
        this.length = length;
    }

    // Diện tích
    public int getArea() {
        return this.width * this.length;
    }

    // Chu vi
    public int getPerimeter() {
        return 2 * (this.width + this.length);
    }
    
    @Override
    public boolean isDuplicate(Shape s) {
        if (this instanceof Rectangle && s instanceof Rectangle) {
            Rectangle r = (Rectangle) s;
            return this.width == r.width && this.length == r.length
                    && this.firstPoint.isDuplicated(r.firstPoint);
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "This is Rectangle. Width: " + this.width + ". Length: " + this.length
                + ". Color: " + this.getColor() + ". Filled: " + this.isFilled();
    }
}
