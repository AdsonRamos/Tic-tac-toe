package tictac.net;

import tictac.game.TicTac;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Player {

	private Scanner reader;
	private PrintWriter writer;
	private Socket socket;
	private String name;
	private TicTac window;
	public boolean[] hasAlreadyClicked = new boolean[9];
	private String whoseTurn = "X";
	private String opponentName = new String();
	private boolean playerOne = false;
	private int size = 0;
	private boolean flagOpponentName = false;
	private boolean alreadyCatched = false;

	public char[][] matriz = new char[3][3];

	public Player(String name, TicTac window, String address, int port) {
		try {
			this.name = name;
			this.window = window;
			socket = new Socket(address, port);
			writer = new PrintWriter(socket.getOutputStream());
			reader = new Scanner(socket.getInputStream());
			inicializaMatriz();
			startArray();

			writer.println("#Size"+":"+name);
			writer.flush();

			new Thread(new ListenToServer()).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class ListenToServer implements Runnable {

		private boolean running;

		public ListenToServer() {
			running = true;
		}

		public void run() {
			String texto;
			while (running) {
				texto = reader.nextLine();
				if(size < 2){
					size++;					
				}
				
				if(texto.startsWith("#OpponentNameIs")){
					if(playerOne){
						if(!alreadyCatched){
							opponentName = texto.substring(15);
							alreadyCatched = true;
						}
					} else {
						opponentName = texto.substring(15);
					}
					window.setOpponentName(opponentName);
				} else if (texto.startsWith("#Size")) {
					if(!playerOne){
						playerOne = Integer.parseInt(texto.substring(5)) == 1;
					}
				} else {
					determineWhoseTurn();				
					setStatus();
					if (texto.startsWith("1")) {
						hasAlreadyClicked[0] = true;
						matriz[0][0] = texto.charAt(2);
						window.button1.setText(String.valueOf(matriz[0][0]));
					} else if (texto.startsWith("2")) {
						hasAlreadyClicked[1] = true;
						matriz[0][1] = texto.charAt(2);
						window.button2.setText(String.valueOf(matriz[0][1]));
					} else if (texto.startsWith("3")) {
						hasAlreadyClicked[2] = true;
						matriz[0][2] = texto.charAt(2);
						window.button3.setText(String.valueOf(matriz[0][2]));
					} else if (texto.startsWith("4")) {
						hasAlreadyClicked[3] = true;
						matriz[1][0] = texto.charAt(2);
						window.button4.setText(String.valueOf(matriz[1][0]));
					} else if (texto.startsWith("5")) {
						hasAlreadyClicked[4] = true;
						matriz[1][1] = texto.charAt(2);
						window.button5.setText(String.valueOf(matriz[1][1]));
					} else if (texto.startsWith("6")) {
						hasAlreadyClicked[5] = true;
						matriz[1][2] = texto.charAt(2);
						window.button6.setText(String.valueOf(matriz[1][2]));
					} else if (texto.startsWith("7")) {
						hasAlreadyClicked[6] = true;
						matriz[2][0] = texto.charAt(2);
						window.button7.setText(String.valueOf(matriz[2][0]));
					} else if (texto.startsWith("8")) {
						hasAlreadyClicked[7] = true;
						matriz[2][1] = texto.charAt(2);
						window.button8.setText(String.valueOf(matriz[2][1]));
					} else if (texto.startsWith("9")) {
						hasAlreadyClicked[8] = true;
						matriz[2][2] = texto.charAt(2);
						window.button9.setText(String.valueOf(matriz[2][2]));
					}
				}
				
				if(!playerOne) size = 2;
				
				determineOpponentName();

				if ((verificaVencedor(matriz) == 'X')
						|| (verificaVencedor(matriz) == 'O')) {
					window.showsWinner(verificaVencedor(matriz));
				} else if (verificaVencedor(matriz) == '#') {
					window.tie();
				}

			}
		}
	}

	public boolean isPlayerOne() {
		return playerOne;
	}

	public void startArray() {
		for (int i = 0; i < hasAlreadyClicked.length; i++) {
			hasAlreadyClicked[i] = false;
		}
	}

	public void button(String texto, boolean X) {
		if (X) {
			texto = texto + ":X";
		} else {
			texto = texto + ":O";
		}
		writer.println(texto);
		writer.flush();
	}

	public void inicializaMatriz() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = '-';
			}
		}
	}

	public static void exibeMatriz(char[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (j == matriz.length - 1) {
					System.out.print(matriz[i][j]);
				} else {
					System.out.print(matriz[i][j] + " ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public char[][] getMatriz() {
		return matriz;
	}

	public String getName() {
		return this.name;
	}

	public String getWhoseTurn() {
		return whoseTurn;
	}

	public void determineWhoseTurn() {
		if (whoseTurn.equals("X")) {
			whoseTurn = "O";
		} else {
			whoseTurn = "X";
		}
	}

	public void setStatus() {
		if (whoseTurn.equals("X")) {
			window.textStatus.setText("Vez de X");
		} else if (whoseTurn.equals("O")) {			
			window.textStatus.setText("Vez de O");
		}
		window.txtplayerOne.setText(name);
		window.txtPlayerTwo.setText(opponentName);
	}
	
	public void determineOpponentName(){		
		if(size == 2){
			if(flagOpponentName) return;
			if(playerOne){
				writer.println("#OpponentName1");
			} else {
				writer.println("#OpponentName2");
			}
			writer.flush();
			flagOpponentName = true;
		}
	}

	// Funcinando perfeitamente
	public char verificaVencedor(char[][] matriz) {
		/*
		 * 
		 * 'X' - X ganhou;
		 * 'O' - O ganhou;
		 * '-' - O jogo ainda não terminou; 
		 * '#' - Houve empate;
		 */

		if (matriz[0][0] == matriz[0][1] && matriz[0][0] == matriz[0][2]
				&& matriz[0][0] != '-') {
			return matriz[0][0];
		} else if (matriz[1][0] == matriz[1][1] && matriz[1][0] == matriz[1][2]
				&& matriz[1][0] != '-') {
			return matriz[1][0];
		} else if (matriz[2][0] == matriz[2][1] && matriz[2][0] == matriz[2][2]
				&& matriz[2][0] != '-') {
			return matriz[2][0];
		} else if (matriz[0][0] == matriz[1][0] && matriz[0][0] == matriz[2][0]
				&& matriz[0][0] != '-') {
			return matriz[0][0];
		} else if (matriz[0][1] == matriz[1][1] && matriz[0][1] == matriz[2][1]
				&& matriz[0][1] != '-') {
			return matriz[0][1];
		} else if (matriz[0][1] == matriz[1][1] && matriz[0][1] == matriz[2][1]
				&& matriz[0][1] != '-') {
			return matriz[0][1];
		} else if (matriz[0][2] == matriz[1][2] && matriz[0][2] == matriz[2][2]
				&& matriz[0][2] != '-') {
			return matriz[0][2];
		} else if (matriz[0][0] == matriz[1][1] && matriz[0][0] == matriz[2][2]
				&& matriz[0][0] != '-') {
			return matriz[0][0];
		} else if (matriz[2][0] == matriz[1][1] && matriz[2][0] == matriz[0][2]
				&& matriz[2][0] != '-') {
			return matriz[2][0];
		}

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (matriz[i][j] == '-')
					return '-';
			}
		}

		return '#';
	}
}
