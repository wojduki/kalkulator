package com.wojduki.kalkulator.model;

//@Entity
public class Work extends Cost {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
    private Integer id;

    public Work(String nazwa, double pricePerM2, Rodzaj rodzaj) {
        super(nazwa, pricePerM2, rodzaj);
    }

    public Work() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
