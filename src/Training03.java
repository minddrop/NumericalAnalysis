/**
 * Created by ryoichi on 5/22/2017.
 */
public class Training03 {
    public static void main(String[] args) {
        double[][] a = new double[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                a[i][j] = 1d / ((i + 1) + (j + 1));
            }
        }
        double[] b = new double[]{1, 1, 1, 1, 1};
        double[][] c = new double[5][5];

        int n = a.length;

        double alpha = 0.0d;


        for (int k = 1; k < n; k++) {
            for (int i = k + 1; i <= n; i++) {
                alpha = a[i - 1][k - 1] / a[k - 1][k - 1];
                for (int j = k + 1; j <= a.length; j++) {
                    a[i - 1][j - 1] = a[i - 1][j - 1] - alpha * a[k - 1][j - 1];
                }
                b[i - 1] = b[i - 1] - alpha * b[k];
            }
        }

        for (int k = a.length; k > 0; k--) {
            b[k] = (b[k]) / a[k][k];
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(a[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
