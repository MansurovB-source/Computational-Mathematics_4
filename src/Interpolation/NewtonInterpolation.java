package Interpolation;

import java.util.Arrays;

public class NewtonInterpolation {
    private double x_from_client[];
    private double y_from_client[];
    private double x_interpolation[];
    private double y_interpolation[];
    private double table_of_differences[][];
    private Double x_client;
    private double y_for_client;

    public void setX_client(Double x_client) {
        this.x_client = x_client;
    }

    public NewtonInterpolation(double[] x_from_client, double[] y_from_client) {
        this.x_from_client = Arrays.copyOf(x_from_client, x_from_client.length);
        this.y_from_client = Arrays.copyOf(y_from_client, y_from_client.length);
        table_of_differences = new double[x_from_client.length][];

    }

    public double[] getX_interpolation() {
        return x_interpolation;
    }

    public double[] getY_interpolation() {
        return y_interpolation;
    }

    public void tableOfDifferences() {
        for (int i = 1; i <= x_from_client.length; i++) {
            table_of_differences[i - 1] = new double[x_from_client.length - (i - 1)];
            for (int j = 0; j < x_from_client.length - (i - 1); j++) {
                if (i - 1 == 0) {
                    table_of_differences[i - 1][j] = y_from_client[j];
                } else {
                    table_of_differences[i - 1][j] = table_of_differences[(i - 1) - 1][j + 1] - table_of_differences[(i - 1) - 1][j];
                }
            }
        }
        System.out.println("-----------------------------");
        for(int i = 0; i < x_from_client.length; i++) {
            System.out.println(table_of_differences[0][i]);
        }
    }

    private double NInterpolation(double x) {
        double second_NInterpolation = 0;
        double interpolation_phase;
        interpolation_phase = (x - this.x_from_client[this.x_from_client.length - 1]) / (this.x_from_client[1] - this.x_from_client[0]);
        double cnt;
        second_NInterpolation += table_of_differences[0][table_of_differences.length - 1];
        for (int i = 1; i < table_of_differences.length; i++) {
            cnt = 1;
            cnt *= table_of_differences[i][table_of_differences.length - (i + 1)];
            for (int j = 0; j < i; j++) {
                cnt *= ((interpolation_phase + j) / (j + 1));
            }
            second_NInterpolation += cnt;
        }
        return second_NInterpolation;
    }

    public void dataset() {
        x_interpolation = new double[x_from_client.length];
        y_interpolation = new double[y_from_client.length];
        for (int i = 0; i < x_from_client.length; i++) {
            x_interpolation[i] = x_from_client[i];
            y_interpolation[i] = NInterpolation(x_from_client[i]);
        }

        if (x_client != null) {
            y_for_client = NInterpolation(x_client);
        }
        System.out.println("--------------------------------");
        for (int i = 0; i < x_interpolation.length; i ++) {
            System.out.println(x_interpolation[i] + " " + y_interpolation[i]);
        }
    }

    @Override
    public String toString() {
        if (x_client != null) {
            return "{ " +
                    "x = " + x_client +
                    ", y = " + y_for_client +
                    " }";
        }
        return "";
    }
}
