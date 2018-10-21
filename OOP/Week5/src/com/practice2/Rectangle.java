package com.practice2;

public class Rectangle extends Shape {

    private double width;
    private double length;

    // Khởi tạo
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle() {
        this(1.0, 1.0);
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    // Diện tích
    public double getArea() {
        return this.width * this.length;
    }

    // Chu vi
    public double getPerimeter() {
        return 2 * (this.width + this.length);
    }

    @Override
    public String toString() {
        return "This is Rectangle";
    }
}
