package controller;

import controller.koszty.MainPaneController10;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;

import java.io.IOException;

public class MainPaneController5 {

    private MainPaneController mainPaneController;

    @FXML
    private AnchorPane mainPane5;

    @FXML
    private Button wyswietlKosztyPrzychody;

    @FXML
    private Button usunKosztyPrzychody;

    @FXML
    private Button dodajKosztyPrzychody;

    @FXML
    private Button powrot4;

    public void setMainPaneController(MainPaneController mainPaneController) {
        this.mainPaneController = mainPaneController;
    }

    public void setScreen(Pane pane) {
        mainPane5.getChildren().clear();
        mainPane5.getChildren().add(pane);
    }

    public void initialize() {
        metoda1();
    }

    private void metoda1() {
        wyswietlKosztyPrzychody.setOnAction(actionEvent -> {
            try {
                System.out.println("Wcisnieto przycisk");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodanieKosztow.fxml"));
                Pane pane = loader.load();
                MainPaneController10 mainPaneController999 = loader.getController();
                setScreen(pane);
                System.out.println("Wcisnieto przycisk dodanie pracownika");
            } catch (NullPointerException e) {
                System.out.println("blad");
            } catch (NumberFormatException n) {
                //Alerty.wyswietlenieAlertuOst();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });
        dodajKosztyPrzychody.setOnAction(actionEvent -> {
            try {
                System.out.println("Wcisnieto przycisk");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodanieKosztow.fxml"));
                Pane pane = loader.load();
                MainPaneController10 mainPaneController999 = loader.getController();
                setScreen(pane);
                System.out.println("Wcisnieto przycisk dodanie pracownika");
            } catch (NullPointerException e) {
                System.out.println("blad");
            } catch (NumberFormatException n) {
                //Alerty.wyswietlenieAlertuOst();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });
        usunKosztyPrzychody.setOnAction(actionEvent -> {
            try {
                System.out.println("Wcisnieto przycisk");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodanieKosztow.fxml"));
                Pane pane = loader.load();
                MainPaneController10 mainPaneController999 = loader.getController();
                setScreen(pane);
                System.out.println("Wcisnieto przycisk dodanie pracownika");
            } catch (NullPointerException e) {
                System.out.println("blad");
            } catch (NumberFormatException n) {
                //Alerty.wyswietlenieAlertuOst();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });

        powrot4.setOnAction(event -> {
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
