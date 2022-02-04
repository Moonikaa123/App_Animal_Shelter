package controller.towar;
import Models.KosztyModel;
import Models.TowarModel;
import controller.*;
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

import javax.persistence.Column;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class MainPaneController11 {

    ObservableList list11 = FXCollections.observableArrayList();

    public static TowarModel towarModel = new TowarModel();

    public TowarTableView usersTableView;


    @FXML
    private AnchorPane dodanieTowar;

    @FXML
    private TextField ilosc;

    @FXML
    private ChoiceBox<String> rodzaj;

    @FXML
    private Button dodaj;

    @FXML
    private Button edytuj;

    @FXML
    private Button pobierz;

    @FXML
    private Button powrot;

    @FXML
    private Button exportBtn;

    @FXML
    private Button usun;

    @FXML
    private Pane listPane;

    @FXML
    private TextField nazwa;

    @FXML
    private TextField koszt;

    public void setScreen(Pane pane) {
        dodanieTowar.getChildren().clear();
        dodanieTowar.getChildren().add(pane);
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
                MainPaneController mainPaneController66= loader.getController();
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

    private void odczytanieWiersza() {

        Towar towar = usersTableView.getSelectionModel().getSelectedItem();

        rodzaj.setValue(towar.getRodzaj());
        nazwa.setText(towar.getNazwa());
        ilosc.setText(String.valueOf(towar.getIlosc()));
        koszt.setText(String.valueOf(towar.getKoszt()));
    }

    public void fillWithUsers() {
        towarModel = new TowarModel();
        usersTableView = new TowarTableView();
        usersTableView.getItems().clear();
        usersTableView.fill(towarModel.getAllTowar());
        listPane.getChildren().clear();
        listPane.getChildren().add(usersTableView);
    }

    private void dodanieDoBazy() {

        String rodzaj1 = (String) rodzaj.getValue();
        String nazwa1 = nazwa.getText();
        double ilosc1 = Double.parseDouble(ilosc.getText());
        double koszt1 = Double.parseDouble(koszt.getText());
        if(ilosc1 < 0){
            Alerty.wyswietlenieAlertuIlosc2();
            return;
        }
        if(koszt1 < 0){
            Alerty.wyswietlenieAlertuKwota();
            return;
        }
        Towar towar = new Towar();
        towar.setRodzaj(rodzaj1);
        towar.setNazwa(nazwa1);
        towar.setIlosc(ilosc1);
        towar.setKoszt(koszt1);
        towarModel.createTowar(towar);
        Alerty.wyswietlenieAlertuInfo();
        System.out.println(towar);

    }

    private void aktualizacjaWBazie() {

        Towar towar = usersTableView.getSelectionModel().getSelectedItem();

        String rodzaj1 = (String) rodzaj.getValue();
        String nazwa1 = nazwa.getText();
        double ilosc1 = Double.parseDouble(ilosc.getText());
        double koszt1 = Double.parseDouble(koszt.getText());

        towar.setRodzaj(rodzaj1);
        towar.setNazwa(nazwa1);
        towar.setIlosc(ilosc1);
        towar.setKoszt(koszt1);
        towarModel.aktualizujTowar(towar);
        System.out.println(towar);

    }

    private void usuniecieZBazy() {
        int id = usersTableView.getSelectionModel().getSelectedItem().getId();
        towarModel.usunTowar(id);
        System.out.println(id);
    }

    private void loadData() {
        list11.removeAll(list11);
        String a = "Zakup";
        String b = "Zużycie";
        list11.addAll(a,b);
        rodzaj.getItems().addAll(list11);
    }

    private void tableToCSV(){

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        Date date = new Date();
        System.out.println(formatter.format(date));

        Workbook workbook = new HSSFWorkbook();
        Sheet spreadsheet = workbook.createSheet("towary");

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
            fileOut = new FileOutputStream("towary-"+formatter.format(date)+".xls");
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
