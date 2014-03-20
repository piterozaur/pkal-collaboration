package p.lodz.pl.kryptografia;

import javax.swing.*;
import p.lodz.pl.kryptografia.data_encryption_algorithms.TripleDESLogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
 
/**
 * SwingWindow class initializes Swing components, is responsible for view interaction and event listeners.
 * 
 * @author Piotr Kluch 165436
 *
 */
public class SwingWindow extends JFrame {

	/**
	 * Variables
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	protected JTextField textFieldKey;
	protected JTextPane txtpnTuWpiszTekst;
	protected JTextPane txtpnMiejsceNaKryptogram;
	protected JButton btnGenerujKlucz;
	private JButton btnEncrypt;
	private JButton btnDeszyfruj;

	/**
	 * Create the application.
	 */
	public SwingWindow() {
		initialize();
		//addActionListeners();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Defaults
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,490);
		getContentPane().setLayout(null);
		
		//Real GUI starts here
		JLabel lblKlucz = new JLabel("Klucz");
		lblKlucz.setBounds(26, 32, 70, 15);
		getContentPane().add(lblKlucz);
		
		JLabel lblSzyfrowanieDeszyfrowanie = new JLabel("Szyfrowanie / Deszyfrowanie");
		lblSzyfrowanieDeszyfrowanie.setBounds(26, 156, 314, 15);
		getContentPane().add(lblSzyfrowanieDeszyfrowanie);
		
		textFieldKey = new JTextField();
		textFieldKey.setBounds(26, 59, 270, 22);
		getContentPane().add(textFieldKey);
		textFieldKey.setColumns(10);
		
		btnGenerujKlucz = new JButton("Generuj klucze");
		btnGenerujKlucz.setBounds(318, 57, 154, 25);
		getContentPane().add(btnGenerujKlucz);
		
		txtpnTuWpiszTekst = new JTextPane();
		txtpnTuWpiszTekst.setText("Miejsce na tekst jawny");
		txtpnTuWpiszTekst.setBounds(26, 181, 446, 87);
		getContentPane().add(txtpnTuWpiszTekst);
		
		btnEncrypt = new JButton("Szyfruj");
		btnEncrypt.setBounds(26, 280, 214, 25);
		getContentPane().add(btnEncrypt);
		
		btnDeszyfruj = new JButton("Deszyfruj");
		btnDeszyfruj.setBounds(258, 280, 214, 25);
		getContentPane().add(btnDeszyfruj);
		
		txtpnMiejsceNaKryptogram = new JTextPane();
		txtpnMiejsceNaKryptogram.setText("Miejsce na kryptogram");
		txtpnMiejsceNaKryptogram.setBounds(26, 317, 446, 87);
		getContentPane().add(txtpnMiejsceNaKryptogram);
		
		
		//Menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mntmFile = new JMenu("File");
		menuBar.add(mntmFile);
		
		JMenuItem quit = new JMenuItem("Quit");
		mntmFile.add(quit);
		
		//Inline listener for quit action.
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
        });


		
	}
	
    

	

	
	
}
