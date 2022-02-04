package controller.czas;

import Entities.Czas;
import Entities.Pracownik;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CzasTableView extends TableView<Czas> {

    public CzasTableView() {

        TableView<Czas> usersTableView = new TableView<>();

        TableColumn<Czas, Integer> idColumn = new TableColumn<>("id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Czas, String> dataColumn = new TableColumn<>("data");
        dataColumn.setCellValueFactory(new PropertyValueFactory<>("data"));

//        TableColumn<Czas, String> nazwiskoColumn = new TableColumn<>("pracownik");
//        nazwiskoColumn.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));

        TableColumn<Czas, String> nazwiskoColumn = new TableColumn<>("pracownik");
        nazwiskoColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPracownik().toString()));

        TableColumn<Czas, Double> iloscColumn = new TableColumn<>("ilosc");
        iloscColumn.setCellValueFactory(new PropertyValueFactory<>("ilosc"));

        this.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);

        this.getColumns().addAll(idColumn, dataColumn, nazwiskoColumn, iloscColumn);
    }

    public void fill(ObservableList users) {
        this.setItems(users);
    }

}