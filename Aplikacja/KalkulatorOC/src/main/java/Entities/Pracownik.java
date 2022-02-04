package Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Pracownik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String imie;
    @Column
    private String nazwisko;
//    @Column
//    private int idPlec; //foreignKey
    @Column
    private int wiek;
//    @Column
//    private int idStanowisko; //foreignKey
    @Column
    private String miejscowosc;
    @Column
    private String ulica;
    @Column
    private String numer;
    @Column
    private int telefon;
    @Column
    private String email;


    @ManyToOne
    @JoinColumn(name="idPlec")
    private Plec plec;

    @ManyToOne
    @JoinColumn(name="idStanowisko")
    private Stanowisko stanowisko;

    @Override
    public String toString() {
        return imie + " " + nazwisko + " - " + stanowisko.getNazwa() ;
    }

}