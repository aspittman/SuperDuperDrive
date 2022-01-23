package com.udacity.jwdnd.course1.cloudstorage.services.home.credentials;

import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.model.Notes;

import java.util.List;

public interface CredentialService {

    List<Credentials> displayCredentialsList(Integer userId);

    void insertCredentials(Credentials credentials, Integer userId);

    Integer deleteCredentials(Integer id);
}
