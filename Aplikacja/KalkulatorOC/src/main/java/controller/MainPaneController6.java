package controller;
import controller.koszty.MainPaneController10;
import controller.towar.MainPaneController11;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;

import java.io.IOException;

public class MainPaneController6 {

    private MainPaneController mainPaneController;

    @FXML
    private AnchorPane mainPane6;

    @FXML
    private Button wyswietlZakupWydanie;

    @FXML
    private Button usunZakupWydanie;

    @FXML
    private Button dodajZakupWydanie;

    @FXML
    private Button powrot5;

    public void setMainPaneController(MainPaneController mainPaneController) {
        this.mainPaneController = mainPaneController;
    }

    public void setScreen(Pane pane) {
        mainPane6.getChildren().clear();
        mainPane6.getChildren().add(pane);
    }

    public void initialize() {
        metoda1();
    }

    private void metoda1() {
        wyswietlZakupWydanie.setOnAction(actionEvent -> {
            try {
                System.out.println("Wcisnieto przycisk");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodanieTowar.fxml"));
                Pane pane = loader.load();
                MainPaneController11 mainPaneController111 = loader.getController();
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
        dodajZakupWydanie.setOnAction(actionEvent -> {
            try {
                System.out.println("Wcisnieto przycisk");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodanieTowar.fxml"));
                Pane pane = loader.load();
                MainPaneController11 mainPaneController111 = loader.getController();
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
        usunZakupWydanie.setOnAction(actionEvent -> {
            try {
                System.out.println("Wcisnieto przycisk");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodanieTowar.fxml"));
                Pane pane = loader.load();
                MainPaneController11 mainPaneController111 = loader.getController();
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
        powrot5.setOnAction(event -> {
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
