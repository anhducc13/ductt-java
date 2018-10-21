package com.draw;

import com.location.Location2D;
import com.shape.Circle;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JOptionPane;

public class DrawC extends Draw {

    public Circle circle = new Circle();

    public void setCom(int x, int y, int r) {
        circle.setRadius(r);
        circle.setCenterPoint(new Location2D(x, y));

        com = new Component() {
            @Override
            public void paint(Graphics g) {
                g.setColor(circle.getColor());
                if (true) {
                    g.fillOval(0, 0, 2 * r, 2 * r);
                } else {
                    g.drawOval(0, 0, 2 * r, 2 * r);
                }
            }
        };
        com.setLocation(this.calculateLocationX(), this.calculateLocationY());
        com.setSize(this.calculateWidthDraw(), this.calculateHeightDraw());
    }

    @Override
    public void add() {
        int r, x, y;
        try {
            String rS = JOptionPane.showInputDialog("Nhập bán kính");
            if (rS == null) {
                com = null;
                return;
            } else {
                r = Integer.parseInt(rS);
            }

            String xS = JOptionPane.showInputDialog("Nhập tọa độ X");
            if (xS == null) {
                com = null;
                return;
            } else {
                x = Integer.parseInt(xS);
            }

            String yS = JOptionPane.showInputDialog("Nhập tọa độ Y");
            if (yS == null) {
                com = null;
                return;
            } else {
                y = Integer.parseInt(yS);
            }
            circle.setColor(Color.red);
            circle.setFilled(true);
            setCom(x, y, r);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ liệu không đúng");
            com = null;
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

            setCom(x, y, circle.getRadius());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ liệu không đúng");
        }
    }

    @Override
    public int calculateLocationX() {
        return circle.getCenterPoint().getX() - circle.getRadius();
    }

    @Override
    public int calculateLocationY() {
        return circle.getCenterPoint().getY() - circle.getRadius();
    }

    @Override
    public int calculateWidthDraw() {
        return 2 * circle.getRadius();
    }

    @Override
    public int calculateHeightDraw() {
        return 2 * circle.getRadius();
    }

    @Override
    public boolean isDuplicate(Draw d) {
        if (circle instanceof Circle && d instanceof DrawC) {
            DrawC dc = (DrawC) d;
            return circle.isDuplicate(dc.circle);
        }
        return false;
    }

}
