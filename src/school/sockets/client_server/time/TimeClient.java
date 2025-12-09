package school.sockets.client_server.time;

import java.io.*;
import java.net.*;

public class TimeClient {
	public static void main(String[] args) {
		try (Socket toServer = new Socket("localhost", 4711)) {
			System.out.println("Verbunden mit " + toServer.getInetAddress());

			InputStream fromServer = toServer.getInputStream();

			BufferedReader br = new BufferedReader(new InputStreamReader(fromServer));

			String zeit = br.readLine();
			System.out.println("Server meldet: " + zeit);

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
