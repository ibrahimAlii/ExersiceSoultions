package IntroductionToJavaProgramming.chapter15_abstractClassesandInterfaces.F_15_1;

import IntroductionToJavaProgramming.chapter15_abstractClassesandInterfaces.AbstractDrawnFunction;

public class F2 extends AbstractDrawnFunction {
    @Override
    public double f(int i) {
        return Math.pow(i, 2);
    }
}
