package p.lodz.pl.kryptografia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import p.lodz.pl.kryptografia.data_encryption_algorithms.TripleDESLogic;


public class ViewController extends InitialWindow implements ActionListener {
		
	public ViewController() {
		
		addActionListeners();
		
	}
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		//Add listeners. This class implements listeners.
		public void addActionListeners() {
			
			btnTripleDES.addActionListener(this);
			
		}
		
		
	    public void actionPerformed(ActionEvent event){
	    	
	        if (event.getSource() == btnTripleDES) {
	        	
	        	//Initialize TripleDESLogic
	        	TripleDESLogic tripleDESLogic = new TripleDESLogic();

	        	
	        }

	    }

		
	
}
