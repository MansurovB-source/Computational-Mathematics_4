package Plot;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

class XY {

    static XYDataset createDataset(double x[], double y[]) {
        XYSeriesCollection dataset = new XYSeriesCollection();

        XYSeries interpolation_series = new XYSeries("интерполяция");
        for (int i = 0; i < x.length; i++) {
            interpolation_series.add(x[i], y[i]);
        }
        dataset.addSeries(interpolation_series);

        return dataset;
    }
}
