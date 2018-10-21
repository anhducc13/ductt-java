package com.draw;

import com.location.Location2D;
import com.shape.Triangle;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JOptionPane;

public class DrawT extends Draw {

    public Triangle tri = new Triangle();

    public void setCom(int[] x, int[] y) {
        tri.setFirstPoint(new Location2D(x[0], y[0]));
        tri.setSecondPoint(new Location2D(x[1], y[1]));
        tri.setThirdPoint(new Location2D(x[2], y[2]));

        int[] pointDrawX = calculatePointDrawX();
        int[] pointDrawY = calculatePointDrawY();

        com = new Component() {
            @Override
            public void paint(Graphics g) {
                g.setColor(tri.getColor());
                if (true) {
                    g.fillPolygon(pointDrawX, pointDrawY, 3);
                } else {
                    g.drawPolygon(pointDrawX, pointDrawY, 3);
                }
            }
        };
        com.setLocation(this.calculateLocationX(), this.calculateLocationY());
        com.setSize(this.calculateWidthDraw(), this.calculateHeightDraw());
    }

    @Override
    public void add() {
        int x0, y0, x1, y1, x2, y2;
        try {
            String x0S = JOptionPane.showInputDialog("Điểm thứ nhất - X");
            if (x0S == null) {
                com = null;
                return;
            } else {
                x0 = Integer.parseInt(x0S);
            }

            String y0S = JOptionPane.showInputDialog("Điểm thứ nhất - Y");
            if (y0S == null) {
                com = null;
                return;
            } else {
                y0 = Integer.parseInt(y0S);
            }

            String x1S = JOptionPane.showInputDialog("Điểm thứ hai - X");
            if (x1S == null) {
                com = null;
                return;
            } else {
                x1 = Integer.parseInt(x1S);
            }

            String y1S = JOptionPane.showInputDialog("Điểm thứ hai - Y");
            if (y1S == null) {
                com = null;
                return;
            } else {
                y1 = Integer.parseInt(y1S);
            }

            String x2S = JOptionPane.showInputDialog("Điểm thứ ba - X");
            if (x2S == null) {
                com = null;
                return;
            } else {
                x2 = Integer.parseInt(x2S);
            }

            String y2S = JOptionPane.showInputDialog("Điểm thứ ba - Y");
            if (y2S == null) {
                com = null;
                return;
            } else {
                y2 = Integer.parseInt(y2S);
            }
            tri.setColor(Color.red);
            tri.setFilled(true);
            setCom(new int[]{x0, x1, x2}, new int[]{y0, y1, y2});

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ liệu không đúng");
        }
    }

    @Override
    public void move() {
        int x, y;
        try {
            String xS = JOptionPane.showInputDialog("Nhập tọa độ mới X");
            if (xS == null) {
                return;
            } else {
                x = Integer.parseInt(xS);
            }

            String yS = JOptionPane.showInputDialog("Nhập tọa độ mới Y");
            if (yS == null) {
                return;
            } else {
                y = Integer.parseInt(yS);
            }

            int subX = x - tri.getFirstPoint().getX();
            int subY = y - tri.getFirstPoint().getY();

            int x0 = x, y0 = y;
            int x1 = tri.getSecondPoint().getX() + subX;
            int y1 = tri.getSecondPoint().getY() + subY;
            int x2 = tri.getThirdPoint().getX() + subX;
            int y2 = tri.getThirdPoint().getY() + subY;
            setCom(new int[]{x0, x1, x2}, new int[]{y0, y1, y2});

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ liệu không đúng");
        }
    }

    @Override
    public int calculateLocationX() {
        return Math.min(tri.getFirstPoint().getX(), Math.min(tri.getSecondPoint().getX(), tri.getThirdPoint().getX()));
    }

    @Override
    public int calculateLocationY() {
        return Math.min(tri.getFirstPoint().getY(), Math.min(tri.getSecondPoint().getY(), tri.getThirdPoint().getY()));
    }

    @Override
    public int calculateWidthDraw() {
        return Math.max(tri.getFirstPoint().getX(), Math.max(tri.getSecondPoint().getX(), tri.getThirdPoint().getX())) - calculateLocationX() + 1;
    }

    @Override
    public int calculateHeightDraw() {
        return Math.max(tri.getFirstPoint().getY(), Math.max(tri.getSecondPoint().getY(), tri.getThirdPoint().getY())) - calculateLocationY() + 1;
    }

    public int[] calculatePointDrawX() {
        int[] pointX = new int[3];
        pointX[0] = tri.getFirstPoint().getX() - calculateLocationX();
        pointX[1] = tri.getSecondPoint().getX() - calculateLocationX();
        pointX[2] = tri.getThirdPoint().getX() - calculateLocationX();
        return pointX;
    }

    public int[] calculatePointDrawY() {
        int[] pointY = new int[3];
        pointY[0] = tri.getFirstPoint().getY() - calculateLocationY();
        pointY[1] = tri.getSecondPoint().getY() - calculateLocationY();
        pointY[2] = tri.getThirdPoint().getY() - calculateLocationY();
        return pointY;
    }

    @Override
    public boolean isDuplicate(Draw d) {
        if (tri instanceof Triangle && d instanceof DrawT) {
            DrawT dt = (DrawT) d;
            return tri.isDuplicate(dt.tri);
        }
        return false;
    }

}
