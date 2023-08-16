package top.marken.xdclass.smartbot.app;

import top.marken.xdclass.smartbot.model.QinyunkeRequest;
import top.marken.xdclass.smartbot.model.QinyunkeResponse;
import top.marken.xdclass.smartbot.service.QinyunkeService;
import top.marken.xdclass.smartbot.service.impl.InitializeBoot;
import top.marken.xdclass.smartbot.service.impl.QinyunkeServiceImpl;
import java.util.Scanner;

/**
 * @author makun
 * @project xdclass_smartbot
 * @description 启动类
 * @date 2022/08/24 14:03:32
 * version 1.0
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName(InitializeBoot.class.getName());

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("倾听中...");
            System.out.print("我 说：");
            String msg = sc.nextLine();

            if ("886".equals(msg)) {
                System.out.println(InitializeBoot.BOT_NAME + " 说：" + "欢迎下次使用，拜拜");
                break;
            } else {
                QinyunkeService qinyunkeService = new QinyunkeServiceImpl();
                QinyunkeResponse response = qinyunkeService.ask(new QinyunkeRequest(msg));

                System.out.println( InitializeBoot.BOT_NAME + " 说：" + response.getContent());
            }
        }
    }
}
