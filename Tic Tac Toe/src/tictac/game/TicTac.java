package tictac.game;

import java.awt.Dimension;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import tictac.net.Player;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class TicTac extends JFrame {

	private static final long serialVersionUID = 1L;
	public JTextField txtplayerOne;
	public JTextField txtPlayerTwo;
	private JTextField txt_score_1;
	private JTextField txt_score_2;

	private Player player;

	public JTextField textStatus;

	private String name, opponentName;

	private int xScore = 0, oScore = 0;

	public final JButton button1 = new JButton("");
	public final JButton button2 = new JButton("");
	public final JButton button3 = new JButton("");
	public final JButton button4 = new JButton("");
	public final JButton button5 = new JButton("");
	public final JButton button6 = new JButton("");
	public final JButton button7 = new JButton("");
	public final JButton button8 = new JButton("");
	public final JButton button9 = new JButton("");

	private boolean playerOne;

	public TicTac(String nome, String address,int port) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {

		}
		
		this.name = nome;

		setTitle("Jogo da Velha");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(640, 480));
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		player = new Player(nome, this, address, port);

		button1.setFont(new Font("Verdana", Font.BOLD, 40));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (player.hasAlreadyClicked[0])
					return;
				if ((player.getWhoseTurn().equals("X") && playerOne)
						|| (player.getWhoseTurn().equals("O") && !playerOne))

					player.button("1", playerOne);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		button1.setBounds(30, 30, 100, 100);
		getContentPane().add(button1);

		button2.setFont(new Font("Verdana", Font.BOLD, 40));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player.hasAlreadyClicked[1])
					return;
				if ((player.getWhoseTurn().equals("X") && playerOne)
						|| (player.getWhoseTurn().equals("O") && !playerOne))

					player.button("2", playerOne);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		button2.setBounds(158, 30, 100, 100);
		getContentPane().add(button2);

		button3.setFont(new Font("Verdana", Font.BOLD, 40));
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player.hasAlreadyClicked[2])
					return;
				if ((player.getWhoseTurn().equals("X") && playerOne)
						|| (player.getWhoseTurn().equals("O") && !playerOne))

					player.button("3", playerOne);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		button3.setBounds(286, 30, 100, 100);
		getContentPane().add(button3);

		button4.setFont(new Font("Verdana", Font.BOLD, 40));
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player.hasAlreadyClicked[3])
					return;
				if ((player.getWhoseTurn().equals("X") && playerOne)
						|| (player.getWhoseTurn().equals("O") && !playerOne))

					player.button("4", playerOne);

				try {
					Thread.sleep(20);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		button4.setBounds(30, 156, 100, 100);
		getContentPane().add(button4);

		button5.setFont(new Font("Verdana", Font.BOLD, 40));
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player.hasAlreadyClicked[4])
					return;
				if ((player.getWhoseTurn().equals("X") && playerOne)
						|| (player.getWhoseTurn().equals("O") && !playerOne))

					player.button("5", playerOne);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		button5.setBounds(158, 156, 100, 100);
		getContentPane().add(button5);

		button6.setFont(new Font("Verdana", Font.BOLD, 40));
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player.hasAlreadyClicked[5])
					return;
				if ((player.getWhoseTurn().equals("X") && playerOne)
						|| (player.getWhoseTurn().equals("O") && !playerOne))

					player.button("6", playerOne);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		button6.setBounds(286, 156, 100, 100);
		getContentPane().add(button6);

		button7.setFont(new Font("Verdana", Font.BOLD, 40));
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player.hasAlreadyClicked[6])
					return;
				if ((player.getWhoseTurn().equals("X") && playerOne)
						|| (player.getWhoseTurn().equals("O") && !playerOne))

					player.button("7", playerOne);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		button7.setBounds(30, 282, 100, 100);
		getContentPane().add(button7);

		button8.setFont(new Font("Verdana", Font.BOLD, 40));
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player.hasAlreadyClicked[7])
					return;
				if ((player.getWhoseTurn().equals("X") && playerOne)
						|| (player.getWhoseTurn().equals("O") && !playerOne))

					player.button("8", playerOne);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		button8.setBounds(158, 282, 100, 100);
		getContentPane().add(button8);

		button9.setFont(new Font("Verdana", Font.BOLD, 40));
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player.hasAlreadyClicked[8])
					return;
				if ((player.getWhoseTurn().equals("X") && playerOne)
						|| (player.getWhoseTurn().equals("O") && !playerOne))
					player.button("9", playerOne);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		button9.setBounds(286, 282, 100, 100);
		getContentPane().add(button9);

		JLabel lblPlacar = new JLabel("Placar:");
		lblPlacar.setBounds(492, 34, 46, 14);
		getContentPane().add(lblPlacar);

		txtplayerOne = new JTextField(nome);
		txtplayerOne.setEditable(false);
		txtplayerOne.setBounds(416, 59, 86, 20);
		getContentPane().add(txtplayerOne);
		txtplayerOne.setColumns(10);

		txtPlayerTwo = new JTextField(opponentName);
		txtPlayerTwo.setEditable(false);
		txtPlayerTwo.setColumns(10);
		txtPlayerTwo.setBounds(416, 110, 86, 20);
		getContentPane().add(txtPlayerTwo);

		txt_score_1 = new JTextField("0");
		txt_score_1.setEnabled(false);
		txt_score_1.setBounds(523, 59, 86, 20);
		getContentPane().add(txt_score_1);
		txt_score_1.setColumns(10);

		txt_score_2 = new JTextField("0");
		txt_score_2.setEnabled(false);
		txt_score_2.setColumns(10);
		txt_score_2.setBounds(523, 110, 86, 20);
		getContentPane().add(txt_score_2);

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(416, 177, 46, 14);
		getContentPane().add(lblStatus);

		textStatus = new JTextField();
		textStatus.setEnabled(false);
		textStatus.setEditable(false);
		textStatus.setBounds(472, 174, 137, 20);
		getContentPane().add(textStatus);
		textStatus.setColumns(10);

		player.setStatus();
		
		setVisible(true);
		try {
			setIconImage(ImageIO.read(new File("res/tictac.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		
		this.playerOne = player.isPlayerOne();
	}

	public void tie() {
		JOptionPane.showMessageDialog(this, "Houve empate!", "Tie",
				JOptionPane.INFORMATION_MESSAGE);
		restartGame();
	}

	public void showsWinner(char winner) {
		String winnerName = new String();
		if (winner == 'X') {
			xScore++;
			if (playerOne) {
				winnerName = this.name;
				txt_score_1.setText(xScore + "");
			} else {
				winnerName = this.opponentName;
				txt_score_2.setText(xScore + "");
			}
		} else if (winner == 'O') {
			oScore++;
			if (playerOne) {
				winnerName = this.opponentName;
				txt_score_2.setText(oScore + "");
			} else {
				winnerName = this.name;
				txt_score_1.setText(oScore + "");
			}
		}
		JOptionPane.showMessageDialog(this, winnerName + " ganhou!",
				"Fim de jogo", JOptionPane.INFORMATION_MESSAGE);
		restartGame();
	}
	
	public void restartGame() {
		button1.setText("");
		button2.setText("");
		button3.setText("");
		button4.setText("");
		button5.setText("");
		button6.setText("");
		button7.setText("");
		button8.setText("");
		button9.setText("");
		player.inicializaMatriz();
		player.startArray();
	}
	
	public void setOpponentName(String newOpponentName){
		opponentName = newOpponentName;
	}
}
