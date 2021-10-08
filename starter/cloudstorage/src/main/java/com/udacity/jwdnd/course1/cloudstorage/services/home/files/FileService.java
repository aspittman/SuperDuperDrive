package com.udacity.jwdnd.course1.cloudstorage.services.home.files;


import com.udacity.jwdnd.course1.cloudstorage.model.Files;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    List<Files> displayFileList();

    void getUserId();

    Integer insertFiles(MultipartFile file);

    Integer deleteFiles(long id);
}
