package com.MichaelRichards.Cutz4kids.Sevice;

import com.MichaelRichards.Cutz4kids.DAO.UserRepository;
import com.MichaelRichards.Cutz4kids.Model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(long id) {

        Optional<User> user= userRepository.findById(id);

        if(user.isEmpty()){
            throw new RuntimeException("No one by that ID");
        }

        return user.get();
    }


    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
