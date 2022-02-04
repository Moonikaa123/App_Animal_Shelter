package controller.towar;

import Entities.Koszty;
import Entities.Towar;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TowarTableView extends TableView<Towar> {

    public TowarTableView() {

        TableView<Towar> usersTableView = new TableView<>();

        TableColumn<Towar, Integer> idColumn = new TableColumn<>("id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Towar, String> rodzajColumn = new TableColumn<>("rodzaj");
        rodzajColumn.setCellValueFactory(new PropertyValueFactory<>("rodzaj"));

        TableColumn<Towar, String> nazwaColumn = new TableColumn<>("nazwa");
        nazwaColumn.setCellValueFactory(new PropertyValueFactory<>("nazwa"));

        TableColumn<Towar, Double> iloscColumn = new TableColumn<>("ilosc");
        iloscColumn.setCellValueFactory(new PropertyValueFactory<>("ilosc"));

        TableColumn<Towar, Double> kosztColumn = new TableColumn<>("koszt");
        kosztColumn.setCellValueFactory(new PropertyValueFactory<>("koszt"));

        this.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);

        this.getColumns().addAll(idColumn, rodzajColumn, nazwaColumn, iloscColumn, kosztColumn);
    }

    public void fill(ObservableList users) {
        this.setItems(users);
    }

}
