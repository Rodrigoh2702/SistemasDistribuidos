package Array;

import java.io.*;
import java.net.*;

public class ArrayMultiplier extends Thread {
    private ServerSocket arrayServer;


    public static void main(String argv[]) throws Exception {
        new ArrayMultiplier();
    }

    public ArrayMultiplier() throws Exception {
        arrayServer = new ServerSocket(4000);
        System.out.println("Server listening on port 4000.");
        this.start();
    }

    public void run() {
        while(true) {
            try {
                System.out.println("Waiting for connections.");
                Socket client = arrayServer.accept();
                System.out.println("Accepted a connection from: "+
                        client.getInetAddress());
                Connect c = new Connect(client);
            } catch(Exception e) {}
        }
    }
}
