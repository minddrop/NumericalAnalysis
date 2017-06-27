/**
 * Created by ryoichi on 5/15/2017.
 */
public class Training02 {
    public static void main(String[] args) {
        int max_iter = 50;
        double eps = 1.0e-10;
        double x = 30;
        for (int i = 0; ; i++) {
            if (Math.abs(f(x)) < eps) {
                System.out.println(i);
                break;
            }
            x = x - f(x) / df(x);
            if (i > max_iter) {
                System.out.println(i);
                break;
            }

            System.out.print(x + "   ");

            System.out.println(x - 1.0d);
        }

        System.out.println(x);
    }


    public static double f(double x) {
        return x * x * x + x * x - 5 * x + 3;
    }

    public static double df(double x) {
        return 3 * x * x + 2 * x - 5;
    }
}
