import java.io.*;
import java.net.Socket;

public class Client {

    private static final int PORT = 8089;
    private static final String HOST = "127.0.0.1";

    public static void main(String[] args) {
        try (var socket = new Socket(HOST, PORT);
             var out = new PrintWriter(socket.getOutputStream(), true);
             var in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            out.println("Timur");
            String resp = in.readLine();
            System.out.println(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
