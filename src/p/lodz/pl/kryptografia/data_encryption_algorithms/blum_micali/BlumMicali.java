package p.lodz.pl.kryptografia.data_encryption_algorithms.blum_micali;

/**
 *
 * @author Praca
 */
public class BlumMicali {

    public class Key {

        byte[] current;
        long p;
        long a;
        long x;

        public byte[] generate(int length) {
            current = new byte[length / 8];
            int tmp;
            for (int i = 0; i < length; i++) {
                x = (long) (Math.pow(a, x) % p);
                if (x > ((p - 1) / 2)) {
                    tmp = 0;
                } else {
                    tmp = 1;
                }
                current[i / 8] = (byte) (current[i / 8] | tmp << i % 8);
            }
            return current;
        }

        /**
         * Zamienia HEX na tablice bajtów.
         * @param str HEX podany jako zapis w formie striga.
         * @return tablica bajtów odpowiadająca ciągowi heksadecymalnemu
         */
        private byte[] hexToBytes(String str) {
            if (str == null) {
                return null;
            } else if (str.length() < 2) {
                return null;
            } else {
                int len = str.length() / 2;
                byte[] buffer = new byte[len];
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) Integer.parseInt(
                            str.substring(i * 2, i * 2 + 2), 16);
                }
                return buffer;
            }
        }

        public boolean isPrime(long n) {
            if (n % 2 == 0 && n!= 2) return false;
            for (long i = 3; i * i <= n; i += 2) {
                if (n % i == 0) return false;
            }
            return true;
        }

        public byte[] XORbytes(byte[] msg) {
            if (msg.length != current.length) {
                return null;
            }
            byte[] result = new byte[msg.length];
            for (int i = 0; i < msg.length; i++) {
                result[i] = (byte) (msg[i] ^ current[i]);
            }
            return result;
        }

        private void setX(String Key) {
            /*byte[]tmp = hexToBytes(Key);
            System.out.print("X:" + tmp);
            x=0;
            for(int i=0; i<tmp.length; i++){
                x+=tmp[i]<<i*8;
            }*/
            x=Long.parseLong(Key, 16);
        }

        private void setA(String Key) {
            /*
            byte[]tmp = hexToBytes(Key);
            System.out.print("A:"+tmp);
            a=0;
            for(int i=0; i<tmp.length; i++){
                a+=tmp[i]<<i*8;
            }*/
            a=Long.parseLong(Key, 16);
        }

        private void setP(String Key) {
            /*byte[]tmp = hexToBytes(Key);
            System.out.print("P:"+tmp);
            p=0;
            for(int i=0; i<tmp.length; i++){
                p+=tmp[i]<<i*8;
            }*/
            p=Long.parseLong(Key, 16);
        }
    }
    
    /*
    private TripleDESPanel panel;
    public BlumMicali() {
        super();
        name = "Blum Micali";
        key = new Key();
        panel = new TripleDESPanel(fChooser, this, "p:", "a:", "X0:");
        panel.setKey("00000000000249E9",1);
        panel.setKey("00000000000249D3",2);
        panel.setKey("123457799BBCDFF1",3);
    }
    */
    
    public BlumMicali() {
    	
    	
    	
    }

    private Key key;
    
    public boolean setKey(String Key, int number) {
        switch (number) {
            case 1:
                key.setP(Key);
                return true;
            case 2:
                key.setA(Key);
                return true;
            case 3:
                key.setX(Key);
                return true;
            default:
                return false;
        }
    }
 
    public byte[] encode(byte[] message){
        byte[] result = new byte[0];
        if(!key.isPrime(key.p) || !key.isPrime(key.a))
        {
        	System.out.println("Liczby p i a muszą być liczbami pierwszymi");
        }
        else if(key.p == 2)
        {
        	System.out.println("Liczba p nie może być równy 2");
        }
        else{
        int length = message.length * 8;
        key.generate(length);
        result = key.XORbytes(message);
        }
        return result;
    }

    public byte[] decode(byte[] encrypted) {
        byte[] result = new byte[0];
        if(!key.isPrime(key.p) || !key.isPrime(key.a))
        {
            System.out.println("Liczby p i a muszą być liczbami pierwszymi");
        }
        else if(key.p == 2)
        {
        	System.out.println("Liczba p nie może być równy 2");
        }
        else{
        int length = encrypted.length * 8;
        key.generate(length);
        result = key.XORbytes(encrypted);
        }
        return result;
    }

}