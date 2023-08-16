package cn.insectmk.xdclass.smartbot.service.impl;

import cn.insectmk.xdclass.smartbot.util.JsonUtil;

import java.io.*;
import java.util.Map;

/**
 * @author makun
 * @project xdclass_smartbot
 * @description 启动初始化
 * @date 2022/08/24 15:43:42
 * version 1.0
 */
public class InitializeBoot {
    private static final String PROFILE_NAME = "profile/application.json";
    public static String BOT_API;
    public static String BOT_NAME;

    static {
        String fileStr = Thread.currentThread().getContextClassLoader().getResource(PROFILE_NAME).getFile();

        StringBuilder sb = new StringBuilder();

        try (FileReader in = new FileReader(fileStr);
             BufferedReader bufReader = new BufferedReader(in);) {
            String line = null;
            while ((line = bufReader.readLine()) != null) {
                sb.append(line);
            }

            Map<String,Object> parameters = JsonUtil.stringToJson(sb.toString(), Map.class);
            BOT_API = parameters.get("bot_api").toString();
            BOT_NAME = parameters.get("bot_name").toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private InitializeBoot() {
        super();
    }
}
