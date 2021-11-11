package com.MichaelRichards.Cutz4kids.Sevice;

import com.MichaelRichards.Cutz4kids.DAO.ConfirmationTokenDAO;
import com.MichaelRichards.Cutz4kids.Token.ConfirmationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConfirmationTokenService {

    @Autowired
    private ConfirmationTokenDAO confirmationTokenDAO;

    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenDAO.save(token);
    }


    public Optional<ConfirmationToken> getConfirmationToken(String token){
        return confirmationTokenDAO.findByToken(token);
    }


}
