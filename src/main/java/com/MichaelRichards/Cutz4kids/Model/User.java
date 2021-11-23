package com.MichaelRichards.Cutz4kids.Model;

import com.MichaelRichards.Cutz4kids.UserValidator.ValidEmail;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;




import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import java.util.*;
import java.sql.Date;

@Entity
@Table(name = "user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "is required")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "is required")
    @Column(name = "email")
    @ValidEmail
    private String email;

    @NotNull(message = "is required")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "is required")
    @Column(name = "username")
    private String username;

    @NotNull(message = "is required")
    @Column(name = "password")
    private String password;

    @Column(name = "locked")
    private boolean locked;

    @Column(name = "enabled")
    private boolean enabled;

    @Past
    @Transient
    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "discriminator")
    @Enumerated(EnumType.STRING)
    private UserRoles userRole;

    public User(String firstName, String email, String lastName, String username, String password, Date birthday) {
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.locked = false;
        this.enabled = true;
        this.userRole = UserRoles.User;
    }


    public User() {
        enabled = true;
        locked = false;
        this.userRole = UserRoles.User;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public UserRoles getUserRoles() {
        return this.userRole;
    }

    public void setUserRoles(UserRoles userRoles) {
        this.userRole = userRoles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("userRoles.name()");
        return Collections.singletonList(simpleGrantedAuthority);
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(email, user.email) && Objects.equals(lastName, user.lastName) && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, email, lastName, username, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", locked=" + locked +
                ", enabled=" + enabled +
                ", userRoles=" + "userRoles" +
                '}';
    }
}
