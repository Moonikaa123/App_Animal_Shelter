package controller;

import controller.zwierzeta.MainPaneController9;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;

import java.io.IOException;

public class MainPaneController4 {

    private MainPaneController mainPaneController;

    @FXML
    private AnchorPane mainPane4;

    @FXML
    private Button dostepneZwierzeta;

    @FXML
    private Button usunZwierze;

    @FXML
    private Button dodajZwierze;

    @FXML
    private Button powrot3;


    public void setMainPaneController(MainPaneController mainPaneController) {
        this.mainPaneController = mainPaneController;
    }

    public void setScreen(Pane pane) {
        mainPane4.getChildren().clear();
        mainPane4.getChildren().add(pane);
    }

    public void initialize() {
        metoda1();
    }

    private void metoda1() {

        dostepneZwierzeta.setOnAction(event ->{
            try {
                System.out.println("Wcisnieto przycisk");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodanieZwierzecia.fxml"));
                Pane pane = loader.load();
                MainPaneController9 mainPaneController99 = loader.getController();
                setScreen(pane);
            }catch (IOException e) {
                e.printStackTrace();
            }catch(NumberFormatException n){
                Alerty.wyswietlenieAlertuOst();
            }
        });

        dodajZwierze.setOnAction(event ->{
            try {
                System.out.println("Wcisnieto przycisk");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodanieZwierzecia.fxml"));
                Pane pane = loader.load();
                MainPaneController9 mainPaneController99 = loader.getController();
                setScreen(pane);
            }catch (IOException e) {
                e.printStackTrace();
            }catch(NumberFormatException n){
                Alerty.wyswietlenieAlertuOst();
            }
        });

        usunZwierze.setOnAction(event ->{
            try {
                System.out.println("Wcisnieto przycisk");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodanieZwierzecia.fxml"));
                Pane pane = loader.load();
                MainPaneController9 mainPaneController99 = loader.getController();
                setScreen(pane);
            }catch (IOException e) {
                e.printStackTrace();
            }catch(NumberFormatException n){
                Alerty.wyswietlenieAlertuOst();
            }
        });

        powrot3.setOnAction(event -> {
            try {
                System.out.println("Wcisnieto przycisk 2");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main1.fxml"));
                Pane pane = loader.load();
                MainPaneController mainPaneController11 = loader.getController();
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
