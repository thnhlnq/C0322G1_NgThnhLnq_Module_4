package com.example.model.employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class User {

    @Id
    private String username;
    private String password;

//    @OneToMany(mappedBy = "username")
//    private Set<Employee> employee;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

//    public User(String username, String password, Set<Employee> employee) {
//        this.username = username;
//        this.password = password;
//        this.employee = employee;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Set<Employee> getEmployee() {
//        return employee;
//    }

//    public void setEmployee(Set<Employee> employee) {
//        this.employee = employee;
//    }
}
