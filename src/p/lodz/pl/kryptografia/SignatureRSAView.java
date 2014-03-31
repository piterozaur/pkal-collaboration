package p.lodz.pl.kryptografia;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Window;

/**
 * TripleDESView class is the JFrame window for this view
 * 
 */
public class SignatureRSAView extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JTextField key1_q_and_g;
	public JTextField key2_y;
	public JTextField key3_x;
	public JTextField key4_mod_p;

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
	private JLabel lblKluczPublicznyY;

	
	public SignatureRSAView() {
		
		setTitle("Szyfrowanie i deszyfrowanie algorytmem symetrycznym Triple DES");
		
		//Defaults
    	//Initialize JFrame
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(844,408);
    	this.setLocation(200,200);
    	this.setVisible(true);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(0, 0, 376, 382);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblKluczPrywatnyX = new JLabel("Klucz prywatny: x");
		lblKluczPrywatnyX.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKluczPrywatnyX.setBounds(-15, 137, 169, 15);
		panel.add(lblKluczPrywatnyX);
		
		JLabel lblModP = new JLabel("MOD p");
		lblModP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModP.setBounds(-15, 183, 169, 15);
		panel.add(lblModP);
		
		key1_q_and_g = new JTextField();
		key1_q_and_g.setBounds(172, 50, 172, 25);
		panel.add(key1_q_and_g);
		key1_q_and_g.setColumns(10);
		
		key2_y = new JTextField();
		key2_y.setBounds(172, 87, 172, 25);
		panel.add(key2_y);
		key2_y.setColumns(10);
		
		key3_x = new JTextField();
		key3_x.setBounds(172, 132, 172, 25);
		panel.add(key3_x);
		key3_x.setColumns(10);
		
		key4_mod_p = new JTextField();
		key4_mod_p.setBounds(172, 179, 172, 23);
		panel.add(key4_mod_p);
		key4_mod_p.setColumns(10);
		
		btnGenerateKeys = new JButton("Generuj klucze");
		btnGenerateKeys.setBounds(172, 214, 172, 25);
		panel.add(btnGenerateKeys);
		
		btnOpenKeys = new JButton("Wczytaj klucze");
		btnOpenKeys.setBounds(172, 268, 172, 25);
		panel.add(btnOpenKeys);
		
		btnSaveKeys = new JButton("Zapisz klucze");
		btnSaveKeys.setBounds(172, 305, 172, 25);
		panel.add(btnSaveKeys);
		
		//Initial GUI starts here
		JLabel lblKlucz = new JLabel("q oraz g");
		lblKlucz.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKlucz.setBounds(-15, 55, 169, 15);
		panel.add(lblKlucz);

		
		lblKluczPublicznyY = new JLabel("Klucz publiczny: y");
		lblKluczPublicznyY.setBounds(-15, 96, 169, 15);
		panel.add(lblKluczPublicznyY);
		lblKluczPublicznyY.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setBounds(376, -12, 468, 382);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel middlePanel = new JPanel ();
		middlePanel.setForeground(Color.WHITE);
		middlePanel.setBounds(29, 63, 190, 148);
		panel_1.add(middlePanel);
		middlePanel.setBorder ( new TitledBorder ( new EtchedBorder (), "Tekst jawny" ) );
		// create the middle panel components
		txtrPlaintext = new JTextArea (7, 15);
		txtrPlaintext.setText("Miejsce na tekst jawny");
		txtrPlaintext.setBounds(218, 51, 187, 148);
		JScrollPane scroll = new JScrollPane ( txtrPlaintext );
		scroll.setBounds(218, 51, 187, 148);
		scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		scroll.setHorizontalScrollBarPolicy ( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS );
		middlePanel.add ( scroll );
		
		
		JPanel middlePanel2 = new JPanel ();
		middlePanel2.setBounds(244, 63, 190, 148);
		panel_1.add(middlePanel2);
		middlePanel2.setBorder ( new TitledBorder ( new EtchedBorder (), "Szyfrogram" ) );
		// create the middle panel components
		txtrCiphertext = new JTextArea(7, 15);
		txtrCiphertext.setText("Miejsce na szyfrogram");
		txtrCiphertext.setBounds(428, 51, 188, 148);
		JScrollPane scroll2 = new JScrollPane ( txtrCiphertext );
		scroll2.setBounds(428, 51, 188, 148);
		scroll2.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		scroll2.setHorizontalScrollBarPolicy ( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS );
		middlePanel2.add ( scroll2 );
		

		
		btnEncrypt = new JButton("Szyfruj ->");
		btnEncrypt.setBounds(29, 223, 190, 25);
		panel_1.add(btnEncrypt);
		
		btnDecrypt = new JButton("<- Deszyfruj");
		btnDecrypt.setBounds(244, 223, 190, 25);
		panel_1.add(btnDecrypt);
		
		btnReadPlaintextFile = new JButton("Wczytaj plik jawny");
		btnReadPlaintextFile.setBounds(29, 269, 190, 25);
		panel_1.add(btnReadPlaintextFile);
		
		btnWritePlaintextFile = new JButton("Zapisz plik jawny");
		btnWritePlaintextFile.setBounds(29, 306, 190, 25);
		panel_1.add(btnWritePlaintextFile);
		
		btnReadCiphertextFile = new JButton("Wczytaj plik szyfrowany");
		btnReadCiphertextFile.setBounds(243, 269, 191, 25);
		panel_1.add(btnReadCiphertextFile);
		
		btnWriteCiphertextFile = new JButton("Zapisz plik szyfrowany");
		btnWriteCiphertextFile.setBounds(243, 306, 191, 25);
		panel_1.add(btnWriteCiphertextFile);
		

		
	}
}