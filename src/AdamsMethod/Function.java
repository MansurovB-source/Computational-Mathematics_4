package AdamsMethod;

import static java.lang.Math.pow;
import static java.lang.Math.sin;

public class Function {
    private int func_num;

    void setFunc_num(int func_num) {
        this.func_num = func_num;
    }

    double f(double x, double y) {
        if (func_num == 1) {
            return y * sin(x) + x;
        } else if (func_num == 2) {
            return (2 * y) - (3 * pow(x, 2)) - 2;
        } else if (func_num == 3) {
            return x + y;
        } else {
            return pow(x, 2) + pow(y, 2);
        }
    }

    void showFunction() {
        System.out.println("" +
                "1) y' = y*sin(x) + x\n" +
                "2) y' = 2y - 3x^2 - 2\n" +
                "3) y' =  x + y\n" +
                "4) y' = x^2 + y^2"
        );
    }

    @Override
    public String toString() {
        System.out.println("Выбранная функция: ");
        if (func_num == 1) {
            return "1) y*sin(x) + x";
        } else if (func_num == 2) {
            return "2) y' = 2y - 3x^2 - 2";
        } else if (func_num == 3) {
            return "3) y' =  x + y";
        } else {
            return "y' = x^2 + y^2";
        }
    }
}

//1) 0 0.2 1
//2) 0 2 1
//3) 0 1 1
//4) 0 0.4 1
