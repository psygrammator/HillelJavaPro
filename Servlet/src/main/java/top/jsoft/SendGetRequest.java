package top.jsoft;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class SendGetRequest {
    @SneakyThrows
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 8080);
            var reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            var writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream())))
        {
            System.out.println("Send request");
            writer.println("GET /order?id=1 HTTP/1.1");
            writer.println("Host: localhost");
            writer.println();
            writer.flush();
            reader.lines().forEach(System.out::println);
        }
    }
}
