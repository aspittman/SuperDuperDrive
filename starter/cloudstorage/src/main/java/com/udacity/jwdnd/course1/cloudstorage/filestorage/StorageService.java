package com.udacity.jwdnd.course1.cloudstorage.filestorage;


import com.udacity.jwdnd.course1.cloudstorage.model.Files;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StorageService {

    List<Files> displayFileList();

    void store(MultipartFile file);

    void deleteFile(int id);
}
