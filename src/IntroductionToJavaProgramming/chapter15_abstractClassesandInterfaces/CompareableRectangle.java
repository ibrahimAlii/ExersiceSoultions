package IntroductionToJavaProgramming.chapter15_abstractClassesandInterfaces;

import IntroductionToJavaProgramming.chapter8_objectsAndClasses.Rectangle_8_1;
import javafx.scene.shape.Rectangle;

import java.awt.*;

public class CompareableRectangle extends Rectangle_8_1 implements Comparable<CompareableRectangle> {

    public CompareableRectangle(double width, double height){
        super(width, height);
    }
    @Override
    public int compareTo(CompareableRectangle o) {
        if (getArea() > o.getArea()) return 1;
        else if (getArea() < o.getArea()) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " Area: " + getArea();
    }
}
