package com.furkankarakus.project.socket;

import org.hibernate.result.Output;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_TwoWay_Person {
    public static void main(String[] args) throws IOException {
        String receiveMessage;
        String sendMessage;

        ServerSocket serverSocket = new ServerSocket(StaticPort.PORT);

        System.out.println("Server is ready...");
        Socket socket = serverSocket.accept();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream = socket.getOutputStream();

        PrintWriter printWriter = new PrintWriter(outputStream,true);

        InputStream inputStream = socket.getInputStream();

        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(inputStream));

        while (true){
            if ((receiveMessage = receiveRead.readLine()) != null){
                System.out.println("Client : " +receiveMessage);
            }
            sendMessage = bufferedReader.readLine();
            printWriter.println(sendMessage);
            printWriter.flush();
        }
    }
}
