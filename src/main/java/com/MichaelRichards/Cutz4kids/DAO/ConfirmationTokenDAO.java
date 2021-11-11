package com.MichaelRichards.Cutz4kids.DAO;

import com.MichaelRichards.Cutz4kids.Token.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfirmationTokenDAO extends JpaRepository<ConfirmationToken, Long> {

        Optional<ConfirmationToken> findByToken(String token);

}
