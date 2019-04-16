package com.company.entities;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @JsonView(ModelView.Summary.class)
    private String id;
    @JsonView(ModelView.Summary.class)
    @NotBlank
    private String name;
    @JsonView(ModelView.Summary.class)
    @NotNull
    private BigDecimal price;
    @JsonView(ModelView.Summary.class)
    @NotBlank
    private String manufacturer;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_subsidiary")
    private Subsidiary subsidiary;

    public Product() {
    }

    public Product(String id, String name, BigDecimal price, String manufacturer, Subsidiary subsidiary) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.subsidiary = subsidiary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Subsidiary getSubsidiary() {
        return subsidiary;
    }

    public void setSubsidiary(Subsidiary subsidiary) {
        this.subsidiary = subsidiary;
    }
}
