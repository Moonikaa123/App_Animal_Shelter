package Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter

public class Zwierze {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String typ;
    @Column
    private String plec;
    @Column
    private String rasa;
    @Column
    private int wiek;
    @Column
    private double waga;
    @Column
    private String nazwa;
    @Column
    private String opis;
}
