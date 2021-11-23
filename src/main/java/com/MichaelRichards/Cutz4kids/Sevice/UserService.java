package com.MichaelRichards.Cutz4kids.Sevice;

import com.MichaelRichards.Cutz4kids.DAO.UserRepository;
import com.MichaelRichards.Cutz4kids.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserService implements UserDetailsService{


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public List<User> findAll(){
        List<User> users = userRepository.findAll();
        if (users.isEmpty()){
            return new ArrayList<>();
        }
        else return users;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User  user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Could not find a user by that name "));
        System.out.println(user);
        return user;
    }




    public Optional<User> findUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findUserById(long id) throws UsernameNotFoundException{
        return  userRepository.findById(id);
    }

    public Optional<User> findUserByEmail(String email) throws UsernameNotFoundException{
        return userRepository.findByEmail(email);
    }

    public List<User> searchBy(String theName) {

        List<User> results;

        if (theName != null && (theName.trim().length() > 0)) {
            results = userRepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(theName, theName);
        }
        else {
            results = findAll();
        }

        return results;
    }


    @Transactional
    public String save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        String token = UUID.randomUUID().toString();


        userRepository.save(user);

        return token;
    }



    private void enableUser(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        user.setEnabled(true);
    }




}


