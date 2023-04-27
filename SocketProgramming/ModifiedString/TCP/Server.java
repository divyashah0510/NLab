package SocketProgramming.ModifiedString.TCP;

import java.io.*;
import java.net.*;

class TCPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Server started...");

        while (true) {
            Socket connectionSocket = serverSocket.accept();

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            String sentence = inFromClient.readLine();
            System.out.println("Received from client: " + sentence);

            String capitalizedSentence = sentence.toUpperCase() + '\n';
            outToClient.writeBytes(capitalizedSentence);
        }
    }
}

