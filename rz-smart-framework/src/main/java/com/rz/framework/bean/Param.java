package com.rz.framework.bean;

import com.rz.framework.utils.CastUtil;
import com.rz.framework.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by as on 2018/2/1.
 * 请求参数对象
 */
public class Param {


    private List<FormParam> formParamList;
    private List<FileParam> fileParamList;

    public Param(List<FormParam> formParamList) {
        this.formParamList = formParamList;
    }

    public Param(List<FormParam> formParamList, List<FileParam> fileParamList) {
        this.formParamList = formParamList;
        this.fileParamList = fileParamList;
    }


    public List<FormParam> getFormParamList() {
        return formParamList;
    }

    public List<FileParam> getFileParamList() {
        return fileParamList;
    }

    /**
     * 获取请求参数映射
     *
     * @return
     */
    public Map<String, Object> getFieldMap() {
        Map<String, Object> fieldMap = new HashMap<>();
        if (formParamList != null && formParamList.size() > 0) {
            for (FormParam formParam : formParamList) {
                String fieldName = formParam.getFieldName();
                Object fieldValue = formParam.getFieldValue();
                if (fieldMap.containsKey(fieldName)) {
                    fieldValue = fieldMap.get(fieldName) + StringUtil.SEPARATOR + fieldValue;
                }
                fieldMap.put(fieldName, fieldValue);
            }
        }
        return fieldMap;
    }

    /**
     * 获取上传文件映射
     *
     * @return
     */
    public Map<String, List<FileParam>> getFileMap() {

        Map<String, List<FileParam>> fileMap = new HashMap<>();
        if (fileParamList != null && fileParamList.size() > 0) {
            for (FileParam fileParam : fileParamList) {
                String fieldName = fileParam.getFieldName();
                List<FileParam> fileParamList = null;
                if (fileMap.containsKey(fieldName)) {
                    fileParamList = fileMap.get(fieldName);
                } else {
                    fileParamList = new ArrayList<>();
                }
                fileParamList.add(fileParam);
                fileMap.put(fieldName, fileParamList);
            }
        }
        return fileMap;
    }

    /**
     * 获取所有上传文件
     *
     * @param fieldName
     * @return
     */
    public List<FileParam> getFileList(String fieldName) {
        return getFileMap().get(fieldName);
    }

    /**
     * 获取唯一上传文件
     *
     * @param fieldName
     * @return
     */
    public FileParam getFile(String fieldName) {
        List<FileParam> fileParamList = getFileList(fieldName);

        if (fileParamList != null && fileParamList.size() == 1) {
            return fileParamList.get(0);
        }
        return null;
    }
//
//    public String getString(String name) {
//        return CastUtil.castStr(paramMap.get(name));
//    }
//
//    public long getLong(String name) {
//        return CastUtil.castLong(paramMap.get(name));
//    }
//
//    public double getDouble(String name) {
//        return CastUtil.castDouble(paramMap.get(name));
//    }
//
//    public int getInt(String name) {
//        return CastUtil.castInt(paramMap.get(name));
//    }
//
//    public boolean getBoolean(String name) {
//        return CastUtil.castBoolean(paramMap.get(name));
//    }

    public boolean isEmpty() {
        return (formParamList == null || formParamList.size() == 0) && (fileParamList == null || fileParamList.size() == 0);
    }
}
