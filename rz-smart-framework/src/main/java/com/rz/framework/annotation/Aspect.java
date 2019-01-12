package com.rz.framework.annotation;

import java.lang.annotation.*;

/**
 * Created by as on 2018/2/3.
 * 切面注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {

    /**
     * 注解
     * @return
     */
    Class<? extends Annotation> value();
}
