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
	
	private JButton btnAddEvent;
	
	public boolean saveData = false;
	
	public JTextField textField;
	public JTextArea textArea;
	
	public JCheckBox chckbxAlertMeOn; 
	
	public TripleDESView() {
		setTitle("TripleDES");
		
		//Defaults
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(635,505);
    	this.setLocation(200,200);
    	this.setVisible(true);	
		getContentPane().setLayout(null);
		
		//Initial GUI starts here
		JLabel lblKlucz = new JLabel("Wybierz czynność do wykonania w programie:");
		lblKlucz.setBounds(26, 24, 362, 15);
		getContentPane().add(lblKlucz);
	}
	
	public String getEventLocation() {
		
		return textField.getText();
		
	}
	
	public String getEventDescription() {
		
		return textArea.getText();
		
	}
	


	public int getEventAlert() {
		
		boolean chckboxVal = chckbxAlertMeOn.isSelected();
		return chckboxVal ? 1 : 0;
		
	}
	
}