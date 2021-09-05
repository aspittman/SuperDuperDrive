package com.udacity.jwdnd.course1.cloudstorage.filestorage;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import com.udacity.jwdnd.course1.cloudstorage.model.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileSystemStorageService implements StorageService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    FileMapper fileMapper;

    @Override
    public void store(MultipartFile file) {

        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file.");
            }
            String fileName = file.getName();
            String fileContentType = file.getContentType();
            long fileSize = file.getSize();
            byte[] fileData = file.getBytes();

            Files files = new Files(fileName, fileContentType, fileSize, fileData);
            fileMapper.insertFileData(files);

        } catch (IOException e) {
            throw new StorageException("Failed to store file.", e);
        }
    }
    @Override
    public void deleteFile(int id) {
        userMapper.deleteById(id);
    }
}
