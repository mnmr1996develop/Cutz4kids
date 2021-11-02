package com.MichaelRichards.Cutz4kids.Model;


import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class Manager extends User {

    private UserRoles userRoles = UserRoles.Manager;

    public Manager(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    private Manager(Long id, String firstName, String lastName, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }


    public Manager promoteEmployeeToManager(Employee employee){
       return new Manager(employee.id, employee.firstName, employee.lastName, employee.username, employee.password);
    }



}
