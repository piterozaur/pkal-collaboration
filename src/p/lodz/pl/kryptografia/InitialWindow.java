package p.lodz.pl.kryptografia;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * InitialWindow class initializes Swing components, is responsible for view interaction and event listeners.
 * 
 * @author <a href="mailto:165436@edu.p.lodz.pl">Piotr Kluch</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 *
 */
public class InitialWindow extends JFrame {

    /**
     * Variables, basically main buttons
     */
    public JFrame frame;
    private static final long serialVersionUID = 1L;
    protected JButton btnTripleDES;
    protected JButton btnBlumMicali;
    protected JButton btnCertificateDSA;

    /**
     * Create the application.
     */
    public InitialWindow() {
        setTitle("Podstawy Kryptografii - Zestaw V"); // [Piotr Kluch, Andrzej Lisowski]
        initialize();
    }

    /**
     * Initialize the contents of the JFrame and some basics.
     */
    private void initialize() {

        // Defaults
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(635, 305);
        this.setLocation(200, 200);
        getContentPane().setLayout(null);

        // Initial GUI starts here
        JLabel lblKlucz = new JLabel("Wybierz czynność do wykonania w programie:");
        lblKlucz.setBounds(26, 24, 362, 15);
        getContentPane().add(lblKlucz);

        btnTripleDES = new JButton("Szyfrowanie i deszyfrowanie algorytmem symetrycznym Triple DES");
        btnTripleDES.setBounds(26, 51, 583, 49);
        getContentPane().add(btnTripleDES);

        btnBlumMicali = new JButton("Szyfrowanie i deszyfrowanie szyfrem strumieniowym z generatorem Blum-Micali");
        btnBlumMicali.setBounds(26, 112, 583, 49);
        getContentPane().add(btnBlumMicali);

        btnCertificateDSA = new JButton("Generowanie i sprawdzanie podpisu cyfrowyego przy użyciu algorytmu DSA");
        btnCertificateDSA.setBounds(26, 173, 583, 49);
        getContentPane().add(btnCertificateDSA);

        // Menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mntmFile = new JMenu("Plik");
        menuBar.add(mntmFile);

        JMenuItem quit = new JMenuItem("Zamknij");
        mntmFile.add(quit);

        // Inline listener for quit action.
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JMenu help = new JMenu("Pomoc");
        menuBar.add(help);
        JMenuItem about = new JMenuItem("O programie");
        help.add(about);
        // Inline listener for about action.
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane
                        .showMessageDialog(
                                frame,
                                "Podstawy Kryptografii\nZestaw V \n\nWersja: v. 0.0.1\n\nAutorzy:\nAndrzej Lisowski 171131\nPiotr Kluch 165436\n\n",
                                "O programie", JOptionPane.INFORMATION_MESSAGE);

            }
        });

    }
}
