package IntroductionToJavaProgramming.chapter16_event_driven_programming;

import javax.swing.*;
import java.awt.*;

public class ImageViewer extends JPanel {

    private Image image;

    private boolean stretched = true;

    private int xCoordinate;

    private int yCoordinate;

    public ImageViewer(){

    }

    public ImageViewer(Image image){
        this.image = image;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image != null){
            if (isStretched())
                g.drawImage(image, xCoordinate, yCoordinate,
                        getWidth(), getHeight(), this);
            else
                g.drawImage(image, xCoordinate, yCoordinate, this);
        }
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isStretched() {
        return stretched;
    }

    public void setStretched(boolean stretched) {
        this.stretched = stretched;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
