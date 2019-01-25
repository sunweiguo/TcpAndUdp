package com.njupt.swg;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author swg.
 * @Date 2019/1/25 21:19
 * @CONTACT 317758022@qq.com
 * @DESC
 */
public class LengthCalculator extends Thread{
    private Socket socket;

    public LengthCalculator(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //获取socket输出流
            OutputStream os = socket.getOutputStream();
            //获取socket输入流
            InputStream is = socket.getInputStream();
            int ch = 0;
            byte[] buff = new byte[1024];
            //buff存放读到的内容，ch未数据的长度
            ch = is.read(buff);
            //将数组转换为字符串打印
            String content = new String(buff,0,ch);
            System.out.println(content);

            //关闭
            os.write(String.valueOf(content.length()).getBytes());
            is.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
