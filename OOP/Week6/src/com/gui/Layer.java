package com.gui;

import com.draw.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

public class Layer extends JPanel {

    public ArrayList<Draw> listShape = new ArrayList<>();

    public JPanel board;
    public JPanel control;
    public JComboBox<String> comboBoxAction;
    public int x;
    public int y;

    public Layer() {
        setLayout(null);
        setSize(Frame._width, Frame._height);
        add(setBoard());
        add(setControl());
    }

    public void drawShapeOnBoard() {
        board.removeAll();
        for (Draw ele : listShape) {
            board.setSize(800, 600);
            board.add(ele.com);
            board.setSize(801, 600);
        }
    }

    public JPanel setBoard() {
        board = new JPanel();
        board.setLayout(null);
        board.setLocation(0, 0);
        board.setSize(Frame._width * 4 / 5, Frame._height);
        return board;
    }

    public JPanel setControl() {
        control = new JPanel();
        control.setLayout(null);
        control.setLocation(Frame._width * 4 / 5, 0);
        control.setSize(Frame._width / 5, Frame._height);
        control.setBackground(Color.green);
        comboBoxAction();
        comboBoxAdd();
        delDuplicateBtn();
        chanceColorBtn();

        return control;
    }

    public void comboBoxAdd() {
        JLabel label = new JLabel("Chọn loại hình");
        label.setBounds(50, 200, 100, 25);
        control.add(label);
        String[] options = {"..............", "Hình tròn", "Hình chữ nhật", "Hình vuông", "Tam giác", "Lục giác đều"};
        JComboBox comboBoxAdd = new JComboBox(options);
        comboBoxAdd.setBounds(40, 230, 100, 25);
        control.add(comboBoxAdd);

        JButton add = new JButton();
        add.setText("Thêm hình");
        add.setBounds(40, 260, 100, 30);
        control.add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Draw c;
                board.setSize(Frame._width * 4 / 5, Frame._height);
                if (comboBoxAdd.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn loại hình");
                } else {
                    switch (comboBoxAdd.getSelectedIndex()) {
                        case 1:
                            c = new DrawC();
                            break;
                        case 2:
                            c = new DrawR();
                            break;
                        case 3:
                            c = new DrawS();
                            break;
                        case 4:
                            c = new DrawT();
                            break;
                        default:
                            c = new DrawH();
                            break;
                    }
                    c.add();
                    if (c.com != null) {
                        listShape.add(c);
                        drawShapeOnBoard();
                        comboBoxAction.addItem("Hinh" + listShape.size());
                        board.setSize(Frame._width * 4 / 5 + 1, Frame._height);
                        comboBoxAdd.setSelectedIndex(0);
                        comboBoxAction.setSelectedIndex(0);
                    }
                }

            }
        });

    }

    public void comboBoxAction() {
        JLabel label = new JLabel("Chọn hình");
        label.setBounds(60, 5, 100, 25);
        control.add(label);
        comboBoxAction = new JComboBox(new String[]{".............."});
        comboBoxAction.setBounds(40, 35, 100, 25);
        control.add(comboBoxAction);
        delButton();
        moveButton();
    }

    public void delButton() {
        JButton del = new JButton();
        del.setText("Xóa hình");
        del.setBounds(40, 65, 100, 30);
        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBoxAction.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Chọn hình cần xóa");
                } else {
                    board.setSize(Frame._width * 4 / 5, Frame._height);
                    listShape.remove(comboBoxAction.getSelectedIndex() - 1);
                    drawShapeOnBoard();
                    comboBoxAction.removeItemAt(comboBoxAction.getSelectedIndex());
                    comboBoxAction.setSelectedIndex(0);
                    board.setSize(Frame._width * 4 / 5 + 1, Frame._height);
                    JOptionPane.showMessageDialog(null, "Đã xóa hình");
                }
            }
        });
        control.add(del);
    }

    public void moveButton() {
        JButton move = new JButton();
        move.setText("Di chuyển");
        move.setBounds(40, 100, 100, 30);
        move.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBoxAction.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Chọn hình cần di chuyển");
                } else {
                    board.setSize(Frame._width * 4 / 5, Frame._height);
                    listShape.get(comboBoxAction.getSelectedIndex() - 1).move();
                    drawShapeOnBoard();
                    comboBoxAction.setSelectedIndex(0);
                    board.setSize(Frame._width * 4 / 5 + 1, Frame._height);
                    JOptionPane.showMessageDialog(null, "Xong");
                }
            }
        });
        control.add(move);
    }

    public void delDuplicateBtn() {
        JButton delDupli = new JButton();
        delDupli.setText("Xóa hình trùng");
        delDupli.setBounds(30, 320, 120, 30);

        delDupli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delDuplicate();
                drawShapeOnBoard();
            }
        });
        control.add(delDupli);

    }

    public void delDuplicate() {
        for (int i = 0; i < listShape.size(); i++) {
            for (int j = i + 1; j < listShape.size(); j++) {
                if (listShape.get(i).isDuplicate(listShape.get(j))) {
                    listShape.remove(j);
                    comboBoxAction.removeItemAt(j + 1);
                    j--;
                }
            }
        }
    }

    public void chanceColorBtn() {
        JButton chanceColor = new JButton();
        chanceColor.setText("Thay màu");
        chanceColor.setBounds(40, 140, 100, 30);
        chanceColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBoxAction.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Chọn một hình");
                } else {
                    chanceColor(listShape.get(comboBoxAction.getSelectedIndex() - 1));
                    board.removeAll();
                    drawShapeOnBoard();
                }
            }
        });
        control.add(chanceColor);
    }

    public void chanceColor(Draw d) {
        Color c;
        Object[] Objcolor = {"Gray", "Blue", "Green", "Yellow", "Orange"};
        int color = JOptionPane.showOptionDialog(null,
                "Chọn màu !",
                "Thay đổi màu",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.DEFAULT_OPTION,
                null,
                Objcolor,
                Objcolor[0]);
        switch (color) {
            case 0:
                c = Color.GRAY;
                break;
            case 1:
                c = Color.BLUE;
                break;
            case 2:
                c = Color.GREEN;
                break;
            case 3:
                c = Color.YELLOW;
                break;
            default:
                c = Color.ORANGE;
        }

        if (d instanceof DrawC) {
            DrawC dc = (DrawC) d;
            dc.circle.setColor(c);
        } else if (d instanceof DrawR) {
            DrawR dr = (DrawR) d;
            dr.rect.setColor(c);
        } else if (d instanceof DrawS) {
            DrawS ds = (DrawS) d;
            ds.square.setColor(c);
        } else if (d instanceof DrawT) {
            DrawT dt = (DrawT) d;
            dt.tri.setColor(c);
        } else {
            DrawH dh = (DrawH) d;
            dh.hexa.setColor(c);
        }
    }

}
