package p.lodz.pl.kryptografia.data_encryption_algorithms;

import javax.swing.JFrame;

import p.lodz.pl.kryptografia.TripleDESView;


public class TripleDESLogic {
	
	public TripleDESLogic() {

    	//Initialize JDialog for TripleDESView
    	// Create new JDialog-like window
    	TripleDESView tripleDESView = new TripleDESView();

		
		if ( tripleDESView.saveData ) {
			
			//theModel.insertNewEvent(location, description, date, alertDate, alert);
			//refreshCurrentView();
			
		}
		
	}
	
	public String generateKeys() {
		
		// TODO Need logic here
		
		String generatedHashKey = "ABCDEF";
		
		return generatedHashKey;
		
	}
	
}
