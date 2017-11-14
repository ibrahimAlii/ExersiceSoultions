package IntroductionToJavaProgramming.chapter8_objectsAndClasses;

public class GeometryNsidedRegular_8_9 {

    //number of sides int the polygon
    private int sidesCount = 3; // with initial value *3*
    private double sideLength = 1; //length of side
    private double xCoordinate = 0; //x-coordinate of the polygon center
    private double yCoordinate = 0; //y-coordinate of the polygon's center

    //no-args constructor
    public GeometryNsidedRegular_8_9(){

    }

    //constructor of specified *sides* and *length* centered at (0,0)
    public GeometryNsidedRegular_8_9(int sides, double length){
        sidesCount = sides;
        sideLength = length;
    }

    //constructor with specified SIDES, LENGTH, X and Y.
    public GeometryNsidedRegular_8_9(int sides, double length, double x, double y){
        sidesCount = sides;
        sideLength = length;
        xCoordinate = x;
        yCoordinate = y;
    }


    public int getSidesCount() {
        return sidesCount;
    }

    public void setSidesCount(int sidesCount) {
        this.sidesCount = sidesCount;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    //get the perimeter of polygon
    public double getPerimeter(){
        return sidesCount * sideLength;
    }

    //get the area od polygon
    public double getArea(){
        return (sidesCount * Math.pow(sideLength, 2) / (4 * Math.tan(Math.PI / sidesCount)));
    }
}
