package com.draw;

import com.location.Location2D;
import com.shape.Hexagon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import static java.lang.Math.sqrt;
import javax.swing.JOptionPane;

public class DrawH extends Draw {

    public Hexagon hexa = new Hexagon();

    public void setCom(int x, int y, int e) {
        hexa.setCenter(new Location2D(x, y));
        hexa.setE((double) e);

        int[] locationX = this.calculatePointDrawX();
        int[] locationY = this.calculatePointDrawY();

        com = new Component() {
            @Override
            public void paint(Graphics g) {
                g.setColor(hexa.getColor());
                if (true) {
                    g.fillPolygon(locationX, locationY, 6);
                } else {
                    g.drawPolygon(locationX, locationY, 6);
                }
            }
        };
        com.setLocation(this.calculateLocationX(), this.calculateLocationY());
        com.setSize(this.calculateWidthDraw(), this.calculateHeightDraw());
    }

    @Override
    public void add() {
        int e, x, y;
        try {
            String eS = JOptionPane.showInputDialog("Nhập cạnh lục giác đều");
            if (eS == null) {
                com = null;
                return;
            } else {
                e = Integer.parseInt(eS);
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
            hexa.setColor(Color.red);
            hexa.setFilled(true);
            setCom(x, y, e);
        } catch (Exception ex) {
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
            setCom(x, y, (int) hexa.getE());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ liệu không đúng");
        }

    }

    @Override
    public int calculateLocationX() {
        return hexa.getCenter().getX() - (int) hexa.getE();
    }

    @Override
    public int calculateLocationY() {
        double h = hexa.getE() * sqrt(3) / 2;
        return hexa.getCenter().getY() - (int) h;
    }

    @Override
    public int calculateWidthDraw() {
        return (int) hexa.getE() * 2;
    }

    @Override
    public int calculateHeightDraw() {
        double h = hexa.getE() * sqrt(3) / 2;
        return (int) (2 * h);
    }

    public int[] calculatePointDrawX() {
        int[] loca = new int[6];

        loca[0] = (int) (hexa.getE() / 2);
        loca[1] = (int) (hexa.getE() * 3 / 2);
        loca[2] = (int) (2 * hexa.getE());
        loca[3] = loca[1];
        loca[4] = loca[0];
        loca[5] = 0;

        return loca;
    }

    public int[] calculatePointDrawY() {
        int[] loca = new int[6];
        double h = hexa.getE() * sqrt(3) / 2;

        loca[0] = 0;
        loca[1] = loca[0];
        loca[2] = (int) h;
        loca[3] = 2 * loca[2];
        loca[4] = loca[3];
        loca[5] = loca[2];

        return loca;
    }

    @Override
    public boolean isDuplicate(Draw d) {
        if (hexa instanceof Hexagon && d instanceof DrawH) {
            DrawH dh = (DrawH) d;
            return hexa.isDuplicate(dh.hexa);
        }
        return false;
    }

}
