package _202211;

public class ChampagneTower799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] row = {poured};
        for (int i = 1; i <= query_row; i++) {
            double[] next = new double[i + 1];
            for (int j = 0; j < i; j++) {
                double volume = row[j];
                if (volume > 1) {
                    next[j] += (volume - 1) / 2;
                    next[j + 1] += (volume - 1) / 2;
                }
            }
            row = next;
        }
        return Math.min(1, row[query_glass]);
    }
}
