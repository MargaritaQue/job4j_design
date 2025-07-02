package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String read = input.readLine();
                    System.out.println(read);
                    String line = read.split(" ")[1];
                    if (line.contains("msg")) {
                        switch (line) {
                            case ("/?msg=Hello") -> {
                                output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                                output.write("Hello.".getBytes());
                            }
                            case ("/?msg=Any") -> {
                                output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                                output.write("What.".getBytes());
                            }
                            case ("/?msg=Exit") ->
                                server.close();
                            default -> {
                                output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                                output.write(line.split("=")[1].getBytes());
                            }
                        }
                    }
                    output.flush();
                } catch (Exception e) {
                    LOG.error("Exception in log example", e);
                }
            }
        }

    }
}