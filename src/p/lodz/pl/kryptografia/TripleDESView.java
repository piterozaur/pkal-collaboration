package p.lodz.pl.kryptografia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

/**
 * TripleDESView class is the JDialog extension that is built for adding new events view.
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
		JLabel lblKlucz = new JLabel("Wybierz czynność do wykonania w programie:");
		lblKlucz.setBounds(26, 24, 362, 15);
		getContentPane().add(lblKlucz);
		
		key1 = new JTextField();
		key1.setBounds(26, 51, 362, 29);
		getContentPane().add(key1);
		key1.setColumns(10);
		
		key2 = new JTextField();
		key2.setColumns(10);
		key2.setBounds(26, 92, 362, 29);
		getContentPane().add(key2);
		
		key3 = new JTextField();
		key3.setColumns(10);
		key3.setBounds(26, 133, 362, 29);
		getContentPane().add(key3);
		
		btnGenerateKeys = new JButton("Generuj klucze");
		btnGenerateKeys.setBounds(26, 178, 230, 25);
		getContentPane().add(btnGenerateKeys);
		
	}
	

}