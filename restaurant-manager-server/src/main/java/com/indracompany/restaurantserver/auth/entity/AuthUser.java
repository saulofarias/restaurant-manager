package com.indracompany.restaurantserver.auth.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class AuthUser {
    @Id
    private String email;
    private String name;
    private String password;

    public AuthUser() {
    }

    public AuthUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AuthUser(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AuthUser [name=" + name + ", email=" + email + ", password=" + password + "]";
    }

}
