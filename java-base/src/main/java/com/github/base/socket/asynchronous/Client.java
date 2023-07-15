package com.github.base.socket.asynchronous;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            // 创建一个 Socket 对象，指定连接的服务器和端口号
            Socket socket = new Socket("localhost", 8888);

            // 获取输出流，用于向服务器发送数据
            OutputStream outputStream = socket.getOutputStream();

            // 将数据写入输出流
            String message = "Hello, Server!";
            outputStream.write(message.getBytes("UTF-8"));

            // 关闭输出流
            socket.shutdownOutput();
            outputStream.close();

            // // 获取输入流，用于从服务器接收数据
            // InputStream inputStream = socket.getInputStream();
            //
            // // 读取服务器返回的数据
            // ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            // byte[] buffer = new byte[1024];
            // int len;
            // while ((len = inputStream.read(buffer)) != -1) {
            //     byteArrayOutputStream.write(buffer, 0, len);
            // }
            // String response = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
            // System.out.println("Server response: " + response);
            //
            // // 关闭输入流和 Socket 连接
            // inputStream.close();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
