package it.unife.lp.view;

import it.unife.lp.Data;
import it.unife.lp.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

public class InventoryReportController {
    
    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;

    private ObservableList<String> productNames = FXCollections.observableArrayList();

    @FXML
    private void initialize() {

        for(Product p: Data.productData) {
            if(!productNames.contains(p.name.get())) {
                productNames.add(p.name.get());
            }
        }

        xAxis.setCategories(productNames);
        setInventoryData();
    }

    public void setInventoryData() {

        int[] productQuantities = new int[productNames.size()];

        XYChart.Series<String, Integer> series = new XYChart.Series<>();

        for(int i=0; i < productNames.size(); i++) {
            for(int j=0; j < Data.productData.size(); j++) {
                if(productNames.get(i).equals(Data.productData.get(j).name.get())) {
                    productQuantities[i] += Data.productData.get(j).quantity.get();
                }
            }
        }

        for(int i=0; i < productNames.size(); i++) {
            series.getData().add(new XYChart.Data<>(productNames.get(i), productQuantities[i]));
        }

        barChart.getData().add(series);
    }
}
