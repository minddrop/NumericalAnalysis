import util.Calc;

/**
 * ガウスの消去法クラス
 * http://gi.ics.nara-wu.ac.jp/~takasu/lecture/old/archives/H16-keisankiJikken1-1.pdf
 * http://www.cs.tsukuba.ac.jp/~takahito/algebra1/system.pdf
 *
 * @author ryu
 */


public class GaussElimination {

    /**
     * 拡大係数行列
     */
    private double[][] A;

    /**
     * 拡大係数行列の行の数
     */
    private int N;

    /**
     * 与えられた拡大係数行列を前進消去法だけした行列
     */
    private double[][] solution;

    /**
     * 解
     */
    private double[] x;

    /**
     * デフォルトコンストラクタ
     */
    GaussElimination() {
        this.A = null;
        this.N = 0;
        this.solution = null;
    }

    /**
     * コンストラクター
     * ガウス消去法を行い, solutionに格納
     *
     * @param mtx 与えられた拡大係数行列
     */
    GaussElimination(double[][] mtx) {
        A = mtx;
        N = A.length;
        this.gauss();
    }

    /**
     * Gaussの消去法で連立方程式を解く
     */
    void gauss() {
        // 前進消去
        double s;
        this.solution = Calc.copyMat(A);
        for (int k = 0; k < N - 1; k++) {
            for (int i = k + 1; i < N; i++) {
                s = this.solution[i][k] / this.solution[k][k];
                for (int j = k; j <= N; j++) {
                    this.solution[i][j] -= s * this.solution[k][j];
                }
            }
        }

        this.x = new double[this.N];

        double[][] d = Calc.copyMat(this.solution);
        for (int i = N - 1; i >= 0; i--) {
            s = d[i][N];
            for (int j = i + 1; j < N; j++) {
                s -= d[i][j] * d[j][N];
            }
            d[i][N] = s / d[i][i];
        }

        // this.xに解を格納する
        for (int i = 0; i < d.length; i++) {
            x[i] = d[i][N];
        }
    }

    @Override
    public String toString() {
        String str = "\r\n\r\n";

        str += "ガウスの消去法による連立1次方程式の解";
        str += "\r\n";
        for (int i = 0; i < this.solution.length; i++) {
            str += "x[" + i + "]" + "] = " + this.x[i] + "\r\n";
        }
        str += "\r\n前進消去した後の拡大係数行列\r\n";
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution.length; j++) {
                str += String.format("%.3e ", solution[i][j]);
            }
            str += "\r\n";
        }
        str += "\r\n\r\n";
        return str;
    }

    /**
     * Gauss Elimination
     * This was made by satoniki 2years ago.
     *
     * @deprecated replaced by {@link #gauss()}
     */
    void gauss1() {
        // 前進消去
        double s;
        for (int k = 0; k < N - 1; k++) {
            for (int i = k + 1; i < N; i++) {
                s = A[i][k] / A[k][k];
                for (int j = k; j <= N; j++) {
                    A[i][j] -= s * A[k][j];
                }
            }
        }
        // 後退代入
        for (int i = N - 1; i >= 0; i--) {
            s = A[i][N];
            for (int j = i + 1; j < N; j++) {
                s -= A[i][j] * A[j][N];
            }
            A[i][N] = s / A[i][i];
        }
    }
}