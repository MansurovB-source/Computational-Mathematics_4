import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean mistake;
    public static void main(String[] args) {
        Function function = new Function();
        function.showFunction();
        int func_num = func_nuc();
        function.setFunc_num(func_num);
        function.toString();
        double x_0 = setInitialValue("x0");
        double y_0 = setInitialValue("y_0");
        double end_of_line = setInitialValue("конец отрезка");
        double accuracy =  accuracy();
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
        do {
            mistake = false;
            accuracy = scanner.nextDouble();
            if(accuracy <= 0 || accuracy < 0.00001) {
                mistake = true;
                System.out.println("Введите точность в диапазоне от 0 до 0,00001 ");
            }
        }while (mistake);

        return accuracy;
    }

    private static int func_nuc() {
        int func_num;
        mistake = false;

        System.out.println("Введите номер функции");
        do {
            mistake = false;
            func_num = scanner.nextInt();
            if(func_num < 1 || func_num > 4) {
                mistake = true;
                System.out.println("Введите от 0 до 4");
            }
        }while (mistake);

        return func_num;
    }
}
