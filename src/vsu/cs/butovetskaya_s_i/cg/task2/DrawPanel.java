package vsu.cs.butovetskaya_s_i.cg.task2;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class DrawPanel extends JPanel {

//    Axes axes;
    int width;
    int height;

    Shape shape;
    Axes axes;
    DrawPanel(Shape shape) {
        this.width = 700;
        this.height = 700;
        this.axes = new Axes(this.getWidth(), this.getHeight());
        this.shape = shape;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(230, 230, 250));
        g2.fillRect(0, 0, 900, 900);
        setSize(900, 900);
        drawAxes(g2);
        g2.setColor(new Color(123, 104, 238));
        g2.fillPolygon(shape.getPeaksX(), shape.getPeaksY(), shape.getPeaks().length);
    }

    public void drawAxes(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawLine(0, height / 2, width, height / 2);
        graphics2D.drawLine(width / 2, 0, width / 2, height);
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

}
