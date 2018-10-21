package com.location;

public class Location2D {
    private int x;
    private int y;

    public Location2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Location2D() {
        this(0,0);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public boolean isDuplicated(Location2D loca) {
        return (this.x == loca.x && this.y == loca.y);
    }
}
