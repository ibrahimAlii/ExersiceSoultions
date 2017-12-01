package IntroductionToJavaProgramming.chapter13_graphics;

import javax.swing.*;
import java.awt.*;

public class MessagePanel extends JPanel {
    /** The message to be displayed */
    private String message = "Welcome To Java";

    /** The x-coordinate where the message displayed*/
    private int xCoordinate = 20;

    /** The y-coordinate where the message displayed*/
    private int yCoordinate = 20;

    /** Indicate whether the message is displayed in the center*/
    private boolean centred;

    /** The interval for moving message horizontally and vertically*/
    private int interval = 10;

    /** Construct with default properties*/
    public MessagePanel(){

    }

    /** Construct a message panel with specified message*/
    public MessagePanel(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        repaint();
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
        repaint();
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
        repaint();
    }

    public boolean isCentred() {
        return centred;
    }

    public void setCentred(boolean centred) {
        this.centred = centred;
        repaint();
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (centred){
            FontMetrics fm = g.getFontMetrics();

            //find the center location to display
            int stringWidth = fm.stringWidth(message);
            int stringAscent = fm.getAscent();
            //Get the position of the leftmost character in the baseline
            xCoordinate = getWidth() / 2 - stringWidth / 2;
            yCoordinate = getHeight() / 2 + stringAscent / 2;
        }
        g.drawString(message, xCoordinate, yCoordinate);
    }

    /** Move the message left*/
    public void moveLeft(){
        xCoordinate -= interval;
        repaint();
    }

    /** Move the message right*/
    public void moveRight(){
        xCoordinate += interval;
        repaint();
    }

    /** Move the message up*/
    public void moveUp(){
        yCoordinate -= interval;
        repaint();
    }

    /** Move the message down*/
    public void moveDown(){
        yCoordinate += interval;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 300);
    }
}
