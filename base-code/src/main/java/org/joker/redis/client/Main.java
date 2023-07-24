package org.joker.redis.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;
import org.joker.redis.handler.RESPBasedFrameDecoder;

import java.net.InetSocketAddress;
import java.util.Scanner;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup nel = new NioEventLoopGroup();
        Scanner scanner = new Scanner(System.in);
        Channel channel = null;

        try {
            channel = new Bootstrap()
                    .group(nel)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            ChannelPipeline pipeline = channel.pipeline();
                            pipeline.addLast(new LoggingHandler());
                            pipeline.addLast(new ChannelInboundHandlerAdapter() {
                                @Override
                                public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                    log.info("读取到---{}", msg);
                                    super.channelRead(ctx, msg);
                                }
                            });
                            pipeline.addLast(new LoggingHandler());
                            //pipeline.addLast(new RESPBasedFrameDecoder());
                        }
                    })
                    .connect(new InetSocketAddress("localhost", 6379))
                    .sync()
                    .channel();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {

            String msg = "*3\r\n" +
                    "$3\r\n" +
                    "SET\r\n" +
                    "$3\r\n" +
                    "key\r\n" +
                    "$5\r\n" +
                    "hello\r\n";

            String msg2 = "*2\r\n$3\r\nGET\r\n$3\r\nKEY\r\n";

            ByteBuf buf = ByteBufAllocator.DEFAULT.buffer();
            buf.writeBytes(msg2.getBytes());

            channel.writeAndFlush(buf).sync();

            scanner.nextLine();
            if (channel != null) {
                channel.close();
            }
            nel.shutdownGracefully();
        }
    }
}
