package com.rz.framework.bean;

import java.io.InputStream;

/**
 * Created by as on 2018/2/7.
 * 封装文件上传的参数
 */
public class FileParam {

    private String fieldName;//文件表单字段名
    private String fileName;//上传文件名
    private long fileSize;//上传文件大小
    private String contentType;//上传文件的Content-Type，可判断文件类型
    private InputStream inputStream;//上传文件的字节流

    public FileParam(String fieldName, String fileName, long fileSize, String contentType, InputStream inputStream) {
        this.fieldName = fieldName;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.contentType = contentType;
        this.inputStream = inputStream;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFileName() {
        return fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public String getContentType() {
        return contentType;
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}
