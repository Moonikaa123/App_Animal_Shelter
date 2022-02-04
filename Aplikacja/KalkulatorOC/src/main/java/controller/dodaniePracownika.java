package controller;

import Models.PlecModel;
import Models.PracownikModel;
import Models.StanowiskoModel;
import controller.pracownicy.PracownicyTableView;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import Entities.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import java.io.*;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;


public class dodaniePracownika {


    public static PracownikModel pracownikModel = new PracownikModel();
    public PracownicyTableView usersTableView;

    public static PlecModel plecModel = new PlecModel();
    ObservableList plcie = FXCollections.observableArrayList();

    public static StanowiskoModel stanowiskoModel = new StanowiskoModel();
    ObservableList stanowiska = FXCollections.observableArrayList();

    private MainPaneController mainPaneController;


    @FXML
    private AnchorPane mainPane3;

    @FXML
    private TextField imie;

    @FXML
    private ChoiceBox<Plec> plec;

    @FXML
    private TextField nazwisko;

    @FXML
    private TextField wiek;

    @FXML
    private TextField telefon;

    @FXML
    private Button dodaj;

    @FXML
    private Button powrot2;

    @FXML
    private Button edytuj;

    @FXML
    private Button pobierz;

    @FXML
    private Button exportBtn;

    @FXML
    private Button usun;

    @FXML
    private Pane listPane;

    @FXML
    private ChoiceBox<Stanowisko> stanowisko;

    @FXML
    private TextField email;

    @FXML
    private TextField miejscowosc;

    @FXML
    private TextField ulica;

    @FXML
    private TextField numer;


    public void setScreen(Pane pane) {
    mainPane3.getChildren().clear();
    mainPane3.getChildren().add(pane);
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

        powrot2.setOnAction(event -> {
            try {
                System.out.println("Wcisnieto przycisk 2");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main1.fxml"));
                Pane pane = loader.load();
                MainPaneController mainPaneController32 = loader.getController();
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

    public void fillWithUsers() {
        pracownikModel = new PracownikModel();
        usersTableView = new PracownicyTableView();
        usersTableView.getItems().clear();
        usersTableView.fill(pracownikModel.getAllUsers());
        listPane.getChildren().clear();
        listPane.getChildren().add(usersTableView);
    }


    private void tableToCSV(){

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        Date date = new Date();
        System.out.println(formatter.format(date));

        Workbook workbook = new HSSFWorkbook();
        Sheet spreadsheet = workbook.createSheet("pracownicy");

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
            fileOut = new FileOutputStream("pracownicy-"+formatter.format(date)+".xls");
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

    private void odczytanieWiersza() {

        Pracownik pracownik = usersTableView.getSelectionModel().getSelectedItem();

        imie.setText(pracownik.getImie());
        nazwisko.setText(pracownik.getNazwisko());
        wiek.setText(String.valueOf(pracownik.getWiek()));
        miejscowosc.setText(pracownik.getMiejscowosc());
        ulica.setText(pracownik.getUlica());
        numer.setText(pracownik.getNumer());
        telefon.setText(String.valueOf(pracownik.getTelefon()));
        email.setText(pracownik.getEmail());
        plec.setValue(pracownik.getPlec());
        stanowisko.setValue(pracownik.getStanowisko());
    }

    private void dodanieDoBazy() {

        String imie1 = imie.getText();
        String nazwisko1 = nazwisko.getText();
        if(imie1.equals("") || nazwisko1.equals("")){
            Alerty.wyswietlenieAlertuBrakDanych();
            return;
        }
        int wiek1 =  Integer.parseInt(wiek.getText());
        if(wiek1 < 0){
            Alerty.wyswietlenieAlertuWiek();
            return;
        }
        String miejscowosc1 = miejscowosc.getText();
        String ulica1 = ulica.getText();
        String numer1 = numer.getText();
        int telefon1 =  Integer.parseInt(telefon.getText());
        if(telefon.getLength() != 9){
            Alerty.wyswietlenieAlertuTelefon();
            return;
        }
        String email1 = email.getText();

        Pracownik pracownik = new Pracownik();
        pracownik.setPlec(plec.getValue());
        pracownik.setStanowisko(stanowisko.getValue());
        pracownik.setImie(imie1);
        pracownik.setNazwisko(nazwisko1);
        pracownik.setWiek(wiek1);
        pracownik.setMiejscowosc(miejscowosc1);
        pracownik.setUlica(ulica1);
        pracownik.setNumer(numer1);
        pracownik.setTelefon(telefon1);
        pracownik.setEmail(email1);
        pracownikModel.createPracownik(pracownik);
        Alerty.wyswietlenieAlertuInfo();
        System.out.println(pracownik);
    }

    private void aktualizacjaWBazie() {
        Pracownik pracownik = usersTableView.getSelectionModel().getSelectedItem();

        String imie1 = imie.getText();
        String nazwisko1 = nazwisko.getText();
        System.out.println(plec.getValue().getId());
        int wiek1 =  Integer.parseInt(wiek.getText());

        String miejscowosc1 = miejscowosc.getText();
        String ulica1 = ulica.getText();
        String numer1 = numer.getText();
        int telefon1 =  Integer.parseInt(telefon.getText());
        String email1 = email.getText();


        pracownik.setPlec(plec.getValue());
        pracownik.setStanowisko(stanowisko.getValue());

        pracownik.setImie(imie1);
        pracownik.setNazwisko(nazwisko1);
        pracownik.setWiek(wiek1);
        pracownik.setMiejscowosc(miejscowosc1);
        pracownik.setUlica(ulica1);
        pracownik.setNumer(numer1);
        pracownik.setTelefon(telefon1);
        pracownik.setEmail(email1);

        pracownikModel.aktualizujPracownik(pracownik);
        System.out.println(pracownik);
    }

    private void usuniecieZBazy() {
        int id = usersTableView.getSelectionModel().getSelectedItem().getId();
        pracownikModel.usunPracownik(id);
        System.out.println(id);
    }

    private void loadData() {
        plcie.removeAll(plcie);
        plcie = plecModel.getAllPlec();
        plec.getItems().addAll(plcie);

        stanowiska.removeAll(stanowiska);
        stanowiska = stanowiskoModel.getAllPlec();
        stanowisko.getItems().addAll(stanowiska);
    }

}

