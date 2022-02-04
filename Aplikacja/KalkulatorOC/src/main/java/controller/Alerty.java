package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public class Alerty {

    public static String zaokraglanie(String liczbaS){
        double liczba = Double.parseDouble(liczbaS);
        liczba = Math.round(liczba);
        return "" + liczba;
    }

    public static void wyswietlenieAlertuInfo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Dodano rekord do bazy!");
        alert.showAndWait();
    }

    public static void wyswietlenieAlertuTelefon() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Zle wprowadzony numer telefonu!");
        alert.showAndWait();
    }

    public static void wyswietlenieAlertuOst() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Źle wprowadzona liczba");
        alert.showAndWait();
    }
    public static void wyswietlenieAlertuWiek() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Wiek nie może być poniżej 0 lat");
        alert.showAndWait();
    }

    public static void wyswietlenieAlertuWaga() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Waga nie może być poniżej 0 kg");
        alert.showAndWait();
    }
    public static void wyswietlenieAlertuIlosc() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Ilosc nie może być poniżej 0 godzin");
        alert.showAndWait();
    }
    public static void wyswietlenieAlertuKwota() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Kwota nie może być poniżej 0 zł");
        alert.showAndWait();
    }
    public static void wyswietlenieAlertuIlosc2() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Ilosc nie może być poniżej 0 ");
        alert.showAndWait();
    }

    public static void wyswietlenieAlertuBrakDanych() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Musisz wprowadzić brakujące dane");
        alert.showAndWait();
    }
    public static void wyswietlenieAlertuUsuniecieZBazy() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Rekord został usunięty!");
        alert.showAndWait();
    }
}
