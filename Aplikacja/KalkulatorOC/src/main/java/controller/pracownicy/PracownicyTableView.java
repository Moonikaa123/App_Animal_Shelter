package controller.pracownicy;

import Entities.Pracownik;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;


public class PracownicyTableView extends TableView<Pracownik> {

    public PracownicyTableView() {
        TableView<Pracownik> usersTableView = new TableView<>();

        TableColumn<Pracownik, Integer> idColumn = new TableColumn<>("id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Pracownik, String> imieColumn = new TableColumn<>("imie");
        imieColumn.setCellValueFactory(new PropertyValueFactory<>("imie"));

        TableColumn<Pracownik, String> nazwiskoColumn = new TableColumn<>("nazwisko");
        nazwiskoColumn.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));

        TableColumn<Pracownik, String> idPlecColumn = new TableColumn<>("plec");
        idPlecColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlec().getNazwa()));

        TableColumn<Pracownik, Integer> wiekColumn = new TableColumn<>("wiek");
        wiekColumn.setCellValueFactory(new PropertyValueFactory<>("wiek"));

        TableColumn<Pracownik, String> idStanowiskoColumn = new TableColumn<>("stanowisko");
        idStanowiskoColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStanowisko().getNazwa()));

        TableColumn<Pracownik, String> miejscowoscColumn = new TableColumn<>("miejscowosc");
        miejscowoscColumn.setCellValueFactory(new PropertyValueFactory<>("miejscowosc"));

        TableColumn<Pracownik, String> ulicaColumn = new TableColumn<>("ulica");
        ulicaColumn.setCellValueFactory(new PropertyValueFactory<>("ulica"));

        TableColumn<Pracownik, String> numerColumn = new TableColumn<>("numer");
        numerColumn.setCellValueFactory(new PropertyValueFactory<>("numer"));

        TableColumn<Pracownik, Integer> telefonColumn = new TableColumn<>("telefon");
        telefonColumn.setCellValueFactory(new PropertyValueFactory<>("telefon"));

        TableColumn<Pracownik, String> emailColumn = new TableColumn<>("email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        this.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);

        this.getColumns().addAll(idColumn, imieColumn, nazwiskoColumn,
                idPlecColumn,
                wiekColumn,
                idStanowiskoColumn,
                miejscowoscColumn, ulicaColumn, numerColumn, telefonColumn, emailColumn);
    }

    public void fill(ObservableList users) {
        this.setItems(users);
    }


}
