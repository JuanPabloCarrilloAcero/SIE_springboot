package com.sieapp.sie.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import javax.persistence.*;

@Entity
@Table(name = "formulario")
@NoArgsConstructor
@EnableJpaAuditing
public class Formulario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_form;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id")
    private Persona person;

    @Column
    private String name;

    @Column
    private String phone;

    @Column
    private String mail;

    @Column
    private String type;

    @Column
    private String comments;

    @Column
    private String date;

    public Long getId_form() {
        return id_form;
    }

    public void setId_form(Long id_form) {
        this.id_form = id_form;
    }

    public Persona getPerson() {
        return person;
    }

    public void setPerson(Persona person) {
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
/*
SQL
create table formulario(
                           id_form BIGSERIAL PRIMARY KEY,
                           id BIGSERIAL,
                           name TEXT,
                           phone TEXT,
                           mail TEXT,
                           type TEXT,
                           comments TEXT,
                           date TEXT,
                           CONSTRAINT fk_person
                               FOREIGN KEY(id)
                                   REFERENCES persona(id)
);
*/
}