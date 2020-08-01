package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotBlank(message="Username can not be empty")
    @Size(min = 5, max = 15, message = "Username must be between 5 and 15 characters long")
    private String username;

    @Email
    private String email;

    @NotBlank(message="Password can not be empty")
    @Size(min = 6, message = "Password is at least 6 characters long")
    private String password;


    @NotNull(message="Passwords do not match")
    private String verify;
    public User() {

    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        checkPassword();
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
        checkPassword();
    }

    private void checkPassword(){
        if (password!=null && verify!=null && !password.equals(verify)){
            verify = null;
        }

    }
}
