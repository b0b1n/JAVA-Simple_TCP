package simple_tcp;

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
		System.out.println("Client " + socket.getRemoteSocketAddress() + " has connected.");

		// I/O buffers:
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

		out_socket.println("Welcome Mr.Client!"); // sending a message to the Client
		String message = in_socket.readLine(); //Storing what the Client wrote
		System.out.println(" 'Mr.Client' says ::: " + message); // display Client's message in the console

		socket.close();
		System.out.println(socket.isClosed() ? "socket is closed." : " socket not closed yet."); 
	}

	public static void main(String[] args) {
		try {
			new Server();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
