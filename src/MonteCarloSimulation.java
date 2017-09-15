public class MonteCarloSimulation {
    public void getSimulation() {
        int totalTrials = 1000000;
        int numHits = 0;

        for (int i = 0; i < totalTrials; i++) {

            double x = Math.random() * 2.0 - 1;
            double y = Math.random() * 2.0 - 1;

            if (x < 0 || DraftProp(x , y)){
                numHits ++;
            }

            System.out.println((1.0 * numHits / totalTrials));
        }
    }

    private static  boolean DraftProp(double x, double y) {

        if (x > 1 || x < 0 || y > 1 || y < 0){
            return false;
        }else {

            double slope = (1.0 - 0) / (0 - 1.0);
            double x1 = x + -y * slope;
            if (x1 <= 1){
                return true;
            }else {
                return false;
            }
        }
    }


}



