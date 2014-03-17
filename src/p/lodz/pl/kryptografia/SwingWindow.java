package p.lodz.pl.kryptografia;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	protected JTextField textFieldKey;
	protected JTextPane txtpnTuWpiszTekst;
	protected JTextPane txtpnMiejsceNaKryptogram;

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
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,470);
		getContentPane().setLayout(null);
		
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
		
		JButton btnGenerujKlucz = new JButton("Generuj klucz");
		btnGenerujKlucz.setBounds(318, 57, 154, 25);
		getContentPane().add(btnGenerujKlucz);
		btnGenerujKlucz.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            btnCallbackActionPerformed(evt);
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
		
		
		//New
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 357, 674, 141);
		panel.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel(); 
		JTable table = new JTable(model);
		scrollPane.setViewportView(table);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mntmFile = new JMenu("File");
		menuBar.add(mntmFile);
		
		JMenuItem quit = new JMenuItem("Quit");
		mntmFile.add(quit);
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
        });

		
	}
	
    private void btnCallbackActionPerformed(ActionEvent evt) {
    	
    	System.out.print(evt.getSource());
    	
    	TrippleDESLogic trippleDESLogic = new TrippleDESLogic(); 
    	this.setKeyValue( trippleDESLogic.generateKeyEvent() );
        
    }
    
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
	

    public void actionPerformed(ActionEvent e) {
        System.out.print(e.getSource());
    }  
	

}
