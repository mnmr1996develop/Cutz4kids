package com.MichaelRichards.Cutz4kids.Model;

public class Manager {
    public int id;
    public String firstName;
    public String lastName;
    public String userName;
    public String password;

    public Manager(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }
}
