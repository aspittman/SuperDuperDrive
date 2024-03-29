package com.udacity.jwdnd.course1.cloudstorage.model;

import org.springframework.web.multipart.MultipartFile;

public class Files {

    //Mostly complete last two variables may be a bit off
    //still not to sure about "primary key"

    Integer fileId;
    String fileName;
    String contentType;
    long fileSize;
    Integer userId;
    //FileData represented as BLOB
    byte[] fileData;
    //foreign key (userid) references USERS(userid)


    public Files(Integer fileId, String fileName, String contentType, long fileSize, Integer userId, byte[] fileData) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.contentType = contentType;
        this.fileSize = fileSize;
        this.userId = userId;
        this.fileData = fileData;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
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

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
}
