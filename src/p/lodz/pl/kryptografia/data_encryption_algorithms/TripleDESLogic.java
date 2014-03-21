package p.lodz.pl.kryptografia.data_encryption_algorithms;
import p.lodz.pl.kryptografia.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TripleDESLogic implements ActionListener {
	
	protected TripleDESView theView;
	
	
	
	/**
	 * Constructor
	 */
	public TripleDESLogic() {
		
		//Create the view
    	theView = new TripleDESView();
		
    	//Add action listeners to the view
    	addActionListeners();
    	
	}
	
	
	
	/**
	 * All action listeners for current view
	 */
	public void addActionListeners() {
		
		theView.btnGenerateKeys.addActionListener(this);
		theView.btnEncrypt.addActionListener(this);
		theView.btnDecrypt.addActionListener(this);

	}
	
	
	
	/**
	 * All actions performed on button click, etc...
	 */
    public void actionPerformed(ActionEvent event){
    	
    	//Generate keys
        if ( event.getSource() == theView.btnGenerateKeys ) {
            
        	setKeys(generateKey_1(), generateKey_2(), generateKey_3());
        	
        }
    	
        //Encrypt
        if ( event.getSource() == theView.btnEncrypt ) {
        	
        	//Get plaintext
        	String text = getPlaintextTextarea();
        	
        	//TODO Magic happens here
        	text = "Wowwo,encrypted_result_value";
        	
        	//Set ciphertext
        	setCiphertextTextarea ( text );

        }
        
        //Decrypt
        if ( event.getSource() == theView.btnDecrypt ) {
        	
        	//Get plaintext
        	String text = getCiphertextTextarea();
        	
        	//TODO Magic happens here
        	text = "IT SHOULD BE ENCRYPTED NOW.";
        	
        	//Set ciphertext
        	setPlaintextTextarea ( text );

        }

    }

	
	/**
	 * All getters and setters for current view components
	 */
	public void setKeys(String value_1, String value_2, String value_3) {
		theView.key1.setText( value_1 );		
		theView.key2.setText( value_2 );		
		theView.key3.setText( value_3 );	
	}
	private void setCiphertextTextarea(String string) {
		theView.txtrCiphertext.setText(string);
	}
	private String getCiphertextTextarea() {
		return theView.txtrCiphertext.getText();
	}
	private void setPlaintextTextarea(String string) {
		theView.txtrPlaintext.setText(string);
	}
	private String getPlaintextTextarea() {
		return theView.txtrPlaintext.getText();
	}
	
	
	/**
	 * Generate 3 keys
	 * @return key value
	 */
	public String generateKey_1() {

		return "0123456789ABCDEF";
		
	}
	public String generateKey_2() {

		return "1133557799BBDDFF";
		
	}
	public String generateKey_3() {

		return "0022446688AACCEE";
		
	}
	
	
	
}
