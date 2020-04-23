import static java.lang.Math.cos;
import static java.lang.Math.pow;

public class Function {
    private int func_num;

    void setFunc_num(int func_num) {
        this.func_num = func_num;
    }

    double f(double x, double y) {
        if(func_num == 1) {
            return pow((y + x), 2);
        } else if (func_num == 2) {
            return  x + cos(y / (pow(10, 0.5)));
        } else if (func_num == 3) {
            return x + y;
        } else {
            return 1;
        }
    }

    void showFunction() {
        System.out.println("" +
                "1) y' = (y + x)^2\n" +
                "2) y' =  x + cos(y /(10^(0.5)))\n" +
                "3) y' =  x + y");
    }

    @Override
    public String toString() {
        System.out.println("Выбранная функция: ");
        if(func_num == 1) {
            return "1) y' = (y + x)^2";
        } else if (func_num == 2) {
            return "2) y' =  x + cos(y /(10^(0.5)))";
        } else if (func_num == 3) {
            return "3) y' =  x + y";
        } else {
            return "";
        }
    }
}
