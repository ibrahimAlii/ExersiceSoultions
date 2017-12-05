package IntroductionToJavaProgramming.chapter13_graphics;

import javax.swing.*;
import java.awt.*;

public class FigurePanel extends JPanel {

    //Declare constants
    private static final int LINE = 0;
    public static final int RECTANGLE = 1;
    public static final int ROUND_RECTANGLE = 2;
    public static final int OVAL = 3;
    private static final int TRIANGLE = 4;
    private static final int POLYGON = 5;
    private static final int ARC = 6;
    public static final int CROSS_LINE = 7;


    private int type;
    private boolean filled;
    private Color color = Color.BLACK; //default is black
    private int width;
    private int height;
    private int xCoordinate;
    private int yCoordinate;
    //In case the required shape is line we need another x and y
    private int xCoordinate2;
    private int yCoordinate2;
    //Polygon and Polyline x and y
    private int[] xPoly;
    private int[] yPoly;
    //Arc angels
    private int startAngel;
    private int arcAngel;


    //No-arg constructor
    public FigurePanel() {

    }

    /**
     * Constructor with specified type
     *
     * @param type specify the type of the shape
     */
    public FigurePanel(int type) {
        this.type = type;
    }

    /**
     * Constructor with specified type and fill
     *
     * @param type   specify the type of the shape
     * @param filled specify if the shape is filled with color or not
     */
    public FigurePanel(int type, boolean filled) {
        this.type = type;
        this.filled = filled;
    }

    /**
     * Constructor with specify type and color
     *
     * @param type  specify the type of the shape
     * @param color specify the color of the shape
     */
    public FigurePanel(int type, Color color) {
        this.type = type;
        this.color = color;
    }

    /**
     * Constructor with specify type, color, x-coordinate and y-coordinate
     *
     * @param type        specify the shape type
     * @param color       specify the shape color
     * @param xCoordinate specify the x-coordinate for the shape
     * @param yCoordinate specify the y-coordinate for the shape
     */
    public FigurePanel(int type, Color color, int xCoordinate, int yCoordinate) {
        this.type = type;
        this.color = color;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    /**
     * Constructor with specify width and height
     *
     * @param type        specify the shape type
     * @param color       specify the shape color
     * @param xCoordinate specify the x-coordinate for the shape
     * @param yCoordinate specify the y-coordinate for the shape
     * @param width       specify the width for the shape
     * @param height      specify the height for the shape
     * @param filled      specify if the shape is filled
     */
    public FigurePanel(int type, Color color, int xCoordinate, int yCoordinate,
                       int width, int height, boolean filled) {
        this.type = type;
        this.color = color;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.width = width;
        this.height = height;
        this.filled = filled;
    }

    //Draw line
    public FigurePanel drawLine(Color color, int xCoordinate1, int yCoordinate1,
                                  int xCoordinate2, int yCoordinate2) {
        this.color = color;
        this.xCoordinate = xCoordinate1;
        this.yCoordinate = yCoordinate1;
        this.xCoordinate2 = xCoordinate2;
        this.yCoordinate2 = yCoordinate2;
        this.type = LINE;
        repaint();

        return this;
    }

    //Draw cross Line _|
    public FigurePanel drawCrossLine(Color verticalColor, int xCoordinate1, int yCoordinate1,
                                     int xCoordinate2, int yCoordinate2){
        this.color = verticalColor;
        this.xCoordinate = xCoordinate1;
        this.yCoordinate = yCoordinate1;
        this.xCoordinate2 = xCoordinate2;
        this.yCoordinate2 = yCoordinate2;
        this.type = CROSS_LINE;
        return this;
    }

    //Draw polygon
    public void drawPolygon(Color color, int[] x, int[] y){
        this.color = color;
        this.xPoly = x;
        this.yPoly = y;
        this.type = POLYGON;
        repaint();
    }

    //Draw polyline

    //Draw Arc
    public FigurePanel drawArc(Color color, int startAngel, int arcAngel){
        this.color = color;
        this.startAngel = startAngel;
        this.arcAngel = arcAngel;
        this.type = ARC;
        repaint();
        return FigurePanel.this;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
        repaint();
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
        repaint();
    }



    //Draw the shape
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);

        g.setColor(color);
        switch (type) {
            //Draw Line
            case LINE:
                g.drawLine(xCoordinate, yCoordinate, xCoordinate2, yCoordinate2);
                break;
            case RECTANGLE:
                if (filled) {
                    g.fillRect(xCoordinate, yCoordinate, width, height);
                }
                else {
                    g.drawRect(xCoordinate, yCoordinate, width, height);
                }
                break;
            //Draw Rectangle
            case ROUND_RECTANGLE:
                if (filled) {
                    g.fillRoundRect(xCoordinate, yCoordinate, width, height,
                            20, 20);
                }
                else {
                    g.drawRoundRect(xCoordinate, yCoordinate, width, height,
                            20, 20);
                }
                break;
            //Draw Oval
            case OVAL:
                if (filled) {
                    g.fillOval(xCoordinate, yCoordinate, width, height);
                }
                else {
                    g.drawOval(xCoordinate, yCoordinate, width, height);
                }
                break;
            //Draw Polygon
            case POLYGON:
                if (filled) {
                    g.fillPolygon(xPoly, yPoly, xPoly.length);
                }
                else {
                    g.drawPolygon(xPoly, yPoly, xPoly.length);
                }
                break;
            //Draw Arc
            case ARC:
                int x = xCenter - radius;
                int y = yCenter - radius;
                if (filled)
                    g.fillArc(x, y, 2 * radius, 2 * radius, startAngel, arcAngel);
                else
                    g.drawArc(x, y, 2 * radius, 2 * radius, startAngel, arcAngel);
                break;
                //Draw Cross Lines _|
            case CROSS_LINE:
                g.drawLine(0, yCoordinate, xCoordinate2, yCoordinate2);//vertical line
                g.drawLine(xCoordinate, 0, xCoordinate2, yCoordinate2);//horizontal line
                break;


        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
}
