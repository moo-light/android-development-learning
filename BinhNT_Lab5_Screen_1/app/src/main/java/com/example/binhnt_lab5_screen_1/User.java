package com.example.binhnt_lab5_screen_1;

public class User {
    private String email;
    private String fullname;
    private String username;

    public User() {
    }

    public User(String username, String name, String email) {
        this.username = username;
        this.fullname = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
