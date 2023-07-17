package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class $server {

    public static void main(String[] args) {
        try {
            (new Thread(new $client())).start();
            (new Thread(new $client())).start();
            (new Thread(new $client())).start();

            int i = 0;
            while(i < 3){
            new Thread(new $handler((new ServerSocket(6663 + i)).accept())).start();
            i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
