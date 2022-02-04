package controller.koszty;
import Models.KosztyModel;
import controller.Alerty;
import controller.MainPaneController;
import controller.MainPaneController4;
import controller.MainPaneController5;
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

public class MainPaneController10 {

    ObservableList list10 = FXCollections.observableArrayList();

    public static KosztyModel kosztyModel = new KosztyModel();

    public KosztyTableView usersTableView;

    @FXML
    private AnchorPane dodanieKosztow;

    @FXML
    private TextField kwota;

    @FXML
    private Button exportBtn;

    @FXML
    private ChoiceBox<String> rodzaj;

    @FXML
    private Button dodaj;

    @FXML
    private Button powrot;

    @FXML
    private Button edytuj;

    @FXML
    private Button pobierz;

    @FXML
    private Button usun;

    @FXML
    private Pane listPane;

    @FXML
    private TextField nazwa;

    public void setScreen(Pane pane) {
        dodanieKosztow.getChildren().clear();
        dodanieKosztow.getChildren().add(pane);
    }

    public void initialize(){
        loadData();
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
                //Alerty.wyswietlenieAlertuOst();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void fillWithUsers() {
        kosztyModel = new KosztyModel();
        usersTableView = new KosztyTableView();
        usersTableView.getItems().clear();
        usersTableView.fill(kosztyModel.getAllKoszty());
        listPane.getChildren().clear();
        listPane.getChildren().add(usersTableView);
    }

    private void odczytanieWiersza() {

        Koszty koszty = usersTableView.getSelectionModel().getSelectedItem();

        rodzaj.setValue(koszty.getRodzaj());
        nazwa.setText(koszty.getNazwa());
        kwota.setText(String.valueOf(koszty.getKwota()));
    }

    private void dodanieDoBazy() {

        String rodzaj1 = (String) rodzaj.getValue();
        String nazwa1 = nazwa.getText();
        double kwota1 = Double.parseDouble(kwota.getText());
        if(kwota1 < 0){
            Alerty.wyswietlenieAlertuKwota();
            return;
        }
        Koszty kosztyWydatki = new Koszty();
        kosztyWydatki.setRodzaj(rodzaj1);
        kosztyWydatki.setNazwa(nazwa1);
        kosztyWydatki.setKwota(kwota1);

        kosztyModel.createKosztyWydatki(kosztyWydatki);
        Alerty.wyswietlenieAlertuInfo();
        System.out.println(kosztyWydatki);

    }

    private void aktualizacjaWBazie() {

        Koszty kosztyWydatki = usersTableView.getSelectionModel().getSelectedItem();

        String rodzaj1 = (String) rodzaj.getValue();
        String nazwa1 = nazwa.getText();
        double kwota1 = Double.parseDouble(kwota.getText());
        kosztyWydatki.setRodzaj(rodzaj1);
        kosztyWydatki.setNazwa(nazwa1);
        kosztyWydatki.setKwota(kwota1);
        kosztyModel.aktualizujKosztyWydatki(kosztyWydatki);
        System.out.println(kosztyWydatki);

    }

    private void usuniecieZBazy() {
        int id = usersTableView.getSelectionModel().getSelectedItem().getId();
        kosztyModel.usunKosztyWydatki(id);
        System.out.println(id);
    }

    private void loadData() {
        list10.removeAll(list10);
        String a = "Koszty";
        String b = "Przychody";
        list10.addAll(a,b);
        rodzaj.getItems().addAll(list10);
    }

    private void tableToCSV(){

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        Date date = new Date();
        System.out.println(formatter.format(date));

        Workbook workbook = new HSSFWorkbook();
        Sheet spreadsheet = workbook.createSheet("koszty");

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
            fileOut = new FileOutputStream("koszty-"+formatter.format(date)+".xls");
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
