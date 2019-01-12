package com.rz.app1.aspect;

import com.rz.framework.annotation.Aspect;
import com.rz.framework.annotation.Controller;
import com.rz.framework.proxy.AspectProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by as on 2018/2/3.
 * 拦截Controller里面所有方法
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);
    private long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        LOGGER.debug("-----begin------");
        LOGGER.debug(String.format("class:%s", cls.getName()));
        LOGGER.debug(String.format("method:%s", method.getName()));
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {

        LOGGER.debug(String.format("time:%dms", System.currentTimeMillis() - begin));
        LOGGER.debug("-----end------");
    }
}
