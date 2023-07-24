package org.joker.redis.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import lombok.extern.slf4j.Slf4j;


//String msg = "*3\r\n" +
//        "$3\r\n" +
//        "SET\r\n" +
//        "$3\r\n" +
//        "key\r\n" +
//        "$5\r\n" +
//        "hello\r\n";
//
//String msg2 = "*2\r\n$3\r\nGET\r\n$3\r\nKEY\r\n";
//
//ByteBuf buf = ByteBufAllocator.DEFAULT.buffer();
//buf.writeBytes(msg.getBytes());
//
//channel.writeAndFlush(buf).sync();
@Slf4j
public class RESPStringEncoder extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {

        String[] input = ((String) msg).split("\\s+");
        ByteBuf buffer = ctx.alloc().buffer();
        if (input.length == 1) {
            buffer.writeBytes(("+" + input[0] + "\r\n").getBytes());
        }else {
            StringBuilder builder = new StringBuilder();
            builder.append("*" + input.length + "\r\n");
            for (String i : input) {
                builder.append("$" + i.length() + "\r\n");
                builder.append(i + "\r\n");
            }
            buffer.writeBytes(builder.toString().getBytes());
        }
        super.write(ctx, buffer, promise);
    }
}
