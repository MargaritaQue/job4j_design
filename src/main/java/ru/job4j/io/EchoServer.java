package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    while (input.ready()) {
                        String read = input.readLine();
                        System.out.println(read);
                        String[] line = read.split("=");
                        if (line[1].contains("Bye")) {
                            server.close();
                        }
                    }
                    output.flush();
                }
            }
        }

    }
}