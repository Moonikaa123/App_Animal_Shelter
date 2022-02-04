package controller;

import controller.czas.MainPaneController12;
import controller.koszty.MainPaneController10;
import controller.pracownicy.MainPaneController8;
import controller.towar.MainPaneController11;
import controller.zwierzeta.MainPaneController9;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import java.io.IOException;

public class MainPaneController {

ObservableList list = FXCollections.observableArrayList();

    public static HelperPracownik helperPracownik;

    private MainPaneController mainPaneController;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Button ewidencjaPracownikow;

    @FXML
    private Button ewidencjaCzasuPracy;

    @FXML
    private Button ewidencjaZwierzat;

    @FXML
    private Button ewidencjaKosztow;

    @FXML
    private Button ewidencjaZakupu;



    public void setMainPaneController(MainPaneController mainPaneController) {
        this.mainPaneController = mainPaneController;
    }

    public void initialize(){
        wybor();

    }

    private void wybor() {

        ewidencjaPracownikow.setOnAction(event ->{
            try {
                System.out.println("Wcisnieto przycisk");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodaniePracownika.fxml"));
                Pane pane = loader.load();
                dodaniePracownika mainPaneController21 = loader.getController();
                setScreen(pane);
            }catch (IOException e) {
                e.printStackTrace();
            }catch(NumberFormatException n){
                Alerty.wyswietlenieAlertuOst();
            }
        });

        ewidencjaCzasuPracy.setOnAction(event ->{
            try {
                System.out.println("Wcisnieto przycisk");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodanieCzas.fxml"));
                Pane pane = loader.load();
                MainPaneController12 mainPaneController21 = loader.getController();
                setScreen(pane);
            }catch (IOException e) {
                e.printStackTrace();
            }catch(NumberFormatException n){
                Alerty.wyswietlenieAlertuOst();
            }
        });

        ewidencjaZwierzat.setOnAction(event ->{
            try {
                System.out.println("Wcisnieto przycisk zwierze");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodanieZwierzecia.fxml"));
                Pane pane = loader.load();
                MainPaneController9 mainPaneController23 = loader.getController();
                setScreen(pane);
            }catch (IOException e) {
                e.printStackTrace();
            }catch(NumberFormatException n){
                Alerty.wyswietlenieAlertuOst();
            }
        });


        ewidencjaKosztow.setOnAction(event ->{
            try {
                System.out.println("Wcisnieto przycisk");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodanieKosztow.fxml"));
                Pane pane = loader.load();
                MainPaneController10 mainPaneController51 = loader.getController();
                setScreen(pane);
            }catch (IOException e) {
                e.printStackTrace();
            }catch(NumberFormatException n){
                Alerty.wyswietlenieAlertuOst();
            }
        });
        ewidencjaZakupu.setOnAction(event ->{
            try {
                System.out.println("Wcisnieto przycisk");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodanieTowar.fxml"));
                Pane pane = loader.load();
                MainPaneController11 mainPaneController61 = loader.getController();
                setScreen(pane);
            }catch (IOException e) {
                e.printStackTrace();
            }catch(NumberFormatException n){
                Alerty.wyswietlenieAlertuOst();
            }
        });
    }

    public void setScreen(Pane pane) {
        mainPane.getChildren().clear();
        mainPane.getChildren().add(pane);
    }
}

