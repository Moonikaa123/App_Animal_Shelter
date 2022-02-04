package controller.czas;

import Models.CzasModel;
import Models.PracownikModel;
import Models.StanowiskoModel;
import Models.TowarModel;
import controller.Alerty;
import controller.MainPaneController;
import controller.MainPaneController2;
import controller.MainPaneController4;
import controller.pracownicy.PracownicyTableView;
import controller.towar.TowarTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import Entities.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class MainPaneController12 {

    ObservableList list12 = FXCollections.observableArrayList();

    public static CzasModel czasModel = new CzasModel();

    public CzasTableView usersTableView;
    public static PracownikModel pracownikModel = new PracownikModel();
    ObservableList pracownicy = FXCollections.observableArrayList();

    @FXML
    private AnchorPane dodanieCzas;

    @FXML
    private TextField ilosc;

    @FXML
    private Button dodaj;

    @FXML
    private Button powrot;

    @FXML
    private Button exportBtn;

    @FXML
    private Button edytuj;

    @FXML
    private Button pobierz;

    @FXML
    private Button usun;

    @FXML
    private Pane listPane;

    @FXML
    private ChoiceBox<Pracownik> pracownik;

    @FXML
    private TextField data;

    public void setScreen(Pane pane) {
        dodanieCzas.getChildren().clear();
        dodanieCzas.getChildren().add(pane);
    }

    public void initialize(){

        pracownicy.removeAll(pracownicy);
        pracownicy = pracownikModel.getAllUsers();
        pracownik.getItems().addAll(pracownicy);

        fillWithUsers();
        metoda1();

    }

    private void metoda1() {

        exportBtn.setOnAction(event -> {
            tableToCSV();
        });

        pobierz.setOnAction(event -> {
            odczytanieWiersza();
        });

        dodaj.setOnAction(event -> {
            try {
                dodanieDoBazy();
                fillWithUsers();

            } catch (NumberFormatException e) {
                Alerty.wyswietlenieAlertuOst();
            }
        });

        edytuj.setOnAction(event -> {
            try {
                aktualizacjaWBazie();
                fillWithUsers();
            } catch (NumberFormatException e) {
                Alerty.wyswietlenieAlertuOst();
            }
        });

        usun.setOnAction(event -> {
            try {
                wyswietlenieKomunikatuPrzedUsunieciem();
            } catch (NumberFormatException e) {
                Alerty.wyswietlenieAlertuOst();
            }
        });


        powrot.setOnAction(event -> {
            try {
                System.out.println("Wcisnieto przycisk 2");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main1.fxml"));
                Pane pane = loader.load();
                MainPaneController mainPaneController55 = loader.getController();
                setScreen(pane);
            } catch (NullPointerException e) {
                System.out.println("blad");
            } catch (NumberFormatException n) {
                System.out.println("blad");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void odczytanieWiersza() {

        Czas czas = usersTableView.getSelectionModel().getSelectedItem();

        data.setText(czas.getData());
        pracownik.setValue(czas.getPracownik());
        ilosc.setText(String.valueOf(czas.getIlosc()));

    }

    private void wyswietlenieKomunikatuPrzedUsunieciem() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Czy na pewno chcesz usunąć wskazany rekord?");

        ButtonType buttonTypeYes = new ButtonType("Tak");
        ButtonType buttonTypeNo = new ButtonType("Nie");
        ButtonType buttonTypeCancel = new ButtonType("Anuluj", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo,buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeYes){
            usuniecieZBazy();
            fillWithUsers();
            Alerty.wyswietlenieAlertuUsuniecieZBazy();
        } else if (result.get() == buttonTypeNo){
            System.out.println("pa pa");
        }
    }

    public void fillWithUsers() {

        czasModel = new CzasModel();
        usersTableView = new CzasTableView();
        usersTableView.getItems().clear();
        usersTableView.fill(czasModel.getAllCzas());
        listPane.getChildren().clear();
        listPane.getChildren().add(usersTableView);
    }

    private void dodanieDoBazy() {

        String data1 = data.getText();

        double ilosc1 = Double.parseDouble(ilosc.getText());
        if(ilosc1 < 0){
            Alerty.wyswietlenieAlertuIlosc();
            return;
        }
        Czas czas = new Czas();
        czas.setPracownik(pracownik.getValue());
        czas.setData(data1);
        czas.setIlosc(ilosc1);
        czasModel.createCzas(czas);
        Alerty.wyswietlenieAlertuInfo();
        System.out.println(czas);

    }

    private void aktualizacjaWBazie() {

        Czas czas = usersTableView.getSelectionModel().getSelectedItem();

        String data1 = data.getText();
        double ilosc1 = Double.parseDouble(ilosc.getText());

        czas.setData(data1);
        czas.setPracownik(pracownik.getValue());
        czas.setIlosc(ilosc1);
        czasModel.aktualizujCzas(czas);
        System.out.println(czas);

    }

    private void usuniecieZBazy() {
        int id = usersTableView.getSelectionModel().getSelectedItem().getId();
        czasModel.usunCzas(id);
        System.out.println(id);
    }

    private void tableToCSV(){

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        Date date = new Date();
        System.out.println(formatter.format(date));

        Workbook workbook = new HSSFWorkbook();
        Sheet spreadsheet = workbook.createSheet("czasPracy");

        Row row = spreadsheet.createRow(0);

        for (int j = 0; j < usersTableView.getColumns().size(); j++) {
            row.createCell(j).setCellValue(usersTableView.getColumns().get(j).getText());
        }

        for (int i = 0; i < usersTableView.getItems().size(); i++) {
            row = spreadsheet.createRow(i + 1);
            for (int j = 0; j < usersTableView.getColumns().size(); j++) {
                if(usersTableView.getColumns().get(j).getCellData(i) != null) {
                    row.createCell(j).setCellValue(usersTableView.getColumns().get(j).getCellData(i).toString());
                }
                else {
                    row.createCell(j).setCellValue("");
                }
            }
        }

        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream("czasPracy-"+formatter.format(date)+".xls");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
