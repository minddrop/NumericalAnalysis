/**
 * Created by ryoichi on 6/26/2017.
 */

import util.Calc;

public class Example {
    public static void main(String[] args) {

        // 拡大係数行列の準備
        double[][] a = new double[5][6];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                a[i][j] = 1d / ((i + 1) + (j + 1));
            }
        }
        for (int i = 0; i < 5; i++) {
            a[i][5] = 1;
        }

        // ガウス消去法クラスのインスタンス作成
        GaussElimination gs = new GaussElimination(a);

        // 解の表示
        System.out.println(gs);

        // 拡大係数行列の準備
        double[][] b = new double[5][6];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                b[i][j] = 1d / ((i + 1) + (j + 1));
            }
        }
        double[] d = new double[]{1.45, 1.093, 0.8845, 0.7456, 0.6456};
        double[] rest = new double[]{0.00145, 0, 0, 0, 0};
        for (int i = 0; i < 5; i++) {
            b[i][5] = Calc.addVec(d, rest)[i];
        }

        // ガウス消去法クラスのインスタンス作成
        GaussElimination g = new GaussElimination(b);
        // 解の表示
        System.out.println(g);
    }
}
