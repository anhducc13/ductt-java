package com.shape;

import com.location.Location2D;

public class Circle extends Shape {

    protected int radius;
    public Location2D centerPoint;
    private final double PI = 3.14;

    public Location2D getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Location2D centerPoint) {
        this.centerPoint = centerPoint;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    // Diện tích
    double getArea() {
        return PI * this.radius * this.radius;
    }

    // Chu vi
    double getPerimeter() {
        return 2 * PI * this.radius;
    }

    @Override
    public boolean isDuplicate(Shape s) {
        if (this instanceof Circle && s instanceof Circle) {
            Circle c = (Circle) s;
            return this.radius == c.radius
                    && this.centerPoint.isDuplicated(c.centerPoint);

        }
        return false;
    }

    @Override
    public String toString() {
        return "Circle{" + "radius=" + radius + ", centerPoint=" + centerPoint + "color = " + color + ", filled = " + filled + '}';
    }

}
