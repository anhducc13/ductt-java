package com.practice2;

public class Square extends Rectangle{
    // Khởi tạo
    public Square() {
        super(1.0,1.0);
    }
    
    public Square(double side) {
        super(side,side);
    }
    
    public Square(double side, String color, boolean filled) {
        super(side,side,color,filled);
    }
    
    // Set side
    public double getSide() {
        return super.getWidth();
    }
    
    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }
    
    @Override
    public void setWidth(double width) {
        this.setSide(width);
    }

    @Override
    public void setLength(double length) {
        this.setSide(length);
    }    

    @Override
    public String toString() {
        return "This is Square";
    }
}
