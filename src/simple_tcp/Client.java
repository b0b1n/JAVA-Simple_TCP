package simple_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public Client() throws IOException{
		Socket socket = new Socket("localhost",2022);
		System.out.println("Connection to the server established");
		
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		
		String message = in_socket.readLine();
		System.out.println(" 'Mr.Server' says ::: "+ message);
		out_socket.println("Thanks Mr.Server!");
		
		socket.close();
		System.out.println(socket.isClosed() ? "socket is closed." : " socket not closed yet."); 
		
	}
	public static void main(String[] args) {
		try {
			new Client();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
