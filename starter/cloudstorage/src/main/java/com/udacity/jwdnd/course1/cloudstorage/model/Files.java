package com.udacity.jwdnd.course1.cloudstorage.model;

import org.springframework.context.annotation.Primary;

public class Files {

    int fileId;
    String fileName;
    String contentType;
    String fileSize;
    int userId;
    long fileData;


    public Files() {
    }


    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getFileData() {
        return fileData;
    }

    public void setFileData(long fileData) {
        this.fileData = fileData;
    }
}
