package p.lodz.pl.kryptografia.data_encryption_algorithms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import p.lodz.pl.kryptografia.TripleDESView;


public class TripleDESLogic implements ActionListener {
	
	protected TripleDESView tripleDESView;
	
	public TripleDESLogic() {
		
		//Create the view
    	tripleDESView = new TripleDESView();
		
    	//Add action listeners to the view
    	addActionListeners();
    	
	}
	
	public void setKeys(String value_1, String value_2, String value_3) {
		
		tripleDESView.key1.setText( value_1 );		
		tripleDESView.key2.setText( value_2 );		
		tripleDESView.key3.setText( value_3 );
		
	}
	
	public void addActionListeners() {
		
		tripleDESView.btnGenerateKeys.addActionListener(this);
		
	}
	
    public void actionPerformed(ActionEvent event){
    	
        if (event.getSource() == tripleDESView.btnGenerateKeys) {
        	
        	setKeys(generateKey_1(), generateKey_1(), generateKey_1());

        	
        }

    }
	
	public String generateKey_1() {
		
		// TODO Need logic here
		
		String generatedHashKey = "ABCDEF";
		
		return generatedHashKey;
		
	}
	
}
