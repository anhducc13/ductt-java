package com.draw;

import com.location.Location2D;
import com.shape.Square;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JOptionPane;

public class DrawS extends Draw {

    public Square square = new Square();

    public void setCom(int x, int y, int s) {
        square.setSide(s);
        square.setFirstPoint(new Location2D(x, y));

        com = new Component() {
            @Override
            public void paint(Graphics g) {
                g.setColor(square.getColor());
                if (true) {
                    g.fillRect(0, 0, s, s);
                } else {
                    g.drawRect(0, 0, s, s);
                }
            }
        };
        com.setLocation(square.getFirstPoint().getX(), square.getFirstPoint().getY());
        com.setSize(s, s);
    }

    @Override
    public void add() {
        int x, y, s;
        try {
            String sS = JOptionPane.showInputDialog("Nhập kích thước");
            if (sS == null) {
                com = null;
                return;
            } else {
                s = Integer.parseInt(sS);
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
            square.setColor(Color.red);
            square.setFilled(true);
            setCom(x, y, s);
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
            setCom(x, y, square.getSide());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ liệu không đúng");
        }

    }

    @Override
    public int calculateLocationX() {
        return square.getFirstPoint().getX();
    }

    @Override
    public int calculateLocationY() {
        return square.getFirstPoint().getY();
    }

    @Override
    public int calculateWidthDraw() {
        return square.getSide();
    }

    @Override
    public int calculateHeightDraw() {
        return square.getSide();
    }

    @Override
    public boolean isDuplicate(Draw d) {
        if (square instanceof Square && d instanceof DrawS) {
            DrawS ds = (DrawS) d;
            return square.isDuplicate(ds.square);
        }
        return false;
    }

}
