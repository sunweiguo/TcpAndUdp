package com.njupt.swg;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Author swg.
 * @Date 2019/1/25 21:18
 * @CONTACT 317758022@qq.com
 * @DESC
 */
public class UDPServer {
    public static void main(String[] args) throws IOException {
        //服务端接受客户端发送的数据
        DatagramSocket socket = new DatagramSocket(65001);
        byte[] buff = new byte[100];
        DatagramPacket packet = new DatagramPacket(buff,buff.length);
        //拿到数据之后封装进DatagramPacket
        socket.receive(packet);

        //从DatagramPacket中取出数据
        byte[] data = packet.getData();
        String content = new String(data,0,packet.getLength());
        System.out.println(content);

        //发送数据也要用DatagramPacket
        byte[] sendedContent = String.valueOf(content.length()).getBytes();

        DatagramPacket packetToClient = new DatagramPacket(sendedContent,
                sendedContent.length,packet.getAddress(),packet.getPort());
        socket.send(packetToClient);
    }
}
