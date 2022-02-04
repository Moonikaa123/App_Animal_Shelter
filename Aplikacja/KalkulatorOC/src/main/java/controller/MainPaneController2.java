package controller;

import controller.czas.MainPaneController12;
import controller.pracownicy.PracownicyTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import Models.PracownikModel;
//import sun.tools.jconsole.JConsole;
import controller.pracownicy.*;

import java.io.IOException;

public class MainPaneController2 {

    public static PracownikModel pracownikModel;
    public PracownicyTableView usersTableView;

    ObservableList list2 = FXCollections.observableArrayList();

    private MainPaneController mainPaneController;

    @FXML
    private MainPaneController2 mainPaneController2;

    @FXML
    private AnchorPane mainPane2;

    @FXML
    private Button powrot;

    @FXML
    private Button wyswietlPracownika;

    @FXML
    private Button dodajPracownika;

    @FXML
    private Button usunPracownika;

    @FXML
    private Button ewidencjaCzasu;



    public void setMainPaneController(MainPaneController mainPaneController) {
        this.mainPaneController = mainPaneController;
    }


    public void setScreen(Pane pane) {
        mainPane2.getChildren().clear();
        mainPane2.getChildren().add(pane);

    }

    public void initialize() {
        metoda1();
    }

    public void metoda1() {
        dodajPracownika.setOnAction(actionEvent -> {
            try {
                System.out.println("Wcisnieto przycisk");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodaniePracownika.fxml"));
                Pane pane = loader.load();
                controller.dodaniePracownika mainPaneController33 = loader.getController();
                setScreen(pane);
                System.out.println("Wcisnieto przycisk dodanie pracownika");
            } catch (NullPointerException e) {
                System.out.println("blad");
            } catch (NumberFormatException n) {
                //Alerty.wyswietlenieAlertuOst();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        usunPracownika.setOnAction(actionEvent -> {
            try {
                System.out.println("Wcisnieto przycisk");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodaniePracownika.fxml"));
                Pane pane = loader.load();
                dodaniePracownika mainPaneController33 = loader.getController();
                setScreen(pane);
                System.out.println("Wcisnieto przycisk dodanie pracownika");
            } catch (NullPointerException e) {
                System.out.println("blad");
            } catch (NumberFormatException n) {
                //Alerty.wyswietlenieAlertuOst();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        wyswietlPracownika.setOnAction(actionEvent -> {
            try {
                System.out.println("Wcisnieto przycisk");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodaniePracownika.fxml"));
                Pane pane = loader.load();
                dodaniePracownika mainPaneController33 = loader.getController();
                setScreen(pane);
                System.out.println("Wcisnieto przycisk dodanie pracownika");
            } catch (NullPointerException e) {
                System.out.println("blad");
            } catch (NumberFormatException n) {
                //Alerty.wyswietlenieAlertuOst();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        ewidencjaCzasu.setOnAction(actionEvent -> {
            try {
                System.out.println("Wcisnieto przycisk");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodanieCzas.fxml"));
                Pane pane = loader.load();
                MainPaneController12 mainPaneController222 = loader.getController();
                setScreen(pane);
                System.out.println("Wcisnieto przycisk dodanie pracownika");
            } catch (NullPointerException e) {
                System.out.println("blad");
            } catch (NumberFormatException n) {
                //Alerty.wyswietlenieAlertuOst();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        powrot.setOnAction(event -> {
            try {
                System.out.println("Wcisnieto przycisk 2");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main1.fxml"));
                Pane pane = loader.load();
                MainPaneController mainPaneController22 = loader.getController();
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
}



