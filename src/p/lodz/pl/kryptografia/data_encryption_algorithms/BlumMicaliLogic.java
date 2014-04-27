package p.lodz.pl.kryptografia.data_encryption_algorithms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import p.lodz.pl.kryptografia.BlumMicaliView;
import p.lodz.pl.kryptografia.FileChooser;
import p.lodz.pl.kryptografia.data_encryption_algorithms.blum_micali.BlumMicali;
import p.lodz.pl.kryptografia.data_encryption_algorithms.triple_des.DesException;
import p.lodz.pl.kryptografia.data_encryption_algorithms.triple_des.TripleDes;

/**
 * Blue Micali logic.
 * 
 * @author <a href="mailto:165436@edu.p.lodz.pl">Piotr Kluch</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 *
 */
public class BlumMicaliLogic implements ActionListener {

    protected BlumMicaliView theView;
	private BlumMicali blumMicali = new BlumMicali();

	public byte[] plainTextBuffer;
	public byte[] cipherTextBuffer;
	
    public BlumMicaliLogic() {

        // Create the view
        theView = new BlumMicaliView();

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
        	//setKeys(generateKey_1(), generateKey_2(), generateKey_3());
        }

        // Encrypt
        if (event.getSource() == theView.btnEncrypt) {
			getKeys();
			byte[] data = getPlaintextTextarea(); //TODO This should be done differently.
			byte[] encodedResult;
			
			encodedResult = blumMicali.encode(data);
			
			//Set buffer
			this.cipherTextBuffer = encodedResult;
			
			//Set view input
			setCiphertextTextarea(new String(encodedResult));
        }

        // Decrypt
        if (event.getSource() == theView.btnDecrypt) {
            // Get plaintext
            //String text = getCiphertextTextarea();

            // TODO Magic happens here
            //text = "IT SHOULD BE DECRYPTED NOW.";

            // Set ciphertext
            //setPlaintextTextarea(text);

        }

        if (event.getSource() == theView.btnOpenKeys) {
            // New FileChooser open
            FileChooser fc = new FileChooser();
            String returnValue[] = fc.openDialogKeys();
            // System.out.print(returnValue[0]);

            // Assign keys
            //setKeys(returnValue[0], returnValue[1], returnValue[2]);

        }

        if (event.getSource() == theView.btnSaveKeys) {
            // Get keys
            String saveBuffer = theView.key1.getText();

            // New FileChooser save
            FileChooser fc = new FileChooser();
            fc.saveDialogKeys(saveBuffer.getBytes());

        }

        if (event.getSource() == theView.btnReadPlaintextFile) {
            // Choose file
            FileChooser fc = new FileChooser();
            byte[] returnValue = fc.openDialog();

            // Set textarea
            //setPlaintextTextarea(returnValue);

        }

        if (event.getSource() == theView.btnReadCiphertextFile) {
            // Choose file
            FileChooser fc = new FileChooser();
            byte[] returnValue = fc.openDialog();

            // Set textarea
            //setCiphertextTextarea(returnValue);

        }

        if (event.getSource() == theView.btnWritePlaintextFile) {
            // Get buffer
            byte[] saveBuffer = getPlaintextTextarea();

            // Write to file
            FileChooser fc = new FileChooser();
            fc.saveDialogKeys(saveBuffer);
        }

        if (event.getSource() == theView.btnWriteCiphertextFile) {

            // Get buffer
            byte[] saveBuffer = getCiphertextTextarea();

            // Write to file
            FileChooser fc = new FileChooser();
            fc.saveDialogKeys(saveBuffer);
        }

    }

    /**
     * All getters and setters for current view components
     */
	public void setKeys(String value_1, String value_2, String value_3) {
		theView.key1.setText(value_1);
		theView.key2.setText(value_2);
		theView.key3.setText(value_3);
		blumMicali.setKey(value_1, 1);
		blumMicali.setKey(value_2, 2);
		blumMicali.setKey(value_3, 3);
	}
	
	public void getKeys(){
		String key1 = theView.key1.getText();
		String key2 = theView.key2.getText();
		String key3 = theView.key3.getText();
		blumMicali.setKey(key1, 1);
		blumMicali.setKey(key1, 2);
		blumMicali.setKey(key1, 3);
	}

    private void setCiphertextTextarea(String string) {
        theView.txtrCiphertext.setText(string);
    }

    private byte[] getCiphertextTextarea() {
        return theView.txtrCiphertext.getText().getBytes();
    }

    private void setPlaintextTextarea(String string) {
        theView.txtrPlaintext.setText(string);
    }

    private byte[] getPlaintextTextarea() {
        return theView.txtrPlaintext.getText().getBytes();
    }
    
	/**
	 * Generate 3 keys
	 * 
	 * @return key value
	 */
	public String generateKey_1() {
		//TODO: key generator
		return "00000000000249E9";
	}

	public String generateKey_2() {
		//TODO: key generator
		return "00000000000249D3";
	}

	public String generateKey_3() {
		//TODO: key generator
		return "123457799BBCDFF1";
	}

}
