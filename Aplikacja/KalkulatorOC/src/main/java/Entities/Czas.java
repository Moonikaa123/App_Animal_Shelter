package Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Czas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column
    private String data;

    @Column
    private double ilosc;

    @ManyToOne
    @JoinColumn(name="idPracownik")
    private Pracownik pracownik;


}