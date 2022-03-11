package com.udacity.jwdnd.course1.cloudstorage.services.home.files;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import com.udacity.jwdnd.course1.cloudstorage.model.Files;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    private final UserMapper userMapper;
    private final FileMapper fileMapper;

    @Autowired
    public FileServiceImpl(UserMapper userMapper, FileMapper fileMapper) {
        this.userMapper = userMapper;
        this.fileMapper = fileMapper;
    }

    @Override
    public List<Files> displayFileList(Integer userId) {
        return fileMapper.findByUserId(userId);
    }

    @Override
    public Files getFileById(Integer fileId) {
        return fileMapper.findFileById(fileId);
    }

    @Override
    public Integer getUserId(Integer userId) {
        return userId;
    }

    @Override
    public Integer insertFiles(MultipartFile file, Integer userId) {

        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file.");
            }
            String fileName = file.getOriginalFilename();
            String fileContentType = file.getContentType();
            long fileSize = file.getSize();
            byte[] fileData = file.getBytes();

            Files files = new Files(null, fileName, fileContentType, fileSize, userId, fileData);
            return fileMapper.insertFileData(files);

        } catch (IOException e) {
            throw new StorageException("Failed to store file.", e);
        }
    }
    @Override
    public Integer deleteFiles(Integer id) {
        return fileMapper.deleteById(id);
    }
}
