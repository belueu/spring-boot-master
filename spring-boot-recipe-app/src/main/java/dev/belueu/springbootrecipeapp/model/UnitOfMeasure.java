package dev.belueu.springbootrecipeapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "uoms")
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uom;

}
