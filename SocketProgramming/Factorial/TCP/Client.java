package SocketProgramming.Factorial.TCP;

class TCPClient
{
	public static void main(String argv[]) throws Exception{
		Socket clientSocket = new Socket("localhost", 6789);
		
		DataInputStream intoToServer = new DataInputStream(clientSocket.getInputStream());
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter length of rectangle: ");
            int length = Integer.parseInt(br.readLine());
            System.out.print("Enter breadth of rectangle: ");
            int breadth = Integer.parseInt(br.readLine());
		
		outToServer.writeInt(length);
		outToServer.writeInt(breadth);
		
		int area = intoToServer.readInt();
		System.out.println("Area of rectangle with length " + length + " and breadth " + breadth + " is " + area);
		
		intoToServer.close();
		outToServer.close();
		clientSocket.close();
		
	}
}