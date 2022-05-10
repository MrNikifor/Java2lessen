package com.geekbrains.clientchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.function.Consumer;

public class Network {

    public static final String SERVER_HOST = "127.0.0.1";
    public static final int SERVER_PORT = 8189;

    private String host;
    private int port;

    private Socket socket;
    private DataInputStream socketInput;
    private DataOutputStream socketOutput;

    public Network(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Network() {
        this(SERVER_HOST, SERVER_PORT);
    }

    public boolean connect() {
        try {
            socket = new Socket(host, port);
            socketOutput = new DataOutputStream(socket.getOutputStream()); // запись
            socketInput = new DataInputStream(socket.getInputStream()); // чтение
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public void sendMessage(String message) throws IOException {
        try {
            socketOutput.writeUTF(message);
        } catch (IOException e) {
            System.err.println("Failed to send a message to the server");
            e.printStackTrace();
            throw e;
        }
    }
    public void waitMessage(Consumer<String> messageHandler){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    try {
                        String message = socketInput.readUTF();
                        messageHandler.accept(message);
                    } catch (IOException e) {
                        System.err.println("Failed to receive message");
                        break;
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
    void close(){
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("Failed to close network connection");
        }
    }
}
