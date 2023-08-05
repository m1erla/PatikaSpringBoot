package com.furkankarakus.project.socket;

import org.aspectj.lang.JoinPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client_TwoWay_Person {
    public static void main(String[] args) throws UnknownHostException, IOException {
        String receiveMessage;
        String sendMessage;

        // port
        Socket socket = new Socket("localhost", StaticPort.PORT);

        // client veri gonderecek

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream, true);

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println("Client : please write a message");

        while (true){
            sendMessage = bufferedReader.readLine();
            printWriter.println(sendMessage);
            printWriter.flush();//refresh

            if ((receiveMessage = bufferedReader1.readLine())!=null){
                System.out.println("SERVER: " +receiveMessage);
            }
        }
    }
}
