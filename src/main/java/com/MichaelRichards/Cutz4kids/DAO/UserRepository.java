package com.MichaelRichards.Cutz4kids.DAO;

import com.MichaelRichards.Cutz4kids.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
        Optional<User> findByUsername(String userName);

        Optional<User> findByEmail(String email);

        List<User> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
}
