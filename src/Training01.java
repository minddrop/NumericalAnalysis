/**
 * Created by ryoichi on 5/8/2017.
 */
public class Training01 {
    public static void main(String[] args) {
        // ニュートン法のアルゴリズムを書く. 解と反復回数を出力する.
        System.out.println("(1)");
        double a = 2;
        double b;
        int c = 0;
        while (true) {
            c++;
            b = a - (f(a) / f_x(a));
            if (Math.abs(b - a) < Math.pow(10, -12)) {
                System.out.println(a);
                System.out.println(c);
                break;
            }
            a = b;
        }

        System.out.println("(2)");
        double d = -6;
        double e;
        int f = 0;
        while (true) {
            f++;
            e = d - (ff(d) / ff_x(d));
            if (Math.abs((e - d) / d) < 1.0e-10) {
                System.out.println(d);
                System.out.println(f);
                break;
            }
            d = e;
        }

        System.out.println("(3)");
        double g = 6;
        double h;
        int i = 0;
        while (true) {
            i++;
            h = g - (fff(g) / fff_x(g));
            if (Math.abs(fff(g)) < 1.0e-6) {//1.0e-6
                System.out.println(g);
                System.out.println(i - 1);
                break;
            }
            g = h;
        }
    }

    public static double f(double x) { // (1)
        return Math.exp(x) - 2 * x - 1; // f(x) = e^x - 2x -1
    }

    public static double f_x(double x) { // (1) の 微分
        return Math.exp(x) - 2;
    }

    public static double ff(double x) { // (2)
        return Math.exp(-x / 2) * Math.sin(x) - 5 * x;
    }

    public static double ff_x(double x) { // (2) の 微分
        return -1 / 2 * Math.exp(-x / 2) * Math.sin(x) + Math.exp(-x / 2) * Math.cos(x) - 5;
    }

    public static double fff(double x) { // (3)
        return Math.cos(2 * x) + 2 * Math.sin(x) + 1 / x;
    }

    public static double fff_x(double x) { // (3) の 微分
        return -2 * Math.sin(2 * x) + 2 * Math.cos(x) - 1 / x / x;
    }
}