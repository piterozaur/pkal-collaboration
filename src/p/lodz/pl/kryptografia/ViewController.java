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
		
		 
		
		//Add listeners. This calss implements listeners.
		public void addActionListeners() {
			
			btnGenerujKlucz.addActionListener(this);
			//btnEncrypt.addActionListener(new myEventListener());
			//btnDeszyfruj.addActionListener(new myEventListener());
			
		}
		
		
	    public void actionPerformed(ActionEvent event){
	    	
	        if(event.getSource() == btnGenerujKlucz){
	        	setKeyValue("hegfghghgfhgfhghy");
	        	System.out.print("Test");
	        }

	    }
		
	
}
