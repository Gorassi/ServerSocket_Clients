package com.javarush.task.task30.task3008;

import java.io.*;
import java.net.Socket;

public class $client implements Runnable {
    public static volatile int number = 0;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " started." );
            Socket socket = new Socket("127.0.0.1", 6663 + number++);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write(Thread.currentThread().getName() + " : hello, dear friend !!!\n");
            writer.write(Thread.currentThread().getName() + " : ku-ku !!!\n");
            writer.write(Thread.currentThread().getName() + " : exit\n");
            writer.close();
            socket.close();
            System.out.println(Thread.currentThread().getName() + " finished");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
