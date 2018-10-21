package com.shape;

public class Square extends Rectangle {

    // Set side
    public int getSide() {
        return this.getWidth();
    }

    public void setSide(int side) {
        this.setWidth(side);
        this.setLength(side);
    }


    @Override
    public boolean isDuplicate(Shape s) {
        if (this instanceof Square && s instanceof Square) {
            Square sq = (Square) s;
            return this.getSide() == sq.getSide() && this.firstPoint.isDuplicated(sq.firstPoint);
        }
        return false;
    }

    @Override
    public String toString() {
        return "This is Square. Side: " + this.getSide() + ". Color: " + this.getColor()
                + ". Filled: " + this.isFilled();
    }
}
