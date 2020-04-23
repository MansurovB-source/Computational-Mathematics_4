import static java.lang.Math.abs;

public class AdamsMethod {
    private double x_0;
    private double y_0;
    private double end_of_line;
    private double accuracy;
    private Function function = new Function();
    private double k[] = new double[4];
    private double h = 1;

    public double[] getX() {
        return x;
    }

    public double[] getY() {
        return y;
    }

    private double x[];
    private double y[];
    private double dy[];

    AdamsMethod(int func_num, double x_0, double y_0, double end_of_line, double accuracy) {
        function.setFunc_num(func_num);
        this.x_0 = x_0;
        this.y_0 = y_0;
        this.end_of_line = end_of_line;
        this.accuracy = accuracy;
    }

    private void methodRungeKutta(double x, double y) {
        k[0] = h * (function.f(x, y));
        for(int i = 1; i < 4; i++) {
            k[i] = h * (function.f((x + (h / 2)),(y + (k[i - 1] / 2))));
        }
        k[3] = h * (function.f((x + h), (y + k[2])));
    }

    void methodAdams() {
        h = 0.1;
        int l =  (int)(((end_of_line - x_0) / h) + 0.00001);
        x = new double[l + 1];
        y = new double[l + 1];
        dy = new double[l + 1];
        x[0] = x_0;
        y[0] = y_0;
        dy[0] = function.f(x[0], y[0]);

        for(int i = 1; i < 4; i++) {
            methodRungeKutta(x[i - 1], y[i - 1]);
            x[i] = x[i - 1] + h;
            y[i] = y[i - 1] + (k[0] + (2 * k[1]) + (2 * k[2]) + k[3]) / 6;
            dy[i] = function.f(x[i], y[i]);
        }
        double a;
        double b;
        for(int i = 3; i < l; i ++) {
            y[i + 1] = y[i] + (1.0 / 24) * h * ((55 * dy[i]) - (59 * dy[i - 1]) + (37 * dy[i - 2]) - (9 * dy[i - 3]));
            x[i + 1] = x[i] + h;
            b = y[i + 1];
            do {
                a = b;
                dy[i + 1] = function.f(x[i + 1], a);
                b = y[i] + (1.0 / 24) * h * ((9 * dy[i + 1]) + (19 * dy[i]) - (5 * dy[i - 1]) + dy[i - 2]);
            }while (abs(a - b) > accuracy);
            y[i + 1] = b;
        }
        for (int i = 0; i < x.length; i ++) {
            System.out.println(x[i] + " " + y[i]);
        }
    }
}