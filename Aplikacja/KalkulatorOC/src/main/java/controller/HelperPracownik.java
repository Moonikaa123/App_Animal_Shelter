package controller;

public class HelperPracownik {

    private String imie;
    private String nazwisko;
    private String plec;
    private int wiek;
    private String stanCywilny;
    private String stanowisko;

    public HelperPracownik(String imie, String nazwisko, String plec, int wiek, String stanCywilny, String stanowisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.wiek = wiek;
        this.stanCywilny = stanCywilny;
        this.stanowisko = stanowisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getStanCywilny() {
        return stanCywilny;
    }

    public void setStanCywilny(String stanCywilny) {
        this.stanCywilny = stanCywilny;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", plec='" + plec + '\'' +
                ", wiek=" + wiek +
                ", stanCywilny='" + stanCywilny + '\'' +
                ", stanowisko='" + stanowisko + '\'' +
                '}';
    }
}