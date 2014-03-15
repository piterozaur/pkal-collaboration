package p.lodz.pl.kryptografia;

import javax.swing.*;
import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingWindow extends JFrame {

	JFrame frame;
	protected JTextField textField;
	protected JTextPane txtpnTuWpiszTekst;
	protected JTextPane txtpnMiejsceNaKryptogram;
	public static TrippleDESLogic trippleDesLogic;

	/**
	 * Create the application.
	 */
	public SwingWindow() {
		initialize();
		
		trippleDesLogic = new TrippleDESLogic();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		final JPanel panel = new JPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(510,470);
		getContentPane().setLayout(null);
		
		JLabel lblKlucz = new JLabel("Klucz");
		lblKlucz.setBounds(26, 32, 70, 15);
		getContentPane().add(lblKlucz);
		
		JLabel lblSzyfrowanieDeszyfrowanie = new JLabel("Szyfrowanie / Deszyfrowanie");
		lblSzyfrowanieDeszyfrowanie.setBounds(26, 156, 314, 15);
		getContentPane().add(lblSzyfrowanieDeszyfrowanie);
		
		textField = new JTextField();
		textField.setBounds(26, 59, 270, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnGenerujKlucz = new JButton("Generuj klucz");
		btnGenerujKlucz.setBounds(318, 57, 154, 25);
		getContentPane().add(btnGenerujKlucz);
		btnGenerujKlucz.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				TrippleDESLogic.generateRandomKeyValue();
				
			}
		});
		
		txtpnTuWpiszTekst = new JTextPane();
		txtpnTuWpiszTekst.setText("Miejsce na tekst jawny");
		txtpnTuWpiszTekst.setBounds(26, 181, 446, 87);
		getContentPane().add(txtpnTuWpiszTekst);
		
		JButton btnSzyfruj = new JButton("Szyfruj");
		btnSzyfruj.setBounds(26, 280, 214, 25);
		getContentPane().add(btnSzyfruj);
		
		JButton btnDeszyfruj = new JButton("Deszyfruj");
		btnDeszyfruj.setBounds(258, 280, 214, 25);
		getContentPane().add(btnDeszyfruj);
		
		txtpnMiejsceNaKryptogram = new JTextPane();
		txtpnMiejsceNaKryptogram.setText("Miejsce na kryptogram");
		txtpnMiejsceNaKryptogram.setBounds(26, 317, 446, 87);
		getContentPane().add(txtpnMiejsceNaKryptogram);

		
	}
	
	/**
	 * Get key text input value
	 * @return Input field value
	 */
	public String getKeyValue() {
		
		return textField.getText();
		
	}
	/**
	 * Set key text input value
	 */
	public void setKeyValue(String text) {
		
		textField.setText(text);
		
	}
	
	/**
	 * Get encrypted text input value
	 * @return Encrypted input pane value
	 */
	public String getEncryptedText() {
		
		return txtpnTuWpiszTekst.getText();
		
	}
	/**
	 * Set encrypted text input value
	 */
	public void setEncryptedText(String text) {
		
		txtpnTuWpiszTekst.setText(text);
		
	}
	
	/**
	 * Get decrypted text input value
	 * @return Decrypted input pane value
	 */
	public String getDecryptedText() {
		
		return txtpnMiejsceNaKryptogram.getText();
	
	}
	/**
	 * Set decrypted text input value
	 */
	public void setDecryptedText(String text) {
		
		txtpnMiejsceNaKryptogram.setText(text);
		
	}
	

}
