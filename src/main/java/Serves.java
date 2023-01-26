import java.io.*;
import java.net.ServerSocket;

public class Serves {
    private static final int PORT = 8089;

    public static void main(String[] args) throws IOException {
        System.out.println("servers started");
        try (var serverSocket = new ServerSocket(PORT)) {
            while (true) {
                try (var clientSocket = serverSocket.accept();
                     var out = new PrintWriter(clientSocket.getOutputStream(), true);
                     var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())))
                {
                    System.out.println("New connection accepted. Port: " + clientSocket.getPort());
                    var name = in.readLine();
                    out.println("Hi " + name + " your port is " + clientSocket.getPort());
                }
            }
        }
    }
}
