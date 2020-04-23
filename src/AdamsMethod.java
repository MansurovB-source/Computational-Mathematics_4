public class AdamsMethod {
    private double end_of_line;
    private double accuracy;
    private Function function = new Function();
    private double k[] = new double[4];
    private double h = 1;
    private double x[];
    private double y[];
    private double dy[];

    public AdamsMethod(int func_num, double x_0, double y_0, double end_of_line, double accuracy) {
        function.setFunc_num(func_num);
        x[0] = x_0;
        y[0] = y_0;
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
        int l =  (int)(((end_of_line - x[0]) / h) + 0.00001);
        x = new double[l];
        y = new double[l];
        dy[0] = function.f(x[0], y[0]);

        for(int i = 1; i < 4; i++) {
            methodRungeKutta(x[i], y[i]);
            y[i] = y[i - 1] + (k[0] + 2 * k[1] + 2 * k[2] + k[3]) / 6;
            x[i] = x[i - 1] + h;
            dy[i] = function.f(x[i], y[i]);
        }
        double a;
        double b;
        for(int i = 4; i <= l; i ++) {
            y[i] = y[i] + (1.0 / 24) * h * (55 * dy[i - 1] - 59 * dy[i - 2] + 37 * dy[i] - 9 * dy[i - 1]);
            x[i] = x[i] + h;
            b = y[i];
            do {
                a = b;
                dy[i] = function.f(x[4], a);
                b = y[3] + (1.0 / 24) * h * (9 * dy[4] + 19 * dy[3] - 5 * dy[2] + dy[1]);
            }while (a - b <= accuracy);
            y[i] = b;
        }
        for (int i = 0; i < x.length; i ++) {
            System.out.println(x[i] + " " + y[i]);
        }
    }
}