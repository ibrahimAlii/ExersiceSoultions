package IntroductionToJavaProgramming.chapter10_ThinkingInObjects.triangle2D;

/**********************************
 *            MyPoint              *
 *---------------------------------*
 * -x: double                      *
 * -y: double                      *
 * +MyPoint()                      *
 * +MyPoint(x: double, y: double)  *
 * +getX(): double                 *
 * +getY(): double                 *
 * +distance(myPoint: MyPoint)     *
 * +distance(x: double, y: double) *
 **********************************/
public class MyPoint {

    //Define x and y
    private double x;
    private double y;

    //Define no-arg constructor with default value
    public MyPoint(){
        this(1 , 1);
    }

    //Define constructor with specific {@params} x and y.
    public MyPoint(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /*
    Get distance between two points, @param MyPoint
     */
    public double distance(MyPoint myPoint){
        return Math.sqrt(Math.pow(myPoint.getX() - x, 2) +
                Math.pow(myPoint.getY() - y, 2));
    }

    /*
    Get distance between two points, @param x, y.
     */
    public double distance(double x, double y){
        return distance(new MyPoint(x, y));
    }

    /**
     * Return true if point (x2, y2) is on the
     * line segment from (x0, y0) to (x1, y1)
     */
    /** Return true if this point is on the
     *  line segment from p0 to p1 */
    public boolean onTheLineSegment(MyPoint p0, MyPoint p1) {

        return onTheLineSegment(p0.x, p0.y, p1.x, p1.y, x, y);

    }

    /** Return true if point (x2, y2) is on the
     *  line segment from (x0, y0) to (x1, y1) */
    public static boolean onTheLineSegment(double x0, double y0, double x1, double y1, double x2, double y2) {

        double position = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);

        return position <= 0.0000000001 && ((x0 <= x2 && x2 <= x1) || (x0 >= x2 && x2 >= x1));
    }
}
