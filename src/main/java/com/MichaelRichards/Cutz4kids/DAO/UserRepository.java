package com.MichaelRichards.Cutz4kids.DAO;

import com.MichaelRichards.Cutz4kids.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
}
