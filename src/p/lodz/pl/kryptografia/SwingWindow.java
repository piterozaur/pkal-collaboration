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
		this.setSize(490,305);
		getContentPane().setLayout(null);
		
		//Real GUI starts here
		JLabel lblKlucz = new JLabel("Wybierz czynność do wykonania w programie:");
		lblKlucz.setBounds(26, 24, 362, 15);
		getContentPane().add(lblKlucz);
		
		JButton btnAlgorytmSymetrycznyTriple = new JButton("Algorytm symetryczny Triple DES");
		btnAlgorytmSymetrycznyTriple.setBounds(26, 51, 436, 49);
		getContentPane().add(btnAlgorytmSymetrycznyTriple);
		
		JButton btnAlgorytmZGeneratorem = new JButton("Algorytm z generatorem Blum-Micali");
		btnAlgorytmZGeneratorem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAlgorytmZGeneratorem.setBounds(26, 112, 436, 49);
		getContentPane().add(btnAlgorytmZGeneratorem);
		
		JButton btnPodpisCyfrowyZ = new JButton("Podpis cyfrowy przy użyciu algorytmu DSA ");
		btnPodpisCyfrowyZ.setBounds(26, 173, 436, 49);
		getContentPane().add(btnPodpisCyfrowyZ);
		
		
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
