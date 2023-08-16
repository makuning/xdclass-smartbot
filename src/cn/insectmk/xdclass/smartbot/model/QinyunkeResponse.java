package cn.insectmk.xdclass.smartbot.model;

/**
 * @author makun
 * @project xdclass_smartbot
 * @description 青云客返回消息实体类
 * @date 2022/08/24 15:41:38
 * version 1.0
 */
public class QinyunkeResponse {
    public Integer result;
    public String content;

    public QinyunkeResponse() {
        super();
    }

    public QinyunkeResponse(Integer result, String content) {
        this.result = result;
        this.content = content;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "QinyunkeResponse{" +
                "result=" + result +
                ", content='" + content + '\'' +
                '}';
    }
}
