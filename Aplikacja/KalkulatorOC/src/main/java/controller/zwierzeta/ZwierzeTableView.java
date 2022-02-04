package controller.zwierzeta;

import Entities.Zwierze;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ZwierzeTableView extends TableView<Zwierze> {

    public ZwierzeTableView() {
        TableView<Zwierze> usersTableView = new TableView<>();

        TableColumn<Zwierze, Integer> idColumn = new TableColumn<>("id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Zwierze, String> typColumn = new TableColumn<>("typ");
        typColumn.setCellValueFactory(new PropertyValueFactory<>("typ"));

        TableColumn<Zwierze, String> plecColumn = new TableColumn<>("płeć");
        plecColumn.setCellValueFactory(new PropertyValueFactory<>("plec"));

        TableColumn<Zwierze, String> rasaColumn = new TableColumn<>("rasa");
        rasaColumn.setCellValueFactory(new PropertyValueFactory<>("rasa"));

        TableColumn<Zwierze, Integer> wiekColumn = new TableColumn<>("wiek");
        wiekColumn.setCellValueFactory(new PropertyValueFactory<>("wiek"));

        TableColumn<Zwierze, Double> wagaColumn = new TableColumn<>("waga");
        wagaColumn.setCellValueFactory(new PropertyValueFactory<>("waga"));

        TableColumn<Zwierze, String> nazwaColumn = new TableColumn<>("nazwa");
        nazwaColumn.setCellValueFactory(new PropertyValueFactory<>("nazwa"));

        TableColumn<Zwierze, String> opisColumn = new TableColumn<>("opis");
        opisColumn.setCellValueFactory(new PropertyValueFactory<>("opis"));

        this.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);

        this.getColumns().addAll(idColumn, typColumn, plecColumn, rasaColumn, wiekColumn, wagaColumn, nazwaColumn, opisColumn);
    }

    public void fill(ObservableList users) {
        this.setItems(users);
    }
}
