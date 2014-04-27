package p.lodz.pl.kryptografia.data_encryption_algorithms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.log4j.Logger;

import p.lodz.pl.kryptografia.FileChooser;
import p.lodz.pl.kryptografia.TripleDESView;
import p.lodz.pl.kryptografia.data_encryption_algorithms.triple_des.DesException;
import p.lodz.pl.kryptografia.data_encryption_algorithms.triple_des.TripleDes;

/**
 * Triple DES logic.
 * 
 * @author <a href="mailto:165436@edu.p.lodz.pl">Piotr Kluch</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 *
 */
public class TripleDESLogic implements ActionListener {

	protected TripleDESView theView;
	private TripleDes tripleDes = new TripleDes();

    public byte[] plainTextBytes;
    public byte[] cipherTextBytes;
	
	private static final Logger LOG = Logger.getLogger(TripleDESLogic.class);

	/**
	 * Constructor
	 */
	public TripleDESLogic() {

		// Create the view
		theView = new TripleDESView();

		// Add action listeners to the view
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
	public void actionPerformed(ActionEvent event) {
		
		// Generate keys
		if (event.getSource() == theView.btnGenerateKeys) {
			setKeys(generateKey_1(), generateKey_2(), generateKey_3());
		}

		// Encode
		if (event.getSource() == theView.btnEncrypt) {
			getKeys();
			String text = new String(getPlaintextTextarea()); //TODO This should be done differently.
			String encodedResult="";
			try {
				encodedResult = tripleDes.tripleDesEncode(text);
			} catch (DesException e) {
				LOG.error("An exception occured",e );
			}
			setCiphertextTextarea(encodedResult);
		}

		// Decode
		if (event.getSource() == theView.btnDecrypt) {
			getKeys();
			String text = new String(getCiphertextTextarea()); //TODO This should be done differently. #2
			String decodedResult = "";
			try {
				decodedResult = tripleDes.tripleDesDecode(text);
			} catch (DesException e) {
				LOG.error("An exception occured",e );
			} 
			setPlaintextTextarea(decodedResult);
		}

		if (event.getSource() == theView.btnOpenKeys) {
			// New FileChooser open
			FileChooser fc = new FileChooser();
			String returnValue[] = fc.openDialogKeys();
			// System.out.print(returnValue[0]);

			// Assign keys
			setKeys(returnValue[0], returnValue[1], returnValue[2]);

		}

		if (event.getSource() == theView.btnSaveKeys) {
			// Get keys
			String saveBuffer = theView.key1.getText() + '\n'
							  + theView.key2.getText() + '\n'
							  + theView.key3.getText();

			// New FileChooser save
			FileChooser fc = new FileChooser();
			fc.saveDialogKeys(saveBuffer.getBytes());
		}

		if (event.getSource() == theView.btnReadPlaintextFile) {
			// Choose file
			FileChooser fc = new FileChooser();
			byte[] returnValue = fc.openDialog();
			
			this.plainTextBytes = returnValue;

			// Set textarea
			setPlaintextTextarea(new String(returnValue));
		}

		if (event.getSource() == theView.btnReadCiphertextFile) {
			// Choose file
			FileChooser fc = new FileChooser();
			byte[] returnValue = fc.openDialog();

			this.cipherTextBytes = returnValue;
			
			// Set textarea
			setCiphertextTextarea(new String(returnValue));
		}

		if (event.getSource() == theView.btnWritePlaintextFile) {
			// Get texture
			byte[] saveBuffer = this.plainTextBytes;

			// Write to file
			FileChooser fc = new FileChooser();
			fc.saveDialog(this.plainTextBytes);
		}

		if (event.getSource() == theView.btnWriteCiphertextFile) {
			// Get textarea
			byte[] saveBuffer = this.cipherTextBytes;

			// Write to file
			FileChooser fc = new FileChooser();
			fc.saveDialog(saveBuffer);
		}

	}

	/**
	 * All getters and setters for current view components
	 */
	public void setKeys(String value_1, String value_2, String value_3) {
		theView.key1.setText(value_1);
		theView.key2.setText(value_2);
		theView.key3.setText(value_3);
		tripleDes.setKeys(value_1, value_2, value_3);
	}
	
	public void getKeys(){
		String key1 = theView.key1.getText();
		String key2 = theView.key2.getText();
		String key3 = theView.key3.getText();
		tripleDes.setKeys(key1, key2, key3);
	}

	private void setCiphertextTextarea(String string) {
		theView.txtrCiphertext.setText(string);
		//this.cipherTextBytes = string.getBytes();
	}

	private byte[] getCiphertextTextarea() {
		//return theView.txtrCiphertext.getText();
		return cipherTextBytes;
	}

	private void setPlaintextTextarea(String string) {
		theView.txtrPlaintext.setText(string);
		//this.plainTextBytes = string.getBytes();
	}

	private byte[] getPlaintextTextarea() {
		//return theView.txtrPlaintext.getText();
		return plainTextBytes;
	}

	/**
	 * Generate 3 keys
	 * 
	 * @return key value
	 */
	public String generateKey_1() {
		//TODO: key generator
		return "0123456789ABCDEF";
	}

	public String generateKey_2() {
		//TODO: key generator
		return "1133557799BBDDFF";
	}

	public String generateKey_3() {
		//TODO: key generator
		return "0022446688AACCEE";
	}

}
