public class ChaosRandom {

    static private double fBaumAlpha = 4.0;
    static private double fBaumStartPop = 0.02;
    static private int fBaumKMax = 100;
    static private int fBaumKStart = 0;
    private long begin = System.nanoTime();



    public static double logMap(double current, double alpha, int iteration, int max){
        if (iteration < max) {
            return logMap(alpha * current * (1.0 - current), alpha, iteration + 1, max);
        }
        else {
            return current;
        }
    }

    /**
     *
     * @param low inclusive lower limit of random output
     * @param high exclusive upper limit of random output
     * @return random output between lower (inclusive) and upper (exclusive) bounds
     */
    public int randRange(int low, int high){
        long use = System.nanoTime() - begin;
        int random = (int) ((high - low) * (logMap(Math.abs(Math.sin(1/(100.0 / use)) * fBaumStartPop), fBaumAlpha, fBaumKStart, fBaumKMax)));
        random += low;
        return random;
    }

    public double randRange(double low, double high){
        long use = System.nanoTime() - begin;
        double random = (high - low) * (logMap(Math.abs(Math.sin(1/(100.0 / use)) * fBaumStartPop), fBaumAlpha, fBaumKStart, fBaumKMax));
        random += low;
        return random;
    }

}
