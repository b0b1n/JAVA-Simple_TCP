package simple_tcp_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public Client() throws IOException{
		Socket socket = new Socket("localhost",2022);
		System.out.println("Connection to the server established");
		
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		
		Scanner keyboard = new Scanner(System.in);
		String user_number;
		int i=1;
		while((in_socket.readLine()).startsWith("Guess")) {
			System.out.println(i++ +".   Server says : Guess a number [1-10].");
			user_number = keyboard.nextLine();
			out_socket.println(user_number);
		}
		
		System.out.println("Hurraay !! You got the secret number");
		socket.close();
		System.out.println(socket.isClosed() ? "Socket is closed." : " Socket not closed yet."); 
		
	}
	public static void main(String[] args) {
		try {
			new Client();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
