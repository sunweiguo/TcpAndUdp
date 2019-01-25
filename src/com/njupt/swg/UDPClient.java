package com.njupt.swg;

import java.io.IOException;
import java.net.*;

/**
 * @Author swg.
 * @Date 2019/1/25 21:18
 * @CONTACT 317758022@qq.com
 * @DESC
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
        //客户端发送数据给服务端
        DatagramSocket socket = new DatagramSocket();
        byte[] buf = "hello world".getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        //发送的数据封装为DatagramPacket对象
        DatagramPacket packet = new DatagramPacket(buf,buf.length,address,65001);
        //发送
        socket.send(packet);
        //接受服务端发来的数据
        byte[] data = new byte[100];
        //创建DatagramPacket来接受数据
        DatagramPacket receivedPacket = new DatagramPacket(data,data.length);
        //将接受到的数据放进DatagramPacket中
        socket.receive(receivedPacket);
        //从DatagramPacket获取数据
        String content = new String(receivedPacket.getData(),0,receivedPacket.getLength());
        System.out.println(content);

    }
}
