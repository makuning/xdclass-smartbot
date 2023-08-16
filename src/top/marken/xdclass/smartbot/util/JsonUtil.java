package top.marken.xdclass.smartbot.util;

import com.google.gson.Gson;

/**
 * @author makun
 * @project xdclass_smartbot
 * @description Json工具类
 * @date 2022/08/24 15:42:04
 * version 1.0
 */
public class JsonUtil {
    private final static Gson gson;

    static {
        gson = new Gson();
    }

    private JsonUtil() {
        super();
    }

    public static String jsonToString(Object object) {
        return gson.toJson(object);
    }

    public static <T> T stringToJson(String jsonStr, Class<T> clazz) {
        return gson.fromJson(jsonStr,clazz);
    }
}
