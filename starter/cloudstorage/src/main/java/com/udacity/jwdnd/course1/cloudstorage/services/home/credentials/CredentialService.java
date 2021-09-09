package com.udacity.jwdnd.course1.cloudstorage.services.home.credentials;

import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.model.Notes;

import java.util.List;

public interface CredentialService {

    List<Credentials> displayCredentialsList();

    void insertCredentials(Credentials credentials);

    int deleteCredentials(long id);
}
