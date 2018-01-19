package IntroductionToJavaProgramming.chapter15_abstractClassesandInterfaces;

public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {

    private int side;

    public Octagon(){
        this(6);
    }

    public Octagon(int side){
        this.side = side;
    }

    public double getArea(){
        return ((2 + (4 / Math.sqrt(2))) * side * side);
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Octagon) this;
    }

    @Override
    public int compareTo(Octagon o) {
        if (this.getArea() > o.getArea())
            return 1;
        else if (this.getArea() == o.getArea())
            return 0;
        else return -1;
    }
}
