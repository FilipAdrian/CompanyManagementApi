package com.company.entities;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employee")
public class Employee {
    @JsonView(ModelView.Summary.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonView(ModelView.Summary.class)
    @NotBlank
    private String name;
    @JsonView(ModelView.Summary.class)
    @NotBlank
    private String surname;
    @JsonView(ModelView.Summary.class)
    @NotBlank
    private String role;
    @JsonView(ModelView.Summary.class)
    private String phone;
    @JsonView(ModelView.Summary.class)
    @NotBlank
    @Column(unique = true)
    private String email;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_subsidiary")
    private Subsidiary subsidiary;
    @JsonView(ModelView.Summary.class)
    @NotBlank
    private String address;

    public Employee() {
    }

    public Employee(String name, String surname, String role, String phone,
                    String email, Subsidiary subsidiary, String address) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.phone = phone;
        this.email = email;
        this.subsidiary = subsidiary;
        this.address = address;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Subsidiary getSubsidiary() {
        return subsidiary;
    }

    public void setSubsidiary(Subsidiary subsidiary) {
        this.subsidiary = subsidiary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
