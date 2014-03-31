package p.lodz.pl.kryptografia.data_encryption_algorithms;
import p.lodz.pl.kryptografia.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import javax.swing.*;

public class SignatureRSALogic implements ActionListener {
	
	protected SignatureRSAView theView;
	
	
	/**
	 * Constructor
	 */
	public SignatureRSALogic() {
		
		//Create the view
    	theView = new SignatureRSAView();
		
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
		
		theView.btnOpenKeys.addActionListener(this);
		theView.btnSaveKeys.addActionListener(this);
		
		theView.btnReadPlaintextFile.addActionListener(this);
		theView.btnReadCiphertextFile.addActionListener(this);
		theView.btnWritePlaintextFile.addActionListener(this);
		theView.btnWriteCiphertextFile.addActionListener(this);

	}
	
	
	
	/**
	 * All actions performed on button click, etc...
	 */
    public void actionPerformed(ActionEvent event){
    	
    	//Generate keys
        if ( event.getSource() == theView.btnGenerateKeys ) {
            
        	setKeys(generateKey_1(), generateKey_2(), generateKey_3(), generateKey_4());
        	
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
        	text = "IT SHOULD BE DECRYPTED NOW.";
        	
        	//Set ciphertext
        	setPlaintextTextarea ( text );

        }
        
        if ( event.getSource() == theView.btnOpenKeys ) {
        	
        	//New FileChooser open
        	FileChooser fc = new FileChooser();
        	String returnValue[] = fc.openDialogKeys();
        	//System.out.print(returnValue[0]);
        	
        	//Assign keys
        	setKeys(returnValue[0], returnValue[1], returnValue[2], returnValue[3]);
        	
        }
        
        if ( event.getSource() == theView.btnSaveKeys ) {
        	
        	//Get keys
        	String saveBuffer = theView.key1_q_and_g.getText() + '\n' + theView.key2_y.getText() + '\n' + theView.key3_x.getText() + '\n' + theView.key4_mod_p.getText();
        	
        	//New FileChooser save
        	FileChooser fc = new FileChooser();
        	fc.saveDialogKeys(saveBuffer.getBytes());
        	
        }
        
        if ( event.getSource() == theView.btnReadPlaintextFile ) {
        	
        	//Choose file
        	FileChooser fc = new FileChooser();
        	String returnValue = fc.openDialog();
        	
        	//Set textarea
        	setPlaintextTextarea(returnValue);
        	
        }
        
        
        if ( event.getSource() == theView.btnReadCiphertextFile ) {
        	
        	//Choose file
        	FileChooser fc = new FileChooser();
        	String returnValue = fc.openDialog();
        	
        	//Set textarea
        	setCiphertextTextarea(returnValue);
        	
        }

        if ( event.getSource() == theView.btnWritePlaintextFile ) {
        	
        	//Get textarea
        	String saveBuffer = getPlaintextTextarea();
        	
        	//Write to file
        	FileChooser fc = new FileChooser();
        	fc.saveDialogKeys(saveBuffer.getBytes());        	
        }
        
        if ( event.getSource() == theView.btnWriteCiphertextFile ) {
        	
        	//Get textarea
        	String saveBuffer = getCiphertextTextarea();
        	
        	//Write to file
        	FileChooser fc = new FileChooser();
        	fc.saveDialogKeys(saveBuffer.getBytes());        	
        }
        
    }

	
	/**
	 * All getters and setters for current view components
	 */
	public void setKeys(String value_1, String value_2, String value_3, String value_4) {
		theView.key1_q_and_g.setText( value_1 );		
		theView.key2_y.setText( value_2 );		
		theView.key3_x.setText( value_3 );	
		theView.key4_mod_p.setText( value_4 );	
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
	public String generateKey_4() {

		return "ABC";
		
	}
	
	
	
}
