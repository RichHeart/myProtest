package cn.kgc.product.common.utils;

/**
 * Created by Tiler on 2020/4/16
 */
public class NumberUtils {
    public static Integer strToInt(String stringValue, Integer defaultValue) {
        if (stringValue == null || stringValue.trim().equals("")) {
            return defaultValue;
        }
        else {
            return Integer.parseInt(stringValue);
        }
    }
}
