package dev.belueu.springbootrecipeapp.model;

import javax.persistence.*;

@Entity
@Table(name = "uoms")
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String uom;
//    @OneToOne(mappedBy = "uom")
//    private Ingredient ingredient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}
