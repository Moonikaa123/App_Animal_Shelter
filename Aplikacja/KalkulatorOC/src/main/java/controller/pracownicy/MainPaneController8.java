package controller.pracownicy;

import Models.PlecModel;
import Models.PracownikModel;
import Models.StanowiskoModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;

import java.io.IOException;

public class MainPaneController8 {

    private MainPaneController8 mainPaneController;

    public static PracownikModel pracownikModel = new PracownikModel();

    public static StanowiskoModel stanowiskoModel = new StanowiskoModel();

    public PracownicyTableView usersTableView;


    ObservableList list3 = FXCollections.observableArrayList();

    @FXML
    private AnchorPane mainPaneController8;

    @FXML
    private Button powrot;

    @FXML
    private Pane wyswietlenieListy;

    @FXML
    private Button edytuj;

    @FXML
    private Button usun;



    public void setMainPaneController(MainPaneController8 mainPaneController) {
        this.mainPaneController = mainPaneController;
    }

    public void setScreen(Pane pane) {
        mainPaneController8.getChildren().clear();
        mainPaneController8.getChildren().add(pane);
    }

    public void initialize() {
        metoda1();
    }

    private void metoda1() {
        fillWithUsers();

        powrot.setOnAction(event -> {
            try {
                System.out.println("Wcisnieto przycisk 2");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodaniePracownika.fxml"));
                Pane pane = loader.load();
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

    private void fillWithUsers() {
        pracownikModel = new PracownikModel();
        usersTableView = new PracownicyTableView();
        usersTableView.getItems().clear();
        usersTableView.fill(pracownikModel.getAllUsers());
        mainPaneController8.getChildren().remove(usersTableView);
        mainPaneController8.getChildren().add(usersTableView);
        System.out.println("xd");
    }


}
