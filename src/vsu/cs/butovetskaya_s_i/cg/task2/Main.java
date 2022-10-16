package vsu.cs.butovetskaya_s_i.cg.task2;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DrawForm().setVisible(true);
            }
        });
//
//        DrawForm draw = new DrawForm();
//        JFrame frame = new JFrame();
//
//        frame.setTitle("hello");
//        frame.setSize(new Dimension(810, 1000));
//        frame.setLocationRelativeTo(null);
//        frame.setLayout(new GridBagLayout());
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        DrawForm geom = new DrawForm();
//
//        frame.add(geom, new GridBagConstraints(0,0,1,1,1,1,
//                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
//                new Insets(2,2,2,2), 0, 0));
//
//        frame.setVisible(true);
    }
}