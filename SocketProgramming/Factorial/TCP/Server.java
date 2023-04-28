package SocketProgramming.Factorial.TCP;

class TCPServer{
		public static void main(String argv[]) throws Exception{
			ServerSocket welcomeSocket = new ServerSocket(6789);
			System.out.println("Server has started Running....");
			
			while(true){
				Socket connectionSocket = welcomeSocket.accept();
				System.out.println("Client is successfully connected :)");
				
				DataInputStream inToClient = new DataInputStream(connectionSocket.getInputStream());
				DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
				
				int length = inToClient.readInt();
				int breadth = inToClient.readInt();
				int area = length * breadth;
				
				outToClient.writeInt(area);
				
				inToClient.close();
				outToClient.close();
				connectionSocket.close();
			}
		}
}
