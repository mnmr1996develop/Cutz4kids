package com.MichaelRichards.Cutz4kids.Sevice;

import com.MichaelRichards.Cutz4kids.DAO.UserRepository;
import com.MichaelRichards.Cutz4kids.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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




    public User findUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isEmpty()){
            throw new RuntimeException("Did not find user by the name - " + username);
        }
        else {
            return user.get();
        }

    }

    public User findUserById(long id) throws UsernameNotFoundException{
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new RuntimeException("Did not find user by ID: - " + id);
        }
        else {
            return user.get();
        }
    }

    public List<User> searchBy(String theName) {

        List<User> results = null;

        if (theName != null && (theName.trim().length() > 0)) {
            results = userRepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(theName, theName);
        }
        else {
            results = findAll();
        }

        return results;
    }



    public void save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

}


