package util;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Calc {

    /**
     * Print the vector {@param x} rounded to 3 digits after the decimal point.
     *
     * @param x the given vector
     */
    public static void printVec(double x[]) {
        for (int i = 0; i < x.length; i++) {
            System.out.printf("%.3e ", x[i]);
        }
        System.out.println();
    }

    /**
     * Print the vector {@param x} rounded to {@param n} digits after the decimal point.
     *
     * @param x the given vector
     * @param n the number of decimal places
     */
    public static void printVec(double x[], int n) {
        for (int i = 0; i < x.length; i++) {
            System.out.printf("%." + n + "e", x[i]);
        }
        System.out.println();
    }

    // 行列(2次元配列)
    public static void printMat(double A[][]) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.printf("%.3e ", A[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // ベクトルｘをスカラーｃ倍
    public static double[] scalarMultiple(double c, double x[]) {
        double[] z = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            z[i] = c * x[i];
        }
        return z;

    }

    // ベクトル同士の加算
    public static double[] addVec(double x[], double y[]) {
        double[] z = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            z[i] = x[i] + y[i];
        }
        return z;
    }

    // ベクトル同士の減算
    public static double[] subVec(double[] x, double y[]) {
        double[] z = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            z[i] = x[i] - y[i];
        }
        return z;
    }

    // ベクトル同士の内積
    public static double innProd(double x[], double y[]) {
        double z = 0;
        for (int i = 0; i < x.length; i++) {
            z += x[i] * y[i];
        }
        // z=x^T*y,z=x[1]*y[1]+…+x[n]*y[n]
        return z;
    }

    /**
     * 行列Aとベクトルｘの積
     */
    public static double[] matVec(double A[][], double x[]) {
        double[] z = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                z[i] += A[i][j] * x[j];
            }
        }
        // y[i]=A[i][1]*x[1]+…
        return z;
    }

    // 行列Aとベクトルx、bに対して、Ax-b(残差)を計算
    public static double[] residual(double A[][], double x[], double b[]) {
        double[] z = new double[x.length];
        z = subVec(matVec(A, x), b);
        return z;
    }

    // 行列同士の加算(A+B)
    public static double[][] addMat(double A[][], double B[][]) {
        double[][] z = new double[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                z[i][j] = A[i][j] + B[i][j];
            }
        }
        return z;
    }

    // 行列同士の積(AB)
    public static double[][] multipleMat(double A[][], double B[][]) {
        double[][] z = new double[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                z[i][j] = 0;
                for (int k = 0; k < A.length; k++) {
                    z[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return z;
    }


    // ベクトルの３ノルム(||x||3)の別解
    public static double vecNormInf_1(double[] x) {
        double norm = 0;
        for (int i = 0; i < x.length; i++) {
            if (norm < Math.abs(x[i])) { // 現在の最大値よりも大きい値が出たら
                norm = Math.abs(x[i]); // 変数maxに値を入れ替える
            }
        }
        return norm;
    }

    // 行列の１ノルム(||A||1)
    public static double matNorm1(double A[][]) {
        double a[] = new double[A[0].length];
        double max1 = Math.abs(A[0][0]);
        for (int i = 0; i < A[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                a[i] = a[i] + Math.abs(A[j][i]);
                if (max1 < a[i]) { // 現在の最大値よりも大きい値が出たら
                    max1 = a[i]; // 変数maxに値を入れ替える
                }
            }
        }
        return max1;
    }

    // 行列の１ノルムの別解
    public static double matNorm1_1(double A[][]) {
        double norm = 0;
        for (int i = 0; i < A[0].length; i++) {
            double s = 0;
            for (int j = 0; j < A.length; j++) {
                s += Math.abs(A[j][i]);
                if (s > norm) { // 現在の最大値よりも大きい値が出たら
                    norm = s; // 変数maxに値を入れ替える
                }
            }
        }
        return norm;
    }

    // 行列の∞ノルム(||A||∞)
    public static double matNormInf(double A[][]) {
        double a[] = new double[A.length];
        double max2 = Math.abs(A[0][0]);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                a[i] = a[i] + Math.abs(A[i][j]);
                if (max2 < a[i]) { // 現在の最大値よりも大きい値が出たら
                    max2 = a[i]; // 変数maxに値を入れ替える
                }
            }
        }
        return max2;
    }

    // 行列の∞ノルム(||A||∞)の別解
    public static double matNormInf_1(double A[][]) {
        double norm = 0;
        for (int i = 0; i < A.length; i++) {
            if (vecNorm1(A[i]) > norm) { // 現在の最大値よりも大きい値が出たら
                norm = vecNorm1(A[i]); // 変数maxに値を入れ替える
            }
        }
        return norm;
    }

    public static double[][] copyMat(double[][] A) {
        double[][] a = new double[A.length][];
        for (int i = 0; i < A.length; i++) {
            a[i] = A[i].clone();
        }
        return a;
    }

    /**
     * Get the norm1
     *
     * @param x the vector which converts norm1
     * @return the norm1 obtained from {@param x}
     */
    public static double vecNorm1(double[] x) {
        double c = 0d;
        for (int i = 0; i < x.length; i++)
            c += Math.abs(x[i]);
        return c;
    }

    /**
     * Get the norm2
     *
     * @param x the vector which converts norm1
     * @return the norm2 obtained from {@param x}
     */
    public static double vecNorm2(double[] x) {
        double c = 0d;
        for (int i = 0; i < x.length; i++)
            c += x[i] * x[i];
        return Math.sqrt(c);
    }

    /**
     * Get the normInfinity
     *
     * @param x the vector which converts normInfinity
     * @return the normInfinity obtained from {@param x}
     */
    public static double vecNormInf(double[] x) {
        double c = 0d;
        for (int i = 0; i < x.length; i++) {
            if (c < Math.abs(x[i])) c = Math.abs(x[i]);
        }
        return c;
    }
}
