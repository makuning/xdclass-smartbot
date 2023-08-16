package cn.insectmk.xdclass.smartbot.service;

import cn.insectmk.xdclass.smartbot.model.QinyunkeRequest;
import cn.insectmk.xdclass.smartbot.model.QinyunkeResponse;

/**
 * @author makun
 * @project xdclass_smartbot
 * @description 青云客服务接口
 * @date 2022/08/24 15:40:51
 * version 1.0
 */
public interface QinyunkeService {
    QinyunkeResponse ask(QinyunkeRequest qinyunkeRequest);
}
