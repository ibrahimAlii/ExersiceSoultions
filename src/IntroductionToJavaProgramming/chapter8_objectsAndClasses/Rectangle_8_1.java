package IntroductionToJavaProgramming.chapter8_objectsAndClasses;

public class Rectangle_8_1 {

    //define width and height
    private double width = 1;
    private double height = 1;

    //define no-arg constructor
    public Rectangle_8_1(){
        //create default rectangle
    }

    //define constructor that create rectangle with specific height and width
    public Rectangle_8_1(double width, double height){
        this.height = height;
        this.width = width;
    }

    //a method to get the area of the rectangle
    public double getArea(){
        return width * height;
    }

    //a method to get the perimeter of rectangle
    public double getPerimeter(){
        return (width + height) * 2;
    }

}
