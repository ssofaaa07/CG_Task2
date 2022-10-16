package vsu.cs.butovetskaya_s_i.cg.task2;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Stack;

public class DrawForm extends JFrame {

    private DrawPanel drawPanel;
    private JPanel panelMain;
    private JButton buttonGo;
    private JSpinner spinnerMovX;
    private JSpinner spinnerMovY;
    private JSpinner spinnerCompX;
    private JSpinner spinnerCompY;
    private JPanel panelMoving;
    private JPanel panelCompression;
    private JPanel panelRotate;
    private JButton buttonRectangle;
    private JPanel panelDraw;
    private JPanel panelButton;
    private JSlider sliderScaling;
    private JPanel panelScaling;
    private JButton buttonMoving;
    private JButton buttonCompression;
    private JButton buttonRotate;
    private JButton buttonScaling;
    private JSpinner spinnerRotate;
    private JLabel labelScaling;
    private JButton buttonTriangle;
    private JButton buttonRedo;
    private JTextField textFieldCompX;
    private JTextField textFieldCompY;

    private JButton buttonHexagon;

    private Rectangle2D rect;
    private Shape shape;
    private Point p1 = new Point(350, 350);
    private Point p2 = new Point(350, 250);
    private Point p3 = new Point(450, 250);
    private Point p4 = new Point(450, 350);
    private Stack<Shape> stackTransformations;


    public DrawForm() {
        this.setContentPane(panelMain);
        this.setSize(950, 700);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);

        sliderScaling.setMaximum(20);
        sliderScaling.setMinimum(0);
        sliderScaling.setValue(10);
        textFieldCompX.setText("1");
        textFieldCompY.setText("1");

        shape = new Shape(new Point[]{p1,p2,p3,p4});
        drawPanel = new DrawPanel(shape);
        panelDraw.add(drawPanel);
        stackTransformations = new Stack<>();

        JMenuBar menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        buttonRectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape = new Shape(new Point[]{new Point(350, 350),new Point(350, 250),
                        new Point(450, 250), new Point(450, 350)});
                drawPanel.setShape(shape);
                drawPanel.repaint();
            }
        });

        buttonTriangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape = new Shape(new Point[]{new Point(350, 350),new Point(350, 250), new Point(450, 350)});
                drawPanel.setShape(shape);
                drawPanel.repaint();
            }
        });

//        buttonHexagon.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                shape = new Shape(new Point[]{new Point(400,350), new Point(350,300),
//                        new Point(400,250), new Point(450,250), new Point(500,300), new Point(450,350)});
//                drawPanel.setShape(shape);
//                drawPanel.repaint();
//            }
//        });

        buttonMoving.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Transformation trans = new Transformation(shape);
                stackTransformations.push(trans.getShape());
                trans.movingMatrix(Double.parseDouble(spinnerMovX.getValue().toString()),
                        - Double.parseDouble(spinnerMovY.getValue().toString()));
                shape = trans.getShape();
                drawPanel.setShape(shape);
                drawPanel.repaint();
            }
        });

        buttonCompression.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Transformation trans = new Transformation(shape);
                stackTransformations.push(trans.getShape());
                trans.scalingMatrix(Double.parseDouble(textFieldCompX.getText()),
                        Double.parseDouble(textFieldCompY.getText()));
                drawPanel.setShape(trans.getShape());
                drawPanel.repaint();
            }
        });

        buttonScaling.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Transformation trans = new Transformation(shape);
                stackTransformations.push(trans.getShape());
                double scaling = (double) sliderScaling.getValue() / 10;
                trans.scalingMatrix(scaling, scaling);
                drawPanel.setShape(trans.getShape());
                drawPanel.repaint();
            }
        });

        sliderScaling.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelScaling.setText(String.valueOf((double) sliderScaling.getValue() / 10));
            }
        });

        buttonRotate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Transformation trans = new Transformation(shape);
                stackTransformations.push(trans.getShape());
                trans.rotateLeftMatrix(Double.parseDouble(spinnerRotate.getValue().toString()));
                drawPanel.setShape(trans.getShape());
                drawPanel.repaint();
            }
        });

        buttonRedo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape = new Shape(new Point[]{new Point(0,0)});
                drawPanel.setShape(shape);
                drawPanel.repaint();
            }
        });

        buttonGo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Transformation trans = new Transformation(shape);
                trans.movingMatrix(Double.parseDouble(spinnerMovX.getValue().toString()),
                        - Double.parseDouble(spinnerMovY.getValue().toString()));
                trans.scalingMatrix(Double.parseDouble(textFieldCompX.getText()),
                        Double.parseDouble(textFieldCompX.getText()));
                double scaling = (double) sliderScaling.getValue() / 10;
                trans.scalingMatrix(scaling, scaling);
                trans.rotateLeftMatrix(Double.parseDouble(spinnerRotate.getValue().toString()));
                drawPanel.setShape(trans.getShape());
                drawPanel.repaint();
            }
        });
    }
}


