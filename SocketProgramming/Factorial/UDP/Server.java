package SocketProgramming.Factorial.UDP;

class UDPServer {
    public static void main(String[] args) throws Exception{
        
            DatagramSocket serverSocket = new DatagramSocket(9876);
            System.out.println("Server is running...");

            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];

            while (true) {
                System.out.println("Waiting for client...");
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                System.out.println("Client connected.");

                int num = Integer.parseInt(new String(receivePacket.getData()).trim());
                int fact = 1;

                for (int i = 2; i <= num; i++) {
                    fact *= i;
                }
                
                InetAddress IPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();

                sendData = String.valueOf(fact).getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                serverSocket.send(sendPacket);
            }
    }
}