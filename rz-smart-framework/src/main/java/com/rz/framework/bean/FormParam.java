package com.rz.framework.bean;

/**
 * Created by as on 2018/2/7.
 * 封装表单参数
 */
public class FormParam {

    private String fieldName;
    private Object fieldValue;

    public FormParam(Object fieldValue, String fieldName) {
        this.fieldValue = fieldValue;
        this.fieldName = fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }
}
