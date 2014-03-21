package p.lodz.pl.kryptografia;

import java.awt.EventQueue;

/**
 * The very top class.
 * 
 * @author Andrzej Lisowski 171131
 * @author Piotr Kluch 165436
 *
 */

public class MainApplication {
	
	public static MainController mainController;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					//Run the main application controller
					mainController = new MainController();
					mainController.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
