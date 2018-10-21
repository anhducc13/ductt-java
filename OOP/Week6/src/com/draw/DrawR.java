package com.draw;

import com.location.Location2D;
import com.shape.Rectangle;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JOptionPane;

public class DrawR extends Draw {

    public Rectangle rect = new Rectangle();

    public void setCom(int x, int y, int w, int h) {
        rect.setWidth(w);
        rect.setLength(h);
        rect.setFirstPoint(new Location2D(x, y));

        com = new Component() {
            @Override
            public void paint(Graphics g) {
                g.setColor(rect.getColor());
                if (true) {
                    g.fillRect(0, 0, w, h);
                } else {
                    g.drawRect(0, 0, w, h);
                }
            }
        };
        com.setLocation(rect.getFirstPoint().getX(), rect.getFirstPoint().getY());
        com.setSize(w, h);
    }

    @Override
    public void add() {
        int x, y, w, h;
        try {
            String wS = JOptionPane.showInputDialog("Nhập chiều dài");
            if (wS == null) {
                com = null;
                return;
            } else {
                w = Integer.parseInt(wS);
            }

            String hS = JOptionPane.showInputDialog("Nhập chiều rộng");
            if (hS == null) {
                com = null;
                return;
            } else {
                h = Integer.parseInt(hS);
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
            rect.setColor(Color.red);
            rect.setFilled(true);
            setCom(x, y, w, h);
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

            setCom(x, y, rect.getWidth(), rect.getLength());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ liệu không đúng");
        }

    }

    @Override
    public int calculateLocationX() {
        return rect.getFirstPoint().getX();
    }

    @Override
    public int calculateLocationY() {
        return rect.getFirstPoint().getY();
    }

    @Override
    public int calculateWidthDraw() {
        return rect.getWidth();
    }

    @Override
    public int calculateHeightDraw() {
        return rect.getLength();
    }

    @Override
    public boolean isDuplicate(Draw d) {
        if (rect instanceof Rectangle && d instanceof DrawR) {
            DrawR dr = (DrawR) d;
            return rect.isDuplicate(dr.rect);
        }
        return false;
    }

}
