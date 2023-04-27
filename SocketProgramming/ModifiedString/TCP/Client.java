package SocketProgramming.ModifiedString.TCP;

import java.io.*;
import java.net.*;

class TCPClient {
    public static void main(String[] args) throws Exception {
        Socket clientSocket = new Socket("localhost", 8888);

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.print("Enter a sentence: ");
        String sentence = inFromUser.readLine();
        outToServer.writeBytes(sentence + '\n');

        String capitalizedSentence = inFromServer.readLine();
        System.out.println("Received from server: " + capitalizedSentence);

        clientSocket.close();
    }
}

