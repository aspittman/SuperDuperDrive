package com.udacity.jwdnd.course1.cloudstorage.filestorage;


import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    void store(MultipartFile file);
}
