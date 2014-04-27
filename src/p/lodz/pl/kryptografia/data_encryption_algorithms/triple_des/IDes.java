package p.lodz.pl.kryptografia.data_encryption_algorithms.triple_des;

import java.util.ArrayList;

/**
 * Interface for DES algorithm.
 * 
 * @author <a href="mailto:165436@edu.p.lodz.pl">Piotr Kluch</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 *
 */
public interface IDes {

    public ArrayList<Boolean> encrypt(ArrayList<Boolean> bitList, ArrayList<Boolean> key);
    
    public ArrayList<Boolean> decrypt(ArrayList<Boolean> bitList, ArrayList<Boolean> key);
    
    public ArrayList<Boolean> transformIntoBitList(String msg);
    
    public String transformFromBitList(ArrayList<Boolean> bitList);
    
}
