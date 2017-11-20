package IntroductionToJavaProgramming.chapter10_ThinkingInObjects;

public class Rectangle2D {
    //Data fields that specify the center of rectangle
    private double x;
    private double y;
    //Data field that specify width and high
    private double width;
    private double high;

    //no-arg constructor with default value
    public Rectangle2D(){
        this(0, 0, 1, 1);
    }

    //constructor with specified x, y, width and high
    public Rectangle2D(double x, double y, double width, double high){
        this.x = x;
        this.y = y;
        this.width = width;
        this.high = high;
    }
// Methods
    /** Returns a bounding rectangle for a set
     *   of points in a two-dimensional plane */
    public static Rectangle2D getRectangle(double[][] points) {
        final int COLUMN_X = 0;
        final int COLUMN_Y = 1;
        double[] minMaxX = minMax(points, COLUMN_X);
        double[] minMaxY = minMax(points, COLUMN_Y);
        double x = (minMaxX[1] + minMaxX[0]) / 2;
        double y = (minMaxY[1] + minMaxY[0]) / 2;
        double height = Math.sqrt(Math.pow(minMaxY[1] - minMaxY[0], 2));;
        double width = Math.sqrt(Math.pow(minMaxX[1] - minMaxX[0], 2));
        return new Rectangle2D(x, y, width, height);
    }

    private static double[] minMax(double[][] points, int col) {
        double[] minMax = new double[2];
        minMax[0] = minMax[1] = points[0][col];
        for (int i = 0; i < points.length; i++) {
            if (points[i][col] < minMax[0])
                minMax[0] = points[i][col];
            if (points[i][col] > minMax[1])
                minMax[0] = points[i][col];
        }
        return minMax;
    }

    //get area of rectangle
    private double getArea(){
        return width * high;
    }

    // get perimeter of rectangle
    private double getPerimeter(){
        return 2 * (width + high);
    }


    /*
    Check if rectangle contain this {@X, @Y} return @true in case contain them.
     */
    private boolean contains(double x, double y){
        java.awt.geom.Rectangle2D  rectangle = new java.awt.geom.Rectangle2D.Double(this.x, this.y, this.width, this.high);
        return rectangle.contains(x, y);
        /*or
        getDistance(this.y, y) <= height / 2 &&
				 getDistance(this.x, x) <= width / 2;
         */
    }

    /*
    Check if rectangle contain this {@RECTANGLE} return @true in case contain them.
     */
    private boolean contains(Rectangle2D r){
        java.awt.geom.Rectangle2D  rectangle = new java.awt.geom.Rectangle2D.Double(this.x, this.y, this.width, this.high);
        return rectangle.contains(r.getX(), r.getY());
        /*or
        getDistance(y, r.getY()) + r.getHeight() / 2 <= height / 2 &&
		 	getDistance(x, r.getX()) + r.getWidth() / 2 <= width / 2 &&
			height / 2 + r.getHeight() / 2 <= height &&
		 	width / 2 + r.getWidth() / 2 <= width;
         */
    }


    /*
    Check if rectangle overlap this {@RECTANGLE return @true in case overlap it.
     */
    private boolean overlap(Rectangle2D r){
        java.awt.geom.Rectangle2D rectangle = new java.awt.geom.Rectangle2D.Double(this.x, this.y, this.width, this.high);
        return rectangle.intersects(r.getX(), r.getY(), r.getWidth(), r.getHigh());
        /*or
        !contains(r) &&
				 ((x + width / 2 > r.getX() - r.getWidth()) ||
				 (y + height / 2 > r.getY() - r.getHeight())) &&
		  		 (getDistance(y, r.getY()) < height / 2 + r.getHeight() / 2) &&
				 (getDistance(x, r.getX()) < width / 2 + r.getWidth() / 2);
         */
    }

    /** Return distance */
    private double getDistance(double p1, double p2) {
        return Math.sqrt(Math.pow(p2 - p1, 2));
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}

