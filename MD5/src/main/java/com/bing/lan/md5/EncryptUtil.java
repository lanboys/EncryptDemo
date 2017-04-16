package com.bing.lan.md5;

/**
 * @author 蓝兵
 * @time 2017/3/27  17:18
 */
public class EncryptUtil {
    public static native String encode(String str, int length);

    public static native String decode(String str, int length);
}
