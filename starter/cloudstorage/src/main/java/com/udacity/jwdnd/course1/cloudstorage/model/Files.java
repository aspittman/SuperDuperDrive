package com.udacity.jwdnd.course1.cloudstorage.model;

import org.springframework.web.multipart.MultipartFile;

public class Files {

    //Mostly complete last two variables may be a bit off
    //still not to sure about "primary key"

    int fileId;
    String fileName;
    String contentType;
    long fileSize;
    int userId;
    //FileData represented as BLOB
    Byte[] fileData;
    //foreign key (userid) references USERS(userid)


    public Files(int fileId, String fileName, String contentType, long fileSize, int userId, Byte[] fileData) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.contentType = contentType;
        this.fileSize = fileSize;
        this.userId = userId;
        this.fileData = fileData;
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

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Byte[] getFileData() {
        return fileData;
    }

    public void setFileData(Byte[] fileData) {
        this.fileData = fileData;
    }
}
