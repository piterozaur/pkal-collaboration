package p.lodz.pl.kryptografia;
import p.lodz.pl.kryptografia.data_encryption_algorithms.BlumMicaliLogic;
import p.lodz.pl.kryptografia.data_encryption_algorithms.TripleDESLogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController extends InitialWindow implements ActionListener {

	private static final long serialVersionUID = 6178411919826238297L;

	public MainController() {

		//Add listeners for main app window
		addActionListeners();
		
	}

	public void addActionListeners() {
		
		btnTripleDES.addActionListener(this);
		btnBlumMicali.addActionListener(this);
		btnCertificateDSA.addActionListener(this);
		
	}
	
    public void actionPerformed(ActionEvent event){
    	
    	//Initialize TripleDESLogic (and the corelated view is a chained reaction as well)
        if (event.getSource() == btnTripleDES) {
        	
        	TripleDESLogic tripleDESLogic = new TripleDESLogic();
        	
        }
        
    	//Initialize TripleDESLogic (and the corelated view is a chained reaction as well)
        if (event.getSource() == btnBlumMicali) {
        	
        	BlumMicaliLogic blumMicaliLogic = new BlumMicaliLogic();
        	
        }

    }
	
	
}
