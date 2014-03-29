package p.lodz.pl.kryptografia;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Window;

/**
 * TripleDESView class is the JFrame window for this view
 * 
 */
public class TripleDESView extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JTextField key1;
	public JTextField key2;
	public JTextField key3;
	public JButton btnGenerateKeys;
	
	public JTextArea txtrPlaintext;
	public JTextArea txtrCiphertext;
	public JButton btnEncrypt;
	public JButton btnDecrypt;

	public JButton btnOpenKeys;
	public JButton btnSaveKeys;

	public JButton btnReadPlaintextFile;
	public JButton btnWritePlaintextFile;
	public JButton btnReadCiphertextFile;
	public JButton btnWriteCiphertextFile;
	
	public TripleDESView() {
		
		setTitle("Szyfrowanie i deszyfrowanie algorytmem symetrycznym Triple DES");
		
		//Defaults
    	//Initialize JFrame
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(635,370);
    	this.setLocation(200,200);
    	this.setVisible(true);
		getContentPane().setLayout(null);
		
		//Initial GUI starts here
		JLabel lblKlucz = new JLabel("Klucze 1, 2 i 3:");
		lblKlucz.setBounds(23, 51, 135, 15);
		getContentPane().add(lblKlucz);
		
		key1 = new JTextField();
		key1.setBounds(20, 78, 159, 29);
		getContentPane().add(key1);
		key1.setColumns(10);
		
		key2 = new JTextField();
		key2.setColumns(10);
		key2.setBounds(20, 119, 159, 29);
		getContentPane().add(key2);
		
		key3 = new JTextField();
		key3.setColumns(10);
		key3.setBounds(20, 160, 159, 29);
		getContentPane().add(key3);
		
		btnGenerateKeys = new JButton("Generuj klucze");
		btnGenerateKeys.setBounds(23, 211, 159, 25);
		getContentPane().add(btnGenerateKeys);
		
		txtrPlaintext = new JTextArea();
		txtrPlaintext.setText("Miejsce na tekst jawny");
		txtrPlaintext.setBounds(218, 51, 187, 148);
		getContentPane().add(txtrPlaintext);
		
		txtrCiphertext = new JTextArea();
		txtrCiphertext.setText("Miejsce na szyfrogram");
		txtrCiphertext.setBounds(428, 51, 188, 148);
		getContentPane().add(txtrCiphertext);
		
		btnEncrypt = new JButton("Szyfruj ->");
		btnEncrypt.setBounds(218, 211, 187, 25);
		getContentPane().add(btnEncrypt);
		
		btnDecrypt = new JButton("<- Deszyfruj");
		btnDecrypt.setBounds(428, 211, 188, 25);
		getContentPane().add(btnDecrypt);
		
		btnOpenKeys = new JButton("Wczytaj klucze");
		btnOpenKeys.setBounds(23, 248, 159, 25);
		getContentPane().add(btnOpenKeys);
		
		btnSaveKeys = new JButton("Zapisz klucze");
		btnSaveKeys.setBounds(23, 273, 159, 25);
		getContentPane().add(btnSaveKeys);
		
		btnReadPlaintextFile = new JButton("Wczytaj plik jawny");
		btnReadPlaintextFile.setBounds(218, 248, 187, 25);
		getContentPane().add(btnReadPlaintextFile);
		
		btnWritePlaintextFile = new JButton("Zapisz plik jawny");
		btnWritePlaintextFile.setBounds(218, 273, 187, 25);
		getContentPane().add(btnWritePlaintextFile);
		
		btnReadCiphertextFile = new JButton("Wczytaj plik szyfrowany");
		btnReadCiphertextFile.setBounds(428, 248, 188, 25);
		getContentPane().add(btnReadCiphertextFile);
		
		btnWriteCiphertextFile = new JButton("Zapisz plik szyfrowany");
		btnWriteCiphertextFile.setBounds(428, 273, 188, 25);
		getContentPane().add(btnWriteCiphertextFile);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(0, 35, 196, 273);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setBounds(196, 35, 439, 273);
		getContentPane().add(panel_1);
		

		
	}
}