package com.shape;

import com.location.Location2D;
import static java.lang.Math.*;

public class Triangle extends Shape {

    protected double a;
    protected double b;
    protected double c;
    
    protected Location2D firstPoint;
    protected Location2D secondPoint;
    protected Location2D thirdPoint;

    public Location2D getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Location2D firstPoint) {
        this.firstPoint = firstPoint;
    }

    public Location2D getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Location2D secondPoint) {
        this.secondPoint = secondPoint;
    }

    public Location2D getThirdPoint() {
        return thirdPoint;
    }

    public void setThirdPoint(Location2D thirdPoint) {
        this.thirdPoint = thirdPoint;
    }
    

    // Diện tích
    public double getArea() {
        double p = (a + b + c) / 2;
        return sqrt(p * (p - a) * (p - b) * (p - c));
    }

    // Chu vi
    public double getPerimeter() {
        return (a + b + c);
    }
    
    @Override
    public boolean isDuplicate(Shape s) {
        if(this instanceof Triangle && s instanceof Triangle) {
            Triangle t = (Triangle)s;
            return this.firstPoint.isDuplicated(t.firstPoint) && 
                    this.secondPoint.isDuplicated(t.secondPoint) &&
                    this.thirdPoint.isDuplicated(t.thirdPoint);
        }
        return false;
    }

    @Override
    public String toString() {
        return "This is Triangle. 3 Edge: " + this.a + ", " + this.b + ", " + this.c
                + ". Color: " + this.getColor() + ". Filled: " + super.isFilled();
    }
}
