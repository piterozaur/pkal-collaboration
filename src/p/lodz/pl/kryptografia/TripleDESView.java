package p.lodz.pl.kryptografia;

import javax.swing.*;

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
	
	public TripleDESView() {
		
		setTitle("Szyfrowanie i deszyfrowanie algorytmem symetrycznym Triple DES");
		
		//Defaults
    	//Initialize JFrame
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(635,505);
    	this.setLocation(200,200);
    	this.setVisible(true);
		getContentPane().setLayout(null);
		
		//Initial GUI starts here
		JLabel lblKlucz = new JLabel("Klucze 1, 2 i 3:");
		lblKlucz.setBounds(26, 24, 159, 15);
		getContentPane().add(lblKlucz);
		
		key1 = new JTextField();
		key1.setBounds(26, 51, 159, 29);
		getContentPane().add(key1);
		key1.setColumns(10);
		
		key2 = new JTextField();
		key2.setColumns(10);
		key2.setBounds(26, 92, 159, 29);
		getContentPane().add(key2);
		
		key3 = new JTextField();
		key3.setColumns(10);
		key3.setBounds(26, 133, 159, 29);
		getContentPane().add(key3);
		
		btnGenerateKeys = new JButton("Generuj klucze");
		btnGenerateKeys.setBounds(26, 174, 159, 25);
		getContentPane().add(btnGenerateKeys);
		
		txtrPlaintext = new JTextArea();
		txtrPlaintext.setText("Miejsce na tekst jawny");
		txtrPlaintext.setBounds(214, 51, 159, 148);
		getContentPane().add(txtrPlaintext);
		
		txtrCiphertext = new JTextArea();
		txtrCiphertext.setText("Miejsce na szyfrogram");
		txtrCiphertext.setBounds(397, 51, 159, 148);
		getContentPane().add(txtrCiphertext);
		
		btnEncrypt = new JButton("Szyfruj ->");
		btnEncrypt.setBounds(214, 211, 159, 25);
		getContentPane().add(btnEncrypt);
		
		btnDecrypt = new JButton("<- Deszyfruj");
		btnDecrypt.setBounds(397, 211, 159, 25);
		getContentPane().add(btnDecrypt);
		
	}
}