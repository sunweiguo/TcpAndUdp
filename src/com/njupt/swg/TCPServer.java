package com.njupt.swg;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author swg.
 * @Date 2019/1/25 21:18
 * @CONTACT 317758022@qq.com
 * @DESC
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建socket，并且将socket绑定到65000端口
        ServerSocket ss = new ServerSocket(65000);
        while (true){
            //监听65000端口，知道客户端返回连接信息才返回
            Socket socket =ss.accept();
            //获取客户端连接之后，执行相关业务逻辑
            new LengthCalculator(socket).start();
        }
    }
}
