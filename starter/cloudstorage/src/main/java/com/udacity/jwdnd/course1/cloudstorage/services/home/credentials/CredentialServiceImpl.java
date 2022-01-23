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
    public List<Credentials> displayCredentialsList(Integer userId) {
        return credentialMapper.findByUserId(userId);
    }

    @Override
    public void insertCredentials(Credentials credentials, Integer userId) {
        String credentialsUrl = credentials.getUrl();
        String credentialsUsername = credentials.getUsername();
        String credentialsKey = credentials.getKey();
        String credentialsPassword= credentials.getPassword();

        Credentials credentialsModel = new Credentials(null, credentialsUrl, credentialsUsername, credentialsKey,
                credentialsPassword, userId);
        credentialMapper.insertCredentialData(credentialsModel);
    }

    @Override
    public Integer deleteCredentials(Integer id) {
        return credentialMapper.deleteById(id);
    }
}
