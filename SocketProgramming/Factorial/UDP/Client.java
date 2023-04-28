// package SocketProgramming.Factorial.UDP;

class UDPClient {
    public static void main(String[] args) throws Exception{
        try {
            DatagramSocket clientSocket = new DatagramSocket();

            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a number to find factorial: ");
            int num = Integer.parseInt(inFromUser.readLine());

            InetAddress IPAddress = InetAddress.getByName("localhost");
            byte[] sendData = String.valueOf(num).getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,   IPAddress, 9876);
            clientSocket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            int fact = Integer.parseInt(new String(receivePacket.getData()).trim());
            System.out.println("Factorial of " + num + " is : " + fact);

            clientSocket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}

