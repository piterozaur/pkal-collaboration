package p.lodz.pl.kryptografia.data_encryption_algorithms.triple_des;

import java.util.ArrayList;

import org.apache.log4j.Logger;

/**
 * Main Triple DES class.
 * 
 * @author <a href="mailto:165436@edu.p.lodz.pl">Piotr Kluch</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 *
 */
public class TripleDes extends DesImpl {
    
    private static final Logger LOG = Logger.getLogger(TripleDes.class);
    
    private ArrayList<Boolean> key1;
    private ArrayList<Boolean> key2;
    private ArrayList<Boolean> key3;

    /**
     * Encodes the message using Triple DES algorithm. 
     * 
     * @param msgToEncode
     * @return encoded message
     * @throws DesException
     */
    public String tripleDesEncode(String msgToEncode) throws DesException {
        ArrayList<Boolean> result = encrypt(transformIntoBitList(msgToEncode), key1);
        result = decrypt(result, key2);
        result = encrypt(result, key3);
        
        if(LOG.isDebugEnabled()){
            LOG.debug("Triple DES has encoded the input successfully.");
        }
        
        return transformFromBitList(result);
    }

    /**
     * Decodes the message using Triple DES algorithm. 
     * 
     * @param msgToDecode
     * @return decoded message
     * @throws DesException
     */
    public String tripleDesDecode(String msgToDecode) throws DesException {
        ArrayList<Boolean> result = decrypt(transformIntoBitList(msgToDecode), key3);
        result = encrypt(result, key2);
        result = decrypt(result, key1);
        
        if(LOG.isDebugEnabled()){
            LOG.debug("Triple DES has decoded the input successfully.");
        }
        
        return transformFromBitList(result);
    }
    
    public void setKeys(String key1, String key2, String key3){
    	this.key1 = transformIntoBitList(key1);
    	this.key2 = transformIntoBitList(key2);
    	this.key3 = transformIntoBitList(key3);
    }

}
