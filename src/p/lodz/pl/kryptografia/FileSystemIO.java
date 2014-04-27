package p.lodz.pl.kryptografia;

import java.io.FileInputStream;
import java.io.FileOutputStream;


/**
 * Class containing IO methods.
 * 
 * @author <a href="mailto:165436@edu.p.lodz.pl">Piotr Kluch</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 *
 */
public class FileSystemIO {

    /**
     * Reads file of a given name into table of bytes.
     * 
     * @param fileName
     * @return data
     * @throws Exception
     */
    public static byte[] wczytajZPliku(String nazwa_pliku) throws Exception {
        FileInputStream fis = new FileInputStream(nazwa_pliku);
        int ileWPliku = fis.available();
        byte[] dane = new byte[ileWPliku];
        fis.read(dane);
        fis.close();

        return dane;
    }

    /**
     * Writes data into a file of a given name.
     * 
     * @param data
     * @param fileName
     * @throws Exception
     */
    public static void zapiszDoPliku(byte dane[], String nazwa_pliku) throws Exception {
        FileOutputStream fos = new FileOutputStream(nazwa_pliku);
        fos.write(dane);
        fos.close();
    }

 
}