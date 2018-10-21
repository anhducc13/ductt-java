package com.practice2;

public class Circle extends Shape {

    private double radius;
    
    private final double PI = 3.14;

    // Khởi tạo
    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
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
    public String toString() {
        return "This is circle";
    }
}
