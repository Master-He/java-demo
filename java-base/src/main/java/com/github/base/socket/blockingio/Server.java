package com.github.base.socket.blockingio;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * @author hewenji
 * @Date 2023/6/3 11:24
 */
public class Server {
    public static void main(String[] args) throws Exception {
        blockingIO();
    }

    public static void blockingIO() throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = inputStream.read(buffer);
        System.out.println("Received message: " + new String(buffer, 0, len));
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
