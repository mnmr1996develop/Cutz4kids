package com.MichaelRichards.Cutz4kids.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
public class Employee extends User {
    public Employee() {
    }



}
