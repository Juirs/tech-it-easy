package com.tech_it_easy.controller.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "wall_brackets")
public class WallBracket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String size;
    private Boolean adjustable;
    private Double price;

    @ManyToMany(mappedBy = "wallBrackets")
    List<Television> televisions;

    public WallBracket() {}

    public WallBracket(String name, String size, Boolean adjustable, Double price) {
        this.name = name;
        this.size = size;
        this.adjustable = adjustable;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getAdjustable() {
        return adjustable;
    }

    public void setAdjustable(Boolean adjustable) {
        this.adjustable = adjustable;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Television> getTelevisions() {
        return televisions;
    }

    public void setTelevisions(List<Television> televisions) {
        this.televisions = televisions;
    }
}
