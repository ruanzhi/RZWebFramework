package com.rz.framework.utils;

/**
 * Created by as on 2018/2/1.
 */
public final class CastUtil {

    /**
     * 转换为String类型
     *
     * @param obj
     * @return
     */
    public static String castStr(Object obj) {
        return CastUtil.castStr(obj, "");
    }

    /**
     * 转换为String（提供默认值）
     *
     * @param obj
     * @param defaultValue
     * @return
     */
    public static String castStr(Object obj, String defaultValue) {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    public static double castDouble(Object obj) {
        return CastUtil.castDouble(obj, 0);
    }

    private static double castDouble(Object obj, double defaultValue) {

        double value = defaultValue;
        if (obj != null) {
            String valueStr = castStr(obj);
            if (!"".equals(valueStr)) {
                try {
                    value = Double.parseDouble(valueStr);
                } catch (NumberFormatException e) {
                    value = defaultValue;
                }
            }
        }
        return value;
    }

    public static long castLong(Object obj) {
        return CastUtil.castLong(obj, 0);
    }

    private static long castLong(Object obj, long defaultValue) {

        long value = defaultValue;
        if (obj != null) {
            String valueStr = castStr(obj);
            if (!"".equals(valueStr)) {
                try {
                    value = Long.parseLong(valueStr);
                } catch (NumberFormatException e) {
                    value = defaultValue;
                }
            }
        }
        return value;
    }

    public static int castInt(Object obj) {
        return CastUtil.castInt(obj, 0);
    }

    private static int castInt(Object obj, int defaultValue) {

        int value = defaultValue;
        if (obj != null) {
            String valueStr = castStr(obj);
            if (!"".equals(valueStr)) {
                try {
                    value = Integer.parseInt(valueStr);
                } catch (NumberFormatException e) {
                    value = defaultValue;
                }
            }
        }
        return value;
    }

    public static boolean castBoolean(Object obj) {
        return CastUtil.castBoolean(obj, false);
    }

    private static boolean castBoolean(Object obj, boolean defaultValue) {

        boolean value = defaultValue;
        if (obj != null) {
            String valueStr = castStr(obj);
            if (!"".equals(valueStr)) {
                try {
                    value = Boolean.parseBoolean(valueStr);
                } catch (NumberFormatException e) {
                    value = defaultValue;
                }
            }
        }
        return value;
    }

}
