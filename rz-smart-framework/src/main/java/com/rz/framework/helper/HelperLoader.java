package com.rz.framework.helper;

import com.rz.framework.utils.ClassUtil;

/**
 * Created by as on 2018/2/1.
 */
public final class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(), false);

        }
    }
}
