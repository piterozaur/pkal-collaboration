package p.lodz.pl.kryptografia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import p.lodz.pl.kryptografia.data_encryption_algorithms.TripleDESLogic;

public class ViewController extends SwingWindow implements ActionListener {
	
	TripleDESLogic tripleDESLogic = new TripleDESLogic(); 
	
	public ViewController() {
		
		addActionListeners();
		
	}
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		//Getters and setters

		
		 
		
		//Add listeners. This calss implements listeners.
		public void addActionListeners() {
			
			//btnGenerujKlucz.addActionListener(this);
			//btnEncrypt.addActionListener(new myEventListener());
			//btnDeszyfruj.addActionListener(new myEventListener());
			
		}
		
		
	    public void actionPerformed(ActionEvent event){
	    	/*
	        if(event.getSource() == btnGenerujKlucz){
	        	setKeyValue("hegfghghgfhgfhghy");
	        	System.out.print("Test");
	        }
*/
	    }
		
	
}
