package com.practice2;

public class Shape {

    private String color;
    private boolean filled;

    // Khởi tạo
    Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    Shape() {
        this("red", true);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    boolean isFilled() {
        return this.filled;
    }

    @Override
    public String toString() {
        return "This is shape";
    }
}
