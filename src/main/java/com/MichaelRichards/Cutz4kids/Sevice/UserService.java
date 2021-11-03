package com.MichaelRichards.Cutz4kids.Sevice;

import com.MichaelRichards.Cutz4kids.DAO.UserRepository;
import com.MichaelRichards.Cutz4kids.Model.Employee;
import com.MichaelRichards.Cutz4kids.Model.User;

import java.util.List;

public interface UserService {

    User findById(long id);

    void save(User user);

    void deleteById(long id);

    List<User> findAll();

    User findByUsername(String username);


}
