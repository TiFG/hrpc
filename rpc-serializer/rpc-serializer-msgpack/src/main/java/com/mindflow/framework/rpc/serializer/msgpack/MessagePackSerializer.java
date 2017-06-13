package com.mindflow.framework.rpc.serializer.msgpack;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindflow.framework.rpc.serializer.Serializer;
import org.msgpack.jackson.dataformat.MessagePackFactory;
import java.io.IOException;

/**
 * msgpack-java: https://github.com/msgpack/msgpack-java
 *
 * @author Ricky Fung
 */
public class MessagePackSerializer implements Serializer {

    private final ObjectMapper objectMapper = new ObjectMapper(new MessagePackFactory());;

    @Override
    public byte[] encode(Object msg) throws IOException {
        return objectMapper.writeValueAsBytes(msg);
    }

    @Override
    public <T> T decode(byte[] buf, Class<T> type) throws IOException {
        return objectMapper.readValue(buf, type);
    }
}
