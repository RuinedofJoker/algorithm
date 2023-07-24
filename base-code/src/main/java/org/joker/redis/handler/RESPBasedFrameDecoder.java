package org.joker.redis.handler;

import com.google.common.primitives.Bytes;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;
import org.joker.redis.protocol.RESP;

import java.util.List;

/**
 * RESP协议解码器类(解决粘包半包问题)
 *
 * 如果lastContent不为null,发生粘包半包问题
 *
 * 将最后不完整的内容放入lastContent的unresolvedBuf交给下一次的decoder解析
 * 每次读取当前ByteBuf in前先判断lastContent是否为null,为null表明有上次未解析完的ByteBuf,先解析上次的
 */
@Slf4j
public class RESPBasedFrameDecoder extends ByteToMessageDecoder {

    private RESP lastContent;

/*             +-------------------------------------------------+
                     |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
            +--------+-------------------------------------------------+----------------+
            |00000000| 2a 33 0d 0a 24 33 0d 0a 53 45 54 0d 0a 24 33 0d |*3..$3..SET..$3.|
            |00000010| 0a 6b 65 79 0d 0a 24 35 0d 0a 68 65 6c 6c 6f 0d |.key..$5..hello.|
            |00000020| 0a                                              |.               |
            +--------+-------------------------------------------------+----------------+

               +-------------------------------------------------+
                     |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
            +--------+-------------------------------------------------+----------------+
            |00000000| 2b 4f 4b 0d 0a                                  |+OK..           |
            +--------+-------------------------------------------------+----------------+
*/


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (lastContent == null) {
            while (in.isReadable()) {
                RESP resp = new RESP(Byte.toString(in.readByte()));
                resolveLength(resp, in);
                int contentCode = resolveContent(resp, in);
                if (contentCode == -1) {
                    lastContent = resp;
                    break;
                }
                if (contentCode == -2) {
                    throw new RuntimeException("error");
                }
                out.add(resp);
            }
        }else {

        }

        in.release();
    }

    private int resolveLength(RESP resp, ByteBuf in) {
        if (resp.getLength() == RESP.COMMON_LENGTH) {
            return 0;
        }else {
            if (!in.isReadable()) {
                return -1;
            }
            resp.setLength(Integer.parseInt(Byte.toString(in.readByte())));
            return 0;
        }
    }

    private int resolveContent(RESP resp, ByteBuf in) {
        if (RESP.SIMPLE_STRINGS.equals(resp.getRespType())
                || RESP.ERROR.equals(resp.getRespType())
                || RESP.NUMBER.equals(resp.getRespType())) {
            //普通类型,以\r\n结尾
            List<Byte> content = resp.getUnresolvedBuf();
            while (in.isReadable()) {
                content.add(in.readByte());
                if (content.get(content.size() - 2) == '\r' && content.get(content.size() - 1) == '\n') {
                    return 0;
                }
            }

            //没有读到\r\n
            return -1;
        }else if (RESP.BULK_STRINGS.equals(resp.getRespType())) {
            //带长度的字符串
            byte[] content = resp.getCommonContent();
            int readableBytes = in.readableBytes();
            if (readableBytes >= resp.readableLength()) {
                //当前resp可读满
                in.readBytes(content, resp.getReadLength(), resp.readableLength());
                return 0;
            }else {
                //当前resp读不满
                in.readBytes(content, resp.getReadLength(), readableBytes);
                resp.setReadLength(resp.getReadLength() + readableBytes);
                return -1;
            }
        }else if (RESP.ARRAY.equals(resp.getRespType())) {

        }
        return -2;
    }

    private int resolveCommonContent(RESP resp, ByteBuf in) {

    }
}
