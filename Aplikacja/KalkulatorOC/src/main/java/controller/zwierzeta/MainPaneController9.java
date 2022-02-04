package controller.zwierzeta;
import Models.ZwierzeModel;
import controller.Alerty;
import controller.MainPaneController;
import controller.MainPaneController2;
import controller.MainPaneController4;
import controller.zwierzeta.ZwierzeTableView;
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

public class MainPaneController9 {

    ObservableList list9 = FXCollections.observableArrayList();

    public static ZwierzeModel zwierzeModel = new ZwierzeModel();

    public ZwierzeTableView usersTableView;

    @FXML
    private Pane listPane;


    @FXML
    private AnchorPane dodanieZwierzecia;

    @FXML
    private TextField wiek;

    @FXML
    private TextField nazwa;

    @FXML
    private Button dodaj;

    @FXML
    private Button deleteButton;

    @FXML
    private Button powrot2;


    @FXML
    private ChoiceBox<String> typ;

    @FXML
    private ChoiceBox<String> plec;

    @FXML
    private Button exportBtn;

    @FXML
    private TextField rasa;

    @FXML
    private TextField waga;

    @FXML
    private TextField opis;

    @FXML
    private Button edytuj;

    @FXML
    private Button pobierz;


    public void setScreen(Pane pane) {
        dodanieZwierzecia.getChildren().clear();
        dodanieZwierzecia.getChildren().add(pane);
    }

    public void initialize(){
        loadData();
        loadData2();
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

        deleteButton.setOnAction(event -> {
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
                //mainPaneController.setScreen(mainPaneController2);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main1.fxml"));
                Pane pane = loader.load();
                MainPaneController mainPaneController44 = loader.getController();
                // mainPaneController3.setMainPaneController(this);
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

        Zwierze zwierze = usersTableView.getSelectionModel().getSelectedItem();

        typ.setValue(zwierze.getTyp());
        plec.setValue(zwierze.getPlec());
        rasa.setText(zwierze.getRasa());
        wiek.setText(String.valueOf(zwierze.getWiek()));
        waga.setText(String.valueOf(zwierze.getWaga()));
        nazwa.setText(zwierze.getNazwa());
        opis.setText(zwierze.getOpis());

    }

    public void fillWithUsers() {
        zwierzeModel = new ZwierzeModel();
        usersTableView = new ZwierzeTableView();
        usersTableView.getItems().clear();
        usersTableView.fill(zwierzeModel.getAllAnimals());
        listPane.getChildren().clear();
        listPane.getChildren().add(usersTableView);
    }

    private void dodanieDoBazy() {

        String typ1 = (String) typ.getValue();
        String plec1 = (String) plec.getValue();
        String rasa1 = rasa.getText();
        int wiek1 = Integer.parseInt(wiek.getText());
        double waga1 = Double.parseDouble(waga.getText());
        if(wiek1 < 0){
            Alerty.wyswietlenieAlertuWiek();
            return;
        }
        if(waga1 < 0){
            Alerty.wyswietlenieAlertuWaga();
            return;
        }
        String nazwa1 = nazwa.getText();
        String opis1 = opis.getText();

        Zwierze zwierze = new Zwierze();
        zwierze.setTyp(typ1);
        zwierze.setPlec(plec1);
        zwierze.setRasa(rasa1);
        zwierze.setWiek(wiek1);
        zwierze.setWaga(waga1);
        zwierze.setNazwa(nazwa1);
        zwierze.setOpis(opis1);
        zwierzeModel.createZwierze(zwierze);
        Alerty.wyswietlenieAlertuInfo();
        System.out.println(zwierze);

    }

    private void aktualizacjaWBazie() {

        Zwierze zwierze = usersTableView.getSelectionModel().getSelectedItem();

        String typ1 = (String) typ.getValue();
        String plec1 = (String) plec.getValue();
        String rasa1 = rasa.getText();
        int wiek1 = Integer.parseInt(wiek.getText());
        double waga1 = Double.parseDouble(waga.getText());
        String nazwa1 = nazwa.getText();
        String opis1 = opis.getText();

        zwierze.setTyp(typ1);
        zwierze.setPlec(plec1);
        zwierze.setRasa(rasa1);
        zwierze.setWiek(wiek1);
        zwierze.setWaga(waga1);
        zwierze.setNazwa(nazwa1);
        zwierze.setOpis(opis1);
        zwierzeModel.aktualizujZwierze(zwierze);

        System.out.println(zwierze);

    }
    private void usuniecieZBazy() {
        int id = usersTableView.getSelectionModel().getSelectedItem().getId();
        zwierzeModel.usunZwierze(id);
        System.out.println(id);
    }

    private void loadData() {
        list9.removeAll(list9);
        String a = "Kot";
        String b = "Pies";
        list9.addAll(a,b);
        typ.getItems().addAll(list9);
    }
    private void loadData2() {
        list9.removeAll(list9);
        String a = "Samiec";
        String b = "Samica";
        list9.addAll(a,b);
        plec.getItems().addAll(list9);
    }

    private void tableToCSV(){

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        Date date = new Date();
        System.out.println(formatter.format(date));

        Workbook workbook = new HSSFWorkbook();
        Sheet spreadsheet = workbook.createSheet("zwierzeta");

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
            fileOut = new FileOutputStream("zwierzeta-"+formatter.format(date)+".xls");
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
