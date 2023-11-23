package task2;

import java.util.Random;

public class GaussRandom {
    private static final double TWO_PI = 2 * Math.PI;
    private Random random;

    public GaussRandom() {
        random = new Random();
    }

    public GaussRandom(long seed) {
        random = new Random(seed);
    }

    public double nextNormal() {
        double fi = random.nextDouble();
        double r = random.nextDouble();
        return Math.sin(TWO_PI * fi) * Math.sqrt(-2 * Math.log(r));
    }

    public double nextNormal(double m, double sigma) {
        return m + sigma * nextNormal();
    }
}
