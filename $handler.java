package com.javarush.task.task30.task3008;

import java.io.*;
import java.net.Socket;

public class $handler implements Runnable {
    Socket socket;
    BufferedReader reader;
    String str;
    BufferedWriter writer;

    $handler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while((str = reader.readLine())!= null){
                System.out.println("handler : " + str);
                writer.write("echo on client : " + str);
                if(str.equals("exit")) break;
            }
            writer.close();
            reader.close();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
