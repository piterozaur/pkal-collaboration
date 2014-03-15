package p.lodz.pl.kryptografia;

import javax.swing.*;
import java.awt.BorderLayout;

public class SwingWindow extends JFrame {

	JFrame frame;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public SwingWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		final JPanel panel = new JPanel();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		
		JTextPane txtpnTuWpiszTekst = new JTextPane();
		txtpnTuWpiszTekst.setText("Miejsce na tekst jawny");
		txtpnTuWpiszTekst.setBounds(26, 181, 446, 87);
		getContentPane().add(txtpnTuWpiszTekst);
		
		JButton btnSzyfruj = new JButton("Szyfruj");
		btnSzyfruj.setBounds(26, 280, 214, 25);
		getContentPane().add(btnSzyfruj);
		
		JButton btnDeszyfruj = new JButton("Deszyfruj");
		btnDeszyfruj.setBounds(258, 280, 214, 25);
		getContentPane().add(btnDeszyfruj);
		
		JTextPane txtpnMiejsceNaKryptogram = new JTextPane();
		txtpnMiejsceNaKryptogram.setText("Miejsce na kryptogram");
		txtpnMiejsceNaKryptogram.setBounds(26, 317, 446, 87);
		getContentPane().add(txtpnMiejsceNaKryptogram);
		
		

		
	}
}
