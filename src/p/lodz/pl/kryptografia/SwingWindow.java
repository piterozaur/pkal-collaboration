package p.lodz.pl.kryptografia;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import p.lodz.pl.kryptografia.data_encryption_algorithms.TripleDESLogic;

import java.awt.Component;
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
	private JButton btnGenerujKlucz;
	private JButton btnEncrypt;
	private JButton btnDeszyfruj;

	/**
	 * Create the application.
	 */
	public SwingWindow() {
		initialize();
		addActionListeners();
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
		
		btnGenerujKlucz = new JButton("Generuj klucz");
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
	
    
    //Getters and setters
	/**
	 * Get key text input value
	 * @return Input field value
	 */
	public String getKeyValue() {
		
		return textFieldKey.getText();
		
	}
	/**
	 * Set key text input value
	 */
	public void setKeyValue(String text) {
		
		textFieldKey.setText(text);
		
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

	public void addActionListeners() {
		
		btnGenerujKlucz.addActionListener(new myEventListener());
		btnEncrypt.addActionListener(new myEventListener());
		btnDeszyfruj.addActionListener(new myEventListener());
		
	}
	
	
	class myEventListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
				//System.out.print(e.getActionCommand());
			
				switch (e.getActionCommand()) {
				
					case "Generuj klucz":
						TripleDESLogic trippleDESLogic = new TripleDESLogic(); 
						setKeyValue( trippleDESLogic.generateKey() );
			    	break;
			    	
					case "Szyfruj":
						//TripleDESLogic trippleDESLogic = new TripleDESLogic(); 
						//setKeyValue( trippleDESLogic.generateKey() );
			    	break;
		    	
				}
				
		}
		
	}
	
	
}
