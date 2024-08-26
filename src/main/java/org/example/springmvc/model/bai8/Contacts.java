package org.example.springmvc.model.bai8;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "contacts")

public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotNull(message = "Firstname is required.")
    @Size(min = 5, max = 45, message = "Firstname must be between 5 and 45 characters.")
    @Column(name = "firstname")
    private String firstname;

    @NotNull(message = "Lastname is required.")
    @Size(min = 5, max = 45, message = "Lastname must be between 5 and 45 characters.")
    @Column(name = "lastname")
    private String lastname;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phonenumber must be a valid phone number with 10 to 15 digits.")
    @Column(name = "phonenumber")
    private String phonenumber;

    @Min(value = 18, message = "Age must be 18 or older.")
    @Column(name = "age")
    private int age;

    @Email(message = "Email must be a valid email address.")
    @Column(name = "email")
    private String email;

    public Contacts(int id, String firstname, String lastname, String phonenumber, int age, String email) {
        this.id = id;
        setFirstname(firstname);
        setLastname(lastname);
        setPhonenumber(phonenumber);
        setAge(age);
        setEmail(email);
    }

    public Contacts() {

    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}


//^[^\s@;,.\-=+]+$