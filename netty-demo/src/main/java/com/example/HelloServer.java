package com.example;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author hewenji
 * @Date 2023/6/16 22:26
 */
public class HelloServer {
    public static void main(String[] args) {
        new ServerBootstrap() // 0. 启动器， 负责组装netty组件， 启动服务器
            .group(new NioEventLoopGroup()) // 1. 一个线程配置一个selector
            .channel(NioServerSocketChannel.class) // 2 选择channel的实现 （负责处理连接的）
            .childHandler(new ChannelInitializer<NioSocketChannel>() { // 3 NioSocketChannel（负责处理具体读写的通道）
                protected void initChannel(NioSocketChannel ch) {
                    // 负责添加别的handler
                    ch.pipeline().addLast(new StringDecoder()); // 5 将ByteBuf 转换成字符串
                    ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() { // 6 自定义 handler
                        @Override // 读事件
                        protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                            // 打印上一步转换好的字符串
                            System.out.println(msg);
                        }
                    });
                }
            })
            .bind(8080);// 4 绑定监听端口
    }
}
