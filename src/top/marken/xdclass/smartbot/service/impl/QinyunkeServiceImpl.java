package top.marken.xdclass.smartbot.service.impl;

import top.marken.xdclass.smartbot.model.QinyunkeRequest;
import top.marken.xdclass.smartbot.model.QinyunkeResponse;
import top.marken.xdclass.smartbot.service.QinyunkeService;
import top.marken.xdclass.smartbot.util.JsonUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author makun
 * @project xdclass_smartbot
 * @description 青云客服务实现类
 * @date 2022/08/24 15:42:38
 * version 1.0
 */
public class QinyunkeServiceImpl implements QinyunkeService {

    @Override
    public QinyunkeResponse ask(QinyunkeRequest qinyunkeRequest) {
        String msg = qinyunkeRequest.getMsg();
        msg = msg.replace(" ", "%20");
        msg = msg.replace("+", "%2B");
        msg = msg.replace("\"","%22");
        msg = msg.replace("#", "%23");
        msg = msg.replace("%", "%25");
        msg = msg.replace("&", "%26");
        msg = msg.replace("(", "%28");
        msg = msg.replace(")", "%29");
        msg = msg.replace("+", "%2B");
        msg = msg.replace(",", "%2C");
        msg = msg.replace("/", "%2F");
        msg = msg.replace(":", "%3A");
        msg = msg.replace(";", "%3B");
        msg = msg.replace("<", "%3C");
        msg = msg.replace("=", "%3D");
        msg = msg.replace(">", "%3E");
        msg = msg.replace("?", "%3F");
        msg = msg.replace("@", "%40");
        msg = msg.replace("\\", "%5C");
        msg = msg.replace("|", "%7C");
        qinyunkeRequest.setMsg(msg);

        StringBuilder sb = new StringBuilder(InitializeBoot.BOT_API);
        sb.append("?");
        sb.append("key=");
        sb.append(qinyunkeRequest.getKey());
        sb.append("&appid=");
        sb.append(qinyunkeRequest.getAppid());
        sb.append("&msg=");
        sb.append(qinyunkeRequest.getMsg());

        QinyunkeResponse response = null;

        try {
            URL url = new URL(sb.toString());
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();

            int code = huc.getResponseCode();
            if (200 <= code && 299 >= code) {
                try (InputStream inputStream = huc.getInputStream();
                     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {
                    String current;
                    StringBuilder sb2 = new StringBuilder();
                    while ((current = bufferedReader.readLine()) != null) {
                        sb2.append(current);
                    }
                    current = sb2.toString();
                    response = JsonUtil.stringToJson(current.replace("{br}", "\n"), QinyunkeResponse.class);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}
