package controller.koszty;

import Entities.Koszty;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class KosztyTableView extends TableView<Koszty> {

    public KosztyTableView() {
        TableView<Koszty> usersTableView = new TableView<>();

        TableColumn<Koszty, Integer> idColumn = new TableColumn<>("id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Koszty, String> rodzajColumn = new TableColumn<>("rodzaj");
        rodzajColumn.setCellValueFactory(new PropertyValueFactory<>("rodzaj"));

        TableColumn<Koszty, String> nazwaColumn = new TableColumn<>("nazwa");
        nazwaColumn.setCellValueFactory(new PropertyValueFactory<>("nazwa"));

        TableColumn<Koszty, Double> kwotaColumn = new TableColumn<>("kwota");
        kwotaColumn.setCellValueFactory(new PropertyValueFactory<>("kwota"));

        this.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);

        this.getColumns().addAll(idColumn, rodzajColumn, nazwaColumn, kwotaColumn);
    }

    public void fill(ObservableList users) {
        this.setItems(users);
    }


}