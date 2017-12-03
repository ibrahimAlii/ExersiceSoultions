package IntroductionToJavaProgramming.chapter13_graphics;


import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class StillClock extends JPanel {
    private int hour;
    private int minute;
    private int second;

    /**
     * Construct a default clock with the current time
     */
    public StillClock() {
        setCurrentTime();
    }

    /**
     * Construct a default clock with specified hour, minute and seconds
     *
     * @param hour   for specified hour
     * @param minute for specified minute
     * @param second for specified second
     */
    public StillClock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
        repaint();
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
        repaint();
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
        repaint();
    }

    /**
     * Draw the clock
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Initialize clock parameters
        int clockRadius =
                (int) (Math.min(getWidth(), getHeight()) * 0.8 * 0.5);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;

        //Draw circle
        g.setColor(Color.BLACK);
        g.drawOval(xCenter - clockRadius, yCenter - clockRadius,
                2 * clockRadius, 2 * clockRadius);
        g.drawString("12", xCenter - 5, yCenter - clockRadius + 12);
        g.drawString("9", xCenter - clockRadius + 3, yCenter + 5);
        g.drawString("3", xCenter + clockRadius - 10, yCenter + 3);
        g.drawString("6", xCenter - 3, yCenter + clockRadius - 3);

        //Draw second hand
        drawSecondHand(clockRadius, xCenter, yCenter, g);

        //Draw minute hand
        drawMinuteHand(clockRadius, xCenter, yCenter, g);

        //Draw hour hand
        drawHourHand(clockRadius, xCenter, yCenter, g);
    }

    private void drawSecondHand(int clockRadius, int xCenter, int yCenter, Graphics g) {
        int length = (int) (clockRadius * 0.8);
        int xSecond = (int) (xCenter + length *
                Math.sin(second * (2 * Math.PI / 60)));
        int ySecond = (int) (yCenter + length *
                Math.cos(second * (2 * Math.PI / 60)));
        g.setColor(Color.red);
        g.drawLine(xCenter, yCenter, xSecond, ySecond);
    }

    private void drawMinuteHand(int clockRadius, int xCenter, int yCenter, Graphics g) {
        int length = (int) (clockRadius * 0.65);
        int xMinute = (int) (xCenter + length *
                Math.sin(minute * (2 * Math.PI / 60)));
        int yMinute = (int) (yCenter + length *
                Math.cos(minute * (2 * Math.PI / 60)));
        g.setColor(Color.red);
        g.drawLine(xCenter, yCenter, xMinute, yMinute);
    }

    private void drawHourHand(int clockRadius, int xCenter, int yCenter, Graphics g) {
        int length = (int) (clockRadius * 0.5);
        int xHour = (int) (xCenter + length *
                Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        int yHour = (int) (yCenter + length *
                Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        g.setColor(Color.green);
        g.drawLine(xCenter, yCenter, xHour, yHour);
    }

    public void setCurrentTime(){
        // Construct a calendar for the current time
        Calendar calendar = new GregorianCalendar();

        // set current hour, minute and second
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
}
