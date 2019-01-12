package com.rz.framework.bean;

import java.lang.reflect.Method;

/**
 * Created by as on 2018/2/1.
 */
public class Handler {
    /**
     * Controller类
     */
    private Class<?> controllerClass;
    /**
     * Action类
     */
    private Method actionMethod;

    public Handler(Method actionMethod, Class<?> controllerClass) {
        this.actionMethod = actionMethod;
        this.controllerClass = controllerClass;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
