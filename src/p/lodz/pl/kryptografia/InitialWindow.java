package p.lodz.pl.kryptografia;

import javax.swing.*;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
 
/**
 * SwingWindow class initializes Swing components, is responsible for view interaction and event listeners.
 * 
 * @author Piotr Kluch 165436
 *
 */
public class InitialWindow extends JFrame {

	/**
	 * Variables
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	protected JButton btnTripleDES;
	protected JButton btnBlumMicali;
	protected JButton btnCertificateDSA;

	/**
	 * Create the application.
	 */
	public InitialWindow() {
		setTitle("Podstawy Kryptografii - Zestaw V [Piotr Kluch, Andrzej Lisowski]");
		initialize();
		//addActionListeners();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Defaults
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(635,305);
		this.setLocation(200,200);
		getContentPane().setLayout(null);
		
		//Initial GUI starts here
		JLabel lblKlucz = new JLabel("Wybierz czynność do wykonania w programie:");
		lblKlucz.setBounds(26, 24, 362, 15);
		getContentPane().add(lblKlucz);
		
		btnTripleDES = new JButton("Szyfrowanie i deszyfrowanie algorytmem symetrycznym Triple DES");
		btnTripleDES.setBounds(26, 51, 583, 49);
		getContentPane().add(btnTripleDES);
		
		btnBlumMicali = new JButton("Szyfrowanie i deszyfrowanie algorytmen z generatorem Blum-Micali");
		btnBlumMicali.setBounds(26, 112, 583, 49);
		getContentPane().add(btnBlumMicali);
		
		btnCertificateDSA = new JButton("Generowanie i sprawdzanie podpisu cyfrowyego przy użyciu algorytmu DSA ");
		btnCertificateDSA.setBounds(26, 173, 583, 49);
		getContentPane().add(btnCertificateDSA);
		
		
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
		
		JMenu about = new JMenu("Help");
		menuBar.add(about);

		//Inline listener for about action.
		about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
        });
		
	}
}
