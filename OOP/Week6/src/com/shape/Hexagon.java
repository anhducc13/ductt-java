package com.shape;

import com.location.Location2D;
import static java.lang.Math.sqrt;

public class Hexagon extends Shape {

    protected double e;
    protected Location2D center;

    public double getE() {
        return e;
    }

    public void setE(double e) {
        this.e = e;
    }

    public Location2D getCenter() {
        return center;
    }

    public void setCenter(Location2D center) {
        this.center = center;
    }


    // Diện tích
    public double getArea() {
        return 6 * e * e * sqrt(3) / 4;
    }

    // Chu vi
    public double getPerimeter() {
        return 6 * e;
    }

    @Override
    public boolean isDuplicate(Shape s) {
        if (this instanceof Hexagon && s instanceof Hexagon) {
            Hexagon h = (Hexagon) s;
            return this.e == h.e && this.center.isDuplicated(h.center);
        }
        return false;
    }

    @Override
    public String toString() {
        return "This is Hexagon. 6 Edge: " + this.e
                + ". Color: " + this.getColor() + ". Filled: " + super.isFilled();
    }
}
