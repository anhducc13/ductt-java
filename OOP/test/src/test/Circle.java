package test;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Admin
 */
public class Circle extends Component {

    public int x;
    public int y;
    public int radius;
    public int angle;
    public int vx;
    public int vy;
    public Color color;

    @Override
    public void paint(Graphics g) {
        g.setColor(this.color);
        g.fillOval(0, 0, 2 * radius, 2 * radius);
    }

    public Circle(int x, int y, int radius, int angle, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.radius = radius;
        this.angle = angle;
        this.setLocation(x, y);
        this.setSize(2 * radius, 2 * radius);
    }
}
