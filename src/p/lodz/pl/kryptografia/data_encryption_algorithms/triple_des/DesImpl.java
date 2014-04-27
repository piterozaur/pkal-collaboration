package p.lodz.pl.kryptografia.data_encryption_algorithms.triple_des;

import java.util.ArrayList;

import org.apache.log4j.Logger;

/**
 * Main DES class.
 * 
 * @author <a href="mailto:165436@edu.p.lodz.pl">Piotr Kluch</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 *
 */
public class DesImpl implements IDes {

    private static final Logger LOG = Logger.getLogger(DesImpl.class);

    /**
     * Encrypts the message stored in the list of bits.
     * 
     * @param bitList
     * @param key
     * @return encrypted message
     */
    public ArrayList<Boolean> encrypt(ArrayList<Boolean> bitList, ArrayList<Boolean> key) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Encyption has started");
        }

        ArrayList<ArrayList<Boolean>> subKeys = generateSubKyes(key);
        ArrayList<Boolean> encrypted = new ArrayList<Boolean>();
        ArrayList<ArrayList<Boolean>> bitListList = new ArrayList<ArrayList<Boolean>>();
        ArrayList<Boolean> finall = new ArrayList<Boolean>();
        for (int j = 0; j < 64; j++) {
            finall.add(Boolean.TRUE);
        }

        for (int i = 0; i < bitList.size(); i += 64) {
            ArrayList<Boolean> a = new ArrayList<Boolean>();
            for (int j = 0; j < 64; j++) {
                a.add(bitList.get(j + i));
            }
            bitListList.add(a);
        }

        for (int i = 0; i < bitListList.size(); i++) {
            ArrayList<Boolean> block = bitListList.get(i);
            block = getInitialPermutation(block);
            ArrayList<Boolean> block32L = new ArrayList<Boolean>();
            ArrayList<Boolean> block32R = new ArrayList<Boolean>();
            for (int j = 0; j < 16; j++) {
                for (int d = 0; d < block.size() / 2; d++) {// two 32-bits blocks
                    block32L.add(block.get(d));
                    block32R.add(block.get(d + block.size() / 2));
                }
                ArrayList<Boolean> block48R = expandRight(block32R);// expansion to 48-bits blocks
                ArrayList<Boolean> block48Rxored = xor(block48R, subKeys.get(j)); // xor
                ArrayList<ArrayList<Boolean>> eightSixBitBlocks = new ArrayList<ArrayList<Boolean>>();
                for (int w = 0; w < block48Rxored.size(); w += 6) {// 8 groups of 6 elements
                    ArrayList<Boolean> a = new ArrayList<Boolean>();
                    for (int u = 0; u < 6; u++) {
                        a.add(block48Rxored.get(u + w));
                    }
                    eightSixBitBlocks.add(a);
                }
                ArrayList<ArrayList<Boolean>> sBoxedList8by4 = new ArrayList<ArrayList<Boolean>>();
                for (int k = 0; k < eightSixBitBlocks.size(); k++) {// sBoxing

                    sBoxedList8by4.add(sBoxing(eightSixBitBlocks.get(k), k));
                }
                ArrayList<Boolean> joinedTo32 = new ArrayList<Boolean>();
                for (int g = 0; g < sBoxedList8by4.size(); g++) {// to 32-bits after sBoxing
                    for (int x = 0; x < sBoxedList8by4.get(g).size(); x++) {
                        joinedTo32.add(sBoxedList8by4.get(g).get(x));
                    }

                }
                ArrayList<Boolean> permutedJoined32 = permP(joinedTo32);// P-permutation
                ArrayList<Boolean> block32Ltemp = block32R;
                block32R = xor(permutedJoined32, block32L);
                block32L = block32Ltemp;

                for (int v = 0; v < 32; v++) {
                    finall.set(v, block32R.get(v));
                    finall.set(32 + v, block32L.get(v));

                }
            }

            finall = ipback(finall);// final permutation

            for (int f = 0; f < 64; f++) {
                encrypted.add(finall.get(f));
            }

        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("Encyption has finished");
        }

        return encrypted;
    }

    /**
     * Decrypts the message stored in the list of bits.
     * 
     * @param bitList
     * @param key
     * @return encrypted message
     */
    public ArrayList<Boolean> decrypt(ArrayList<Boolean> bitList, ArrayList<Boolean> key) {

        if (LOG.isDebugEnabled()) {
            LOG.debug("Decryption has started");
        }

        ArrayList<ArrayList<Boolean>> subKeys = generateSubKyes(key);
        ArrayList<Boolean> decrypted = new ArrayList<Boolean>();
        ArrayList<ArrayList<Boolean>> bitListList = new ArrayList<ArrayList<Boolean>>();
        ArrayList<Boolean> finall = new ArrayList<Boolean>();
        for (int j = 0; j < 64; j++) {// size initialization
            finall.add(Boolean.TRUE);
        }

        for (int i = 0; i < bitList.size(); i += 64) {// list of list
            ArrayList<Boolean> a = new ArrayList<Boolean>();
            for (int j = 0; j < 64; j++) {
                a.add(bitList.get(j + i));
            }
            bitListList.add(a);
        }

        for (int i = 0; i < bitListList.size(); i++) {

            ArrayList<Boolean> block = bitListList.get(i);
            block = getInitialPermutation(block);// initial permutation
            ArrayList<Boolean> block32L = new ArrayList<Boolean>();
            ArrayList<Boolean> block32R = new ArrayList<Boolean>();
            for (int j = 0; j < 16; j++) {
                for (int d = 0; d < block.size() / 2; d++) {// 2 32-bits blocks
                    block32L.add(block.get(d));
                    block32R.add(block.get(d + block.size() / 2));
                }
                ArrayList<Boolean> block48R = expandRight(block32R);// to 48-bit expansion
                ArrayList<Boolean> block48Rxored = xor(block48R, subKeys.get(15 - j)); // xor
                ArrayList<ArrayList<Boolean>> eightSixBitBlocks = new ArrayList<ArrayList<Boolean>>();
                for (int w = 0; w < block48Rxored.size(); w += 6) {// 8 groups of 6 blocks
                    ArrayList<Boolean> a = new ArrayList<Boolean>();
                    for (int u = 0; u < 6; u++) {
                        a.add(block48Rxored.get(u + w));
                    }
                    eightSixBitBlocks.add(a);
                }
                ArrayList<ArrayList<Boolean>> sBoxedList8by4 = new ArrayList<ArrayList<Boolean>>();
                for (int k = 0; k < eightSixBitBlocks.size(); k++) {// sBoxing to 8 lists of 4 bits

                    sBoxedList8by4.add(sBoxing(eightSixBitBlocks.get(k), k));
                }
                ArrayList<Boolean> joinedTo32 = new ArrayList<Boolean>();
                for (int g = 0; g < sBoxedList8by4.size(); g++) {// links into 32 bits
                    for (int x = 0; x < sBoxedList8by4.get(g).size(); x++) {
                        joinedTo32.add(sBoxedList8by4.get(g).get(x));
                    }

                }
                ArrayList<Boolean> permutedJoined32 = permP(joinedTo32);// P-permutation
                ArrayList<Boolean> block32Ltemp = block32R;
                block32R = xor(permutedJoined32, block32L);
                block32L = block32Ltemp;

                for (int v = 0; v < 32; v++) {
                    finall.set(v, block32R.get(v));
                    finall.set(32 + v, block32L.get(v));
                }
            }

            finall = ipback(finall);// final permutation

            for (int f = 0; f < 64; f++) {
                decrypted.add(finall.get(f));
            }

        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("Decryption has finished");
        }

        return decrypted;
    }

    private ArrayList<ArrayList<Boolean>> generateSubKyes(ArrayList<Boolean> key) {// 16 subkeys of 48bits each

        ArrayList<ArrayList<Boolean>> subKeys = new ArrayList<ArrayList<Boolean>>();
        ArrayList<Boolean> key56 = getPermutedChoice1(key);// initial key permutation
        ArrayList<Boolean> key28v1 = new ArrayList<Boolean>();
        ArrayList<Boolean> key28v2 = new ArrayList<Boolean>();
        for (int i = 0; i < key56.size() / 2; i++) {// 2 blocks of 28 bits
            key28v1.add(key56.get(i));
            key28v2.add(key56.get(i + 28));
        }

        System.out.println("permutacja koncowa klucza");
        for (int i = 0; i < 16; i++) {// 1 or 2 positions left, linking, final key permutation
            if ((i == 2) || (i == 3) || (i == 4) || (i == 5) || (i == 6) || (i == 7) || (i == 9) || (i == 10)
                    || (i == 11) || (i == 12) || (i == 13) || (i == 14)) {
                key28v1 = leftShift(key28v1);
                key28v2 = leftShift(key28v2);
            }
            key28v1 = leftShift(key28v1);
            key28v2 = leftShift(key28v2);
            for (int j = 0; j < key56.size(); j++) {// connects 2 x 28 =56
                if (j < 28) {
                    key56.set(j, key28v1.get(j));
                } else {
                    key56.set(j, key28v2.get(j - 28));
                }
            }

            ArrayList<Boolean> key48 = new ArrayList<Boolean>();
            key48 = getPermutedChoice2(key56);// second key permutation
            subKeys.add(key48);
        }

        return subKeys;
    }

    private ArrayList<Boolean> getPermutedChoice1(ArrayList<Boolean> key) {
        ArrayList<Boolean> permutedKey = new ArrayList<Boolean>();

        final int[] pc1 = { 57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3,
                60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21,
                13, 5, 28, 20, 12, 4 };

        for (int i = 0; i < pc1.length; i++) {
            permutedKey.add(key.get(pc1[i] - 1));
        }

        return permutedKey;
    }

    private ArrayList<Boolean> leftShift(ArrayList<Boolean> key) {
        ArrayList<Boolean> leftShiftedKey = new ArrayList<Boolean>();
        for (int i = 1; i < key.size(); i++) {
            leftShiftedKey.add(key.get(i));

        }
        leftShiftedKey.add(key.get(key.size() - 1));
        return leftShiftedKey;
    }

    private  ArrayList<Boolean> getPermutedChoice2(ArrayList<Boolean> key) {
        ArrayList<Boolean> permutedKey = new ArrayList<Boolean>();

        final int[] pc2 = { 14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19, 12, 4, 26, 8, 16, 7, 27, 20, 13, 2, 41,
                52, 31, 37, 47, 55, 30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32 };

        for (int i = 0; i < pc2.length; i++) {
            permutedKey.add(key.get(pc2[i] - 1));
        }

        return permutedKey;
    }

    private ArrayList<Boolean> getInitialPermutation(ArrayList<Boolean> text) {
        ArrayList<Boolean> permutedText = new ArrayList<Boolean>();
        final int[] tab = { 58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14,
                6, 64, 56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53,
                45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7 };

        for (int i = 0; i < text.size(); i++) {
            permutedText.add(text.get(tab[i] - 1));
        }

        return permutedText;
    }

    private ArrayList<Boolean> ipback(ArrayList<Boolean> text) {
        ArrayList<Boolean> permutedText = new ArrayList<Boolean>();
        for (int i = 0; i < text.size(); i++) {
            permutedText.add(Boolean.TRUE);

        }
        int[] tab = { 58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64,
                56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37,
                29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7 };

        for (int i = 0; i < text.size(); i++) {
            permutedText.set(tab[i] - 1, text.get(i));

        }

        return permutedText;
    }

    private ArrayList<Boolean> expandRight(ArrayList<Boolean> blockR) {
        ArrayList<Boolean> expanded = new ArrayList<Boolean>();
        int[] tab = { 32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18,
                19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1 };
        for (int i = 0; i < 48; i++) {
            expanded.add(blockR.get(tab[i] - 1));

        }
        return expanded;
    }

    private ArrayList<Boolean> xor(ArrayList<Boolean> blockR48, ArrayList<Boolean> key) {
        ArrayList<Boolean> xored = new ArrayList<Boolean>();
        for (int i = 0; i < blockR48.size(); i++) {
            if (blockR48.get(i) && key.get(i)) {
                xored.add(Boolean.FALSE);
            }
            if (!blockR48.get(i) && key.get(i)) {
                xored.add(Boolean.TRUE);
            }
            if (blockR48.get(i) && !key.get(i)) {
                xored.add(Boolean.TRUE);
            }
            if (!blockR48.get(i) && !key.get(i)) {
                xored.add(Boolean.FALSE);
            }
        }
        return xored;
    }

    private ArrayList<Boolean> sBoxing(ArrayList<Boolean> block6, int sBoksNumber) {
        ArrayList<Boolean> sBoxed = new ArrayList<Boolean>();

        final int[][] sBox1 = { { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7 },
                { 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8 },
                { 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0 },
                { 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 } };

        final int[][] sBox2 = { { 15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 1 },
                { 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5 },
                { 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15 },
                { 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9 } };

        final int[][] sBox3 = { { 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8 },
                { 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1 },
                { 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7 },
                { 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12 } };

        final int[][] sBox4 = { { 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15 },
                { 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9 },
                { 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4 },
                { 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14 } };

        final int[][] sBox5 = { { 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9 },
                { 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6 },
                { 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14 },
                { 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3 } };

        final int[][] sBox6 = { { 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11 },
                { 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8 },
                { 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6 },
                { 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13 } };

        final int[][] sBox7 = { { 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1 },
                { 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6 },
                { 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2 },
                { 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12 } };
        
        final int[][] sBox8 = { { 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7 },
                { 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2 },
                { 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8 },
                { 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11 } };

        ArrayList<int[][]> sBoksList = new ArrayList<int[][]>();
        sBoksList.add(sBox1);
        sBoksList.add(sBox2);
        sBoksList.add(sBox3);
        sBoksList.add(sBox4);
        sBoksList.add(sBox5);
        sBoksList.add(sBox6);
        sBoksList.add(sBox7);
        sBoksList.add(sBox8);

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < 6; k++) {
            String bit;
            if (block6.get(k)) {
                bit = new String("1");
            } else {
                bit = new String("0");
            }
            sb.append(bit);
        }

        String sixBitStr = sb.toString();
        StringBuilder rowSb = new StringBuilder();
        StringBuilder columnSb = new StringBuilder();
        for (int i = 0; i < sixBitStr.length(); i++) {
            if (i == 0) {
                rowSb.append(sixBitStr.charAt(i));
            } else if (i == 1) {
                columnSb.append(sixBitStr.charAt(i));
            } else if (i == 2) {
                columnSb.append(sixBitStr.charAt(i));
            } else if (i == 3) {
                columnSb.append(sixBitStr.charAt(i));
            } else if (i == 4) {
                columnSb.append(sixBitStr.charAt(i));
            } else if (i == 5) {
                rowSb.append(sixBitStr.charAt(i));
            }
        }
        int row = Integer.parseInt(rowSb.toString(), 2);
        int column = Integer.parseInt(columnSb.toString(), 2);
        int value = sBoksList.get(sBoksNumber)[row][column];

        String s = Integer.toBinaryString(value);

        for (int q = s.length(); q < 4; q++) {
            s = "0" + s;
        }

        for (int k = 0; k < s.length(); k++) {
            if (s.charAt(k) == '1') {
                sBoxed.add(Boolean.TRUE);
            } else {
                sBoxed.add(Boolean.FALSE);
            }
        }

        return sBoxed;
    }

    private ArrayList<Boolean> permP(ArrayList<Boolean> joined32) {
        ArrayList<Boolean> permuted = new ArrayList<Boolean>();

        int[] P = { 16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13,
                30, 6, 22, 11, 4, 25 };

        for (int i = 0; i < joined32.size(); i++) {
            permuted.add(joined32.get(P[i] - 1));
        }

        return permuted;
    }

    /**
     * Converts the text into binary list.
     * 
     * @param msg
     * @return bitList
     */
    public ArrayList<Boolean> transformIntoBitList(String msg) {
        String bitstream = "";
        ArrayList<Boolean> bitList = new ArrayList<Boolean>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < msg.length(); i++) {

            String s = Integer.toBinaryString(msg.charAt(i));

            for (int q = s.length(); q < 8; q++) {
                s = "0" + s;
            }

            sb.append(s);

        }
        bitstream = sb.toString();

        int length = bitstream.length();
        if ((bitstream.length() % 64) != 0) {
            for (int i = 0; i < 64 - (length % 64); i++) {
                bitstream = bitstream + "0";
            }
        }

        for (int k = 0; k < bitstream.length(); k++) {
            if (bitstream.charAt(k) == '1') {
                bitList.add(Boolean.TRUE);
            } else {
                bitList.add(Boolean.FALSE);
            }
        }

        return bitList;
    }

    /**
     * Converts the list of binary into text.
     * 
     * @param bitList
     * @return resultNormal
     */
    public String transformFromBitList(ArrayList<Boolean> bitList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bitList.size(); i++) {
            String bit;
            if (bitList.get(i)) {
                bit = new String("1");
            } else {
                bit = new String("0");
            }
            sb.append(bit);

        }

        String resultBinary = sb.toString();
        String resultNormal = "";
        for (int i = 0; i <= resultBinary.length() - 8; i += 8) {
            int k = Integer.parseInt(resultBinary.substring(i, i + 8), 2);
            resultNormal += (char) k;
        }
        return resultNormal;
    }

}
