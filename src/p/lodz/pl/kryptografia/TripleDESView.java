package p.lodz.pl.kryptografia;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * TripleDESView class is the JFrame window for this view.
 * 
 * @author <a href="mailto:165436@edu.p.lodz.pl">Piotr Kluch</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 * 
 */
public class TripleDESView extends JFrame {

    /**
     * Generated serial version ID.
     */
    private static final long serialVersionUID = 2647038714923727841L;
    public JTextField key1;
    public JTextField key2;
    public JTextField key3;
    public JButton btnGenerateKeys;

    public JTextArea txtrPlaintext;
    public JTextArea txtrCiphertext;
    
    public JButton btnEncrypt;
    public JButton btnDecrypt;

    public JButton btnOpenKeys;
    public JButton btnSaveKeys;

    public JButton btnReadPlaintextFile;
    public JButton btnWritePlaintextFile;
    public JButton btnReadCiphertextFile;
    public JButton btnWriteCiphertextFile;

    public TripleDESView() {

        setTitle("Szyfrowanie i deszyfrowanie algorytmem symetrycznym Triple DES");

        // Defaults
        // Initialize JFrame
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(698, 355);
        this.setLocation(200, 200);
        this.setVisible(true);
        getContentPane().setLayout(null);

        // Initial GUI starts here
        JLabel lblKlucz = new JLabel("Klucze 1, 2 i 3:");
        lblKlucz.setBounds(29, 23, 169, 15);
        getContentPane().add(lblKlucz);

        key1 = new JTextField();
        key1.setBounds(26, 50, 172, 29);
        getContentPane().add(key1);
        key1.setColumns(10);

        key2 = new JTextField();
        key2.setColumns(10);
        key2.setBounds(26, 91, 172, 29);
        getContentPane().add(key2);

        key3 = new JTextField();
        key3.setColumns(10);
        key3.setBounds(26, 132, 172, 29);
        getContentPane().add(key3);

        btnGenerateKeys = new JButton("Generuj klucze");
        btnGenerateKeys.setBounds(26, 183, 172, 25);
        getContentPane().add(btnGenerateKeys);

        JPanel middlePanel = new JPanel();
        middlePanel.setBounds(259, 23, 190, 148);
        middlePanel.setBorder(new TitledBorder(new EtchedBorder(), "Tekst jawny"));
        // create the middle panel components
        txtrPlaintext = new JTextArea(7, 15);
        txtrPlaintext.setText("Miejsce na tekst jawny");
        txtrPlaintext.setBounds(218, 51, 187, 148);
        JScrollPane scroll = new JScrollPane(txtrPlaintext);
        scroll.setBounds(218, 51, 187, 148);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        middlePanel.add(scroll);
        getContentPane().add(middlePanel);

        JPanel middlePanel2 = new JPanel();
        middlePanel2.setBounds(474, 23, 190, 148);
        middlePanel2.setBorder(new TitledBorder(new EtchedBorder(), "Szyfrogram"));
        // create the middle panel components
        txtrCiphertext = new JTextArea(7, 15);
        txtrCiphertext.setText("Miejsce na szyfrogram");
        txtrCiphertext.setBounds(428, 51, 188, 148);
        JScrollPane scroll2 = new JScrollPane(txtrCiphertext);
        scroll2.setBounds(428, 51, 188, 148);
        scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        middlePanel2.add(scroll2);
        getContentPane().add(middlePanel2);

        btnEncrypt = new JButton("Szyfruj ->");
        btnEncrypt.setBounds(259, 183, 190, 25);
        getContentPane().add(btnEncrypt);

        btnDecrypt = new JButton("<- Deszyfruj");
        btnDecrypt.setBounds(474, 183, 190, 25);
        getContentPane().add(btnDecrypt);

        btnOpenKeys = new JButton("Wczytaj klucze");
        btnOpenKeys.setBounds(26, 229, 172, 25);
        getContentPane().add(btnOpenKeys);

        btnSaveKeys = new JButton("Zapisz klucze");
        btnSaveKeys.setBounds(26, 266, 172, 25);
        getContentPane().add(btnSaveKeys);

        btnReadPlaintextFile = new JButton("Wczytaj plik jawny");
        btnReadPlaintextFile.setBounds(259, 229, 190, 25);
        getContentPane().add(btnReadPlaintextFile);

        btnWritePlaintextFile = new JButton("Zapisz plik jawny");
        btnWritePlaintextFile.setBounds(259, 266, 190, 25);
        getContentPane().add(btnWritePlaintextFile);

        btnReadCiphertextFile = new JButton("Wczytaj plik szyfrowany");
        btnReadCiphertextFile.setBounds(473, 229, 191, 25);
        getContentPane().add(btnReadCiphertextFile);

        btnWriteCiphertextFile = new JButton("Zapisz plik szyfrowany");
        btnWriteCiphertextFile.setBounds(473, 266, 191, 25);
        getContentPane().add(btnWriteCiphertextFile);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(204, 204, 204));
        panel.setBounds(0, 0, 229, 322);
        getContentPane().add(panel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(51, 51, 51));
        panel_1.setBounds(228, 0, 468, 322);
        getContentPane().add(panel_1);

    }
}