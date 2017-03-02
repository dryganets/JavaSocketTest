package com.sergeyd;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * Created by sergeyd on 2/28/17.
 */
public class SocketTest {

    public static void main(String[] argv) throws IOException, InterruptedException {
        String host = "Use your server ip";

        try {
            Socket socket = new Socket(host, 3000);
            System.out.println(String.format("write size: %d, read size: %d, keep-alive: %b, OOBInline: %b, linger: %d, No-delay: %b",
                    socket.getSendBufferSize(), socket.getReceiveBufferSize(), socket.getKeepAlive(), socket.getOOBInline(), socket.getSoLinger(), socket.getTcpNoDelay()));
            InputStream stream = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            int iter = 0;
            while (true) {
                out.write(UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8));
                iter++;
                System.out.println(iter);
                Thread.sleep(500);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
