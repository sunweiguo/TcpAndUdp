package com.njupt.swg;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author swg.
 * @Date 2019/1/25 21:17
 * @CONTACT 317758022@qq.com
 * @DESC
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //创建socket
        Socket socket = new Socket("127.0.0.1",65000);
        //获取输出流和输入流
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();

        //将需要传输的内容转换为驻足写入到输出流
        os.write(new String("hello world").getBytes());
        int ch = 0;
        byte[] buff = new byte[1024];
        //读取输入内容放进数组中
        ch = is.read(buff);
        String content = new String(buff,0,ch);
        System.out.println(content);

        //关闭
        is.close();
        os.close();
        socket.close();
    }
}
