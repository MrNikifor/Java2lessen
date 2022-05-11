package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static final int PORT = 8189;
    public static void main(String[] args) {
       try(ServerSocket serverSocket = new ServerSocket(PORT)){
           System.out.println("The server has started working, we are waiting for a new connection");
          Socket clientSocket = serverSocket.accept();
           System.out.println("The client is connected");
           DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
           DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
           while (true){
               String message = inputStream.readUTF();
               if(message.startsWith("/end")){
                   break;
               }
               outputStream.writeUTF("Echo: " + message);
           }
       }catch (IOException e){
            System.err.println("Error when connecting to porn 8189");
            e.printStackTrace();
        }
    }
}
