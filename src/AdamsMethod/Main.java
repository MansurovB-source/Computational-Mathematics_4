package AdamsMethod;

import Interpolation.NewtonInterpolation;
import Plot.DrawPlot;
import org.jfree.ui.RefineryUtilities;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean mistake;

    public static void main(String[] args) {
        Function function = new Function();
        function.showFunction();
        int func_num = func_nuc();
        function.setFunc_num(func_num);
        System.out.println(function.toString());
        double x_0 = setInitialValue("x0");
        double y_0 = setInitialValue("y_0");
        double end_of_line = setInitialValue("конец отрезка");
        double accuracy = accuracy();
        Double x;
        AdamsMethod adams = new AdamsMethod(func_num, x_0, y_0, end_of_line, accuracy);
        adams.methodAdams();
        NewtonInterpolation interpolation = new NewtonInterpolation(adams.getX(), adams.getY());
        if (checkUser()) {
            x = var();
        } else {
            x = null;
        }
        interpolation.setX_client(x);
        interpolation.tableOfDifferences();
        interpolation.dataset();
        DrawPlot plot = new DrawPlot(interpolation.getX_interpolation(), interpolation.getY_interpolation());
        plot.pack();
        RefineryUtilities.centerFrameOnScreen(plot);
        plot.setVisible(true);
    }

    private static double setInitialValue(String initial_value) {
        System.out.println("Введите " + initial_value + ": ");
        double value;
        value = scanner.nextDouble();
        return value;
    }

    private static double accuracy() {
        double accuracy;
        mistake = false;
        System.out.println("Введите точность:");
        do {
            mistake = false;
            accuracy = scanner.nextDouble();
            if (accuracy <= 0 || accuracy < 0.00001) {
                mistake = true;
                System.out.println("Введите точность в диапазоне от 0 до 0,00001 ");
            }
        } while (mistake);

        return accuracy;
    }

    private static int func_nuc() {
        int func_num;
        mistake = false;

        System.out.println("Введите номер функции: ");
        do {
            mistake = false;
            func_num = scanner.nextInt();
            if (func_num < 1 || func_num > 4) {
                mistake = true;
                System.out.println("Введите от 0 до 4");
            }
        } while (mistake);

        return func_num;
    }

    private static boolean checkUser() {
        String s;
        System.out.println("Хотите найти значения интерполяционной функциии в точке x\n" +
                "Введите \"Да\" или \"Нет\": ");
        do {
            mistake = false;
            s = scanner.nextLine();
            s = s.toLowerCase();
            if (!s.equals("да") && !s.equals("нет")) {
                System.out.println("Введите только \"Да\" или \"Нет\"");
                mistake = true;
            }
        } while (mistake);

        return s.equals("да");
    }

    private static double var() {
        System.out.println("Введите x  для которого надо найти f(x):");
        return scanner.nextDouble();
    }
}
