package SocketProgramming.ModifiedString.UDP;

import java.net.*;
import java.io.*;

class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        int port = 8888;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a sentence: ");
        String sentence = inFromUser.readLine();
        byte[] sendData = sentence.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
        clientSocket.send(sendPacket);

        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        String capitalizedSentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Received from server: " + capitalizedSentence);

        clientSocket.close();
    }
}


