package Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Towar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column
    private String rodzaj;
    @Column
    private String nazwa;
    @Column
    private double ilosc;
    @Column
    private double koszt;

}