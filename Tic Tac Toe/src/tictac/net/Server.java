package tictac.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {

	private ServerSocket server;
	private boolean running;

	private List<PrintWriter> players = new ArrayList<PrintWriter>();
	private List<String> playersName = new ArrayList<String>();

	public Server() {
		running = true;

		try {
			server = new ServerSocket(5000);
			while (running) {
				Socket s = server.accept();
				PrintWriter p = new PrintWriter(s.getOutputStream());
				players.add(p);
				new Thread(new ListenToClient(s)).start();
			}
		} catch (IOException e) {
			running = false;
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Server();
	}

	private class ListenToClient implements Runnable {

		Scanner scanner;

		public ListenToClient(Socket socket) {
			try {
				scanner = new Scanner(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void run() {
			String texto;
			while (running) {
				if (scanner.hasNext()) {
					texto = scanner.nextLine();
					// Só é executado quando size == 2
					if (texto.startsWith("#OpponentName")) {
						if (texto.substring(13).equals("1")) {							
							sendToAll("#OpponentNameIs" + playersName.get(1));
						} else if (texto.substring(13).equals("2")) {
							sendToAll("#OpponentNameIs" + playersName.get(0));
						}
					} else if (texto.startsWith("#Size")) {
						playersName.add(texto.substring(6));
						sendToAll("#Size" + players.size());
					} else {
						sendToAll(texto);
					}
				}
			}
		}
	}

	private void sendToAll(String texto) {
		PrintWriter p;
		for (int i = 0; i < players.size(); i++) {
			p = players.get(i);
			p.println(texto);
			p.flush();
		}
	}

}
