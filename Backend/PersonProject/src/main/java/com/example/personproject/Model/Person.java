package com.example.personproject.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;


@Entity
public class Person {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max=30)
    @NotEmpty(message = "Name is empty")
    @NotNull(message = "Name is required")
    private String name;

    @Size(max=30)
    @NotEmpty(message = "SurName is empty")
    @NotNull(message = "SurName is required")
    private String surname;


    @Size(max=11,min =11,message = "phone number should be 11 digits")
    @NotEmpty(message = "Phone is empty")
    @NotNull(message = "Phone is required")
    private String phone;

    @NotEmpty(message = "Email is empty")
    @NotNull(message = "Email is required")
    @Email(message = "Enter a valid email address.")
    private String email;


    private Boolean isDeleted;

    public Person() {
    }


    public Person(String name, String surname, String phone,String email) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email=email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
