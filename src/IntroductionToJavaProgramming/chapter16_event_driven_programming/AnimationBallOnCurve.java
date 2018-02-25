import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationBallOnCurve extends JFrame {


    BallOnCurve ballOnCurve = new BallOnCurve();
    Timer timer = new Timer(10000, ballOnCurve);

    public AnimationBallOnCurve() {

        add(ballOnCurve);
        ballOnCurve.requestFocus();
        timer.start();

    }

    class BallOnCurve extends JPanel implements ActionListener {

        private int sineX = 0;
        private int mX = -360;
        private Polygon pSin;
        //private Polygon pCos;

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Draw sine and cosine curve
            drawSineCosiceCurve(g);
            if (mX < 360) {
                g.drawOval(mX + 200, 100 - (int) (50 * Math.sin((mX / 100.0) * 2 * Math.PI)),
                        15, 15);
                mX++;
            }else mX = -360;
            repaint();
        }

        private void drawSineCosiceCurve(Graphics g) {
            pSin = new Polygon();
            //pCos = new Polygon();

            for (sineX = -360; sineX <= 360; sineX++) {
                pSin.addPoint(sineX + 200,
                        100 - (int) (50 * Math.sin((sineX / 100.0) * 2 * Math.PI)));

                //pCos.addPoint(sineX + 200,
                //      100 - (int)(50 * Math.cos((sineX / 100.0) * 2 * Math.PI)));

            }


            g.drawLine(0, 100, 500, 100);
            g.setColor(Color.red);
            g.drawPolyline(pSin.xpoints, pSin.ypoints, pSin.npoints);
            g.setColor(Color.BLUE);
            //g.drawPolyline(pCos.xpoints, pCos.ypoints, pCos.npoints);
            g.drawString("-2\u03c0", 100, 100);
            g.drawString("2\u03c0", 300, 100);
            g.drawString("0", 200, 100);
        }
    }
}
