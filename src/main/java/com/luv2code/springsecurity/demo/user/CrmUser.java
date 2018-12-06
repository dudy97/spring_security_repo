package com.luv2code.springsecurity.demo.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by admin on 05.12.2018.
 */

public class CrmUser {
    @NotNull(message = "Is required")
    @Size(min = 1, message = "Is required")
    private String user;

    @NotNull(message = "Is required")
    @Size(min = 1, message = "Is required")
    private String password;

    @NotNull(message = "Is required")
    @Size(min = 1, message = "Is required")
    private String secondPassword;

    @NotNull(message = "Is required")
    @Size(min = 1, message = "Is required")
    private String name;

    @NotNull(message = "Is required")
    @Size(min = 1, message = "Is required")
    private String lastName;

    @NotNull(message = "Is required")
    @Size(min = 1, message = "Is required")
    private String email;

    public CrmUser() {
    }

    public CrmUser(@NotNull(message = "Is required") @Size(min = 1, message = "Is required") String name,
                   @NotNull(message = "Is required") @Size(min = 1, message = "Is required") String lastName,
                   @NotNull(message = "Is required") @Size(min = 1, message = "Is required") String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecondPassword() {
        return secondPassword;
    }

    public void setSecondPassword(String secondPassword) {
        this.secondPassword = secondPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
