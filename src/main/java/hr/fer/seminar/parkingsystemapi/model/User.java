package hr.fer.seminar.parkingsystemapi.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

public class User implements Serializable {
    @Id
    @GeneratedValue(generator = "user-sequence-generator")
    @SequenceGenerator(name = "user-sequence-generator", sequenceName = "USER_SEQ", allocationSize = 1)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_ID")
    private String name;

    @Column(name = "USER_NAME")
    private String surname;

    @Column(name = "USER_SURNAME")
    private String email;

    @Column(name = "USER_EMAIL")
    private String password;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
