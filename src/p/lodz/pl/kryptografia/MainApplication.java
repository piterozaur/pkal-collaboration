package p.lodz.pl.kryptografia;

import java.awt.EventQueue;

import javax.swing.UIManager;

import org.apache.log4j.BasicConfigurator;

/**
 * The very top class.
 * 
 * @author <a href="mailto:165436@edu.p.lodz.pl">Piotr Kluch</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 *
 */

public class MainApplication {

    public static MainController mainController;

    public static void main(String[] args) {
        // initializing logger
        BasicConfigurator.configure();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    // Turn off irritating boldness of swing metal theme
                    UIManager.put("swing.boldMetal", Boolean.FALSE);

                    // Run the main application controller
                    mainController = new MainController();
                    mainController.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
