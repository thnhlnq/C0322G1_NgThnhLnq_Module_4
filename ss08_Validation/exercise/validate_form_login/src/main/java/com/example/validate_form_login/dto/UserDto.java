package com.example.validate_form_login.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

public class UserDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "First Name can't be Empty..")
    @Size(min = 5, max = 45)
    private String firstName;

    @NotEmpty(message = "Last Name can't be Empty..")
    @Size(min = 5, max = 45)
    private String lastName;

    @NotEmpty
    @Pattern(regexp = "(0)+(\\d{9})", message = "Phone Invalid")
    private String phone;

    @Min(value = 18, message = "Age Must be > 18")
    private int age;

    @NotEmpty
    @Email(message = "Email Invalid")
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phone, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
