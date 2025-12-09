package school.sockets.client_server.time;

import java.io.*;
import java.net.*;
import java.time.*;

public class TimeServer {
	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(4711)) {
			while (true) {
				Socket client = server.accept();

				System.out.println("Mit Client " + client.getInetAddress() + " verbunden");

				OutputStream toClient = client.getOutputStream();

				PrintWriter writer = new PrintWriter(toClient);

				LocalTime time = LocalTime.now();

				writer.println(time.toString());

				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
