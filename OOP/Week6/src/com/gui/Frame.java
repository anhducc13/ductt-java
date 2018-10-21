package com.gui;

import com.draw.Draw;
import com.draw.DrawC;
import com.draw.DrawH;
import com.draw.DrawR;
import com.draw.DrawS;
import com.draw.DrawT;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Frame extends JFrame {

    public static int _width;
    public static int _height;
    public ArrayList<Layer> listLayer = new ArrayList<>();
    public JTabbedPane tp = new JTabbedPane();

    ;
    
    public Frame(int width, int height) {
        _width = width;
        _height = height;
        setSize(_width, _height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        creMenu();
        getContentPane().add(tp);
        setVisible(true);
    }

    public void creMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuAction = new JMenu("Menu");
        menuBar.add(menuAction);
        JMenuItem addLayer = new JMenuItem("Thêm Layer");
        menuAction.add(addLayer);
        addLayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Layer layerAdd = new Layer();
                tp.addTab("Layer " + (tp.getTabCount() + 1), layerAdd);
                listLayer.add(layerAdd);
            }

        });
        JMenuItem delLayer = new JMenuItem("Xóa Layer");
        menuAction.add(delLayer);
        delLayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tp.getTabCount() != 0) {
                    listLayer.remove(tp.getSelectedIndex());
                    tp.remove(tp.getSelectedIndex());
                }
            }
        });

        JMenuItem stdLayer = new JMenuItem("Chuẩn hóa");
        menuAction.add(stdLayer);
        stdLayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                standardFrame();
            }
        });

        this.setJMenuBar(menuBar);
    }

    public void standardFrame() {
        if (tp.getTabCount() != 0) {
            Layer layerCircle = new Layer();
            layerCircle.setName("Hình tròn");

            Layer layerRect = new Layer();
            layerRect.setName("Hình chữ nhật");

            Layer layerSquare = new Layer();
            layerSquare.setName("Hình vuông");

            Layer layerTri = new Layer();
            layerTri.setName("Hình tam giác");

            Layer layerHexa = new Layer();
            layerHexa.setName("Hình lục giác");

            for(int i = 0; i < tp.getTabCount(); i++) {
                for (Draw ele : ((Layer)tp.getTabComponentAt(i)).listShape) {
                    if (ele instanceof DrawC) {
                        layerCircle.add(ele);
                    } else if (ele instanceof DrawR) {
                        layerRect.add(ele);
                    } else if (ele instanceof DrawS) {
                        layerSquare.add(ele);
                    } else if (ele instanceof DrawT) {
                        layerTri.add(ele);
                    } else {
                        layerHexa.add(ele);
                    }
                }
            }
            tp.removeAll();
            
            listLayer.clear();
            
            if (!layerCircle.listShape.isEmpty()) {
                listLayer.add(layerCircle);
                tp.addTab(layerCircle.getName(), layerCircle);
            }
            if (!layerRect.listShape.isEmpty()) {
                listLayer.add(layerRect);
                tp.addTab(layerRect.getName(), layerRect);
            }
            if (!layerSquare.listShape.isEmpty()) {
                listLayer.add(layerSquare);
                tp.addTab(layerSquare.getName(), layerSquare);
            }
            if (!layerTri.listShape.isEmpty()) {
                listLayer.add(layerTri);
                tp.addTab(layerTri.getName(), layerTri);
            }
            if (!layerHexa.listShape.isEmpty()) {
                listLayer.add(layerHexa);
                tp.addTab(layerHexa.getName(), layerHexa);
            }
            System.out.println(listLayer.size());
            for (Layer l : listLayer) {
                l.drawShapeOnBoard();
            }
            this.getContentPane().removeAll();
            new Frame(_width, _height);
        }
    }

    public static void main(String[] args) {
        Frame f = new Frame(1000, 600);
    }
}
