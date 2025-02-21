package it.unife.lp.view;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Locale;

import it.unife.lp.Data;
import it.unife.lp.model.Sale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

public class SaleReportController {
    
    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;

    private ObservableList<String> monthNames = FXCollections.observableArrayList();

    @FXML
    private void initialize() {

        String[] months = DateFormatSymbols.getInstance(Locale.ITALIAN).getMonths();
        monthNames.addAll(Arrays.asList(months));

        xAxis.setCategories(monthNames);
        setSaleData();
    }

    public void setSaleData() {
        int[] monthCounter = new int[12];

        for(Sale s: Data.saleData) {
            int month = s.date.get().getMonthValue() - 1;
            monthCounter[month]++;
        }

        XYChart.Series<String, Integer> series = new XYChart.Series<>();

        for(int i=0; i < monthCounter.length; i++) {
            series.getData().add(new XYChart.Data<>(monthNames.get(i), monthCounter[i]));
        }

        barChart.getData().add(series);
    }
}
