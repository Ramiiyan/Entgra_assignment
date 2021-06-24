package com.engratcp.demo.Service;

import java.net.*;
import java.io.*;

public class EntgraTcpServer {
    private int serverPort = 4020;
    private Socket server;
    private PrintWriter toClient;
    private BufferedReader fromClient;
    private ServerSocket serverSocket;

    public void run() {
        try {

            serverSocket = new ServerSocket(serverPort);
            serverSocket.setSoTimeout(10000);
            while(true) {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");

                server = serverSocket.accept();
                System.out.println("Just connected to " + server.getRemoteSocketAddress());

                toClient = new PrintWriter(server.getOutputStream(),true);
                fromClient = new BufferedReader( new InputStreamReader(server.getInputStream()));
//                String line = fromClient.readLine();
//                System.out.println("Server received: " + line);
//                toClient.println("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
                String inputLine;
                while((inputLine = fromClient.readLine()) != null){
                    if (".".equals(inputLine)) {
                        toClient.println("good bye");
                        break;
                    }
                    toClient.println(inputLine);
                }
            }
        } catch(IOException ex) {
            System.out.println("Io Exception in Server...................");
            ex.printStackTrace();
        }
    }
    public void stop() throws IOException {
        fromClient.close();
        toClient.close();
        server.close();
        serverSocket.close();


    }

}
