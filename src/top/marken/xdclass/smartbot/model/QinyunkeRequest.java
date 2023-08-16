package top.marken.xdclass.smartbot.model;

/**
 * @author makun
 * @project xdclass_smartbot
 * @description 青云客请求实体类
 * @date 2022/08/24 16:22:18
 * version 1.0
 */
public class QinyunkeRequest {
    public String key;
    public Integer appid;
    public String msg;

    {
        key = "free";
        appid = 0;
    }

    public QinyunkeRequest() {
        super();
    }

    public QinyunkeRequest(String key, Integer appid, String msg) {
        this.key = key;
        this.appid = appid;
        this.msg = msg;
    }

    public QinyunkeRequest(String msg) {
        this.msg = msg;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "QinyunkeRequest{" +
                "key='" + key + '\'' +
                ", appid=" + appid +
                ", msg='" + msg + '\'' +
                '}';
    }
}
