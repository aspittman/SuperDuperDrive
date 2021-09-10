package com.udacity.jwdnd.course1.cloudstorage.services.home.files;

import com.udacity.jwdnd.course1.cloudstorage.filestorage.StorageException;
import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import com.udacity.jwdnd.course1.cloudstorage.model.Files;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    FileMapper fileMapper;

    @Override
    public List<Files> displayFileList() {
        return fileMapper.findAll();
    }

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

            Files files = new Files(fileName, fileContentType, fileSize, 12, fileData);
            fileMapper.insertFileData(files);

        } catch (IOException e) {
            throw new StorageException("Failed to store file.", e);
        }
    }
    @Override
    public void deleteFile(Integer id) {
        userMapper.deleteById(id);
    }
}
