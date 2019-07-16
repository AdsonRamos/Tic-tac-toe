package tictac.game;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textAddress;
	private JTextField textPort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		super("Login");
		
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e){
			
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(360, 480));
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(41, 70, 46, 14);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(97, 69, 206, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblIp = new JLabel("IP:");
		lblIp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIp.setBounds(41, 131, 46, 14);
		contentPane.add(lblIp);
		
		textAddress = new JTextField();
		textAddress.setBounds(97, 130, 206, 20);
		contentPane.add(textAddress);
		textAddress.setColumns(10);
		
		JLabel lblPorta = new JLabel("Porta:");
		lblPorta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPorta.setBounds(41, 188, 46, 14);
		contentPane.add(lblPorta);
		
		textPort = new JTextField();
		textPort.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					new TicTac(textNome.getText(), textAddress.getText(), Integer.parseInt(textPort.getText()));
					dispose();
				}
			}
		});
		textPort.setBounds(97, 187, 86, 20);
		contentPane.add(textPort);
		textPort.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TicTac(textNome.getText(), textAddress.getText(), Integer.parseInt(textPort.getText()));
				dispose();
			}
		});
		btnLogin.setBounds(127, 364, 89, 23);
		contentPane.add(btnLogin);
		
	}

}
