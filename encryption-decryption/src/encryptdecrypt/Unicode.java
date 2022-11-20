package encryptdecrypt;

class Unicode extends Cypher {

    @Override
    public String encrypt(String text, int key) {
        char[] resultEnc = text.toCharArray();

        for(int i = 0; i < resultEnc.length; i++) {
            int temp = resultEnc[i] + key;
            resultEnc[i] = (char) temp;
        }

        return String.valueOf(resultEnc);
    }

    @Override
    public String decrypt(String text, int key) {
        char[] resultDec = text.toCharArray();

        for(int i = 0; i < resultDec.length; i++) {
            int temp = resultDec[i] - key;
            resultDec[i] = (char) temp;
        }

        return String.valueOf(resultDec);
    }
}
