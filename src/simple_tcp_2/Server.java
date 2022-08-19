package simple_tcp_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public Server() throws IOException  {

		ServerSocket server_socket = new ServerSocket(2022); // opening a new port
		System.out.println("Port 2022 is open.");

		Socket socket = server_socket.accept();
		System.out.println("The Client " + socket.getRemoteSocketAddress() + " has connected.");

		// I/O buffers:
		/*
		 * Data coming from the client to the socket
		 */
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
		/*
		 * Outgoing data sent from the server to the client
		 */
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

		String message;
		int secret_number = (int)(Math.random()*10+1);
		do {
			out_socket.println("Guess a number [1-10] : ");
			message = in_socket.readLine();
		}while((Integer.parseInt(message)!=secret_number));
		
		out_socket.println("The secret number is exposed");
		System.out.println("Secret number is out. Exiting the app.");
		
		socket.close();
		System.out.println(socket.isClosed() ? "Socket is closed." : " Socket not closed yet."); 
	}

	public static void main(String[] args) {
		try {
			new Server();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
