package com.udacity.jwdnd.course1.cloudstorage.services.home.credentials;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialServiceImpl implements CredentialService {

    private final CredentialMapper credentialMapper;

    public CredentialServiceImpl(CredentialMapper credentialMapper) {
        this.credentialMapper = credentialMapper;
    }

    @Override
    public List<Credentials> displayCredentialsList() {
        return credentialMapper.findAll();
    }

    @Override
    public void insertCredentials(Credentials credentials) {
        String credentialsUrl = credentials.getUrl();
        String credentialsUsername = credentials.getUsername();
        String credentialsKey = credentials.getKey();
        String credentialsPassword= credentials.getPassword();
        int userId = credentials.getUserId();
        String credentialsDecryptedPassword= credentials.getDecryptedPassword();

        Credentials credentialsModel = new Credentials(null, credentialsUrl, credentialsUsername, credentialsKey,
                credentialsPassword, 32, credentialsDecryptedPassword);
        credentialMapper.insertCredentialData(credentialsModel);
    }

    @Override
    public Integer deleteCredentials(long id) {
        return 0;
    }
}
