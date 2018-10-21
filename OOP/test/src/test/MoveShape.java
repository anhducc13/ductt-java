package test;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class MoveShape extends JFrame {

    ArrayList<Circle> list = new ArrayList<>();

    public MoveShape() throws InterruptedException {
        setSize(1015, 640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.BLACK);
        p.setSize(1000, 600);
        getContentPane().add(p);
        initList();
        do {
            addToPanel(p);
        } while (true);
    }

    public void initList() {
        list.add(new Circle(50, 50, 40, -60, Color.BLUE));
        list.add(new Circle(150, 50, 50, 40, Color.RED));
        list.add(new Circle(50, 150, 60, 10, Color.GREEN));
        list.add(new Circle(50, 50, 25, -150, Color.YELLOW));
        list.add(new Circle(50, 50, 45, -10, Color.DARK_GRAY));
        list.add(new Circle(50, 50, 55, -45, Color.ORANGE));

        for (Circle c : list) {
            if (c.angle == 0) {
                c.vx = 10;
                c.vy = 0;
            } else if (c.angle == 180 || c.angle == -180) {
                c.vx = -10;
                c.vy = 0;
            } else if (c.angle == 90) {
                c.vx = 0;
                c.vy = 10;
            } else if (c.angle == -90) {
                c.vx = 0;
                c.vy = -10;
            } else if (c.angle > -90 && c.angle < 90 && c.angle != 0) {
                c.vx = 10;
                c.vy = (int) (c.vx * Math.tan(Math.toRadians((double) c.angle)));
            } else if (c.angle > 90 && c.angle < 180 || c.angle < -90 && c.angle > -180) {
                c.vx = -10;
                c.vy = (int) (c.vx * Math.tan(Math.toRadians((double) c.angle)));
            }
        }
    }

    public void addToPanel(JPanel p) throws InterruptedException {
        p.removeAll();
        p.setSize(1001, 600);
        for (Circle c : list) {
            p.add(new Circle(c.x, c.y, c.radius, c.angle, c.color));
        }
        p.setSize(1000, 600);
        move();
        Thread.sleep(15);
    }

    public void move() {
        for (Circle c : list) {
            if (c.x <= 0 || c.x >= 1000 - 2 * c.radius) {
                c.vx *= -1;
            }
            if (c.y <= 0 || c.y >= 600 - 2 * c.radius) {
                c.vy *= -1;
            }
            c.x += c.vx;
            c.y += c.vy;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MoveShape ms = new MoveShape();
    }
}
